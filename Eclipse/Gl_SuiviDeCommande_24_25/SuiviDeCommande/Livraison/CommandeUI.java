package Livraison;

import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class CommandeUI extends PanneauUI implements ActionListener{
	
	private static ListCommande _commandes = new ListCommande();
	private static ListCommande _commandesNotif = new ListCommande();
	private static int _statut = 1;
	
	private JButton _buttonRefresh;
	
	private JTextArea _taAffichage;
	
	private JLabel _labelIdCommande;
	private JTextField _textIdCommande;
	
	private JButton _buttonStatut;
	private JButton _valideCommande;
	
	private JScrollPane _scroll;
	
	private JPanel _zoneCommandes;

	CommandeUI(GestionUI fenetre) {
		super(fenetre);
		super._titre.setText("Commandes");
		_corps.setLayout(new BoxLayout(_corps, BoxLayout.PAGE_AXIS));
		
		_zoneCommandes = new JPanel();
		_zoneCommandes.setLayout(new BoxLayout(_zoneCommandes,BoxLayout.PAGE_AXIS));
		
		_buttonRefresh = new JButton("Rafraichir");
		_buttonRefresh.addActionListener(this);
		
		_taAffichage = new JTextArea();
		_taAffichage.setEditable(false);
		_taAffichage.setFont(_taAffichage.getFont().deriveFont(15f));
		
		_labelIdCommande = new JLabel("...");
		_textIdCommande = new JTextField(12);
		_textIdCommande.setEditable(false);
		
		_buttonStatut = new JButton("...");
		_buttonStatut.disable();
		_buttonStatut.addActionListener(this);
		
		_valideCommande = new JButton("...");
		_valideCommande.addActionListener(this);
		
		_zoneCommandes.add(_buttonRefresh);
		_zoneCommandes.add(_taAffichage);
		_zoneCommandes.add(_labelIdCommande);
		_zoneCommandes.add(_textIdCommande);
		_zoneCommandes.add(_buttonStatut);
		_zoneCommandes.add(_valideCommande);
		
		
		_corps.add(_zoneCommandes);

		_scroll = new JScrollPane(_corps, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        _scroll.setBounds(0, 0, 930, 610);
        
        this.add(_scroll,BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == _buttonRefresh) {
			this.update();
		}
		
		if (e.getSource() == _valideCommande) {
			Compte actuelle = GestionUI.getConnecter();
			
			try {
				
				if (actuelle.get_Type() == 1) {
					creerCommande();
					update();
				} else {
					
					int idCom = Integer.valueOf(_textIdCommande.getText());
					_textIdCommande.setText("");
					if (_commandes.getCommande(idCom) == null) {
						throw new Exception();
					}
					
					_commandes.getCommande(idCom).setStatus(_statut);
					
					verifCommandeNotif(_commandes.getCommande(idCom));
					update();
				}
				
			} catch (NumberFormatException numberError) {
				JOptionPane.showMessageDialog(this, "L'iddentifiant de commande comporte que des numéros !", "Commande", JOptionPane.ERROR_MESSAGE);
			} catch (Exception error) {
				JOptionPane.showMessageDialog(this, "Commande inexistante !", "Commande", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource() == _buttonStatut && GestionUI.getConnecter().get_Type() != 1) {
			if (_statut == 3) {
				_statut = 1;
				_buttonStatut.setText(intStatutToString(_statut));
			} else {
				_statut++;
				_buttonStatut.setText(intStatutToString(_statut));
			}
		}
		
	}

	private String listCommandeToString(ArrayList<Commande> toDisplay) {
		String display = "ID Commandes \t ID Client\tID Livreur\tDate\tÉtat\n";
		
		for (Commande c: toDisplay) {
			display += c.getID_Commande() + "\t\t" + c.getID_Client() + "\t" + c.getID_Livreur() + "\t" + c.getDate() + "\t" + intStatutToString(c.getStatus()) + "\n";
		}
		
		return display;
	}
	
	protected static String intStatutToString(int statut) {
		String str = null;
		switch(statut) {
		case 1:
			str = "En préparation";
			break;
			
		case 2:
			str = "En livraison";
			break;
			
		case 3:
			str = "Commande livrée";
			break;
		}
		return str;
	}
	
	public static void creerCommande() {
		int num_liv = 0;
		ArrayList<Livreur> _livreurs = ConnexionUI.getLivreurs();
		Compte _connecter = GestionUI.getConnecter();
		
		while (num_liv < _livreurs.size() && _livreurs.get(num_liv).getDispo() == false) {
			num_liv++;
		}
		

		if (_livreurs.get(num_liv).getDispo()) {
			Commande nouvCommande =  new Commande(((Client) _connecter).getID_Client(), _livreurs.get(num_liv).getID_Livreur());

			_commandes.ajoutCommande(nouvCommande);
		}
		else {
			Commande nouvCommande =  new Commande(((Client) _connecter).getID_Client());
			_commandes.ajoutCommande(nouvCommande);
		}
		
	}
	
	private void verifCommandeNotif(Commande c) {
		
		if (_commandesNotif.getCommande(c.getID_Commande()) != null) {
			_commandesNotif.modifCommande(c, c.getID_Commande());
		} else {
			_commandesNotif.ajoutCommande(c);
		}
		
	}
	
	protected static ListCommande getCommandeChange(){
		return _commandesNotif;
	}
	

	void update() {
		// TODO Auto-generated method stub
		Compte actuelle = GestionUI.getConnecter();
		
		if (actuelle != null) {
			ArrayList<Commande> commandesCompte = null;
			switch(actuelle.get_Type()) {
				case 1:

					_buttonStatut.setText("...");
					_buttonStatut.disable();
					_textIdCommande.setEditable(false);
					_labelIdCommande.setText("...");
					_valideCommande.setText("Commander");
					commandesCompte = _commandes.getClientCommande(((Client)actuelle).getID_Client());
					break;
				
				case 2:
					_buttonStatut.setText("En préparation");
					_statut = 1;
					_buttonStatut.enable();
					_textIdCommande.setEditable(true);
					_labelIdCommande.setText("ID Commande : ");
					_valideCommande.enable();
					_valideCommande.setText("Mettre à jour");
					commandesCompte = _commandes.getLivreurCommande(((Livreur)actuelle).getID_Livreur());
					break;
					
				case 3:
					_buttonStatut.setText("En préparation");
					_statut = 1;
					_buttonStatut.enable();
					_textIdCommande.setEditable(true);
					_labelIdCommande.setText("ID Commande : ");
					_valideCommande.enable();
					_valideCommande.setText("Mettre à jour");
					commandesCompte = _commandes.getListeCommandes();
					break;
				}
			
			if (!commandesCompte.isEmpty()) {
				_taAffichage.setText(listCommandeToString(commandesCompte));
			} else {
				_taAffichage.setText("Vide");
			}
			
		}
	}

}

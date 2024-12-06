package V0_1;

import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CommandeUI extends PanneauUI implements ActionListener{
	
	private static ListCommande _commandes = new ListCommande();
	private static int _statut = 1;
	
	private JButton _buttonRefresh;
	
	private JTextArea _taAffichage;
	
	private JLabel _labelIdCommande;
	private JTextField _textIdCommande;
	
	private JButton _buttonStatut;
	private JButton _valideCommande;
	
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
		this.add(_corps,BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == _buttonRefresh) {
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
						commandesCompte = _commandes.getClientCommande(((Livreur)actuelle).getID_Livreur());
						break;
						
					case 3:
						_buttonStatut.setText("En préparation");
						_statut = 1;
						_buttonStatut.enable();
						_textIdCommande.setEditable(true);
						_labelIdCommande.setText("ID Commande : ");
						_valideCommande.enable();
						_valideCommande.setText("Mettre à jour");
						commandesCompte = _commandes.getCommandes();
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

	private String listCommandeToString(ArrayList<Commande> toDisplay) {
		String display = "ID Commandes\tID Client\tID Livreur\tDate\t\tÉtat\n";
		
		for (Commande c: toDisplay) {
			display += c.getID_Commande() + "\t\t" + c.getID_Client() + "\t\t" + c.getID_Livreur() + "\t\t" + c.getDate() + "\t\t" + intStatutToString(c.getStatus()) + "\n";
		}
		
		return display;
	}
	
	private String intStatutToString(int statut) {
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
	
	
	@Override
	void update() {
		// TODO Auto-generated method stub
		
	}

}

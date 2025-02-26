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
import javax.swing.JTextField;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class ConnexionUI extends PanneauUI implements ActionListener {
	
	private static ArrayList<Client> _clients = new ArrayList<>();
	private static ArrayList<Livreur> _livreurs = new ArrayList<>();
	private static ArrayList<Administrateur> _administrateurs = new ArrayList<>();
	private static int _type = 1;
	
	private JLabel _labelLogin;
	private JTextField _textLogin;
	private JLabel _labelMotDePasse;
	private JPasswordField _textMotDePasse;
	private JButton _valideType;
	private JButton _valideConnexion;
	
	
	private JLabel _labelSeparation;
	
	private JLabel _labelNom;
	private JTextField _textNom;
	private JLabel _labelPrenom;
	private JTextField _textPrenom;
	private JLabel _labelAdresse;
	private JTextField _textAdresse;
	private JLabel _labelCodePostal;
	private JTextField _textCodePostal;
	private JLabel _labelMDP;
	private JPasswordField _textMDP;
	private JLabel _labelComfirmer;
	private JPasswordField _textComfirmer;
	private JButton _valideInscription;
	
	private JButton _valideDeconnexion;
	
	private JPanel _zoneConnexion;
	
	
	ConnexionUI(GestionUI fenetre) {
		super(fenetre);
		_clients.add(new Client("Alpha","Beta","PPT","12345","qwerty"));
		_livreurs.add(new Livreur("Delta","Thibault",true,"qwerty"));
		_administrateurs.add(new Administrateur("Ender","Jean","azerty"));
		
		_corps.setLayout(new BoxLayout(_corps, BoxLayout.PAGE_AXIS));
	
		_zoneConnexion = new JPanel();
		_zoneConnexion.setLayout(new BoxLayout(_zoneConnexion,BoxLayout.PAGE_AXIS));
		
		super._titre.setText("Connexion");
		
		_labelLogin= new JLabel("Login :");
		_textLogin = new JTextField(40);
		
		_labelMotDePasse = new JLabel("Mot de passe :");
		_textMotDePasse = new JPasswordField(20);
		
		_valideType = new JButton("Client");
		_valideType.addActionListener(this);
		
		_valideConnexion = new JButton("Se connecter");
		_valideConnexion.addActionListener(this);
		
		_valideDeconnexion = new JButton("Se déconnecter");
		_valideDeconnexion.addActionListener(this);
		
		_zoneConnexion.add(_labelLogin);
		_zoneConnexion.add(_textLogin);
		_zoneConnexion.add(_labelMotDePasse);
		_zoneConnexion.add(_textMotDePasse);
		_zoneConnexion.add(_valideType);
		_zoneConnexion.add(_valideConnexion);
		_zoneConnexion.add(_valideDeconnexion);
		
		_labelSeparation = new JLabel("------ Inscription Client -------");
		_zoneConnexion.add(_labelSeparation);
		
		_labelNom= new JLabel("Nom :");
		_textNom = new JTextField(20);
		
		_labelPrenom= new JLabel("Prenom :");
		_textPrenom = new JTextField(20);
		
		_labelAdresse= new JLabel("Adresse :");
		_textAdresse = new JTextField(30);
		
		_labelCodePostal= new JLabel("CodePostal :");
		_textCodePostal = new JTextField(10);
		
		_labelMDP= new JLabel("Mot de passe :");
		_textMDP = new JPasswordField(20);
		
		_labelComfirmer = new JLabel("Comfirmer mot de passe :");
		_textComfirmer = new JPasswordField(20);
		
		_valideInscription = new JButton("S'inscrire");
		_valideInscription.addActionListener(this);
		
		_zoneConnexion.add(_labelNom);
		_zoneConnexion.add(_textNom);
		_zoneConnexion.add(_labelPrenom);
		_zoneConnexion.add(_textPrenom);
		_zoneConnexion.add(_labelAdresse);
		_zoneConnexion.add(_textAdresse);
		_zoneConnexion.add(_labelCodePostal);
		_zoneConnexion.add(_textCodePostal);
		_zoneConnexion.add(_labelMDP);
		_zoneConnexion.add(_textMDP);
		_zoneConnexion.add(_labelComfirmer);
		_zoneConnexion.add(_textComfirmer);
		_zoneConnexion.add(_valideInscription);
		
		_corps.add(_zoneConnexion);
		this.add(_corps,BorderLayout.CENTER);
	}

	@Override
	void update() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == _valideConnexion) {
			if (GestionUI.getConnecter() == null) {
				
				try {
				
					String login = _textLogin.getText();
					String password = _textMotDePasse.getText();
					
					Compte trouvee = searchType(login);
					
					if (trouvee == null) {
						throw new Exception();
					} else {
						if (trouvee.verificationMotDePasse(password)) {
							GestionUI.setConnecter(trouvee);
							JOptionPane.showMessageDialog(this, "Bienvenue " + trouvee.getNom_Utilisateur() + " !", "Connexion", JOptionPane.PLAIN_MESSAGE);
							
							if (trouvee.get_Type() == 1) {
								notification();
							}
							
							_textMotDePasse.setText("");
							_fenetre.update();
						}
					}
					
				} catch (Exception error) {
					JOptionPane.showMessageDialog(this, "Nom d'utilisateur ou Mot de passe Incorrect !", "Connexion", JOptionPane.ERROR_MESSAGE);
				}
				
			} else {
				JOptionPane.showMessageDialog(this, "Vous êtes déjà connecter !", "Connexion", JOptionPane.WARNING_MESSAGE);
			}
			
		} 

		if (e.getSource() == _valideType) {
			if (_type == 3) {
				_type = 1;
				_valideType.setText("Client");
			} else {
				_type++;
			}
			
			if (_type == 2) {
				_valideType.setText("Livreur");
			} else if (_type == 3) {
				_valideType.setText("Admin");
			}
		}
		
		if (e.getSource() == _valideInscription) {
			
			if (GestionUI.getConnecter() == null) {
				
				try {
					String nom = _textNom.getText();
					String prenom = _textPrenom.getText();
					String adresse = _textAdresse.getText();
					String codePostal = _textCodePostal.getText();
					String mdp = _textMDP.getText();
					String confirm = _textComfirmer.getText();
					
					boolean verification = !nom.isBlank() &&
											!prenom.isBlank() &&
											!adresse.isBlank() &&
											!codePostal.isBlank() &&
											!mdp.isBlank() &&
											!confirm.isBlank();
					
					if (verification && mdp.contentEquals(confirm)) {
						Client temporaire = new Client(nom,prenom,adresse,codePostal,mdp);
						_clients.add(temporaire);
						JOptionPane.showMessageDialog(this,
								"Bienvenue " + temporaire.getNom_Compte() + " " + temporaire.getPrenom_Compte()
								+ " ! Vôtre nom d'utilisateur est : " + temporaire.getNom_Utilisateur() 
								+ " Votre mot de passe est : " + mdp + ". Veuillez vous connecter à nouveau.",
								"Inscription Réussi", JOptionPane.PLAIN_MESSAGE);
						viderInscription();
					} else {
						throw new Exception();
					}
					
				} catch (Exception error) {
					JOptionPane.showMessageDialog(this, "Champs vide ou Comfirmation mot de passe érroné", "Inscription", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vous êtes déjà connecter !", "Connexion", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource() == _valideDeconnexion) {
			if (GestionUI.getConnecter() != null){
				GestionUI.setConnecter(null);
				JOptionPane.showMessageDialog(this, "Déconnectée !", "Connexion", JOptionPane.PLAIN_MESSAGE);
				_textLogin.setText("");
				_fenetre.update();
			}
		}
		
	}

	private Compte searchType(String Login) {
		Compte result = null;
		int i = 0;
		
		switch (_type) {
			case 1:
				if (_clients.size() != 0) {
					while (i < _clients.size() && result == null) {
						if (_clients.get(i).getNom_Utilisateur().contentEquals(Login)) {
							result = _clients.get(i);
						}
						i++;
					}
				}
				
				break;

			case 2:
				if (_livreurs.size() != 0) {
					while (i < _livreurs.size() && result == null) {
						if (_livreurs.get(i).getNom_Utilisateur().contentEquals(Login)) {
							result = _livreurs.get(i);
						}
						i++;
					}
				}
				break;

			case 3:
				if (_administrateurs.size() != 0) {
					while (i < _administrateurs.size() && result == null) {
						if (_administrateurs.get(i).getNom_Utilisateur().contentEquals(Login)) {
							result = _administrateurs.get(i);
						}
						i++;
					}
				}
				break;
			}
		return result;
	}
	
	private void viderInscription() {
		_textNom.setText("");
		_textPrenom.setText("");
		_textAdresse.setText("");
		_textCodePostal.setText("");
		_textMDP.setText("");
		_textComfirmer.setText("");
	}
	
	protected static ArrayList<Client> getClients() {
		return _clients;
	}
	
	protected static ArrayList<Livreur> getLivreurs() {
		return _livreurs;
	}
	
	protected static ArrayList<Administrateur> getAdministrateur() {
		return _administrateurs;
	}
	
	private void notification() {
		ListCommande commandes = CommandeUI.getCommandeChange();
		ArrayList<Commande> actuals = commandes.getClientCommande(((Client)GestionUI.getConnecter()).getID_Client());
		
		if (actuals != null) {
			for (Commande c: actuals) {
				JOptionPane.showMessageDialog(this, "Votre commande (id: " + c.getID_Commande() + ") statut actuelle : " + CommandeUI.intStatutToString(c.getStatus()), "Commandes", JOptionPane.PLAIN_MESSAGE);
				CommandeUI.getCommandeChange().supCommande(c.getID_Commande());
			}
		}
	}
}

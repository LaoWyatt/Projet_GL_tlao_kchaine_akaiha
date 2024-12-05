package V0_1;

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
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class ConnexionUI extends PanneauUI implements ActionListener {
	
	
	private JLabel _labelLogin;
	private JTextField _textLogin;
	private JLabel _labelMotDePasse;
	private JPasswordField _textMotDePasse;
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
		
			_corps.setLayout(new BoxLayout(_corps, BoxLayout.PAGE_AXIS));
		
			_zoneConnexion = new JPanel();
			_zoneConnexion.setLayout(new BoxLayout(_zoneConnexion,BoxLayout.PAGE_AXIS));
			
		if(fenetre.getConnecter() == null) {
			
			super._titre.setText("Connexion");
			
			_labelLogin= new JLabel("Login :");
			_textLogin = new JTextField(40);
			
			_labelMotDePasse = new JLabel("Mot de passe :");
			_textMotDePasse = new JPasswordField(20);
			
			_valideConnexion = new JButton("Se connecter");
			_valideConnexion.addActionListener(this);
			
			_zoneConnexion.add(_labelLogin);
			_zoneConnexion.add(_textLogin);
			_zoneConnexion.add(_labelMotDePasse);
			_zoneConnexion.add(_textMotDePasse);
			_zoneConnexion.add(_valideConnexion);
			
			_labelSeparation = new JLabel("-------------");
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
			_textMDP.setEchoChar('*');
			
			_labelComfirmer = new JLabel("Comfirmer mot de passe :");
			_textComfirmer = new JPasswordField(20);
			_textComfirmer.setEchoChar('*');
			
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
			
		} else {
			
			super._titre.setText("Déconnexion");
			
			_labelLogin= new JLabel("Bienvenue " + fenetre.getConnecter().get_NomUtilisateur() + " !");
			_valideDeconnexion = new JButton("Se déconnecter");
			_valideDeconnexion.addActionListener(this);
			
			_zoneConnexion.add(_labelLogin);
			_zoneConnexion.add(_valideDeconnexion);
			
		}
		
		_corps.add(_zoneConnexion);
		
		this.add(_corps,BorderLayout.CENTER);
		
		
	}

	@Override
	void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}

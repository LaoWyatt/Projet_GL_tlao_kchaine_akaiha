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
	private JPanel _zoneConnexion;
	
	
	private JPanel _zoneInscription;
	
	
	ConnexionUI(GestionUI fenetre) {
		super(fenetre);
		super._titre.setText("Commandes");
		_corps.setLayout(new BoxLayout(_corps, BoxLayout.PAGE_AXIS));

		_zoneConnexion = new JPanel();
		_zoneConnexion.setLayout(new BoxLayout(_zoneConnexion,BoxLayout.PAGE_AXIS));
		
		_labelLogin= new JLabel("Login :");
		_textLogin = new JTextField(30);
		
		_labelMotDePasse = new JLabel("Mot de passe :");
		_textMotDePasse = new JPasswordField(30);
		
		_valideConnexion = new JButton("Se connecter");
		_valideConnexion.addActionListener(this);
		
		_zoneConnexion.add(_labelLogin);
		_zoneConnexion.add(_textLogin);
		_zoneConnexion.add(_labelMotDePasse);
		_zoneConnexion.add(_textMotDePasse);
		_zoneConnexion.add(_valideConnexion);
		
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

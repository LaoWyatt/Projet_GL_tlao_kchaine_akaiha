package V0_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class GestionUI extends JFrame {

	private JPanel conteneur;
	private JPanel entete;
	private JLabel titre;
	private JTabbedPane tabs = new JTabbedPane();
	private static Compte _connecter = null;
	
	private ConnexionUI _connexionUI;
	/*
	private CommandeUI commandeUI;
	private ClientUI clientUI;
	private LivreurUI livreurUI;
	*/
	
	public GestionUI() {
		super();
		this.setTitle("Suivi de Commandes");
		this.setSize(600,700);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
		conteneur = new JPanel(new BorderLayout());
		
		
		entete = new JPanel();
	    entete.setBackground(Color.BLUE);
	    titre = new JLabel("Suivi de Commandes");
	    titre.setForeground(Color.WHITE);
	    titre.setFont(new Font("SansSerif",Font.BOLD,24));
	    entete.add(titre);
	    
	    _connexionUI = new ConnexionUI(this);
	    /*
	    commandeUI = new CommandeUI(this);
	    clientUI = new ClientUI(this);
	    livreurUI = new LivreurUI(this);	
	    */	
	    tabs.addTab("Connexion", _connexionUI);
	    /*
	    tabs.addTab("Commande", commandeUI);
	    tabs.addTab("Notation", clientUI);
	    tabs.addTab("Resultats", livreurUI);
	    */
	    
	    
	    conteneur.add(entete,BorderLayout.NORTH);
	    conteneur.add(tabs,BorderLayout.CENTER);	    
	    this.setContentPane(conteneur);
	    this.setVisible(true);
	    this.update();
	}
	
	
	void update() {
		if (_connecter == null) {
			tabs.setEnabledAt(1, false);
			tabs.setEnabledAt(2, false);
			tabs.setEnabledAt(3, false);
		} else {
			tabs.setEnabledAt(1, true);			
			if (_connecter.get_Type() == 1) {
				tabs.setEnabledAt(2, false);	
				tabs.setEnabledAt(3, false);
			} else {
				tabs.setEnabledAt(2, true);	
				tabs.setEnabledAt(3, true);
			}
		}
	}
	
	protected static Compte getConnecter() {
		return _connecter;
	}
	
	protected static void setConnecter(Compte compte) {
		_connecter = compte;
	}
	
	protected ConnexionUI getConnexionUI() {
		return _connexionUI;
	}
	
	public static void main(String[] args) {
		
		new GestionUI();

	}
	
	
}

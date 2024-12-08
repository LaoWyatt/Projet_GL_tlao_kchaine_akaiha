package Livraison;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class GestionUI extends JFrame {

	private JPanel _conteneur;
	private JPanel _entete;
	private JLabel _titre;
	private JTabbedPane _tabs = new JTabbedPane();
	private static Compte _connecter = null;
	
	private ConnexionUI _connexionUI;
	private CommandeUI _commandeUI;
	/*
	private ClientUI clientUI;
	private LivreurUI livreurUI;
	*/
	
	public GestionUI() {
		super();
		this.setTitle("Suivi de Commandes");
		this.setSize(700,800);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
		_conteneur = new JPanel(new BorderLayout());
		
		
		_entete = new JPanel();
	    _entete.setBackground(Color.BLUE);
	    _titre = new JLabel("Suivi de Commandes");
	    _titre.setForeground(Color.WHITE);
	    _titre.setFont(new Font("SansSerif",Font.BOLD,24));
	    _entete.add(_titre);
	    
	    _connexionUI = new ConnexionUI(this);
	    _commandeUI = new CommandeUI(this);
	    /*
	    clientUI = new ClientUI(this);
	    livreurUI = new LivreurUI(this);	
	    */	
	    _tabs.addTab("Connexion", _connexionUI);
	    _tabs.addTab("Commande", _commandeUI);
	    /*
	    tabs.addTab("Notation", clientUI);
	    tabs.addTab("Resultats", livreurUI);
	    */
	    
	    
	    _conteneur.add(_entete,BorderLayout.NORTH);
	    _conteneur.add(_tabs,BorderLayout.CENTER);	    
	    this.setContentPane(_conteneur);
	    this.setVisible(true);
	    this.update();
	}
	
	
	void update() {
		if (_connecter == null) {
			_tabs.setEnabledAt(1, false);
			_tabs.setEnabledAt(2, false);
			_tabs.setEnabledAt(3, false);
		} else {
			_tabs.setEnabledAt(1, true);			
			if (_connecter.get_Type() == 1) {
				_tabs.setEnabledAt(2, false);	
				_tabs.setEnabledAt(3, false);
			} else {
				_tabs.setEnabledAt(2, true);	
				_tabs.setEnabledAt(3, true);
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

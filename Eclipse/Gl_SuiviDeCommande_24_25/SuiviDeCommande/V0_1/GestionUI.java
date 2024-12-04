package V0_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GestionUI extends JFrame {

	private JPanel conteneur;
	private JPanel entete;
	private JLabel titre;
	private JTabbedPane tabs = new JTabbedPane();
	/*
	private ConnexionUI connexionUI;
	private CommandeUI commandeUI;
	private ClientUI clientUI;
	private LivreurUI livreurUI;
	*/
	
	public GestionUI() {
		super();
		this.setTitle("Suivi de Commandes");
		this.setSize(400,600);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
		conteneur = new JPanel(new BorderLayout());
		
		
		entete = new JPanel();
	    entete.setBackground(Color.BLUE);
	    titre = new JLabel("Gestion des études ");
	    titre.setForeground(Color.WHITE);
	    titre.setFont(new Font("SansSerif",Font.BOLD,24));
	    entete.add(titre);
	    
	    /*
	    connexionUI = new ConnexionUI(this);
	    commandeUI = new CommandeUI(this);
	    clientUI = new NotesUI(this);
	    resultatUI = new ResultatsUI(this);		
	    tabs.addTab("Connexion", connexionUI);
	    tabs.addTab("Commande", commandeUI);
	    tabs.addTab("Notation", notationUI);
	    tabs.addTab("Resultats", resultatUI);
	    */
	    
	    
	    conteneur.add(entete,BorderLayout.NORTH);
	    conteneur.add(tabs,BorderLayout.CENTER);	    
	    this.setContentPane(conteneur);
	    this.setVisible(true);
	    this.update();
	}
	
}

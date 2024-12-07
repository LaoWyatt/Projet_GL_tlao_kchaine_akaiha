package Livraison;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

abstract public class PanneauUI extends JPanel {

	GestionUI _fenetre;
	protected JPanel _entete;
	public JPanel _corps;
	protected JLabel _titre;
	
	PanneauUI(GestionUI fenetre){
		super();
		_fenetre = fenetre;
		_entete = new JPanel();
		_corps = new JPanel();
		_titre = new JLabel();
		this.setLayout(new BorderLayout());
	    _titre.setFont(new Font("SansSerif",Font.BOLD,18));
	    _entete.add(_titre);
		this.add(_entete,BorderLayout.NORTH);
	}
	
	abstract void update();
	
}

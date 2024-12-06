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
		// TODO Auto-generated method stub
		
	}

	@Override
	void update() {
		// TODO Auto-generated method stub
		
	}

}

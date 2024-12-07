package Livraison;

public class Administrateur extends Compte {

	private int _id_admin;
	private String _nom_admin;
	private String _prenom_admin;
	static private int _compteur_admin = 1;
	
	Administrateur(String nom, String prenom, String motDePasse) {
		super(nom, prenom, (nom + prenom + _compteur_admin), motDePasse, 3);
		
		boolean verif_vide = !nom.isEmpty() && !prenom.isEmpty();
		
		if (verif_vide) {
			setID_Admin(_id_admin);
			setNom_Admin(nom);
			setPrenom_Admin(prenom);
			
			_compteur_admin++;
		}
		
	}
	
	protected void setID_Admin(int id) {
		_id_admin = id;
	}
	
	public int getID_Admin() {
		return _id_admin;
	}
	
	protected void setNom_Admin(String n) {
		_nom_admin = n;
	}
	
	public String getNom_Admin() {
		return _nom_admin;
	}
	
	protected void setPrenom_Admin(String p) {
		_prenom_admin = p;
	}
	
	public String getPrenom_Admin() {
		return _prenom_admin;
	}
	
}

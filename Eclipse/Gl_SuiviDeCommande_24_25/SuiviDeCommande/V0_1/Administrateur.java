package V0_1;

public class Administrateur extends Compte {

	private int _id_admin;
	private String _nom;
	private String _prenom;
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
		_nom = n;
	}
	
	public String getNom_Admin() {
		return _nom;
	}
	
	protected void setPrenom_Admin(String p) {
		_prenom = p;
	}
	
	public String getPrenom_Admin() {
		return _prenom;
	}
	
}

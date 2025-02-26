package Livraison;

public class Client extends Compte {
	
	private int _id_client;
	private String _nom_client;
	private String _prenom_client;
	private String _code_postale;
	private String _adresse;
	static private int _conteur_cl = 1;
	
	Client(String nom, String prenom, String cp, String adresse, String motDePasse){
		super(nom, prenom, (nom + prenom + _conteur_cl), motDePasse, 1);
			
		boolean verif_vide = !nom.isEmpty() && !prenom.isEmpty() && !cp.isEmpty() && !adresse.isEmpty();
		
		if (verif_vide) {
			setID_Client(_conteur_cl);
			setNom_Client(nom);
			setPrenom_Client(prenom);
			setCodePostal(cp);
			setAdresse(adresse);
			
			_conteur_cl++;
			
		}
	}
	
	protected void setID_Client(int id) {
		_id_client = id;
	}
	
	public int getID_Client() {
		return _id_client;
	}
	
	protected void setNom_Client(String n) {
		_nom_client = n;
	}
	
	public String getNom_Client() {
		return _nom_client;
	}
	
	protected void setPrenom_Client(String p) {
		_prenom_client = p;
	}
	
	public String getPrenom_Client() {
		return _prenom_client;
	}
	
	protected void setCodePostal(String cp) {
		_code_postale = cp;
	}
	
	public String getCodePostal() {
		return _code_postale;
	}
	
	protected void setAdresse(String a) {
		_adresse = a;
	}
	
	public String getAdresse() {
		return _adresse;
	}

}
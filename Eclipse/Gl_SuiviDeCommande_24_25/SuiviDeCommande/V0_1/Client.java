package V0_1;

public class Client {
	
	//----------ATTRIBUTS D'INSTANCE----------//
	
	static private int _conteur = 0;
	private int _id_client;
	private String _motdepasse;
	private String _nom;
	private String _prenom;
	private String _code_postale;
	private String _adresse;
	
	
	//----------CONSTRUCTEURS----------//
	
	Client(String nom, String prenom, String codePostale, String adresse){
		boolean verif_vide = !nom.isEmpty() && !prenom.isEmpty() && !codePostale.isEmpty() && !adresse.isEmpty();
		
		if (verif_vide) {
			_id_client = _conteur;
			_conteur++;
			
			_nom = nom;
			_prenom = prenom;
			_code_postale = codePostale;
			_adresse = adresse;
		}
	}
	
	
	//----------MÉTHODES----------//
	
	public void setId(int id) {
		_id_client = id;
	}
	
	public int getId() {
		return _id_client;
	}
	
	
	public void setNom(String n) {
		_nom = n;
	}
	
	public String getNom() {
		return _nom;
	}
	
	public void setPrenom(String p) {
		_prenom = p;
	}
	
	public String getPrenom() {
		return _prenom;
	}
	
	public void setCodePostal(String cp) {
		_code_postale = cp;
	}
	
	public String getCodePostal() {
		return _code_postale;
	}
	
	public void setAdresse(String a) {
		_adresse = a;
	}
	
	public String getAdresse() {
		return _adresse;
	}
	
	protected boolean setMDP(String mdp) {
		if (!mdp.isEmpty()) {
			_motdepasse = chiffrement(mdp);
			return true;
		} else return false;
	}
	
	private String chiffrement(String mdp) {
		String chif = "";
		
		for (int i = 0; i < mdp.length(); i++) {
			chif += (char) (((int)mdp.charAt(i) * 57 + 8 - 10 + 6) % 255);
		}
		
		return chif;
	}
	
	protected boolean verifMDP(String mdp) {
		return _motdepasse == chiffrement(mdp);
	}
	

}
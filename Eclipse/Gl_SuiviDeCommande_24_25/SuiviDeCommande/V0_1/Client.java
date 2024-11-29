package V0_1;

public class Client {
	
	//----------ATTRIBUTS D'INSTANCE----------//
	
	private int _id_client;
	private String _motdepasse;
	private String _nom;
	private String _prenom;
	private String _code_postale;
	private String _adresse;
	static private int _conteur_cl = 1;
	
	
	//----------CONSTRUCTEURS----------//
	
	Client(String n, String p, String cp, String a){
		boolean verif_vide = !n.isEmpty() && !p.isEmpty() && !cp.isEmpty() && !a.isEmpty();
		
		if (verif_vide) {
			setID_cl(_conteur_cl);
			setNom_cl(n);
			setPrenom_cl(p);
			setCodePostal(cp);
			setAdresse(a);
			
			_conteur_cl++;
			
		}
	}
	
	
	//----------MÉTHODES----------//
	
	protected void setID_cl(int id) {
		_id_client = id;
	}
	
	public int getID_cl() {
		return _id_client;
	}
	
	protected void setNom_cl(String n) {
		_nom = n;
	}
	
	public String getNom_cl() {
		return _nom;
	}
	
	protected void setPrenom_cl(String p) {
		_prenom = p;
	}
	
	public String getPrenom_cl() {
		return _prenom;
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
	
	public int suivreCommande(Commande com) {
		return com.getStatus();
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
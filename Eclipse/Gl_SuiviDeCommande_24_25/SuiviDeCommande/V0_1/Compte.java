package V0_1;

public class Compte {
	private String _nom;
	private String _prenom;
	private String _nomUtilisateur;
	private int _graine, _type;
	private String _motDePasse;
	
	// type d'un compte utilisateur = Client, Livreur ou Administrateur.
	Compte(String nouvNom, String nouvPrenom, String nouvNU, String nouvMDP, int type){
		
		set_NomCompte(nouvNom);
		set_PrenomCompte(nouvPrenom);
		set_NomUtilisateur(nouvNU);
		_graine = (int)(Math.random() * 101);
		setMotDePasse(nouvMDP);
		_type = type;
	}
	
	public String get_NomCompte() {
		return _nom;
	}
	
	protected void set_NomCompte(String nouvNU) {
		_nom = nouvNU;
	}
	
	public String get_PrenomCompte() {
		return _prenom;
	}
	
	protected void set_PrenomCompte(String nouvNU) {
		_prenom = nouvNU;
	}
	
	public String get_NomUtilisateur() {
		return _nomUtilisateur;
	}
	
	protected void set_NomUtilisateur(String nouvNU) {
		_nomUtilisateur = nouvNU;
	}
	
	public int get_Type() {
		return _type;
	}
	
	private String chiffrement(String mdp) {
		String chif = "";
		
		for (int i = 0; i < mdp.length(); i++) {
			chif += (char) (((int)mdp.charAt(i) * _graine + 8 - 10 + 6 * _graine) % 255);
		}
		return chif;
	}
	
	protected boolean setMotDePasse(String nouvMDP) {
		
		if (!nouvMDP.isEmpty()) {
			_motDePasse = chiffrement(nouvMDP);
			return true;
		}
		return false;
	}
	
	protected boolean verificationMotDePasse(String mdp) {
		return _motDePasse.contentEquals(chiffrement(mdp));
	}
}



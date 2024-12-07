package Livraison;

public class Compte {
	private String _nom_compte;
	private String _prenom_compte;
	private String _nomUtilisateur;
	private int _graine, _type;
	private String _motDePasse;
	
	// type d'un compte utilisateur = Client, Livreur ou Administrateur.
	Compte(String nouvNom, String nouvPrenom, String nouvNU, String nouvMDP, int type){
		
		setNom_Compte(nouvNom);
		setPrenom_Compte(nouvPrenom);
		setNom_Utilisateur(nouvNU);
		_graine = (int)(Math.random() * 101);
		setMotDePasse(nouvMDP);
		_type = type;
	}
	
	public String getNom_Compte() {
		return _nom_compte;
	}
	
	protected void setNom_Compte(String nouvNU) {
		_nom_compte = nouvNU;
	}
	
	public String getPrenom_Compte() {
		return _prenom_compte;
	}
	
	protected void setPrenom_Compte(String nouvNU) {
		_prenom_compte = nouvNU;
	}
	
	public String getNom_Utilisateur() {
		return _nomUtilisateur;
	}
	
	protected void setNom_Utilisateur(String nouvNU) {
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



package V0_1;

public class Compte{
	private String _nomUtilisateur;
	private int _graine;
	public String _motDePasse;
	
	
	Compte(String nouvNU, String nouvMDP){
	set_NomUtilisateur(nouvNU);
		_graine = (int)(Math.random() * 101);
		setMotDePasse(nouvMDP);
	
	}
	
	
	public String get_NomUtilisateur() {
		return _nomUtilisateur;
	}
	
	protected void set_NomUtilisateur(String nouvNU) {
		_nomUtilisateur = nouvNU;
	}
	
	private boolean setMotDePasse(String nouvMDP) {
		
		if (!nouvMDP.isEmpty()) {
			_motDePasse = chiffrement(nouvMDP);
			return true;
		}
		return false;
	}
	
	public String chiffrement(String mdp) {
		String chif = "";
		
		for (int i = 0; i < mdp.length(); i++) {
			chif += (char) (((int)mdp.charAt(i) * _graine + 8 - 10 + 6 * _graine) % 255);
		}
		return chif;
	}
	
	protected boolean verificationMotDePasse(String mdp) {
		return _motDePasse.contentEquals(chiffrement(mdp));
	}
}



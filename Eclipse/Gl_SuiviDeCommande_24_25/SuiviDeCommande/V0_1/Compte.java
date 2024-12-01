package V0_1;

public class Compte{
	private String _login;
	private int _graine;
	private String _motDePasse;
	
	
	Compte(String nouvLogin, String nouvMdp){
		setLogin(nouvLogin);
		setMotDePasse(nouvMdp);
		_graine = (int)(Math.random() * 101);
	
	}
	
	
	public String getLogin() {
		return _login;
	}
	
	protected void setLogin(String nouvLogin) {
		_login = nouvLogin;
	}
	
	protected boolean setMotDePasse(String nouvMotDePasse) {
		if (!nouvMotDePasse.isEmpty()) {
			_motDePasse = chiffrement(nouvMotDePasse);
			return true;
		} else return false;
	}
	
	private String chiffrement(String mdp) {
		String chif = "";
		
		for (int i = 0; i < mdp.length(); i++) {
			chif += (char) (((int)mdp.charAt(i) * _graine + 8 - 10 + 6 * _graine) % 255);
		}
		
		return chif;
	}
	
	protected boolean verificationMotDePasse(String mdp) {
		return _motDePasse == chiffrement(mdp);
	}
}



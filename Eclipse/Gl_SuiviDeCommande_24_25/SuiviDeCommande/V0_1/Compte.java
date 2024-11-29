package V0_1;

public class Compte{
	private String _login;
	private int _graine;
	private String _motdepasse;
	
	
	public String getLogin() {
		return _login;
	}
	
	protected void setLogin(String nouvLogin) {
		_login = nouvLogin;
	}
	
	public String getMotDePasse() {
		return _motdepasse;
	}
	
	protected void setMotDePasse(String nouvMotDePasse) {
		_login = nouvMotDePasse;
	}
	
	Compte(String nouvLogin, String nouvMdp){
		setLogin(nouvLogin);
		setMotDePasse(nouvMdp);
		_graine = (int)(Math.random() * 101);
	
 }
}



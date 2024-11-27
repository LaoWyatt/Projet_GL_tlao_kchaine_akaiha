
package V0_1;

public class Client {
	
	static private int _counter = 0;
	private int _id_client;
	private String _password;
	private String _nom;
	private String _prenom;
	private String _code_postale;
	private String _adresse;
	
	
	Client(String nom, String prenom, String codePostale, String adresse){
		boolean check = !nom.isEmpty() && !prenom.isEmpty() && !codePostale.isEmpty() && !adresse.isEmpty();
		
		if (check) {
			_id_client = _counter;
			_counter++;
			
			_nom = nom;
			_prenom = prenom;
			_code_postale = codePostale;
			_adresse = adresse;
		}
	}
	
	
	
	public void setId(int newId) {
		_id_client = newId;
	}
	
	public int getId() {
		return _id_client;
	}
	
	
	public void setNom(String newNom) {
		_nom = newNom;
	}
	
	public String getNom() {
		return _nom;
	}
	
	public void setPrenom(String newPrenom) {
		_prenom = newPrenom;
	}
	
	public String getPrenom() {
		return _prenom;
	}
	
	public void setCodePostal(String newCodePostal) {
		_code_postale = newCodePostal;
	}
	
	public String getPostal() {
		return _code_postale;
	}
	
	public void setAdresse(String newAdresse) {
		_adresse = newAdresse;
	}
	
	public String getAdresse() {
		return _adresse;
	}
	
	private String cyphering(String password) {
		String cyp = "";
		
		for (int i = 0; i < password.length(); i++) {
			cyp += (char) (((int)password.charAt(i) * 57 + 8 - 10 + 6) % 255);
		}
		
		return cyp;
	}
	
	
	

}
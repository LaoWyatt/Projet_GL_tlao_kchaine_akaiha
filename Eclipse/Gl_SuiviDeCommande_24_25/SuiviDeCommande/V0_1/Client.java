
package V0_1;
import java.util.ArrayList;

public class Client {
	
	private int _id_client;
	private String _nom;
	private String _prenom;
	private String _code_postale;
	private String _adresse;
	private ArrayList<int> _commande;
	
	public void setId(int newId) {
		_id_client = newId;
	}
	
	public int getId(void) {
		return _id_client;
	}
	
	
	
	public void setNom(String newNom) {
		_nom = newNom;
	}
	
	public String getNom(void) {
		return _nom;
	}
	
	public void setNom(String newPrenom) {
		_prenom = newPrenom;
	}
	
	public String getPrenom(void) {
		return _prenom;
	}
	
	public void setCodePostal(String newCodePostal) {
		_code_postal = newCodePostal;
	}
	
	public String getPrenom(void) {
		return _code_postal;
	}
	
	public void setAdresse(String newAdresse) {
		_adresse = newAdresse;
	}
	
	public String getPrenom(void) {
		return _adresse;
	}
	
	public void setCommande(ArrayList<int> newCommande) {
		_commande = newCommande;
	}
	
	public ArrayList getCommande(void) {
		return _commande;
	}
	public void addCommande(int idCommande) {
		list = getCommande;
		list.add(idCommande);
		setCommande(list);
		
	}
	
	public void deleteCommande(int idCommande) {
		list = getCommande;
		list.remove(idCommande);
		setCommande(list);
		
	}
	

}
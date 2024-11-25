
package V0_1;

public class Livreur{
	static private int _counterLivreur = 0;
	private int _id_Livreur;
	public boolean _statut;
	
	
	Livreur(){
		_id_Livreur = _counterLivreur;
		_counterLivreur++;
		_statut= true;
	}
	
	public void setIdLivreur(int id) {
		_id_Livreur = id;
	}
	
	public int getIdLivreur() {
		return _id_Livreur;
	}
	
	public void changeStatut() {
		if (_statut == true) {
			_statut = false;
		}else {
			_statut = true;
		}
	}
	
}


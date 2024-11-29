package V0_1;

import java.time.LocalDate;

public class Commande {
	
	//----------ATTRIBUTS D'INSTANCE----------//

    private int _id_commande, _id_client, _id_livreur, _status;
    private LocalDate _date = LocalDate.now();
    static private int _conteur_com = 1;


    //----------CONSTRUCTEURS----------//

    Commande(int id_cl, int id_liv, int stat, LocalDate d){
            
    		setID_com(_conteur_com);
            _id_client = id_cl;
            _id_livreur = id_liv;
            setStatus(stat);
            setDate(d);
            
            _conteur_com++;

    }


    //----------MÉTHODES----------//

    public int getID_com() {
        return _id_commande;
    }
    
    protected void setID_com(int id_com){
        _id_commande = id_com;
    }
    
    public int getStatus() {
        return _status;
    }
    
    public void setStatus(int stat) {
        _status = stat;
    }
    
    public LocalDate getDate() {
        return _date;
    }
    
    protected void setDate(LocalDate d){
        _date = d;
    }
	
}

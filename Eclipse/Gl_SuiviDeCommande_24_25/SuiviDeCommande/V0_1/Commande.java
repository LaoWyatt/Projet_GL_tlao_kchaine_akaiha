package V0_1;

import java.time.LocalDate;

public class Commande {
	
	//----------ATTRIBUTS D'INSTANCE----------//

    private int _id_commande, _id_client, _id_livreur, _status;
    private LocalDate _date = LocalDate.now();
    static private int _conteur_com = 1;


    //----------CONSTRUCTEURS----------//

    Commande(int id_cl, int id_liv){
            
    		setID_Commande(_conteur_com);
            _id_client = id_cl;
            _id_livreur = id_liv;
            setStatus(1);
            
            _conteur_com++;

    }
    
    Commande(int id_cl){
        
		setID_Commande(_conteur_com);
        _id_client = id_cl;
        _id_livreur = 0;
        setStatus(1);
        
        _conteur_com++;

}


    //----------MÉTHODES----------//

    public int getID_Commande() {
        return _id_commande;
    }
    
    public int getID_Client() {
        return _id_client;
    }
    
    public int getID_Livreur() {
        return _id_livreur;
    }
    
    protected void setID_Commande(int id_com){
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

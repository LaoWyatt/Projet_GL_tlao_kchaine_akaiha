package V0_1;

public class Commande {
	
	//----------ATTRIBUTS D'INSTANCE----------//

    private int _id_commande, _id_client, _id_livreur, _status;
    private String _date;


    //----------CONSTRUCTEURS----------//

    Commande(int id_com, int id_cl, int id_liv, int stat, String d){

        // Vérifie qu'aucune variable est vide
        boolean verif_vide = !d.isEmpty();

        if (verif_vide){
            setID_com(id_com);
            setID_cl(id_cl);
            setID_liv(id_liv);
            setStatus(stat);
            setDate(d);
        }

    }


    //----------MÉTHODES----------//

    public int getID_com() {
        return _id_commande;
    }
    protected void setID_com(int id_com){
        _id_commande = id_com;
    }

    public int getID_cl() {
        return _id_client;
    }
    protected void setID_cl(int id_cl){
        _id_client = id_cl;
    }
    
    public int getID_liv() {
        return _id_livreur;
    }
    protected void setID_liv(int id_liv){
        _id_livreur = id_liv;
    }
    
    public int getStatus() {
        return _status;
    }
    protected void setStatus(int stat) {
        _status = stat;
    }
    
    public String getDate() {
        return _date;
    }
    protected void setDate(String d){
        _date = d;
    }
	
}

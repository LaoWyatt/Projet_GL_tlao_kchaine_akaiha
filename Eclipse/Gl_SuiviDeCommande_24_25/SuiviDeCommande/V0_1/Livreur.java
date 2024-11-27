package V0_1;

public class Livreur {
	
	//----------ATTRIBUTS D'INSTANCE----------//

    private int _id_livreur;
    private String _nom, _prenom;
    private boolean _disponibilite;


    //----------CONSTRUCTEURS----------//

    Livreur(int id_liv, String n, String p, boolean dispo){

        // Vérifie qu'aucune variable est vide
        boolean verif_vide = !n.equals("") && !p.equals("");

        if (verif_vide){
            setID(id_liv);
            setNom(n);
            setPrenom(p);
            setDispo(dispo);
        }

    }


    //----------MÉTHODES----------//

    public int getID() {
        return _id_livreur;
    }
    protected void setID(int id){
        _id_livreur = id;
    }

    public int getNom() {
        return _nom;
    }
    protected void setNom(int n){
        _nom = n;
    }
    
    public int getPrenom() {
        return _prenom;
    }
    protected void setPrenom(int p){
        _prenom = p;
    }
    
    public boolean getDispo() {
        return _disponibilite;
    }
    protected void setDispo(boolean dispo){
        _disponibilite = dispo;
    }
	
}
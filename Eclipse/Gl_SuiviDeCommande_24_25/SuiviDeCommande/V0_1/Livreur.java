package V0_1;

public class Livreur {
	
	//----------ATTRIBUTS D'INSTANCE----------//

    private int _id_livreur;
    private String _nom, _prenom;
    private boolean _disponibilite;
    static private int _conteur_liv = 1;


    //----------CONSTRUCTEURS----------//

    Livreur(String n, String p, boolean dispo){

        // Vérifie qu'aucune variable est vide
        boolean verif_vide = !n.isEmpty() && !p.isEmpty();

        if (verif_vide){
            setID_liv(_conteur_liv);
            setNom_liv(n);
            setPrenom_liv(p);
            setDispo(dispo);

            _conteur_liv++;
            
        }

    }


    //----------MÉTHODES----------//

    public int getID_liv() {
        return _id_livreur;
    }
    
    protected void setID_liv(int id){
        _id_livreur = id;
    }

    public String getNom_liv() {
        return _nom;
    }
    
    protected void setNom_liv(String n){
        _nom = n;
    }
    
    public String getPrenom_liv() {
        return _prenom;
    }
    
    protected void setPrenom_liv(String p){
        _prenom = p;
    }
    
    public boolean getDispo() {
        return _disponibilite;
    }
    
    public void setDispo(boolean dispo){
        _disponibilite = dispo;
    }
	
}
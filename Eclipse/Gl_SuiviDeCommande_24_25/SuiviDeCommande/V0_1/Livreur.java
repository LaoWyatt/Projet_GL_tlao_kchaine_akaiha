package V0_1;

public class Livreur extends Compte {

    private int _id_livreur;
    private String _nom, _prenom;
    private boolean _disponibilite;
    static private int _conteur_liv = 1;

    Livreur(String nom, String prenom, boolean dispo, String motDePasse){
    	super((nom + prenom + _conteur_liv), motDePasse,2);

        boolean verif_vide = !nom.isEmpty() && !prenom.isEmpty();

        if (verif_vide){
            setID_Livreur(_conteur_liv);
            setNom_Livreur(nom);
            setPrenom_Livreur(prenom);
            setDispo(dispo);

            _conteur_liv++;
            
        }

    }

    public int getID_Livreur() {
        return _id_livreur;
    }
    
    protected void setID_Livreur(int id){
        _id_livreur = id;
    }

    public String getNom_Livreur() {
        return _nom;
    }
    
    protected void setNom_Livreur(String n){
        _nom = n;
    }
    
    public String getPrenom_Livreur() {
        return _prenom;
    }
    
    protected void setPrenom_Livreur(String p){
        _prenom = p;
    }
    
    public boolean getDispo() {
        return _disponibilite;
    }
    
    public void setDispo(boolean dispo){
        _disponibilite = dispo;
    }
	
}
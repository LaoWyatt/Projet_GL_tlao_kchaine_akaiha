package V0_1;

import java.util.ArrayList;

public class ListCommande {
	
	//----------ATTRIBUTS D'INSTANCE----------//

    private ArrayList<Commande> _listCommande = new ArrayList<Commande>();
	private static int conteur;

    //----------CONSTRUCTEURS----------//

    ListCommande(){

        //

    }


    //----------MÉTHODES----------//

    public Commande getCommande(int num_com) {
    	return _listCommande.get(num_com);
    }
    
    public boolean ajoutCommande(Commande com) {
        boolean ajout = false;
        
        if (com != null) {
        	_listCommande.add(com);
        	ajout = true;
        }
        
    	return ajout;
    }
    
    public boolean modifCommande(Commande com, int num_com) {
        boolean modif = false;
        
        if (com != null && num_com >= 0 && num_com <= _listCommande.size()) {
        	_listCommande.set(num_com, com);
        	modif = true;
        }
        
    	return modif;
    }
    
    public boolean supCommande(int num_com) {
        boolean sup = false;
        
        if (num_com >= 0 && num_com <= _listCommande.size()) {
        	_listCommande.remove(num_com);
        	sup = true;
        }
        
    	return sup;
    }
	
}

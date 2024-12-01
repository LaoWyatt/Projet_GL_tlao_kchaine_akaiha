package V0_1;

import java.util.ArrayList;

public class ListCommande {
	
	//----------ATTRIBUTS D'INSTANCE----------//

    private ArrayList<Commande> _listCommande = new ArrayList<Commande>();

    //----------CONSTRUCTEURS----------//

    ListCommande(){

        // constructeur

    }


    //----------MÉTHODES----------//

    public Commande getCommande(int num_com) {
    	return _listCommande.get(num_com);
    }
    
    public boolean ajoutCommande(Commande com) {
        
        if (com != null) {
        	_listCommande.add(com);
        	return true;
        }
        
    	return false;
    }
    
    public boolean modifCommande(Commande com, int num_com) {
        
        if (com != null && num_com >= 0 && num_com <= _listCommande.size()) {
        	_listCommande.set(num_com, com);
        	return true;
        }
        
    	return false;
    }
    
    public boolean supCommande(int num_com) {
        
        if (num_com >= 0 && num_com <= _listCommande.size()) {
        	_listCommande.remove(num_com);
        	return true;
        }
        
    	return false;
    }
	
}

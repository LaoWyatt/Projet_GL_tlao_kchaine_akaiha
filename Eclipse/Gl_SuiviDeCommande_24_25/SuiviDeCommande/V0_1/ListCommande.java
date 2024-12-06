package V0_1;

import java.util.ArrayList;

public class ListCommande {

    private ArrayList<Commande> _listeCommandes = new ArrayList<Commande>();

    ListCommande(){

        // constructeur

    }

    public Commande getCommande(int id_com) {
    	int i = 0;
    	Commande com = null;
    	
    	while (i < _listeCommandes.size() && com == null) {
    		if (id_com == _listeCommandes.get(i).getID_Commande()) com = _listeCommandes.get(i);
    		i++;
    	}
    	
    	return com;
    }
    
    protected ArrayList<Commande> getCommandes() {
    	return _listeCommandes;
    }
    
    public ArrayList<Commande> getClientCommande(int idClient){
    	ArrayList<Commande> listeDuClient = new ArrayList<>();
    	
    	for (Commande uneCommande : _listeCommandes) {
    		if (uneCommande.getID_Client() == idClient) {
    			listeDuClient.add(uneCommande);
    		}
    	}
    	
    	return listeDuClient;
    }
    
    public ArrayList<Commande> getLivreurCommande(int idLivreur){
    	ArrayList<Commande> listeDuLivreur = new ArrayList<>();
    	
    	for (Commande uneCommande : _listeCommandes) {
    		if (uneCommande.getID_Livreur() == idLivreur) {
    			listeDuLivreur.add(uneCommande);
    		}
    	}
    	
    	return listeDuLivreur;
    }
    
    public void ajoutCommande(Commande com) {
        
        if (com != null) {
        	_listeCommandes.add(com);
        }
        
    }
    
    public void modifCommande(Commande com, int id_com) {
    	int i = 0;
    	
    	if (com != null) {
    		while (i < _listeCommandes.size()) {
	    		if (id_com == _listeCommandes.get(i).getID_Commande()) {
	    			_listeCommandes.set(i, com);
	    		}
	    		i++;
	    	}
    	}
    	
    }
    
    public void supCommande(int id_com) {
        int i = 0;
    		
        while (i < _listeCommandes.size()) {
    		if (id_com == _listeCommandes.get(i).getID_Commande()) {
    			_listeCommandes.remove(i);
    		}
    		i++;
    	}
        
    }
	
}

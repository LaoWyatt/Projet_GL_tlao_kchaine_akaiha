package V0_1;

import java.util.ArrayList;

public class ListCommande {

    private ArrayList<Commande> _listeCommandes = new ArrayList<Commande>();

    ListCommande(){

        // constructeur

    }

    public Commande getCommande(int ID_com) {
    	int i = 0;
    	Commande seek = null;
    	
    	while (i < _listeCommandes.size() && seek == null) {
    		if (ID_com == _listeCommandes.get(i).getID_Commande()) seek = _listeCommandes.get(i);
    		i++;
    	}
    	
    	return seek;
    }
    
    protected ArrayList getCommandes() {
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
    
    public void modifCommande(Commande com, int num_com) {
        
        if (com != null && num_com >= 0 && num_com <= _listeCommandes.size()) {
        	_listeCommandes.set(num_com, com);
        }
        
    }
    
    public void supCommande(int num_com) {
        
        if (num_com >= 0 && num_com <= _listeCommandes.size()) {
        	_listeCommandes.remove(num_com);
        }
        
    }
	
}

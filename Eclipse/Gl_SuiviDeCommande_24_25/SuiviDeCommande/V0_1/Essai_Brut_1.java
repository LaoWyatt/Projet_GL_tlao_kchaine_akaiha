package V0_1;

import java.util.ArrayList;

public class Essai_Brut_1 {
	
	private ArrayList<Livreur> _delivers;
	private ArrayList<Client> _clients;
	private ListCommande _commandes = new ListCommande();
	
	public void addClient() {
		//;
	}
	
	public void addLivreur() {
		//;
	}
	
	public void setDelivers(ArrayList<Livreur> newDelivers){
		_delivers = newDelivers;
	}

	
	
	public ArrayList<Livreur> getDelivers(){
		return _delivers;
	}
	
	
	public void setClient(ArrayList<Client> newClient){
		_clients = newClient;
	}

	
	
	public ArrayList<Client> getClients(){
		return _clients;
	}
	
	
	
	public void createCommande(String Contenu, int IdClient, int IdLivreur) {
		//Commande newCommande =  new Commande();
	}
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}

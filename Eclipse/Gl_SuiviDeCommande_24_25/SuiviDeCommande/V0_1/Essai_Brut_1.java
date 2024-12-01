package V0_1;

import java.util.ArrayList;
import java.util.Scanner;

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

		int decision = -1;
		
		while (decision != 0){
			System.out.print("----{ Suivie de commande 1 }----\n\n");
			
			System.out.print("[ Liste de processus ]\n>> Saisisez 0 pour quitter\n\n");
			System.out.print("1> ...\n");
			System.out.print("2> ...\n");
			System.out.print("3> ...\n");
			System.out.print("4> ...\n");
			System.out.print("5> ...\n");
			System.out.print("6> ...\n\n");
		
			System.out.print("Numéro de processus : ");
			Scanner keyboard = new Scanner(System.in);
			decision = keyboard.nextInt();
			
			switch(decision) {
			
			case 0:
				keyboard.close();
				break;
				
			case 1:
				System.out.print("Hello Process !\n\n");
				break;
				
			default:
				System.out.print("Hello World !\n\n");
			
			}
		
		}
		
		System.out.print("Bye Bye !\n\n");
		return;
	}
	
	

}

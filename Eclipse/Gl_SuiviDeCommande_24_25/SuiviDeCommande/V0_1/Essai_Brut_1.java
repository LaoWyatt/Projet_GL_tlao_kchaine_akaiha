package V0_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Essai_Brut_1 {
	
	private static Compte _connecter = null;
	private static ArrayList<Livreur> _delivers = new ArrayList<>();
	private static ArrayList<Client> _clients = new ArrayList<>();
	private static ListCommande _commandes = new ListCommande();
	
	public static void connexion(int type, String nomUtilisateur, String mdp) {
		int i = 0;
		
		if (type == 0 && !_clients.isEmpty()) {
			
			while (i < _clients.size() && _connecter == null) {
				if (_clients.get(i).get_NomUtilisateur().contentEquals(nomUtilisateur)) {
					_connecter = _clients.get(i);
				}
				i++;
			}
			
		} else if (!_delivers.isEmpty()) {
			
			while (i < _delivers.size() && _delivers == null) {
				if (_delivers.get(i).get_NomUtilisateur().contentEquals(nomUtilisateur)) {
					_connecter = _delivers.get(i);
				}
				i++;
			}
			
		}

		if (_connecter != null && !_connecter.verificationMotDePasse(mdp)) _connecter = null;
		
	}
	
	public static void addClient() {
		//;
	}
	
	public static void addLivreur() {
		//;
	}
	
	public static void setDelivers(ArrayList<Livreur> newDelivers){
		_delivers = newDelivers;
	}

	
	
	public static ArrayList<Livreur> getDelivers(){
		return _delivers;
	}
	
	
	public static void setClient(ArrayList<Client> newClient){
		_clients = newClient;
	}

	
	
	public static ArrayList<Client> getClients(){
		return _clients;
	}
	
	
	
	public static void createCommande(String Contenu, int IdClient, int IdLivreur) {
		//Commande newCommande =  new Commande();
	}
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int decision = -1;
		_clients.add(new Client("Ultimate","Admin","00000","JAVA","HelloWorld"));
		
		
		while (decision != 0){
			System.out.print("----{ Suivie de commande 1 }----\n\n");
			
			System.out.print("[ Liste de processus ]\n>> Saisisez 0 pour quitter\n\n");
			System.out.print("1> Connexion\n");
			
			if (_connecter == null) {
				System.out.print("2> Inscription\n");
			} else {
				System.out.print("2> Déconnexion\n");
			}

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
				if (_connecter == null) {
					System.out.print(">>> Connexion du compte <<<\n\n");
					System.out.print("Nom utilisateur : ");
					
					String nomUtilisateur = keyboard.next();
					
					System.out.print("\nMot de passe : ");
					
					String mdp  = keyboard.next();
					
					System.out.print("\nLivreur (Y/N) :");
					
					String type = keyboard.next();
					int logicType = 0;
					if (type == "Y") logicType = 1;
					
					connexion(logicType,nomUtilisateur,mdp);
					
					if (_connecter == null) {
						System.out.print("\n\nLogin ou Mot de passe incorrect !\n\n");
					} else {
						System.out.print("\n\nBienvunue "+ _connecter.get_NomUtilisateur() +"\n\n");
					}
				} else {
					System.out.print("\n\nConnexion actif en tant que "+ _connecter.get_NomUtilisateur() +" !\n\n");
				}
				
				break;
				
			case 2:
				if (_connecter == null) {
					
				} else {
					System.out.print("\n\nAu revoir "+ _connecter.get_NomUtilisateur() +" !\n\n");
					_connecter = null;
				}
				
				break;
				
			default:
				System.out.print("Hello World !\n\n");
			
			}
		
		}
		
		System.out.print("Bye Bye !\n\n");
		return;
	}
	
	

}

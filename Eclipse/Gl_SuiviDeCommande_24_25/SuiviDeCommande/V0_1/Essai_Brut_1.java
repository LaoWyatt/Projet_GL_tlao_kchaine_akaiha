package V0_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Essai_Brut_1 {
	
	private static Compte _connecter = null;
	private static ArrayList<Livreur> _livreurs = new ArrayList<>();
	private static ArrayList<Client> _clients = new ArrayList<>();;
	private static ArrayList<Administrateur> _administrateurs = new ArrayList<>();
	private static ListCommande _commandes = new ListCommande();
	
	public static void connexion(int type, String nomUtilisateur, String mdp) {
		int i = 0;
		
		switch(type) {
			
			case 1:
				if (!_clients.isEmpty()) {
					while (i < _clients.size() && _connecter == null) {
						if (_clients.get(i).get_NomUtilisateur().contentEquals(nomUtilisateur)) {
							_connecter = _clients.get(i);
						}
						i++;
					}
				}
				break;
			
			case 2:
				if (!_livreurs.isEmpty()) {
					
					while (i < _livreurs.size() && _livreurs == null) {
						if (_livreurs.get(i).get_NomUtilisateur().contentEquals(nomUtilisateur)) {
							_connecter = _livreurs.get(i);
						}
						i++;
					}
				}
				break;
				
			case 3:
				if (!_administrateurs.isEmpty()) {
					
					while (i < _administrateurs.size() && _administrateurs == null) {
						if (_administrateurs.get(i).get_NomUtilisateur().contentEquals(nomUtilisateur)) {
							_connecter = _administrateurs.get(i);
						}
						i++;
					}
				}
				break;
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
		_livreurs = newDelivers;
	}

	
	
	public static ArrayList<Livreur> getDelivers(){
		return _livreurs;
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
	

	

	@SuppressWarnings({ "unlikely-arg-type", "unchecked" })
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
				System.out.print("3> Liste de Commande\n");
			}

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
					
					System.out.print("\n(1) Client / (2) Livreur / (3) administrateur :");
					
					int type = keyboard.nextInt();
					
					connexion(type,nomUtilisateur,mdp);
					
					if (_connecter == null) {
						System.out.print("\n\nLogin ou Mot de passe incorrect !\n\n");
					} else {
						System.out.print("\n\nBienvunue "+ _connecter.get_NomUtilisateur() +"\n\n");
					}
				} else {
					System.out.print("\n\nConnexion actif en tant que "+ _connecter.get_NomUtilisateur() +" !\n");
					System.out.print("Connexion actif en tant que "+ _connecter.getClass().getName() +" !\n\n");
				}
				
				break;
				
			case 2:
				if (_connecter == null) {
					
				} else {
					System.out.print("\n\nAu revoir "+ _connecter.get_NomUtilisateur() +" !\n\n");
					_connecter = null;
				}
				
				break;
				
			case 3:
				if (_connecter != null) {
					
					ArrayList<Commande> commandesActuelle;
					
					if (_connecter.equals(_clients.getClass()) && ((Client) _connecter).getID_Client() != 0) {
						commandesActuelle = _commandes.getClientCommande((((Client) _connecter).getID_Client()));
						
					} else if (_connecter.equals(_livreurs.getClass())) {
						commandesActuelle = _commandes.getLivreurCommande((((Livreur) _connecter).getID_Livreur()));
						
					} else if (_connecter.equals(_clients.getClass()) && ((Client) _connecter).getID_Client() == 0) {
						commandesActuelle = _commandes.getCommandes(((Client) _connecter));
					}
					
				}
				
			default:
				System.out.print("Hello World !\n\n");
			
			}
		
		}
		
		System.out.print("Bye Bye !\n\n");
		return;
	}
	
	

}

package V0_1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.Console;



public class Essai_Brut_1 {
	
	private static Compte _connecter = null;
	private static ArrayList<Livreur> _livreurs = new ArrayList<>();
	private static ArrayList<Client> _clients = new ArrayList<>();
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
	
	public static void supLivreur() {
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
	
	public static void afficherCommandes(ArrayList<Commande> toDisplay) {
		System.out.println("\n\nID Commande\tID Client\tID Livreur\tDate");
		
		for (Commande c: toDisplay) {
			System.out.println(c.getID_Commande() + "\t" + c.getID_Client() + "\t" + c.getID_Livreur() + "\t" + c.getDate());
		}
		
		System.out.println("\n--------------------------");
		
	}
	
	public static void creerCommande(String Contenu, int IdClient, int IdLivreur) {
		//Commande newCommande =  new Commande();
	}
	
	public static void gestionDeConnexion(Scanner keyboard) {
		if (_connecter == null) {
			System.out.print(">>> Connexion du compte <<<\n\n");
			System.out.print("Nom utilisateur : ");
			
			String nomUtilisateur = keyboard.next();
			
			System.out.print("\nMot de passe : ");

			Console console = System.console();
			String mdp  = new String(console.readPassword("Mot de passe: "));
			
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
	}
	
	public static void inscription(Scanner keyboard, int type) {
		
		Console console = System.console();
		System.out.print(">> Inscription <<\n\n");
		
		String nom = "";
		while (nom.isBlank()) {
			System.out.print("\nNom : ");
			nom = keyboard.next();
		}
		
		String prenom = "";
		while (prenom.isBlank()) {
			System.out.print("\nPrénom : ");
			prenom = keyboard.next();
		}
		
		String mdp = "";
		while (mdp.isBlank()) {
			mdp = new String(console.readPassword("\nMot de passe: "));
		}
		
		String confirmation = "";
		while (confirmation.contentEquals(mdp)) {
			confirmation = new String(console.readPassword("\nConfirmer mot de passe: "));
		}
		
		switch(type) {
		
		case 1:
			String codePostal = "";
			while (codePostal.isBlank()) {
				System.out.print("\nCode postal : ");
				codePostal = keyboard.next();
			}
			
			String adresse = "";
			while (adresse.isBlank()) {
				System.out.print("\nAdresse : ");
				adresse = keyboard.next();
			}
			Client temporaireC = new Client(nom,prenom,codePostal,adresse,mdp);
			_clients.add(temporaireC);
			System.out.print("\n\nBienvenue " + temporaireC.getNom_Client() + temporaireC.getPrenom_Client()
								+ " ! Vôtre nom d'utilisateur est : " + temporaireC.get_NomUtilisateur() 
								+ ". Veuillez vous connecter à nouveau.\n\n");
			break;
			
		case 2:
			boolean disponibilite = false;
			int dispo = -1;
			while (dispo == -1) {
				System.out.print("\nDisponibilité : ");
				dispo = keyboard.nextInt();
				disponibilite = (dispo == 1);
			}
			
			Livreur temporaireL = new Livreur(nom,prenom,disponibilite,mdp);
			_livreurs.add(temporaireL);
			System.out.print("\n\nBienvenue " + temporaireL.getNom_Livreur() + temporaireL.getPrenom_Livreur()
								+ " ! Vôtre nom d'utilisateur est : " + temporaireL.get_NomUtilisateur() 
								+ ". Veuillez vous connecter à nouveau.\n\n");
			break;
			
		case 3:
			Administrateur temporaireA = new Administrateur(nom,prenom,mdp);
			_administrateurs.add(temporaireA);
			System.out.print("\n\nBienvenue " + nom + prenom
								+ " ! Vôtre nom d'utilisateur est : " + temporaireA.get_NomUtilisateur() 
								+ ". Veuillez vous connecter à nouveau.\n\n");
			break;
			
		}
	}
	
	
    @SuppressWarnings({ "unlikely-arg-type", "unchecked" })
	public static void listeCommande(Scanner key) {
    	if (_connecter != null) {
			
			ArrayList<Commande> commandesActuelle = null;
			boolean gestion = false;
			
			if (_connecter.equals(_clients.getClass())) {
				commandesActuelle = _commandes.getClientCommande((((Client) _connecter).getID_Client()));
				
			} else if (_connecter.equals(_livreurs.getClass())) {
				commandesActuelle = _commandes.getLivreurCommande((((Livreur) _connecter).getID_Livreur()));
				gestion = true;
				
			} else if (_connecter.equals(_administrateurs.getClass())) {
				commandesActuelle = _commandes.getCommandes();
				gestion = true;
			}
			
			afficherCommandes(commandesActuelle);
			
			if (gestion) {
				int decision = -1;
				
				while (decision != -1) {
						
					System.out.print(">> Opération (0 pour sortir) <<\n\n");
					System.out.print("1> Modifier statut d'une commande\n");
					System.out.print("2> ...\n\n");
					
					System.out.print("Opération : ");
					decision = key.nextInt();
					
					switch(decision) {
						case 1:
							System.out.print("\n\nIddentifiant de la Commande : ");
							int ID = key.nextInt();

							System.out.print("\n[1]En Préparation, [2] En Livraison, [3] Livré : ");
							int statut = key.nextInt();
							
							Commande temporaire = _commandes.getCommande(ID);
							temporaire.setStatus(statut);
							break;
						default:
							System.out.print("\n\n");
					}
				}
			}
		} 
    }
	
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int decision = -1;
		_administrateurs.add(new Administrateur("Ultimate","Admin","HelloWorld"));
		
		
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
				gestionDeConnexion(keyboard);
				break;
				
			case 2:
				if (_connecter == null) {
					inscription(keyboard,1);
				} else {
					System.out.print("\n\nAu revoir "+ _connecter.get_NomUtilisateur() +" !\n\n");
					_connecter = null;
				}
				
				break;
				
			case 3:
				listeCommande(keyboard);
				break;
				
			default:
				System.out.print("Hello World !\n\n");
			}
		
		}
		
		System.out.print("Bye Bye !\n\n");
		return;
	}
	
	

}

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
	
	public void supLivreur(int num_liv) {
		
		if (num_liv >= 1 && num_liv <= _livreurs.size()+1) {
			_livreurs.remove(num_liv-1);
        }
        
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
		if (toDisplay != null) {
			for (Commande c: toDisplay) {
				System.out.println(c.getID_Commande() + "\t\t" + c.getID_Client() + "\t\t" + c.getID_Livreur() + "\t\t" + c.getDate());
			}
		}
		
		
		System.out.println("\n--------------------------");
		
	}
	
	public static void creerCommande() {
		int num_liv = 0;
		
		while (num_liv < _livreurs.size() && _livreurs.get(num_liv).getDispo() == false) {
			num_liv++;
		}
		

		if (_livreurs.get(num_liv).getDispo()) {
			Commande newCommande =  new Commande(((Client) _connecter).getID_Client(), _livreurs.get(num_liv).getID_Livreur());

			_commandes.ajoutCommande(newCommande);
		}
		else {
			Commande newCommande =  new Commande(((Client) _connecter).getID_Client());
			_commandes.ajoutCommande(newCommande);
		}
		
	}
	
	public static void gestionDeConnexion(Scanner clavier) {
		if (_connecter == null) {
			System.out.print("\n>>> Connexion du compte <<<\n\n");
			System.out.print("Nom utilisateur : ");
			
			String nomUtilisateur = clavier.next();

			Console console = System.console();
			String mdp  = new String(console.readPassword("Mot de passe: "));
			
			System.out.print("\n(1) Client / (2) Livreur / (3) administrateur : ");
			
			int type = clavier.nextInt();
			
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
	
	public static void inscription(Scanner clavier, int type) {
		
		Console console = System.console();
		System.out.print(">> Inscription <<\n\n");
		
		String nom = "";
		while (nom.isBlank()) {
			System.out.print("\nNom : ");
			nom = clavier.next();
		}
		
		String prenom = "";
		while (prenom.isBlank()) {
			System.out.print("\nPrénom : ");
			prenom = clavier.next();
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
				codePostal = clavier.next();
			}
			
			String adresse = "";
			while (adresse.isBlank()) {
				System.out.print("\nAdresse : ");
				adresse = clavier.next();
			}
			Client temporaireC = new Client(nom,prenom,codePostal,adresse,mdp);
			_clients.add(temporaireC);
			System.out.print("\n\nBienvenue " + temporaireC.getNom_Client() + temporaireC.getPrenom_Client()
								+ " ! Votre nom d'utilisateur est : " + temporaireC.get_NomUtilisateur() 
								+ ". Veuillez vous connecter à nouveau.\n\n");
			break;
			
		case 2:
			boolean disponibilite = false;
			int dispo = -1;
			while (dispo == -1) {
				System.out.print("\nDisponibilité (0 : non disponible / 1 : disponible) : ");
				dispo = clavier.nextInt();
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
	
	
    @SuppressWarnings({ "unchecked" })
	public static void listeCommande(Scanner cle) {
    	if (_connecter != null) {
			
			ArrayList<Commande> commandesActuelle = null;
			boolean gestion = false;
			
			if (_connecter.get_Type() == 1) {
				commandesActuelle = _commandes.getClientCommande((((Client) _connecter).getID_Client()));
				
			} else if (_connecter.get_Type() == 2) {
				commandesActuelle = _commandes.getLivreurCommande((((Livreur) _connecter).getID_Livreur()));
				gestion = true;
				
			} else if (_connecter.get_Type() == 3) {
				commandesActuelle = _commandes.getCommandes();
				gestion = true;
			}
			
			afficherCommandes(commandesActuelle);
			int decision = -1;
			if (gestion) {
				
				while (decision != 0) {
						
					System.out.print(">> Opération (0 pour sortir) <<\n\n");
					System.out.print("1> Modifier statut d'une commande\n");
					
					System.out.print("Opération : ");
					decision = cle.nextInt();
					
					switch(decision) {
						case 1:
							System.out.print("\n\nIddentifiant de la Commande : ");
							int ID = cle.nextInt();

							System.out.print("\n[1]En Préparation, [2] En Livraison, [3] Livré : ");
							int statut = cle.nextInt();
							
							Commande temporaire = _commandes.getCommande(ID);
							temporaire.setStatus(statut);
							break;
						default:
							System.out.print("\n\n");
					}
				}
			}
			
			else {
				
				while (decision != 0) {
						
					System.out.print(">> Opération (0 pour sortir) <<\n\n");
					System.out.print("1> Commander\n\n");
					
					System.out.print("Opération : ");
					decision = cle.nextInt();
					
					switch(decision) {
						case 1:
							System.out.print("\n\nCommandé !");
							creerCommande();
							break;
						default:
							System.out.print("\n\n");
					}
				}
			}
			
		} 
    }
	
    
    public static void informationsCompte(Scanner clavier) {
    	if (_connecter != null) {
    		System.out.print(">>> Informations du compte <<<\n\n");
        	
        	System.out.print("Nom : " + _connecter.get_NomCompte());
        	
        	System.out.print("\nPrenom : " + _connecter.get_PrenomCompte());
        	
    		System.out.print("\nNom utilisateur : " + _connecter.get_NomUtilisateur());
    		System.out.print("\nType d'utilisateur : ");
    		
    		if (_connecter.get_Type() == 1) {
    			System.out.print("Client");
    			System.out.print("\nAdresse : " + ((Client)_connecter).getAdresse());
    			System.out.print("\nCode postal : " + ((Client)_connecter).getCodePostal());
    			
    		}
    		else if (_connecter.get_Type() == 2) {
    			System.out.print("Livreur\n");
    			System.out.print("\nDisponibilité : " + ((Livreur)_connecter).getDispo());
    			
    		}
    		else {
    			System.out.print("Administrateur\n");
    			
    		}
    		
    		System.out.print("\nVoulez-vous modifier vos informations ? (0 : quitter / 1 : modifier) : ");
    		
    		int rep = clavier.nextInt();
    		
    		if (rep == 1) {
    			Console console = System.console();
    			
    			System.out.print("\n\n>>> Modifactions du compte <<<\n\n");
    			String nom = "";
    			while (nom.isBlank()) {
    				System.out.print("\nNom : ");
    				nom = clavier.next();
    			}
    			
    			String prenom = "";
    			while (prenom.isBlank()) {
    				System.out.print("\nPrénom : ");
    				prenom = clavier.next();
    			}
    			
    			String mdp = "";
    			while (mdp.isBlank()) {
    				mdp = new String(console.readPassword("\nMot de passe: "));
    			}
    			
    			String confirmation = "";
    			while (confirmation.contentEquals(mdp)) {
    				confirmation = new String(console.readPassword("\nConfirmer mot de passe: "));
    			}
    			
    			switch(_connecter.get_Type()) {
    			
    			case 1:
    				String codePostal = "";
    				while (codePostal.isBlank()) {
    					System.out.print("\nCode postal : ");
    					codePostal = clavier.next();
    				}
    				
    				String adresse = "";
    				while (adresse.isBlank()) {
    					System.out.print("\nAdresse : ");
    					adresse = clavier.next();
    				}
    				Client temporaireC = new Client(nom,prenom,codePostal,adresse,mdp);
    				_clients.set(((Client)_connecter).getID_Client(), temporaireC);
    				System.out.print("\n\nBienvenue " + temporaireC.getNom_Client() + temporaireC.getPrenom_Client()
    									+ " ! Votre nom d'utilisateur est : " + temporaireC.get_NomUtilisateur() 
    									+ ". Veuillez vous connecter à nouveau.\n\n");
    				break;
    				
    			case 2:
    				boolean disponibilite = false;
    				int dispo = -1;
    				while (dispo == -1) {
    					System.out.print("\nDisponibilité (0 : non disponible / 1 : disponible) : ");
    					dispo = clavier.nextInt();
    					disponibilite = (dispo == 1);
    				}
    				
    				Livreur temporaireL = new Livreur(nom,prenom,disponibilite,mdp);
    				_livreurs.set(((Livreur)_connecter).getID_Livreur(), temporaireL);
    				System.out.print("\n\nBienvenue " + temporaireL.getNom_Livreur() + temporaireL.getPrenom_Livreur()
    									+ " ! Vôtre nom d'utilisateur est : " + temporaireL.get_NomUtilisateur() 
    									+ ". Veuillez vous connecter à nouveau.\n\n");
    				break;
    				
    			case 3:
    				Administrateur temporaireA = new Administrateur(nom,prenom,mdp);
    				_administrateurs.set(((Administrateur)_connecter).getID_Admin(), temporaireA);
    				System.out.print("\n\nBienvenue " + nom + prenom
    									+ " ! Vôtre nom d'utilisateur est : " + temporaireA.get_NomUtilisateur() 
    									+ ". Veuillez vous connecter à nouveau.\n\n");
    				break;
    				
    			}
    		}
    		
    	}
    	
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int decision = -1;
		_administrateurs.add(new Administrateur("Ultimate","Admin","HelloWorld"));
		_livreurs.add(new Livreur("Ultimate","Livreur",true,"DaFloof"));
		_clients.add(new Client("a","a","1","a","a"));
		
		while (decision != 0){
			System.out.print("----{ Suivie de commande 1 }----\n\n");
			
			System.out.print("[ Liste de processus ]\n>> Saisisez 0 pour quitter\n\n");
			
			if (_connecter == null) {
				System.out.print("1> Connexion\n");
				System.out.print("2> Inscription\n");
			} else {
				System.out.print("3> Liste de commandes\n"); 
				System.out.print("4> Mes informations\n");
				System.out.print("5> Déconnexion\n\n");
				
				if (_connecter.get_Type() == 2 || _connecter.get_Type() == 3) {
					System.out.print("6> Liste de clients\n");
					System.out.print("7> Disponibilité du livreur\n\n");
				}
				
			}
		
			System.out.print("Numéro de processus : ");
			Scanner clavier = new Scanner(System.in);
			decision = clavier.nextInt();
			
			switch(decision) {
			
			case 0:
				clavier.close();
				break;
				
			case 1:
				gestionDeConnexion(clavier);
				break;
				
			case 2:
				if (_connecter == null) {
					inscription(clavier,1);
				} else {
					System.out.print("\n\nAu revoir "+ _connecter.get_NomUtilisateur() +" !\n\n");
					_connecter = null;
				}
				
				break;
				
			case 3:
				listeCommande(clavier);
				break;
			
			case 4:
				informationsCompte(clavier);
				break;
			
			case 5:
				clavier.close();
				break;
				
			default:
				System.out.print("Hello World !\n\n");
			}
		
		}
		
		System.out.print("Bye Bye !\n\n");
		return;
	}
	
	

}

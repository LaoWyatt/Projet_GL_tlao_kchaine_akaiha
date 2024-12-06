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
	
	public static void setClients(ArrayList<Client> nouvClients){
		_clients = nouvClients;
	}

	public static ArrayList<Client> getClients(){
		return _clients;
	}
	
	public void modifClient(int num_cl, Client cl) {
		
		if (num_cl >= 1 && num_cl < _clients.size()) {
			_clients.set(num_cl, cl);
        }
		
	}
	
	public void supClient(int num_cl) {
		
		if (num_cl >= 1 && num_cl < _clients.size()) {
			_clients.remove(num_cl);
        }
        
	}
	
	public static void setLivreurs(ArrayList<Livreur> nouvLivreurs){
		_livreurs = nouvLivreurs;
	}

	public static ArrayList<Livreur> getLivreurs(){
		return _livreurs;
	}
	
	public void ajoutLivreur(Livreur liv) {
			_livreurs.add(liv);
	}
	
	public void modifLivreur(int num_liv, Livreur liv) {
		
		if (num_liv >= 1 && num_liv < _livreurs.size()) {
			_livreurs.set(num_liv, liv);
        }
        
	}
	
	public void supLivreur(int num_liv) {
		
		if (num_liv >= 1 && num_liv < _livreurs.size()) {
			_livreurs.remove(num_liv);
        }
        
	}
	
	public static void creerCommande() {
		int num_liv = 0;
		
		while (num_liv < _livreurs.size() && _livreurs.get(num_liv).getDispo() == false) {
			num_liv++;
		}

		if (_livreurs.get(num_liv).getDispo()) {
			Commande nouvCommande =  new Commande(((Client) _connecter).getID_Client(), _livreurs.get(num_liv).getID_Livreur());
			_commandes.ajoutCommande(nouvCommande);
		}
		else {
			Commande nouvCommande =  new Commande(((Client) _connecter).getID_Client());
			_commandes.ajoutCommande(nouvCommande);
		}
		
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
			
			int decision = -1;
			if (gestion) {
				
				while (decision != 0) {
					afficherCommandes(commandesActuelle);
					System.out.print(">> Opération (0 pour sortir) <<\n\n");
					System.out.print("1> Modifier statut d'une commande\n");
					
					System.out.print("Opération : ");
					decision = cle.nextInt();
					
					switch(decision) {
						case 1:
							System.out.print("\n\nIdentifiant de la Commande : ");
							int ID = cle.nextInt();

							System.out.print("\nStatut = (1) En Préparation / (2) En Livraison (3) Livrée : ");
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
					afficherCommandes(commandesActuelle);
					System.out.print("\n>> Opération (0 pour sortir) <<\n\n");
					System.out.print("1> Commander\n\n");
					
					System.out.print("Opération : ");
					decision = cle.nextInt();
					
					switch(decision) {
						case 1:
							System.out.print("\nCommandé !\n");
							creerCommande();
							break;
						default:
							System.out.print("\n\n");
					}
				}
			}
			
		}
    	else {
    		System.out.print("\nL'option saisie est inconnue.\n");
    	}
    	
    }
	
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
	
	public static void gestionDeConnexion(Scanner clavier) {
		if (_connecter == null) {
			System.out.print("\n>>> Connexion du compte <<<\n\n");
			System.out.print("Nom d'utilisateur : ");
			
			String nomUtilisateur = clavier.next();

			Console console = System.console();
			String mdp  = new String(console.readPassword("Mot de passe : "));
			
			System.out.print("\nStatut = (1) Client / (2) Livreur / (3) Administrateur : ");
			
			int type = clavier.nextInt();
			
			connexion(type,nomUtilisateur,mdp);
			
			if (_connecter == null) {
				System.out.print("\nNom d'utilisateur, mot de passe ou statut incorrect!\n\n\n");
			} else {
				System.out.print("\nBienvenue "+ _connecter.get_NomUtilisateur() +"\n\n");
			}
		} else {
			System.out.print("\nConnexion active en tant que "+ _connecter.get_NomUtilisateur() +" !\n");
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
			System.out.print("\nPrenom : ");
			prenom = clavier.next();
		}
		
		String mdp = "";
		while (mdp.isBlank()) {
			mdp = new String(console.readPassword("\nMot de passe: "));
		}
		
		String confirmation = "";
		while (confirmation.contentEquals(mdp)) {
			confirmation = new String(console.readPassword("\nConfirmation du mot de passe: "));
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
				System.out.print("\nDisponibilité = (0) non disponible / (1) disponible : ");
				dispo = clavier.nextInt();
				disponibilite = (dispo == 1);
			}
			
			Livreur temporaireL = new Livreur(nom,prenom,disponibilite,mdp);
			_livreurs.add(temporaireL);
			System.out.print("\n\nBienvenue " + temporaireL.getNom_Livreur() + temporaireL.getPrenom_Livreur()
								+ " ! Votre nom d'utilisateur est : " + temporaireL.get_NomUtilisateur() 
								+ ". Veuillez vous connecter à nouveau.\n\n");
			break;
			
		case 3:
			Administrateur temporaireA = new Administrateur(nom,prenom,mdp);
			_administrateurs.add(temporaireA);
			System.out.print("\n\nBienvenue " + nom + prenom
								+ " ! Votre nom d'utilisateur est : " + temporaireA.get_NomUtilisateur() 
								+ ". Veuillez vous connecter à nouveau.\n\n");
			break;
			
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
    			System.out.print("Livreur");
    			System.out.print("\nDisponibilité : " + ((Livreur)_connecter).getDispo());
    			
    		}
    		else {
    			System.out.print("Administrateur");
    			
    		}
    		
    		System.out.print("\nVoulez-vous modifier vos informations ? (0) quitter / (1) modifier : ");
    		
    		int rep = clavier.nextInt();
    		
    		if (rep == 1) {
    			Console console = System.console();
    			
    			System.out.print("\n\n>>> Modifaction du compte <<<\n\n");
    			String nom = "";
    			while (nom.isBlank()) {
    				System.out.print("\nNom : ");
    				nom = clavier.next();
    			}
    			
    			String prenom = "";
    			while (prenom.isBlank()) {
    				System.out.print("\nPrenom : ");
    				prenom = clavier.next();
    			}
    			
    			String mdp = "";
    			while (mdp.isBlank()) {
    				mdp = new String(console.readPassword("\nMot de passe: "));
    			}
    			
    			String confirmation = "";
    			while (confirmation.contentEquals(mdp)) {
    				confirmation = new String(console.readPassword("\nConfirmation mot de passe: "));
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
    					System.out.print("\nDisponibilité = (0) non disponible / (1) disponible : ");
    					dispo = clavier.nextInt();
    					disponibilite = (dispo == 1);
    				}
    				
    				Livreur temporaireL = new Livreur(nom,prenom,disponibilite,mdp);
    				_livreurs.set(((Livreur)_connecter).getID_Livreur(), temporaireL);
    				System.out.print("\n\nBienvenue " + temporaireL.getNom_Livreur() + temporaireL.getPrenom_Livreur()
    									+ " ! Votre nom d'utilisateur est : " + temporaireL.get_NomUtilisateur() 
    									+ ". Veuillez vous connecter à nouveau.\n\n");
    				break;
    				
    			case 3:
    				Administrateur temporaireA = new Administrateur(nom,prenom,mdp);
    				_administrateurs.set(((Administrateur)_connecter).getID_Admin(), temporaireA);
    				System.out.print("\n\nBienvenue " + nom + prenom
    									+ " ! Votre nom d'utilisateur est : " + temporaireA.get_NomUtilisateur() 
    									+ ". Veuillez vous connecter à nouveau.\n\n");
    				break;
    				
    			}
    		}
    		
    	}
    	else {
    		System.out.print("\nL'option saisie est inconnue.\n");
    	}
    	
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int decision = -1;
		_administrateurs.add(new Administrateur("d","d","d"));
		_livreurs.add(new Livreur("l","l",true,"l"));
		_clients.add(new Client("a","a","1","a","a"));
		
		while (decision != 0) {
			System.out.print("----{ Suivie de commande }----\n\n");
			
			System.out.print("[ Liste d'options ]\n>> Saisisez 0 pour quitter\n\n");
			
			if (_connecter == null) {
				System.out.print("1> Connexion\n");
				System.out.print("2> Inscription\n");
			} 
			else {
				System.out.print("3> Liste de commandes\n"); 
				System.out.print("4> Mes informations\n");
				System.out.print("5> Déconnexion\n\n");
				
				if (_connecter.get_Type() == 2 || _connecter.get_Type() == 3) {
					System.out.print("6> Liste de clients\n");
					System.out.print("7> Disponibilité du livreur\n\n");
				}
				
			}
		
			System.out.print("Numéro de l'option choisie : ");
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
				}
				else {
					System.out.print("\nL'option saisie est inconnue.\n\n");
				}
				
				break;
				
			case 3:
				listeCommande(clavier);
				break;
			
			case 4:
				informationsCompte(clavier);
				break;
			
			case 5:
				System.out.print("\nDéconnexion effectuée.\n\n");
				_connecter = null;
				break;
				
			default:
				System.out.print("\nL'option saisie est inconnue.\n");
			}
		
		}
		
		System.out.print("Merci de votre visite, à bientôt !\n\n");
		return;
	}
	
	

}

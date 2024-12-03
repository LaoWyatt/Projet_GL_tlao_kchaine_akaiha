package V0_1;

public class Administrateur extends Compte {

	private static int _compteur = 0;
	
	Administrateur(String nom, String prenom, String nouvMDP) {
		super(nom + prenom + _compteur, nouvMDP);
		
	}

}

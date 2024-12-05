package V0_1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;


public class test_unitaire{
	public Compte testCompte;
	public Administrateur testAdmin;
	public Livreur testLivreur;
	public Commande testCommande;
	public ListCommande testListCommande;

	
	
@BeforeAll
	public void testCreerCompte() {
		 String nomTest = "Test";
		 String mdpTest = "123";
		 Compte compteTest = new Compte(nomTest,mdpTest,1);
		 
		assertEquals(compteTest.get_NomUtilisateur, nomTest);
		/**Faire pour le mdp**/
		
	}

@BeforeAll
	public void testCreerCommande() {
	int idClientTest = 1;
	Commande commandeTest = new Commande(idClientTest);
	
	assertEquals(commandeTest.getID_Client(), idClientTest);

}



@Test
	public void testGetListCommande() {
	int idClientTest = 1;
	Commande commandeTest = new Commande(idClientTest);
	
	ListCommande testListCommande = new ListCommande();
	
	
}





	
	
}
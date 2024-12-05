package V0_1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;


public class test_unitaire{
	public Compte _testCompte;
	public Client _testClient;
	public Administrateur _testAdmin;
	public Livreur _testLivreur;
	public Commande _testCommande;
	public ListCommande _testListCommande;

	
	
@BeforeAll
	public void testCreerCompte() {
		 String nomTest = "Test";
		 String mdpTest = "123";
		 Compte compteTestLocal = new Compte(nomTest,mdpTest,1);
		 
		assertEquals(compteTestLocal.get_NomUtilisateur(), nomTest);
		/**Faire pour le mdp**/
		_testCompte = compteTestLocal;
		
		
	}

@BeforeAll
	public void testCreerClient() {
	String nomTest = "TestN";
	String prenomTest = "TestP";
	String cpTest = "TestCp";
	String adresseTest = "TestA";
	String mdpTest = "TestMdp";
	
	Client clientTestLocal = new Client(nomTest,prenomTest,cpTest,adresseTest,mdpTest);
	assertEquals(clientTestLocal.getNom_Client(),nomTest);
	assertEquals(clientTestLocal.getPrenom_Client(),prenomTest);
	assertEquals(clientTestLocal.getCodePostal(),cpTest);
	assertEquals(clientTestLocal.getNom_Client(),nomTest);
	
	
}
@BeforeAll
	public void testCreerCommande() {
	int idClientTest = 1;
	Commande commandeTest = new Commande(idClientTest);
	
	assertEquals(commandeTest.getID_Client(), idClientTest);
	_testCommande = commandeTest;

}



@Test
	public void testGetListCommande() {
	int idClientTest = 1;
	Commande commandeTest = new Commande(idClientTest);
	
	ListCommande testListCommande = new ListCommande();
	
	
}





	
	
}
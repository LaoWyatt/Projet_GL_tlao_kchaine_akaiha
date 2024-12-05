package V0_1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class test_unitaire{
	public static Compte _testCompte;
	public static Client _testClient;
	public static Administrateur _testAdmin;
	public static Livreur _testLivreur;
	public static Commande _testCommande;
	public static ListCommande _testListCommande;

	
	
@BeforeAll
	public static void testCreerCompte() {
		 String nomTest = "Test";
		 String mdpTest = "123";
		 Compte compteTestLocal = new Compte(nomTest,mdpTest,1);
		 
		assertEquals(compteTestLocal.get_NomUtilisateur(), nomTest);
		assertTrue(compteTestLocal.verificationMotDePasse(mdpTest));
		/**Faire pour le mdp**/
		_testCompte = compteTestLocal;
		
		
	}

@BeforeAll
	public  static void testCreerClient() {
	String nomTest = "TestN";
	String prenomTest = "TestP";
	String cpTest = "TestCp";
	String adresseTest = "TestA";
	String mdpTest = "TestMdp";
	
	Client clientTestLocal = new Client(nomTest,prenomTest,cpTest,adresseTest,mdpTest);
	assertEquals(clientTestLocal.getNom_Client(),nomTest);
	assertEquals(clientTestLocal.getPrenom_Client(),prenomTest);
	assertEquals(clientTestLocal.getCodePostal(),cpTest);
	assertEquals(clientTestLocal.getAdresse(),adresseTest);
	assertTrue(clientTestLocal.verificationMotDePasse(mdpTest));
	
	_testClient = clientTestLocal;

	
	
}
@BeforeAll
	public static void testCreerCommande() {
	int idClientTest = 1;
	Commande commandeTestLocal = new Commande(idClientTest);
	
	assertEquals(commandeTestLocal.getID_Client(), idClientTest);
	_testCommande = commandeTestLocal;

}

@BeforeAll
	public static void testCreerListCommandes() {
	ListCommande testListCommandeLocal = new ListCommande();
	_testListCommande = testListCommandeLocal;
	
}



@Test
	public void testAddListCommande() {
	_testListCommande.ajoutCommande(_testCommande);
	ArrayList<Commande> testList = new ArrayList<Commande>();
	testList = _testListCommande.getCommandes();
	
	assertEquals(testList.size(), 1);
	assertEquals(testList.get(0).getID_Commande(), _testCommande.getID_Commande());
	
}	
	
@Test

	public void testSupListCommande() {
		_testListCommande.supCommande(_testCommande.getID_Client());
		ArrayList<Commande> testList = new ArrayList<Commande>();
		testList = _testListCommande.getCommandes();
		assertFalse(testList.contains(_testCommande));
	}





	
	
}
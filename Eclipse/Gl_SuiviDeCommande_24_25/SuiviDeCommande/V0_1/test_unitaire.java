package V0_1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		assertTrue(compteTestLocal.verificationMotDePasse(mdpTest));
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
	assertEquals(clientTestLocal.getAdresse(),adresseTest);
	assertTrue(clientTestLocal.verificationMotDePasse(mdpTest));
	
	_testClient = clientTestLocal;

	
	
}
@BeforeAll
	public void testCreerCommande() {
	int idClientTest = 1;
	Commande commandeTestLocal = new Commande(idClientTest);
	
	assertEquals(commandeTestLocal.getID_Client(), idClientTest);
	_testCommande = commandeTestLocal;

}



@Test
	public void testGetListCommande() {
	ListCommande testListCommandeLocal = new ListCommande();
	testListCommandeLocal.ajoutCommande(_testCommande);
	ArrayList<Commande> testList = new ArrayList<Commande>();
	testList = testListCommandeLocal.getCommandes();
	
	assertEquals(testList.size(), 1);
	assertEquals(testList.get(0).getID_Commande(), _testCommande.getID_Commande());
	
	
	
	
}





	
	
}
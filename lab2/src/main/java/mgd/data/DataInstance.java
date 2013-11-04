package mgd.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Mock Up d'un syst�me de bdd
 * @author GPerrot
 *
 */
public class DataInstance {
	public static Map<Produit, Integer> produits = new HashMap<Produit, Integer>(){
		private static final long serialVersionUID = -4516961064328857748L;
		{
			put(new Produit("1v", "Violon","Corde", 1500f), 8);
			put(new Produit("1g","Guitare", "Corde", 500f), 8);
			put(new Produit("3f", "Flute","Vent", 1000f), 31);
			put(new Produit("2tr","Triangle", "Percussion", 25f), 50);
			put(new Produit("2ta","Tambour", "Corde", 80f), 5);
		}
	};

	public static List<Client> clients = new ArrayList<Client>(3){
		private static final long serialVersionUID = 4065256324112267249L;
		{
			Client jd = new Client("Dupont", "Jean", new Adresse("10 av de la R�publique", "Nice", "FR"));
			jd.addCommande(new Commande(""));
			jd.getCommandes().get(0).addProduits(produits);
			add(jd);
			add(new Client("Michel", "Albert", new Adresse("150 rue des Tulipes", "Moulins", "FR")));
			add(new Client("Blanc", "Paulette", new Adresse("24 bis rue Martin", "Nice", "FR")));
			
			
		}
	};
}

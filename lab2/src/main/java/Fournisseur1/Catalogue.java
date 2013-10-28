package Fournisseur1;

import java.util.ArrayList;

public class Catalogue {
	
	private static ArrayList<Product> listProduct;
	
	private static volatile Catalogue catalog = null;
	
	private Catalogue () {
		listProduct = new ArrayList<Product>();
	}
	
	public void addProduct(Product product) {
		listProduct.add(product);
	}
	
	public final static Catalogue getInstance() {
        if (Catalogue.catalog == null) {
           synchronized(Catalogue.class) {
             if (Catalogue.catalog == null) {
            	 Catalogue.catalog = new Catalogue();
             }
           }
        }
        return Catalogue.catalog;
    }

	public ArrayList<Product> getListProduct() {
		return listProduct;
	}
	
}

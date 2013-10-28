package api;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {
	
	private ArrayList<Customer> customers = new ArrayList<Customer> ();
	private ArrayList<Product> products = new ArrayList<Product> ();
	private ArrayList<Order> orders = new ArrayList<Order> ();
	private ArrayList<Category> categories = new ArrayList<Category> ();
	
	private HashMap<String, Integer> tokens = new HashMap<String, Integer> ();
	private HashMap<String, String> identifications = new HashMap<String, String> ();
	
	private static volatile Data data = null;
	
	private Data() {		
		Customer c1 = new Customer();
		c1.id = 1;
		c1.login = "Dupont";
		c1.nameCustomer = "Dupont";
		c1.firstNameCustomer = "Olivier";
		c1.address = "2255 Route des dolines";
		identifications.put(c1.login, "pwd");
		//tokens.put(BEGIN_TOKEN + c1.nameCustomer, c1.id);
		
		Customer c2 = new Customer();
		c2.id = 2;
		c2.login = "Dupuis";
		c2.nameCustomer = "Dupuis";
		c2.firstNameCustomer = "Pascal";
		c2.address = "77 Rue Antoine Del Bello, 13010 Marseille";
		identifications.put(c2.login, "pwd2");
		//tokens.put(BEGIN_TOKEN + c2.nameCustomer, c2.id);
		
		customers.add(c1);
		customers.add(c2);
		
		Category cat1 = new Category ();
		cat1.id = 1;
		cat1.category = "CD";
		Category cat2 = new Category ();
		cat2.id = 2;
		cat2.category = "Livre";
		categories.add(cat1);
		categories.add(cat2);
		
		Product p1 = new Product();
		p1.id = 1;
		p1.nameProduct = "Céline Dion";
		p1.category = cat1;
		p1.reference = "0001";
		p1.price = 20.0;
		
		Product p2 = new Product();
		p2.id = 2;
		p2.nameProduct = "Patrick Bruel";
		p2.category = cat1;
		p2.reference = "0002";
		p2.price = 15.0;
		
		Product p3 = new Product();
		p3.id = 3;
		p3.nameProduct = "Un été avec Montaigne";
		p3.category = cat2;
		p3.reference = "0011";
		p3.price = 8.5;
		
		Product p4 = new Product();
		p4.id = 4;
		p4.nameProduct = "Vendredi ou la vie sauvage";
		p4.category = cat2;
		p4.reference = "0012";
		p4.price = 10.4;
		
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		
		Catalogue.getInstance().addProduct(p1);
		Catalogue.getInstance().addProduct(p1);
		Catalogue.getInstance().addProduct(p2);
		Catalogue.getInstance().addProduct(p3);
		Catalogue.getInstance().addProduct(p4);
		
		//HashMap<Product, Integer> listProducts1 = new HashMap<Product, Integer>();
//		listProducts1.put(p1, 2);
//		listProducts1.put(p2, 3);
		ArrayList<ProductQuantity> listProducts1 = new ArrayList<ProductQuantity>();
		listProducts1.add(new ProductQuantity(p1, 2));
		listProducts1.add(new ProductQuantity(p2, 3));
		Order order1 = new Order();
		order1.id = 1;
		order1.customer = c1;
		order1.products = listProducts1;
		order1.priceTotal = calculSumTotelOrder(listProducts1);
		
		
		//HashMap<Product, Integer> listProducts2 = new HashMap<Product, Integer>();
		ArrayList<ProductQuantity> listProducts2 = new ArrayList<ProductQuantity>();
		listProducts2.add(new ProductQuantity(p3, 1));
		listProducts2.add(new ProductQuantity(p4, 2));
		Order order2 = new Order();
		order1.id = 2;
		order1.customer = c2;
		order1.products = listProducts2;
		order1.priceTotal = calculSumTotelOrder(listProducts2);
		
		orders.add(order1);
		orders.add(order2);
		
	}
	
//	private double calculSumTotelOrder (HashMap <Product, Integer> products) {
//		double prixTotal = 0.0;
//		for(Entry<Product, Integer> entry : products.entrySet()) {
//		    Product product = entry.getKey();
//		    Integer quantity = entry.getValue();
//		    prixTotal += product.price * quantity;
//		}
//		return prixTotal;
//	}
	
	private double calculSumTotelOrder (ArrayList<ProductQuantity> products) {
		double prixTotal = 0.0;
		for(ProductQuantity pq: products) {
		    prixTotal += pq.product.price * pq.quantity;
		}
		return prixTotal;
	}
	
	public final static Data getInstance() {
        if (Data.data == null) {
           synchronized(Data.class) {
             if (Data.data == null) {
            	 Data.data = new Data();
             }
           }
        }
        return Data.data;
    }

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public ArrayList<Category> getCategories() {
		return categories;
	}
	
	public HashMap<String, Integer> getTokens() {
		return tokens;
	}
	
//	public ArrayList<String> getTokens() {
//		return tokens;
//	}
	
	public HashMap<String, String> getIdentification() {
		return identifications;
	}

//	public String getBeginToken() {
//		return BEGIN_TOKEN;
//	}
	
}

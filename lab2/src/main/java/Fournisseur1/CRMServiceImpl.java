package Fournisseur1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class CRMServiceImpl implements CRMService {
	
	private final static String BEGIN_TOKEN = "a_secret_ticket_access_";
	
	public String getToken(String login, String pwd) throws UnauthorizedAccessFault {
		if (!checkAccess(login, pwd)) throw new UnauthorizedAccessFault();
		String token = BEGIN_TOKEN + login;
		Data.getInstance().getTokens().put(token, getCustomerByLogin(login));
		return token;
	}
	
	public Customer account(String token) throws UnauthorizedAccessFault {
		if(!checkToken(token)) throw new UnauthorizedAccessFault();
		int id = Data.getInstance().getTokens().get(token);
		return getCustomer(id);
	}
	
	public String disconnect (Customer customer) {
		Data.getInstance().getTokens().remove(BEGIN_TOKEN + customer.login);
		return "Déconnexion du client " + customer.login;
	}

	private boolean checkAccess(String username, String password) {
		HashMap<String, String> usernamepwd = Data.getInstance().getIdentification();
		if (!usernamepwd.containsKey(username))
			return false;
		if (!usernamepwd.get(username).equals(password))
			return false;
		return true;
	}
	
	private boolean checkToken(String token) {
		HashMap<String, Integer> tokens = Data.getInstance().getTokens();
		if (tokens.containsKey(token))
			return true;
		return false;
	}
	
	public Customer createCustomer(String login, String pwd, String nameCustomer, String firstNameCustomer, String address) 
			throws ExistingLoginFault
	{
		if(isExistingLogin(login)) throw new ExistingLoginFault();
		
		ArrayList<Customer> customers = Data.getInstance().getCustomers();
		Customer customer = new Customer();
		
		//search id max
		int idmax = 0;
		for (Customer c : customers) {
			if (idmax < c.id) {
				idmax = c.id;
			}
		}
		
		customer.id = ++idmax;
		customer.login = login;
		customer.nameCustomer = nameCustomer;
		customer.firstNameCustomer = firstNameCustomer;
		customer.address = address;
		customers.add(customer);
		
		Data.getInstance().getIdentification().put(login, pwd);
		
		return customer;
	}
	
	private boolean isExistingLogin(String login) {
		HashMap<String, String> idents = Data.getInstance().getIdentification();
		if (idents.containsKey(login))
			return true;
		return false;
	}
	
	public Product createProduct(String nameProduct, Category category, String reference, double price) throws ExistingReferenceFault
	{
		if (isExistingReference(reference)) throw new ExistingReferenceFault();
		
		ArrayList<Product> products = Data.getInstance().getProducts();
		
		//search id max
		int idmax = 0;
		for (Product p : products) {
			if (idmax < p.id) {
				idmax = p.id;
			}
		}
		
		Product product = new Product();
		product.id = ++idmax;
		product.nameProduct = nameProduct;
		product.category = category;
		product.reference = reference;
		product.price = price;
		products.add(product);
		Catalogue.getInstance().addProduct(product);
		return product;
	}
	
	private boolean isExistingReference(String reference) {
		ArrayList<Product> products = Data.getInstance().getProducts();
		for (Product p : products) {
			if (p.reference.equals(reference)) {
				return true;
			}
		}
		return false;
	}

	public Order createOrder(Customer customer, ArrayList<ProductQuantity> products) throws NotConnectedFault
	{
		if(Data.getInstance().getTokens().containsKey(BEGIN_TOKEN + customer.login)) throw new NotConnectedFault();
		
		ArrayList<Order> orders = Data.getInstance().getOrders();
		
		//search id max
		int idmax = 0;
		for (Order o : orders) {
			if (idmax < o.id) {
				idmax = o.id;
			}
		}
		
		Order order = new Order();
		order.id = ++idmax;
		order.customer = customer;
		order.products = products;
		order.priceTotal = calculSumTotelOrder(products);
		orders.add(order);
		
		//save Products order
		for (ProductQuantity pq : order.products) {
			if (!customer.preferredProducts.contains(pq.product)) {
				customer.preferredProducts.add(pq.product);
			}
		}

		return order;
	}
	
	private double calculSumTotelOrder (ArrayList<ProductQuantity> products) {
		double prixTotal = 0.0;
		for(ProductQuantity pq: products) {
		    prixTotal += pq.product.price * pq.quantity;
		}
		return prixTotal;
	}
	
	public Category createCategory(String categoryStr)
	{
		ArrayList<Category> categories = Data.getInstance().getCategories();
		
		//search id max
		int idmax = 0;
		for (Category c : categories) {
			if (idmax < c.id) {
				idmax = c.id;
			}
		}
		
		Category category = new Category();
		category.id = ++idmax;
		category.category = categoryStr;
		categories.add(category);
		return category;
	}
	
	public Customer modifyCustomer(int id, String login, String pwd, String nameCustomer, String firstNameCustomer, String address) throws ExistingLoginFault {
		Customer customer = getCustomer(id);
		if(isExistingLogin(login)) throw new ExistingLoginFault();
		customer.login = login;
		if (!pwd.equals(""))
			Data.getInstance().getIdentification().put(login, pwd);
		customer.nameCustomer = nameCustomer;
		customer.firstNameCustomer = firstNameCustomer;
		customer.address = address;
		return customer;
	}
	
	public String deleteCustomer(int id) {
		Customer customer = getCustomer(id);
		Data.getInstance().getCustomers().remove(getCustomer(id));
		return "Utilisateur " + customer.login + " supprimer";
	}
	
	private Customer getCustomer(int id) {
		Customer customer = null;
		ArrayList<Customer> customers = Data.getInstance().getCustomers();
		for (Customer c: customers) {
			if (c.id == id) {
				customer = c;
			}
		}
		return customer;
	}
	
	private int getCustomerByLogin(String login) {
		int customerId = 0;
		ArrayList<Customer> customers = Data.getInstance().getCustomers();
		for (Customer c: customers) {
			if (c.login.equals(login)) {
				customerId = c.id;
			}
		}
		return customerId;
	}

	public Product getProduct(int id) {
		Product product = null;
		ArrayList<Product> products = Data.getInstance().getProducts();
		for (Product p : products) {
			if (p.id == id) {
				product = p;
			}
		}
		return product;
	}
	
	public Order getOrder(int id) {
		Order order = null;
		ArrayList<Order> orders = Data.getInstance().getOrders();
		for (Order o : orders) {
			if (o.id == id) {
				order = o;
			}
		}
		return order;
	}
	
	public Category getCategory(int id) {
		Category category = null;
		ArrayList<Category> categories = Data.getInstance().getCategories();
		for (Category cat: categories) {
			if(cat.id == id) {
				category = cat;
			}
		}
		return category;
	}
	
	public ArrayList<Product> getPreferredProducts(int nbProdPref) {
		//counts the number of times that the product was order
		HashMap <Product, Integer> productsPref = new HashMap<Product, Integer> ();
		ArrayList<Customer> customers = Data.getInstance().getCustomers();
		for (Customer c : customers) {
			for(Product p : c.preferredProducts) {
				if (productsPref.containsKey(p)) {
					int nb = productsPref.get(p);
					productsPref.put(p, ++nb);
				} else {
					productsPref.put(p, 0);
				}
			}
		}
		
		//search nbProdPref first preferred products
		ArrayList<Product> products = new ArrayList<Product>();
		for (int i = 0; i < nbProdPref; ++i) {
			int nbMaxProdOrder = 0;
			Product prodSuccess = new Product();
			for (Entry<Product, Integer> entry : productsPref.entrySet()) {
			    Product p = entry.getKey();
			    Integer nbTimeOrder = entry.getValue();
				if (nbMaxProdOrder < nbTimeOrder) {
					prodSuccess = p;
				}
			}
			products.add(prodSuccess);
			productsPref.remove(prodSuccess);
		}
		return products;
	}
	
	public ArrayList<Product> searchProduct (String name, Category category, String reference) {
		ArrayList<Product> productsAll = Catalogue.getInstance().getListProduct();
		for(Product p : productsAll) {
			if (! p.nameProduct.equals(name) && ! p.category.equals(category) && ! p.reference.equals(reference)) {
				productsAll.remove(p);
			}
		}
		return productsAll;
	}
}

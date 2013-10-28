package Fournisseur2;

import java.util.HashMap;

public class CRMSystem {
	private static HashMap<String, Customer> _customerMap;
	private static HashMap<String, Product> _catalogue;
	private static HashMap<Integer, Order> _orderMap;
	private static int _refOrder;

	public CRMSystem() {
		_customerMap = new HashMap<String, Customer>();
		_catalogue = new HashMap<String, Product>();
		_orderMap = new HashMap<Integer, Order>();

		Customer c1 = new Customer("1", "pwd1", "Pierre", "Dupond",
				"109 route de grenoble Grasse");
		Customer c2 = new Customer("2", "pwd2", "George", "Mars",
				"27 av l'esterel Nice");
		Customer c3 = new Customer("3", "pwd3", "François", "Chave",
				"10 rue Newton Lyon");
		Customer c4 = new Customer("4", "pwd4", "Frida", "Dalros",
				"109 rue de la part dieu Lyon");
		Customer c5 = new Customer("5", "pwd5", "Jean", "Durant",
				"5 route du bord de mer Menton");

		_customerMap.put(c1.get_ident(), c1);
		_customerMap.put(c2.get_ident(), c2);
		_customerMap.put(c3.get_ident(), c3);
		_customerMap.put(c4.get_ident(), c4);
		_customerMap.put(c5.get_ident(), c5);

		Product p1 = new Product("POI1", "Poire Jaune", "fruit arbre");
		Product p2 = new Product("POMPL", "Pomme pink lady", "fruit arbre");
		Product p3 = new Product("POMGOL", "Pomme golden", "fruit arbre");
		Product p4 = new Product("MELESP", "Melon d'espagne", "fruit plante");
		Product p5 = new Product("FRAGAR", "Fraise gariguette", "fruit plante");
		Product p6 = new Product("PORVRT", "Poireau", "légume vert");
		Product p7 = new Product("POMTRR", "Pomme de terre",
				"légume sous terre");
		p7.set_onSale(false);
		Product p8 = new Product("Haricot", "", "");
		Product p9 = new Product("PVRRGE", "Poivron rouge", "légume plante");

		_catalogue.put(p1.get_reference(), p1);
		_catalogue.put(p2.get_reference(), p2);
		_catalogue.put(p3.get_reference(), p3);
		_catalogue.put(p4.get_reference(), p4);
		_catalogue.put(p5.get_reference(), p5);
		_catalogue.put(p6.get_reference(), p6);
		_catalogue.put(p7.get_reference(), p7);
		_catalogue.put(p8.get_reference(), p8);
		_catalogue.put(p9.get_reference(), p9);
		

		Order o1 = new Order(1, "10/09/2013", "Livree", c1);
		o1.add_item(p1);
		o1.add_item(p1);
		o1.add_item(p6);

		Order o2 = new Order(2, "12/09/2013", "Preparation", c1);
		o2.add_item(p2);
		o2.add_item(p3);
		o2.add_item(p4);

		Order o3 = new Order(3, "26/09/2013", "transite", c1);
		o3.add_item(p8);
		o3.add_item(p9);

		_orderMap.put(o1.get_number(), o1);
		_orderMap.put(o2.get_number(), o2);
		_orderMap.put(o3.get_number(), o3);

		_refOrder = 3;

	}
	
	public HashMap<Integer, Order> get_orderMap(){
		return _orderMap;
	}
	
	public HashMap<String, Customer> get_customerMap(){
		return _customerMap;
	}
	
	public HashMap<String, Product> get_catalogue(){
		return _catalogue;
	}

	public int addCustomer(String log, String pwd, String firstname, String lastname, String address) {
		if(_customerMap.containsKey(log)){
			return 0;
		}
		Customer c = new Customer(log, pwd, firstname, lastname, address);
		_customerMap.put(c.get_ident(), c);
		return 1;
	}

	public int updateCustomer(String log, String pwd, String firstname, String lastname, String address) {
		if(!_customerMap.containsKey(log))
			return 0;
		_customerMap.get(log).set_pwd(pwd);
		_customerMap.get(log).set_prenom(firstname);
		_customerMap.get(log).set_nom(lastname);
		_customerMap.get(log).set_adress(address);
		return 1;
	}

	public void deleteCustomer(String log) {
		_customerMap.remove(log);
	}

	public boolean rightPassword(String login, String pwd) {
		String initPwd = _customerMap.get(login).get_pwd();
		return pwd.equals(initPwd);
	}

	public int createOrder(String login) {
		if (_customerMap.containsKey(login)) {
			_refOrder++;

			String format = "dd/MM/yy";

			java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(
					format);
			java.util.Date date = new java.util.Date();

			String mydate = formater.format(date);

			Order o = new Order(_refOrder, mydate, "preparation",
					_customerMap.get(login));
			
			_orderMap.put(_refOrder, o);

			return _refOrder;
		} else
			return -1;
	}

	public String addProductToOrder(String login, String refProd, int numOrder) {
		if(!_customerMap.containsKey(login))
			return "the client " +login+ " does not exist";
		if(!_orderMap.containsKey(numOrder))
			return "the order " +numOrder+ " does not exist";
		if(!_catalogue.containsKey(refProd))
			return "the product " +refProd+ " does not exist";
		if (!_customerMap.get(login).get_orderList().contains(_orderMap.get(numOrder)))
			return "the client "+login+" has not this order "+numOrder;
		if(!_catalogue.get(refProd).is_onSale())
			return "the product "+refProd+" is not on sale";
		
		_orderMap.get(numOrder).add_item(_catalogue.get(refProd));
		return "the product "+refProd+" has been added to the order"+numOrder;
	}
	
	
	public int addProduct(String ref, String name, String category) {
		if(_catalogue.containsKey(ref)){
			return 0;
		}
		Product p = new Product(ref, name, category);
		_catalogue.put(p.get_reference(), p);
		return 1;
		
	}

	public int updateProduct(String ref, String name, String category) {
		if(!_catalogue.containsKey(ref)){
			return 0;
		}
		_catalogue.get(ref).set_name(name);
		_catalogue.get(ref).set_category(category);
		return 1;
	}
	
	public int ProductNotOnSale(String ref){
		if(!_catalogue.containsKey(ref)){
			return 0;
		}
		_catalogue.get(ref).set_onSale(false);
		return 1;
	}
	
	public int ProductOnSale(String ref){
		if(!_catalogue.containsKey(ref)){
			return 0;
		}
		_catalogue.get(ref).set_onSale(true);
		return 1;
	}
}

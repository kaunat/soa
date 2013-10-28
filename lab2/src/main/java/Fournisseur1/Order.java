package Fournisseur1;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class Order {
	
	@XmlElement(required=true, name="id")
	public int id;
	
	@XmlElement(required=true, name="priceTotal")
	public double priceTotal;
	
	@XmlElement(required=true, name="customer")
	public Customer customer;
	
	@XmlElement(required=true, name="products")
	public ArrayList <ProductQuantity> products;
	
	
	/*public Order(int id, Customer customer, HashMap<Product, Integer> products, double priceTotal){
		this.id = id;
		this.priceTotal = priceTotal;
		this.customer = customer;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public double getPriceTotal() {
		return priceTotal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public HashMap<Product, Integer> getProducts() {
		return products;
	}*/

}

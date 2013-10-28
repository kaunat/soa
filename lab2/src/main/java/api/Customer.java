package api;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="AccountRequest")
public class Customer {
	
	@XmlElement(required=true, name="login")
	public String login;
	
	@XmlElement(required=true, name="id")
	public int id;
	
	@XmlElement(required=true, name="nameCustomer")
	public String nameCustomer;
	
	@XmlElement(required=true, name="firstNameCustomer")
	public String firstNameCustomer;
	
	@XmlElement(required=true, name="address")
	public String address;
	
	@XmlElement(required=true, name="preferredProducts")
	public ArrayList<Product> preferredProducts = new ArrayList<Product>();
	
	/*public Customer() {
		//preferredProducts = new ArrayList<Product>();
	}
	
	public Customer(int id, String nameCustomer,String firstNameCustomer, String address) {
		this.id = id;
		this.nameCustomer = nameCustomer;
		this.firstNameCustomer = firstNameCustomer;
		this.address = address;
		//preferredProducts = new ArrayList<Product>();
	}

	public int getId() {
		return id;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public String getFirstNameCustomer() {
		return firstNameCustomer;
	}

	public String getAddress() {
		return address;
	}

	public ArrayList<Product> getPreferredProducts() {
		return preferredProducts;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public void setFirstNameCustomer(String firstNameCustomer) {
		this.firstNameCustomer = firstNameCustomer;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPreferredProducts(ArrayList<Product> preferredProducts) {
		this.preferredProducts = preferredProducts;
	}*/
	
}

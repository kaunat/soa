package Fournisseur1;

import javax.xml.bind.annotation.XmlElement;

public class Product {
	
	@XmlElement(required=true, name="id")
	public int id;
	
	@XmlElement(required=true, name="nameProduct")
	public String nameProduct;
	
	@XmlElement(required=true, name="category")
	public Category category;
	
	@XmlElement(required=true, name="reference")
	public String reference;
	
	@XmlElement(required=true, name="price")
	public double price;
	
	/*public Product (int id, String nameProduct, Category category, String reference, double price) {
		this.id = id;
		this.nameProduct = nameProduct;
		this.category = category;
		this.reference = reference;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public Category getCategory() {
		return category;
	}

	public String getReference() {
		return reference;
	}
	
	public double getPrice() {
		return price;
	}*/
}

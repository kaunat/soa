package Fournisseur1;

import javax.xml.bind.annotation.XmlElement;

public class ProductQuantity {
	
	@XmlElement(required=true, name="product")
	public Product product;

	@XmlElement(required=true, name="quantity")
	public int quantity;

	public ProductQuantity() {}
	
	public ProductQuantity(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
	}
}

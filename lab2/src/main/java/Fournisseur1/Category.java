package Fournisseur1;

import javax.xml.bind.annotation.XmlElement;

public class Category {
	
	@XmlElement(required=true, name="id")
	public int id;
	
	@XmlElement(required=true, name="nameCategory")
	public String category;

	/*public Category (int id, String category) {
		this.id = id;
		this.category = category;
	}
	
	public int getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}*/
	
	
}

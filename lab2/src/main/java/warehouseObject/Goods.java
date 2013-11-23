package warehouseObject;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Goods implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reference;
	private String name;
	private int seuil;
	private int quantity;

	public Goods() throws Exception {
		this(null, null, 1, 0);
	}

	public Goods(String reference, String name, int seuil, int quantity) throws Exception {
		this.reference = reference;
		this.name = name;
		if(seuil >= 0) {
			this.seuil = seuil;
		}
		else {
			throw new Exception("The amount of goods before considering it to be nearly out of stock must be positive");
		}
		if(quantity >= 0) {
			this.quantity = quantity;
		}
		else {
			throw new Exception("Goods quantity must be positive");
		}
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) throws Exception {
		if(quantity >= 0) {
			this.quantity = quantity;
		}
		else {
			throw new Exception("New quantity must be positive");
		}
	}

	public static Goods getGoodsByRef(List<Goods> list, String ref) {
		for(Goods goods : list) {
			if(goods.getReference().equals(ref)){
				return goods;
			}
		}
		return null;
	}

	public static String getListGoodsToString(List<Goods> list) {
		String goodsString = "";
		for(Goods goods : list) {
			goodsString += "\t" + goods.toString() + "\n";
		}
		return goodsString;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSeuil(int seuil) {
		this.seuil = seuil;
	}

	public String getName() {
		return name;
	}

	public int getSeuil() {
		return seuil;
	}

	public String toString() {
		return "{\"reference\" : \""+this.reference+"\", \"name\" : \""+this.name+"\", \"seuil\" : \""+this.seuil + "\", \"quantity\" : \"" + this.quantity + "\"}";
	}

}

package warehouseObject;

public class Transporter extends Entity {

	public Transporter(int id, String name, String adress) {
		super(id, name, adress);
	}
	
	public Transporter() {
		this(-1, "undefined", "undefined");
	}

	public String toString() {
		return "Transporter information : \n\t" + super.toString();
	}
}
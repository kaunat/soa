package warehouseObject;

public abstract class Entity {


	public void setId(int id) {
		this.id = id;
	}

	private int id;
	private String name;
	private String adress;

	protected Entity (int id, String name, String adress) {
		this.id = id;
		this.name = name;
		this.adress = adress;
	}
	
	protected Entity () {
		this(-1, "undefinde", "undefinde");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "Id :" + this.id + "\nName :" + this.name + "\nAdress :" + this.adress;
	}
}

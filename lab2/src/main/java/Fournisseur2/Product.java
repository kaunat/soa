package Fournisseur2;

public class Product{
	private String _reference;
	private String _name;
	private String _category;
	private int _orderAmount;
	private boolean _onSale;
	
	public Product(String ref, String name, String category){
		set_reference(ref);
		set_name(name);
		set_category(category);
		set_orderAmount(0);
		set_onSale(true);
	}

	public String get_reference() {
		return _reference;
	}

	public void set_reference(String _reference) {
		this._reference = _reference;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_category() {
		return _category;
	}

	public void set_category(String _category) {
		this._category = _category;
	}
	
	public void addOneToOrderAmount(){
		set_orderAmount(get_orderAmount() + 1);
	}

	public int get_orderAmount() {
		return _orderAmount;
	}

	public void set_orderAmount(int _orderAmount) {
		this._orderAmount = _orderAmount;
	}

	public boolean is_onSale() {
		return _onSale;
	}

	public void set_onSale(boolean _onSale) {
		this._onSale = _onSale;
	}
}

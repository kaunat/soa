package Fournisseur2;

import java.util.ArrayList;

public class Order {
	private int _number;
	private String _orderDate;
	private String _state;
	private Customer _buyer;
	private ArrayList<Product> _productList;
	
	public Order(int number, String date, String state, Customer buyer){
		set_number(number);
		set_orderDate(date);
		set_state(state);
		set_buyer(buyer);
		set_productList(new ArrayList<Product>());
		buyer.add_order(this);
	}

	public int get_number() {
		return _number;
	}

	public void set_number(int _number) {
		this._number = _number;
	}

	public String get_orderDate() {
		return _orderDate;
	}

	public void set_orderDate(String _orderDate) {
		this._orderDate = _orderDate;
	}

	public Customer get_buyer() {
		return _buyer;
	}

	public void set_buyer(Customer _buyer) {
		this._buyer = _buyer;
	}

	public String get_state() {
		return _state;
	}

	public void set_state(String _state) {
		this._state = _state;
	}

	public ArrayList<Product> get_productList() {
		return _productList;
	}

	public void set_productList(ArrayList<Product> _productList) {
		this._productList = _productList;
	}
	
	public void add_item(Product p){
		p.addOneToOrderAmount();
		this._productList.add(p);
	}
}

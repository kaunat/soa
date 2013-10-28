package Fournisseur2;

import java.util.ArrayList;

public class Customer {
	private String _ident;
	private String _pwd;
	private String _nom;
	private String _prenom;
	private String _adress;
	private ArrayList<Order> _orderList;
	
	public Customer(String id, String pwd, String prenom, String nom, String adress){
		set_ident(id);
		set_pwd(pwd);
		set_nom(nom);
		set_prenom(prenom);
		set_adress(adress);
		set_orderList(new ArrayList<Order>());
	}

	public String get_ident() {
		return _ident;
	}

	public void set_ident(String _ident) {
		this._ident = _ident;
	}

	public String get_pwd() {
		return _pwd;
	}

	public void set_pwd(String _pwd) {
		this._pwd = _pwd;
	}

	public String get_nom() {
		return _nom;
	}

	public void set_nom(String _nom) {
		this._nom = _nom;
	}

	public String get_prenom() {
		return _prenom;
	}

	public void set_prenom(String _prenom) {
		this._prenom = _prenom;
	}

	public String get_adress() {
		return _adress;
	}

	public void set_adress(String _adress) {
		this._adress = _adress;
	}

	public ArrayList<Order> get_orderList() {
		return _orderList;
	}

	public void set_orderList(ArrayList<Order> _orderList) {
		this._orderList = _orderList;
	}
	
	public void add_order(Order order){
		_orderList.add(order);
	}
	
	
}

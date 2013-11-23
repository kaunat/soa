package warehouseObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Transaction {

	protected List<Goods> goodsList;
	protected String date;
	protected Transporter transporter;
	protected Warehouse warehouse;
	protected String transactionType;

	protected Transaction(List<Goods> goodsList, String date, Transporter transporter, Warehouse warehouse) {
		this.goodsList = goodsList;
		this.date = date;
		this.transporter = transporter;
		this.warehouse = warehouse;
		this.transactionType = "Undefined";
	}
	
	protected Transaction() {
		this(new ArrayList<Goods>(), "", new Transporter(), new Warehouse());
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse providedWarehouse) {
		this.warehouse = providedWarehouse;
	}
	
	public String getTransactionType() {
		return transactionType;
	}	
	
	public String toString() {
		return "Transaction date : " + this.date + " \nTransaction transporter : " + this.transporter + " \nTransaction warehouse : " + this.warehouse +
				" \nTransaction type : " + this.transactionType + " \nGoods concerned : \n" + Goods.getListGoodsToString(this.goodsList);
	}
}

package warehouseObject;

import java.util.ArrayList;
import java.util.List;

public class Order extends Transaction{
	

	public Order(List<Goods> goodsList, String date, Transporter transporter, Warehouse providedWarehouse) {
		super(goodsList, date, transporter, providedWarehouse);
		super.transactionType = "Order";
	}
	
	public Order() {
		this(new ArrayList<Goods>(), "", new Transporter(), new Warehouse());
	}
}

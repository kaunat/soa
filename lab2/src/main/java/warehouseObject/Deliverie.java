package warehouseObject;

import java.util.ArrayList;
import java.util.List;

public class Deliverie extends Transaction{

	public Deliverie(List<Goods> goodsList, String date, Transporter transporter, Warehouse providingWarehouse) {
		super(goodsList, date, transporter, providingWarehouse);
		super.transactionType = "Deliverie";
	}
	
	public Deliverie() {
		this(new ArrayList<Goods>(), "", new Transporter(), new Warehouse());
	}
}

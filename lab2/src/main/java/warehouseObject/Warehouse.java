package warehouseObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Warehouse extends Entity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static List<Warehouse> globalWarehouseList = new ArrayList<Warehouse>();

	private List<Goods> warehouseGoods;
	
	public Warehouse (int id, String name, String adress, List<Goods> warehouseGoods) {
		super(id, name, adress);
		this.warehouseGoods = warehouseGoods;
	}
	
	public Warehouse () {
		this(-1, "undefined", "undefined", new ArrayList<Goods>());
	}
	
	public Warehouse (int id, String name, String adress) {
		this(id, name, adress, new ArrayList<Goods>());
	}

	public List<Goods> getWarehouseGoods() {
		return warehouseGoods;
	}

	public void setWarehouseGoods(List<Goods> warehouseGoods) {
		this.warehouseGoods = warehouseGoods;
	}

	public String toString() {
		return "Warehouse information : \n\t" + "Warehouse's goods : \n" + Goods.getListGoodsToString(this.warehouseGoods) + super.toString();
	}

}

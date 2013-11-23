package services;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;
import warehouseObject.Deliverie;
import warehouseObject.Goods;
import warehouseObject.Order;
import warehouseObject.Schedule;
import warehouseObject.Warehouse;

@WebService(endpointInterface = "WarehouseService")
public class WarehouseServiceImpl implements WarehouseService {

	@Override
	public String addGoods (
			@WebParam(name = "addedGoodsList") List<Goods> goodsList,
			@WebParam(name = "providedWarehouse") Warehouse warehouse) {
		if(!Warehouse.globalWarehouseList.contains(warehouse))
			Warehouse.globalWarehouseList.add(warehouse);
		for(Goods goods : goodsList) {
			List<Goods> warehouseGoods = warehouse.getWarehouseGoods();
			if(warehouseGoods.contains(goods)){
				Goods containedGoods = warehouseGoods.get(warehouseGoods.indexOf(goods));
				try {
					containedGoods.setQuantity(containedGoods.getQuantity() + goods.getQuantity());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
				warehouseGoods.add(goods);
			}
		}
		return "Goods added : " + goodsList.toString() + " in the warehouse " + warehouse.toString();
	}

	@Override
	public String removeGoods(
			@WebParam(name = "removedGoodsList") List<Goods> goodsList,
			@WebParam(name = "provisionningWarehouse") Warehouse warehouse) throws Exception {
		for(Goods goods : goodsList) {
			List<Goods> warehouseGoods = warehouse.getWarehouseGoods();
			boolean contains = false;
			for(Goods g : warehouseGoods) {
				if(g.getReference().equals(goods.getReference())){
					contains = true;
					try {
						g.setQuantity(g.getQuantity() - goods.getQuantity());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			if(!contains)
			{
				throw new Exception("The goods : " + goods.getReference() + " isn't in the warehouse " + warehouse.toString());	
			}
		}
		return "Goods removed : " + goodsList.toString() + " in the warehouse " + warehouse.toString();
	}

	@Override
	public String addDeliverie(
			@WebParam(name = "deliverie") Deliverie deliverie) {
		Schedule.getSchedule().getTransactionList().add(deliverie);
		return "Deliverie added : " + deliverie.toString();
	}

	@Override
	public String addOrder(
			@WebParam(name = "order") Order order) {
		Schedule.getSchedule().getTransactionList().add(order);
		return "Order added : " + order.toString();
	}

	@Override
	public String printListedWarehouseSchedule(
			@WebParam(name = "warehouseList") List<Warehouse> warehouseList) {
		return Schedule.getSchedule().printScheludeByWarehouse(warehouseList);
	}

	@Override
	public String printSpecificWarehouseSchedule(
			@WebParam(name = "warehouse") Warehouse warehouse) {
		return Schedule.getSchedule().printScheludeByWarehouse(warehouse);
	}

	@Override
	public String printGeneralSchedule() {
		return Schedule.getSchedule().toString();
	}

	@Override
	public List<Warehouse> getGoodsLocation(
			@WebParam(name = "goodsReference") String reference) {
		List<Warehouse> warehouseOwnerList = new ArrayList<Warehouse>();
		for(Warehouse wh : Warehouse.globalWarehouseList) {
			Goods tempGoods = Goods.getGoodsByRef(wh.getWarehouseGoods(), reference);
			if(tempGoods != null && tempGoods.getQuantity() > 0) {
				warehouseOwnerList.add(wh);
			}
		}
		return warehouseOwnerList;
	}

	@Override
	public int getSpecificWarehouseGoodsQuantity(
			@WebParam(name = "goodsReference") String reference,
			@WebParam(name = "warehouse") Warehouse warehouse) {
		List<Warehouse> warehouseOwnerList = getGoodsLocation(reference);
		int quantity = 0;
		for(Warehouse wh : warehouseOwnerList) {
			if(warehouse.getId() == wh.getId()) {
				quantity += Goods.getGoodsByRef(wh.getWarehouseGoods(), reference).getQuantity();
			}
		}
		return quantity;
	}

	@Override
	public int getGoodsQuantity(
			@WebParam(name = "goodsReference") String reference) {
		int totalQuantity = 0;
		for(Warehouse wh : Warehouse.globalWarehouseList) {
			totalQuantity += getSpecificWarehouseGoodsQuantity(reference, wh);
		}
		return totalQuantity;
	}

	@Override
	public String getListedWarehouseNearlyOutOfStockGoods(
			@WebParam(name = "warehouseList") List<Warehouse> warehouseList) {
		boolean first = true;
		String goodsList = "{\"all\" : {\n";
		for(Warehouse wh : warehouseList) {
			if(first) {
				goodsList += getSpecificWarehouseNearlyOutOfStockGoods(wh);
				first = false;
			}
			else {
				goodsList += ", \n" + getSpecificWarehouseNearlyOutOfStockGoods(wh);
			}
		}
		goodsList += "\n} \n ";
		return goodsList;
	}

	@Override
	public String getSpecificWarehouseNearlyOutOfStockGoods(
			@WebParam(name = "warehouse") Warehouse warehouse) {
		boolean first = true;
		String goodsList = "\"warehouse" + warehouse.getId() + "\" : [";
		for(Goods goods : warehouse.getWarehouseGoods()) {
			if(goods.getSeuil() > goods.getQuantity()) {
				if(first) {
					goodsList += goods.toString();
					first = false;
				}
				else {
					goodsList +=  ", \n" + goods.toString();
				}
			}
		}
		goodsList += "]";
		return goodsList;
	}

	@Override
	public String getAllNearlyOutOfStockGoods() {
		return getListedWarehouseNearlyOutOfStockGoods(Warehouse.globalWarehouseList);
	}

}

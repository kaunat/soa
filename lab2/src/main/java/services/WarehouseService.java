package services;

import java.util.List;
import javax.jws.*;
import warehouseObject.*;

@WebService(serviceName="Security")
public interface WarehouseService {

	public String addGoods (@WebParam(name="addedGoodsList") List<Goods> goodsList, 
			@WebParam(name="providedWarehouse")	Warehouse warehouse);

	public String removeGoods(@WebParam(name="removedGoodsList") List<Goods> goodsList, 
			@WebParam(name="provisionningWarehouse") Warehouse warehouse) throws Exception;

	public String addDeliverie(@WebParam(name="deliverie") Deliverie deliverie);

	public String addOrder(@WebParam(name="order") Order order);

	public String printListedWarehouseSchedule(@WebParam(name="warehouseList") List<Warehouse> warehouseList);
	public String printSpecificWarehouseSchedule(@WebParam(name="warehouse") Warehouse warehouse);
	public String printGeneralSchedule();

	public List<Warehouse> getGoodsLocation(@WebParam(name="goodsReference") String reference);

	public int getSpecificWarehouseGoodsQuantity(@WebParam(name="goodsReference") String reference, @WebParam(name="warehouse") Warehouse warehouse);
	public int getGoodsQuantity(@WebParam(name="goodsReference") String reference);

	public String getListedWarehouseNearlyOutOfStockGoods(@WebParam(name="warehouseList") List<Warehouse> warehouseList);
	public String getSpecificWarehouseNearlyOutOfStockGoods(@WebParam(name="warehouse") Warehouse warehouse);
	public String getAllNearlyOutOfStockGoods();

}
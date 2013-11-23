package services;

import javax.jws.WebService;

@WebService(endpointInterface = "orderOutOfStock")
public class OrderOutOfStockGoodsImpl implements OrderOutOfStockGoods {
	
	@Override
	public String orderOutOfStockGoods(){
		return "Success !";
	}
}

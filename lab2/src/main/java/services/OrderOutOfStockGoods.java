package services;

import javax.jws.WebService;

@WebService(serviceName="Security")
public interface OrderOutOfStockGoods {

	public String orderOutOfStockGoods();

}

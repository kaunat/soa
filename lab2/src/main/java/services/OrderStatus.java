package services;

import javax.jws.WebService;

@WebService(serviceName="orderStatus")
public interface OrderStatus {

	public String orderStatus();
}

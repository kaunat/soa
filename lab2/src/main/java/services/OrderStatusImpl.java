package services;

import javax.jws.WebService;

@WebService(endpointInterface = "orderStatus")
public class OrderStatusImpl implements OrderStatus {

	@Override
	public String orderStatus() {
		return "Success !";
	}
}

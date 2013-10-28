package Fournisseur2;

import javax.jws.*;

@WebService(serviceName="extern")
public interface ClientExterieur {

	@WebMethod
	@WebResult(name="createClient")
	public String createClient(@WebParam(name="log")String login,@WebParam(name="pwd") String pwd,@WebParam(name="firstname") String firstname,@WebParam(name="famname") String famname,@WebParam(name="address") String address);
	@WebMethod
	@WebResult(name="updateClient")
	public String updateClient(@WebParam(name="log")String login,@WebParam(name="pwd") String pwd,@WebParam(name="firstname") String firstname,@WebParam(name="famname") String famname,@WebParam(name="address") String address);
	@WebMethod
	@WebResult(name="deleteClient")
	public String deleteClient(@WebParam(name="log")String login);
	
	
	@WebMethod
	@WebResult(name="logsession")
	public String checkPassword(@WebParam(name="client") String idClient, @WebParam(name="pwd") String pwd);
	
	@WebMethod
	@WebResult(name="refOrder")
	public String createOrder(@WebParam(name="client") String login);
	
	@WebMethod
	@WebResult(name="orders")
	public String orderProduct(@WebParam(name="client") String idClient, @WebParam(name="referenceOrder") String refOrder, @WebParam(name="referenceProd") String refProduct);
	
	
	@WebMethod
	@WebResult(name="orders")
	public String seeClientOrders(@WebParam(name="client") String idClient);
	
	@WebMethod
	@WebResult(name="order")
	public String seeClientOrder(@WebParam(name="client") String idClient, @WebParam(name="refOrder") String refOrder);
	
	@WebMethod
	@WebResult(name="products")
	public String findProductBy(@WebParam(name="kind")String kind,@WebParam(name="value") String value);
	
	@WebMethod
	@WebResult(name="catalogue")
	public String seeCatalogue();
	

}

package Fournisseur1;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


@WebService(serviceName="CRM")
public interface CRMService {
	
	@WebMethod
	@WebResult(name="getToken")
	public String getToken(@WebParam(name="login") String login, @WebParam(name="pwd") String pwd) throws UnauthorizedAccessFault;
	
	@WebMethod
	@WebResult(name="account")
	public Customer account(@WebParam(name="token") String token) throws UnauthorizedAccessFault;
	
	@WebMethod
	@WebResult(name="createCustomer")
	public Customer createCustomer(@WebParam(name="login") String login, @WebParam(name="pwd") String pwd, 
			@WebParam(name="nameCustomer") String nameCustomer, @WebParam(name="firstNameCustomer") String firstNameCustomer, 
			@WebParam(name="address") String address) throws ExistingLoginFault;
	
	@WebMethod
	@WebResult(name="createProduct")
	public Product createProduct(@WebParam(name="nameProduct") String nameProduct, @WebParam(name="category", header = true) Category category, 
			@WebParam(name="reference") String reference, @WebParam(name="price") double price) throws ExistingReferenceFault;
	
	@WebMethod
	@WebResult(name="createOrder")
	public Order createOrder(@WebParam(name="customer", header = true) Customer customer, 
			@WebParam(name="products") ArrayList<ProductQuantity> products) throws NotConnectedFault;
	
	@WebMethod
	@WebResult(name="createCategory")
	public Category createCategory(@WebParam(name="nameCategory") String categoryStr);
	
	@WebMethod
	@WebResult(name="modifyCustomer")
	public Customer modifyCustomer(@WebParam(name="id") int id, @WebParam(name="login") String login, @WebParam(name="pwd") String pwd, 
			@WebParam(name="nameCustomer") String nameCustomer, @WebParam(name="firstNameCustomer") String firstNameCustomer,
			@WebParam(name="address") String address) throws ExistingLoginFault;
	
	@WebMethod
	@WebResult(name="deleteCustomer")
	public String deleteCustomer(@WebParam(name="id") int id);
	
	@WebMethod
	@WebResult(name="getProduct")
	public Product getProduct(@WebParam(name="id") int id);
	
	@WebMethod
	@WebResult(name="getOrder")
	public Order getOrder(@WebParam(name="id") int id);
	
	@WebMethod
	@WebResult(name="getCategory")
	public Category getCategory(@WebParam(name="id") int id);
	
	@WebMethod
	@WebResult(name="getPreferredProducts")
	public ArrayList<Product> getPreferredProducts(@WebParam(name="nbProdPref") int nbProdPref);
	
	@WebMethod
	@WebResult(name="searchProduct")
	public ArrayList<Product> searchProduct (@WebParam(name="name") String name, @WebParam(name="category") Category category, 
			@WebParam(name="reference") String reference);
	
	@WebMethod
	@WebResult(name="Disconnect")
	public String disconnect (@WebParam(name="customer") Customer customer);
	
}

package Fournisseur2;

import javax.jws.*;

@WebService(serviceName="intern")
public interface InternUser {

	@WebMethod
	@WebResult(name="favProd")
	public String getFavoriteProduct(@WebParam(name="client") String idClient);
	
	@WebMethod
	@WebResult(name="createProd")
	public String createProduct(@WebParam(name="reference") String reference, @WebParam(name="name") String name, @WebParam(name="category") String category);
	
	@WebMethod
	@WebResult(name="updateProd")
	public String updateProduct(@WebParam(name="reference") String reference, @WebParam(name="name") String name, @WebParam(name="category") String category);
	
	@WebMethod
	@WebResult(name="deleteProd")
	public String deleteProduct(@WebParam(name="reference") String reference);
	
	@WebMethod
	@WebResult(name="relistprod")
	public String relistProduct(@WebParam(name="reference") String reference);
	
}

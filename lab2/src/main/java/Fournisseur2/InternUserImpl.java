package Fournisseur2;

import javax.jws.*;


@WebService(endpointInterface="service.InternUser")
public class InternUserImpl implements InternUser {
	
	private CRMSystem _crm;
	private boolean isInit = false;

	public String getFavoriteProduct(String idClient){
		if(!isInit) initCRMData();
		return "";
	}
	

	public String createProduct(String reference, String name, String category){
		if(!isInit) initCRMData();
		int r = _crm.addProduct(reference, name, category);
		if(r==0)
			return "The reference " +reference+ " already exist";
		return "The product " +reference+ " has been created";
	}
	

	public String updateProduct(String reference, String name, String category){
		if(!isInit) initCRMData();
		int r = _crm.updateProduct(reference, name, category);
		if(r==0)
			return "The reference " +reference+ " does not exist";
		return "The product " +reference+ " has been updated";
	}
	

	public String deleteProduct(String reference){
		if(!isInit) initCRMData();
		int r = _crm.ProductNotOnSale(reference);
		if(r==0)
			return "The reference " +reference+ " does not exist";
		return "The product " +reference+ " has been out of sale";
		
		
	}
	
	public String relistProduct(String reference){
		if(!isInit) initCRMData();
		int r = _crm.ProductOnSale(reference);
		if(r==0)
			return "The reference " +reference+ " does not exist";
		return "The product " +reference+ " has been relisted";
		
	}
	
	private void initCRMData(){
		_crm = new CRMSystem();
		isInit = true;
	}

}

package Fournisseur2;

import java.util.Map.Entry;

import javax.jws.*;


@WebService(endpointInterface="service.ClientExterieur")
public class ClientExterieurImpl implements ClientExterieur{
	
	private CRMSystem _crm;
	private boolean isInit = false;

	public String createClient(String login, String pwd, String firstname, String famname, String address){
		if(!isInit) initCRMData();
		int r = _crm.addCustomer(login, pwd, firstname, famname, address);
		if(r==0)
			return "The login " +login+ " already exist";
		return "The client " +login+ " has been created";
	}

	public String updateClient(String login, String pwd, String firstname, String famname, String address){
		if(!isInit) initCRMData();
		int r = _crm.updateCustomer(login, pwd, firstname, famname, address);
		if(r ==0)
			return "The client " +login+ " does not exist";
		return "The client " +login+ " has been updated";
	}

	public String deleteClient(String login){
		if(!isInit) initCRMData();
		_crm.deleteCustomer(login);
		return "The client " +login+ " has been deleted";
	}
	
	public String checkPassword(String idClient, String pwd){
		if(!isInit) initCRMData();
		if(!_crm.get_customerMap().containsKey(idClient)){
			return "the client " +idClient+ " does not exist";
		}
		if(_crm.rightPassword(idClient, pwd)) return "right";
		else return "wrong";
	}
	
	
	public String createOrder(String login){
		if(!isInit) initCRMData();
		int ref = _crm.createOrder(login);
		if(ref==-1)
			return "the client " +login+ " does not exist";
		return String.valueOf(ref);
	}

	public String orderProduct(String idClient, String refOrder, String refProduct){
		if(!isInit) initCRMData();
		return _crm.addProductToOrder(idClient, refProduct, Integer.parseInt(refOrder));
	}

	public String seeClientOrders(String idClient){
		if(!isInit) initCRMData();
		if(!_crm.get_customerMap().containsKey(idClient))
			return "The client "+idClient+" does not exist";
		if(_crm.get_customerMap().get(idClient).get_orderList().isEmpty())
			return "The client "+idClient+" has not orders";
		String result = "";
		for (Entry<Integer, Order> e :  _crm.get_orderMap().entrySet()){
			result += "<order>\n";
			result += "\t<reference>" + e.getKey() +"</reference>\n";
			result += "\t<state>" + e.getValue().get_state() + "</state>\n";
			result += "</order>\n";
		} 
		return result;
	}
	
	public String seeClientOrder(String idClient, String refOrder){
		if(!isInit) initCRMData();
		
		int iRefOrder = Integer.parseInt(refOrder);
		
		if(!_crm.get_customerMap().containsKey(idClient))
			return "The client "+idClient+" does not exist";
		if(!_crm.get_orderMap().containsKey(iRefOrder))
			return "The order "+refOrder+" does not exist";
		if(!_crm.get_customerMap().get(idClient).get_orderList().contains(_crm.get_orderMap().get(iRefOrder)))
			return "The client "+idClient+" has not the order "+refOrder;
		
		String result = "";
		Order o = _crm.get_orderMap().get(iRefOrder);
		result += "<numOrder>" + o.get_number() + "</numOrder>\n" ;
		result += "<date>" + o.get_orderDate() +"</date>\n";
		result += "<state>" + o.get_state() + "</state>\n";
		for (Product p :  o.get_productList()){
			result += "<product>\n";
			result += "\t<reference>" + p.get_reference() + "</reference>\n";
			result += "\t<name>" + p.get_name() + "</name>\n";
			result += "\t<category>" + p.get_category() + "</category>\n";
			result += "</product>\n";
		} 
		return result;
	}
	
	public String findProductBy(String kind, String value){
		if(!isInit) initCRMData();
		String result = "";
		if(kind.equals("name")){
			for(Entry<String, Product> e :  _crm.get_catalogue().entrySet()){
				if(value.equals(e.getValue().get_name()) && e.getValue().is_onSale()){
					result += "<item>";
					result += "\t<reference>" + e.getValue().get_reference() + "</reference>\n";
					result += "\t<name>" + e.getValue().get_name() + "</name>\n";
					result += "\t<category>" + e.getValue().get_category() + "</category>\n";
					result += "</item>\n";
				}
			}
		}
		else {
			if(kind.equals("reference")){
				for(Entry<String, Product> e :  _crm.get_catalogue().entrySet()){
					if(value.equals(e.getValue().get_reference()) && e.getValue().is_onSale()){
						result += "<item>";
						result += "\t<reference>" + e.getValue().get_reference() + "</reference>\n";
						result += "\t<name>" + e.getValue().get_name() + "</name>\n";
						result += "\t<category>" + e.getValue().get_category() + "</category>\n";
						result += "</item>\n";
					}
				}
			}
			else{
				if(kind.equals("category")){
					for(Entry<String, Product> e :  _crm.get_catalogue().entrySet()){
						if(value.equals(e.getValue().get_category()) && e.getValue().is_onSale()){
							result += "<item>";
							result += "\t<reference>" + e.getValue().get_reference() + "</reference>\n";
							result += "\t<name>" + e.getValue().get_name() + "</name>\n";
							result += "\t<category>" + e.getValue().get_category() + "</category>\n";
							result += "</item>\n";
						}
					}
				}
				else{
					result = "the kind "+kind + " does not exist";
				}
			}
		}
		
		return result;
	}
	
	private void initCRMData(){
		_crm = new CRMSystem();
		isInit = true;
	}
	
	public String seeCatalogue(){
		if(!isInit) initCRMData();
		String result = "";
		for (Entry<String, Product> e :  _crm.get_catalogue().entrySet()){
			if(e.getValue().is_onSale()){
				result += "<product>";
				result += "\t<reference>" + e.getValue().get_reference() + "</reference>\n";
				result += "\t<name>" + e.getValue().get_name() + "</name>\n";
				result += "\t<category>" + e.getValue().get_category() + "</category>\n";
				result += "</product>\n";
			}
		} 
		return result;
	}
}

package mgd;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import mgd.data.Client;
import mgd.data.Commande;
import mgd.data.DataInstance;
import mgd.data.Produit;


@Path("customer")
public class CustomerRest {


	@GET
	@Produces("text/json")
	public Response getDefault() {
		return Response.status(Status.OK).entity("{ \"clients\" : "+Client.formatClients(DataInstance.clients)+" }").build();
	}

	@GET
	@Path("{customerId}")
	@Produces("text/json")
	public Response getCustomer(@PathParam("customerId") String customerId) {
		for(Client c : DataInstance.clients)
			if(c.id.equals(customerId))
				return Response.status(Status.OK).entity(c.toString()).build();
		return Response.status(Status.NOT_FOUND).entity("null\nUser not found").build();
	}

	@POST
	@Path("{customerID}/")
	@Produces("text/json")
	public Response setCustomer(
			@PathParam("customerId") String customerId,
			@FormParam("nom") String nom,
			@FormParam("prenom") String prenom,
			@FormParam("adresse") String adresse,
			@FormParam("ville") String ville,
			@FormParam("pays") String pays) {
		String resp = "";
		return Response.status(Status.OK).entity(resp).build();
	}
	
	
	@GET
	@Path("{customerId}/products")
	@Produces("text/json")
	public Response getPreferredProducts(@PathParam("customerId") String customerId) {
		Client client = null;
		for(Client c : DataInstance.clients) {
			if(c.id.equals(customerId)) {
				client = c;
				break;
			}
		}
		if(null == client) return Response.status(Status.NOT_FOUND).entity("null\nUser not found").build();
		
		// Recherche des meilleurs produits
		Commande globale = new Commande("");
		for(Commande c : client.getCommandes())
			globale.addProduits(c.getProduits());
		
		if(globale.getProduits().isEmpty())
			return Response.status(Status.OK).entity("{ \"produits-preferes\" : null }").build();
		
		TreeMap<Integer, Set<Produit>> sort = new TreeMap<Integer,Set<Produit>>();
		for(Entry<Produit,Integer> e : globale.getProduits().entrySet()) {
			if(!sort.containsKey(e.getValue()))
				sort.put(e.getValue(), new HashSet<Produit>());
			sort.get(e.getValue()).add(e.getKey());
		}
		
		StringBuilder sb = new StringBuilder("{ \"produits-preferes\" : [\n");
		Entry<Integer, Set<Produit>> e = sort.pollLastEntry();
		sb.append(treeCell(e));
		while(!sort.isEmpty()) {
			sb.append(",\n").append(treeCell(sort.pollLastEntry()));
		}
		
		sb.append("\n] }");
		return Response.status(Status.OK).entity(sb.toString()).build();
	}
	
	private String treeCell(Entry<Integer,Set<Produit>> e) {
		StringBuilder sb = new StringBuilder("{ \"nombre-achat\" : ");
		sb.append(e.getKey()).append(", \"produits\" : [ ");
		if(0 == e.getKey()) sb.append("null");
		else {			
			Iterator<Produit> it = e.getValue().iterator();
			sb.append(it.next());
			while(it.hasNext()) {
				sb.append(", ").append(it.next());
			}
			sb.append(" ]");
		}
		sb.append(" }");
		
		return sb.toString();
	}
	

	
}

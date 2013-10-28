package Transporteur1;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("fedps")
public class FedPS {

	private static HashMap<String, Delivery> deliveryList;

	public FedPS() {
		deliveryList = new HashMap<String, Delivery>();
	}

	// Suivre un colis enregistré
	@GET
	@Path("/track/{deliveryId}")
	@Produces("text/json")
	public Response trackDelivery(@PathParam("deliveryId") String deliveryId) {
		if (!deliveryList.containsKey(deliveryId)) {
			return Response.status(Status.OK).entity("{\"status\": \"Delivery not found\"}").build();
		}
		Delivery d = deliveryList.get(deliveryId);
		String resp = "{\"id\": \"" + d.id + "\", \"pickupPlace\": \"" + d.pickupPlace.name + "\", \"deliveryPlace\": \"" + d.deliveryPlace.name + "\", \"estimatedDeliveryDate\": \"12/12/2013\", \"price\": \"" + d.price() + "\"}";
		return Response.status(Status.OK).entity(resp).build();
	}

	// Ajouter un nouveau colis
	@GET
	@Path("/create/{pickUpPlace}/{deliveryPlace}/{length}/{width}/{height}/{weight}")
	@Produces("text/json")
	public Response createDelivery(@PathParam("pickUpPlace") String pickUpPlace, @PathParam("deliveryPlace") String deliveryPlace, @PathParam("length") int length, @PathParam("width") int width, @PathParam("height") int height, @PathParam("weight") int weight) {
		Delivery d = new Delivery(new Location(pickUpPlace), new Location(deliveryPlace), new Dimension(length, width, height), weight);
		deliveryList.put(String.valueOf(d.id), d);
		String resp = "{\"id\": \"" + DeliveryFactory.CURRENT_ID + "\", \"status\": \"ok\"}";
		return Response.status(Status.OK).entity(resp).build();
	}

	// Estimer le prix d'un colis
	@GET
	@Path("/estimate/{pickUpPlace}/{deliveryPlace}/{length}/{width}/{height}/{weight}")
	@Produces("text/json")
	public Response estimateDelivery(@PathParam("pickUpPlace") String pickUpPlace, @PathParam("deliveryPlace") String deliveryPlace, @PathParam("length") int length, @PathParam("width") int width, @PathParam("height") int height, @PathParam("weight") int weight) {
		Delivery d = new Delivery(-1, new Location(pickUpPlace), new Location(deliveryPlace), new Dimension(length, width, height), weight);
		String resp = "{\"estimatedPrice\": \"" + d.price() + "\"}";
		return Response.status(Status.OK).entity(resp).build();
	}

}

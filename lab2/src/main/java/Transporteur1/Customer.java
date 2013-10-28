package Transporteur1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("customer")
public class Customer {

	@GET
	@Path("/{customerId}")
	@Produces("text/json")
	public Response getExample(@PathParam("customerId") String customerId) {
		System.out.println(customerId);
		if (customerId.equals("unknown"))
			return Response.status(Status.NOT_FOUND).build();
		String resp = "{\"id\": \"" + customerId + "\"}";
		return Response.status(Status.OK).entity(resp).build();
	}

}

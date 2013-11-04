package mgd;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import mgd.data.DataInstance;
import mgd.data.Produit;


@Path("catalogue")
public class CRMRest {

	@GET
	@Produces("text/json")
	public Response getCatalogue() {
		return Response.status(Status.OK).entity("{ \"catalogue\" : "+Produit.formatProduits(DataInstance.produits)+" }").build();
	}

	/**
	 * Recherche dans le catalogue selon des crit�res donn�s par l'utilisateur.
	 * Tous les crit�res sont optionnels et n'ont pas besoin d'�tre plac� dans
	 * un ordre pr�cis.
	 * Si aucun crit�re n'est fournit la recherche retournera l'ensemble du catalogue.
	 * http://localhost:8081/rest/catalogue/search?nom={someName}&categorie={someCategorie}&reference={someReference}
	 * @param nom
	 * @param categorie
	 * @param reference
	 * @return Sous partie du catalogue correspondant aux crit�res de recherhce sous forme JSon
	 */
	@GET
	@Path("/{action}")
	@Produces("text/json")
	public Response getSearchCatalogue(
			@PathParam("action") String action,
			@QueryParam("nom") String nom,
			@QueryParam("categorie") String categorie,
			@QueryParam("reference") String reference) {

		Map<Produit, Integer> retour = new HashMap<Produit, Integer>();

		for(Entry<Produit, Integer> e : DataInstance.produits.entrySet()) {
			// Si un crit�re de recherche est d�fini on l'applique.
			// S'il n'y a pas de match alors on passe au produit suivant.
			if(null != nom			&& !Pattern.matches("(?i).*"+nom+".*",			e.getKey().getNom()))		continue;
			if(null != categorie	&& !Pattern.matches("(?i).*"+categorie+".*",	e.getKey().getCategorie()))	continue;
			if(null != reference	&& !Pattern.matches("(?i).*"+reference+".*",	e.getKey().getReference()))	continue;
			// Produit match tous les param�tres de la recherche
			retour.put(e.getKey(),e.getValue());
		}

		return Response.status(Status.OK).entity("{ \"catalogue\" : "+Produit.formatProduits(retour)+" }").build();
	}
}

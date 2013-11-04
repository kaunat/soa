package mgd.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Commande {
	private String date;
	private float prixTotal;
	private Map<Produit,Integer> produits;

	
	public Commande(String date) {
		this(date, new HashMap<Produit,Integer>());
	}
	
	public Commande(String date, Map<Produit,Integer> produits) {
		this.date = date;
		this.produits = produits;
		setPrixTotal();
	}

	/* Date */
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	/* Prix Total */
	public float getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}
	/**
	 * Set the total price according to the list of products associated with the command
	 */
	public void setPrixTotal() {
		prixTotal = 0;
		for(Entry<Produit, Integer> e  : produits.entrySet())
			prixTotal += e.getValue() * e.getKey().getPrix();
	}

	/* Produits */
	public Map<Produit,Integer> getProduits() {
		return produits;
	}
	public void addProduit(int nombre, Produit produit) {
		assert nombre >= 0 : "On ne peut pas commander un nombre n�gatif d'objet";
		if(this.produits.containsKey(produit))
			this.produits.put(produit, nombre+this.produits.get(produit));
		else
			this.produits.put(produit, nombre);
		prixTotal += nombre * produit.getPrix();
	}
	public void addProduits(Map<Produit,Integer> newp) {
		if(newp.isEmpty()) return;

		for(Entry<Produit,Integer> e : newp.entrySet()){
			if(produits.containsKey(e.getKey())) {
				produits.put(e.getKey(), e.getValue()+produits.get(e.getKey()));
			} else {
				produits.put(e.getKey(), e.getValue());
			}				
		}
		setPrixTotal();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ \"date\" : \"").append(date)
		.append("\", \"total\" : ").append(prixTotal)
		.append(", \"produits\" : ");

		sb.append(Produit.formatProduits(produits));

		sb.append(" }");
		return sb.toString();
	}
	
	public static String formatCommandes(java.util.List<Commande> commandes) {
		
		if(commandes.isEmpty()) return "null";
		
		StringBuilder retour = new StringBuilder("[ ");
		Iterator<Commande> it = commandes.iterator();
		retour.append(it.next());
		while(it.hasNext())
			retour.append(", ").append(it.next());
		retour.append(" ]");
		return retour.toString();
	}

}

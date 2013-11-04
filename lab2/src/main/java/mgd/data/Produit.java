package mgd.data;

import java.util.Iterator;
import java.util.Map;

public class Produit {
	private String reference;
	private String nom;
	private String categorie;
	private float prix;

	public Produit( String reference, String nom, String categorie, float prix) {
		assert prix >= 0 : "Le prix d'un objet ne peut �tre n�gatif";

		this.reference = reference;
		this.nom = nom;
		this.categorie = categorie;
		this.prix= prix;
	}

	/* Reference */
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}

	/* Nom*/
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	/* Categorie */
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	/* Prix */
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}


	@Override
	public String toString() {
		return "{ \"reference\" : \""+reference+"\", "
				+"\"nom\" : \""+nom+"\", "
				+"\"categorie\" : \""+categorie+"\", "
				+"\"prix\" : "+prix
				+" }";
	}

	public static String formatProduits(Map<Produit,Integer> produits) {
		
		if(produits.isEmpty()) return "null";
		
		
		StringBuilder sb = new StringBuilder();
		Iterator<Produit> it = produits.keySet().iterator();

		Produit p = it.next();
		sb.append("[ { \"nombre\" : ").append(produits.get(p))
		.append(", \"produit\" : ").append(p.toString()).append(" }");

		// Si il y en a plus qu'un
		while(it.hasNext()) {
			p = it.next();
			sb.append(", { \"nombre\" : ").append(produits.get(p))
			.append(", \"produit\" : ").append(p.toString()).append(" }");
		}

		sb.append(" ]");

		return sb.toString();
	}

}

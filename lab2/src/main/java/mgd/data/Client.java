package mgd.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {

	private static int created = 0;
	
	public final String id;
	public final String nom;
	public final String prenom;
	public final Adresse adresse;

	private List<Commande> commandes;

	public Client(String nom, String prenom, Adresse adresse) {
		this.nom= nom;
		this.prenom = prenom;
		this.adresse = adresse;
		
		this.id = nom.substring(0, 1).toLowerCase()+prenom.substring(0, 1).toLowerCase()+(++created);

		this.commandes = new ArrayList<Commande>();
	}

	public void addCommande(Commande c) {
		commandes.add(c);
	}
	public  List<Commande> getCommandes() {
		return commandes;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{ \"id\" : \"");
		sb.append(id).append("\", \"nom\" : \"")
		.append(nom).append("\",")
		.append(" \"prenom\" : \"").append(prenom)
		.append("\", \"commandes\" : ")
		.append(Commande.formatCommandes(commandes))
		.append(" }");
		return sb.toString();
	}
	
	public static String formatClients(List<Client> clients) {
		if (clients.isEmpty()) return "null";
		
		StringBuilder sb = new StringBuilder("[ ");
		Iterator<Client> it = clients.iterator();
		
		sb.append(it.next());
		while(it.hasNext())
				sb.append(", ").append(it.next());
		
		sb.append(" ]");
		return sb.toString();
	}
}

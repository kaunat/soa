package mgd.data;

public class Adresse {

	public final String rue;
	public final String ville;
	public final String pays;

	public Adresse(String rue, String ville, String pays) {
		this.rue = rue;
		this.ville = ville;
		this.pays = pays;
	}
	
	@Override
	public String toString() {
		return rue + " " + ville + " " + pays;
	}

}

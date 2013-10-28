package Transporteur1;

public class Delivery {

	public int id;
	public Location pickupPlace, deliveryPlace;
	public Dimension dimension;
	public int weight;

	public Delivery(int id, Location pickupPlace, Location deliveryPlace, Dimension dimension, int weight) {
		this.id = id;
		this.pickupPlace = pickupPlace;
		this.deliveryPlace = deliveryPlace;
		this.dimension = dimension;
		this.weight = weight;
	}

	public Delivery(Location pickupPlace, Location deliveryPlace, Dimension dimension, int weight) {
		this.id = -1;
		this.pickupPlace = pickupPlace;
		this.deliveryPlace = deliveryPlace;
		this.dimension = dimension;
		this.weight = weight;
	}

	public int price() {
		return dimension.volume() * weight;
	}

}

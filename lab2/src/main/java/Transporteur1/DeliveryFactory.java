package Transporteur1;

import java.util.Random;

public class DeliveryFactory {

	public static int CURRENT_ID = 1;
	public final static String[] PLACES = { "Paris", "Valbonne", "Sophia-Antipolis", "Nice", "Toulouse", "Bordeaux", "Marseille" };

	public static Delivery getRandomDelivery() {

		Random r = new Random();

		Location pickupPlace = new Location(PLACES[r.nextInt(PLACES.length)]);
		Location deliveryPlace = new Location(PLACES[r.nextInt(PLACES.length)]);
		Dimension dimension = new Dimension(r.nextInt(150) + 1, r.nextInt(150) + 1, r.nextInt(150) + 1); // Dimensions (cm)
		int weight = r.nextInt(50000) + 1; // Masse (g)

		Delivery delivery = new Delivery(CURRENT_ID++, pickupPlace, deliveryPlace, dimension, weight);
		return delivery;
	}

}

package Transporteur2;

import java.util.Date;
import java.util.Calendar;

import javax.jws.WebService;


@WebService(endpointInterface = "transport.DeliveryNetworkService")
public class DeliveryNetworkServiceImpl implements DeliveryNetworkService {

	public DeliveryPersonalResponse delivery(DeliveryPersonalRequest request) throws DeliveryFault {
		DeliveryPersonalResponse response = new DeliveryPersonalResponse();
		DeliveryProperties properties = new DeliveryProperties();
		
		response.price = computePrice(properties);
		response.estimatedDate = computeEstimatedDate();
		response.packageNumber = computePackageNumber(properties, request);
		
		return response;
	}

	public DeliveryPersonalResponse quote(DeliveryPersonalRequest request) throws DeliveryFault {
		DeliveryPersonalResponse response = new DeliveryPersonalResponse();
		DeliveryProperties properties = new DeliveryProperties();
		
		response.price = computePrice(properties);
		response.estimatedDate = computeEstimatedDate();
		
		return response;
	}

	public TrackPersonalResponse track(String packageNumber, TrackPersonalRequest request) throws TrackFault {
		TrackPersonalResponse response = new TrackPersonalResponse();
		
		response.estimatedDate = computeEstimatedDate();
		response.location = computeLocation();
		
		return response;
	}
	

	private int computePrice(DeliveryProperties properties) {
		int price  = 10;
		int weight = properties.weight;
		int height = properties.height;
		int width  = properties.width;
		int length = properties.length;
		
		price += weight * 2 + height * width * length * 2;
		
		return price;
	}
	
	private Calendar computeEstimatedDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
				
		cal.add(cal.DATE, 2);
		
		return cal;
	}
	
	private String computePackageNumber(DeliveryProperties properties, DeliveryPersonalRequest request) {
		int weight = properties.weight;
		int height = properties.height;
		int width  = properties.width;
		int length = properties.length;
		
		String packageNumber = weight * height * width * length + "_" + request.firstName + "_" + request.lastName;
		
		return packageNumber;
	}
	
	private String computeLocation() {
		String location = "Last update : your package is located in Cannes";
		
		return location;
	}

}

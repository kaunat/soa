package Transporteur2;

import java.util.Date;
import java.util.Calendar;

import javax.jws.WebService;


@WebService(endpointInterface = "transport.DeliveryNetworkService")
public class DeliveryNetworkServiceImpl implements DeliveryNetworkService {

	public DeliveryResponse delivery(DeliveryRequest request) throws DeliveryFault {
		DeliveryResponse response = new DeliveryResponse();
		DeliveryProperties properties = new DeliveryProperties();
		
		response.price = computePrice(properties);
		response.estimatedDate = computeEstimatedDate();
		response.packageNumber = computePackageNumber(properties, request);
		
		return response;
	}

	public DeliveryResponse quote(DeliveryRequest request) throws DeliveryFault {
		DeliveryResponse response = new DeliveryResponse();
		DeliveryProperties properties = new DeliveryProperties();
		
		response.price = computePrice(properties);
		response.estimatedDate = computeEstimatedDate();
		
		return response;
	}

	public TrackResponse track(String packageNumber, TrackRequest request) throws TrackFault {
		TrackResponse response = new TrackResponse();
		
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
	
	private String computePackageNumber(DeliveryProperties properties, DeliveryRequest request) {
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

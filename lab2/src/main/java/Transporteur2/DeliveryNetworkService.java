package Transporteur2;

import javax.jws.*;

@WebService(name="DeliveryNetwork")
public interface DeliveryNetworkService {

	@WebMethod
	@WebResult(name="delivery_response")
	public DeliveryPersonalResponse delivery(@WebParam(name="delivery_request") DeliveryPersonalRequest request)
		throws DeliveryFault;
	
	@WebMethod
	@WebResult(name="quote_response")
	public DeliveryPersonalResponse quote(@WebParam(name="quote_request") DeliveryPersonalRequest request)
		throws DeliveryFault;
	
	@WebMethod
	@WebResult(name="track_response")
	public TrackPersonalResponse track(@WebParam(name="number", header=true) String packageNumber,
								@WebParam(name="track_request") TrackPersonalRequest request)
		throws TrackFault;

}
 
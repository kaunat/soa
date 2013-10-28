package Transporteur2;

import javax.jws.*;

import transport.messages.*;

@WebService(name="DeliveryNetwork")
public interface DeliveryNetworkService {

	@WebMethod
	@WebResult(name="delivery_response")
	public DeliveryResponse delivery(@WebParam(name="delivery_request") DeliveryRequest request)
		throws DeliveryFault;
	
	@WebMethod
	@WebResult(name="quote_response")
	public DeliveryResponse quote(@WebParam(name="quote_request") DeliveryRequest request)
		throws DeliveryFault;
	
	@WebMethod
	@WebResult(name="track_response")
	public TrackResponse track(@WebParam(name="number", header=true) String packageNumber,
								@WebParam(name="track_request") TrackRequest request)
		throws TrackFault;

}
 
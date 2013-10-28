package Transporteur2;

import javax.xml.bind.annotation.*;

import transport.packages.*;

@XmlType(name="DeliveryRequest")
public class DeliveryRequest {
	
	@XmlElement(required=true, name="from_address")
	public String fromAddress;
	
	@XmlElement(required=true, name="to_address")
	public String toAddress;
	
	@XmlElement(required=true, name="first_name")
	public String firstName;
	
	@XmlElement(required=true, name="last_name")
	public String lastName;
	
	@XmlElement(required=true, name="delivery_properties")
	public DeliveryProperties deliveryProperties;
}

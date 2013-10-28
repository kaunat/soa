package Transporteur2;

import javax.xml.bind.annotation.*;

@XmlType(name="DeliveryProperties")
public class DeliveryProperties {

	@XmlElement(required=true, name="length")
	public int length;
	
	@XmlElement(required=true, name="width")
	public int width;
	
	@XmlElement(required=true, name="height")
	public int height;
	
	@XmlElement(required=true, name="weight")
	public int weight;
}

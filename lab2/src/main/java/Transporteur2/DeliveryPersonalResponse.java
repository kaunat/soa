package Transporteur2;

import java.util.Calendar;
import javax.xml.bind.annotation.*;

@XmlType(name="DeliveryPersonalResponse")
public class DeliveryPersonalResponse {
	
	@XmlElement(name="price")
	public int price;
	
	@XmlElement(name="estimated_date")
	public Calendar estimatedDate;
	
	@XmlElement(name="package_number")
	public String packageNumber;

}

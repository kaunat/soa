package Transporteur2;

import javax.xml.bind.annotation.*;

@XmlType(name="TrackPersonalRequest")
public class TrackPersonalRequest {
	
	@XmlElement(name="delivery_number")
	public String packageNumber;

}

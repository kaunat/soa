package Transporteur2;

import javax.xml.bind.annotation.*;

@XmlType(name="TrackRequest")
public class TrackRequest {
	
	@XmlElement(name="delivery_number")
	public String packageNumber;

}

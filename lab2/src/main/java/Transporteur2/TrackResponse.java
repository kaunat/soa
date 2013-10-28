package Transporteur2;

import java.util.Calendar;
import javax.xml.bind.annotation.*;

@XmlType(name="TrackResponse")
public class TrackResponse {
	
	@XmlElement(name="estimated_date")
	public Calendar estimatedDate;
	
	@XmlElement(name="location")
	public String location;
}

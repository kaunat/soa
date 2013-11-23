
package transport.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trackResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trackResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="track_response" type="{http://Transporteur2/}TrackPersonalResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trackResponse", propOrder = {
    "trackResponse"
})
public class TrackResponse {

    @XmlElement(name = "track_response")
    protected TrackPersonalResponse trackResponse;

    /**
     * Gets the value of the trackResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TrackPersonalResponse }
     *     
     */
    public TrackPersonalResponse getTrackResponse() {
        return trackResponse;
    }

    /**
     * Sets the value of the trackResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackPersonalResponse }
     *     
     */
    public void setTrackResponse(TrackPersonalResponse value) {
        this.trackResponse = value;
    }

}

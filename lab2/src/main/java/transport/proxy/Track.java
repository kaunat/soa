
package transport.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for track complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="track">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="track_request" type="{http://Transporteur2/}TrackPersonalRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "track", propOrder = {
    "trackRequest"
})
public class Track {

    @XmlElement(name = "track_request")
    protected TrackPersonalRequest trackRequest;

    /**
     * Gets the value of the trackRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TrackPersonalRequest }
     *     
     */
    public TrackPersonalRequest getTrackRequest() {
        return trackRequest;
    }

    /**
     * Sets the value of the trackRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackPersonalRequest }
     *     
     */
    public void setTrackRequest(TrackPersonalRequest value) {
        this.trackRequest = value;
    }

}

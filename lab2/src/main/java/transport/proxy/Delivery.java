
package transport.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for delivery complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="delivery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="delivery_request" type="{http://Transporteur2/}DeliveryPersonalRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "delivery", propOrder = {
    "deliveryRequest"
})
public class Delivery {

    @XmlElement(name = "delivery_request")
    protected DeliveryPersonalRequest deliveryRequest;

    /**
     * Gets the value of the deliveryRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryPersonalRequest }
     *     
     */
    public DeliveryPersonalRequest getDeliveryRequest() {
        return deliveryRequest;
    }

    /**
     * Sets the value of the deliveryRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryPersonalRequest }
     *     
     */
    public void setDeliveryRequest(DeliveryPersonalRequest value) {
        this.deliveryRequest = value;
    }

}

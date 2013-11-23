
package transport.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for quote complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="quote">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="quote_request" type="{http://Transporteur2/}DeliveryPersonalRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "quote", propOrder = {
    "quoteRequest"
})
public class Quote {

    @XmlElement(name = "quote_request")
    protected DeliveryPersonalRequest quoteRequest;

    /**
     * Gets the value of the quoteRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryPersonalRequest }
     *     
     */
    public DeliveryPersonalRequest getQuoteRequest() {
        return quoteRequest;
    }

    /**
     * Sets the value of the quoteRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryPersonalRequest }
     *     
     */
    public void setQuoteRequest(DeliveryPersonalRequest value) {
        this.quoteRequest = value;
    }

}

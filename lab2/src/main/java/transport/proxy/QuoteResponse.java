
package transport.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for quoteResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="quoteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="quote_response" type="{http://Transporteur2/}DeliveryPersonalResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "quoteResponse", propOrder = {
    "quoteResponse"
})
public class QuoteResponse {

    @XmlElement(name = "quote_response")
    protected DeliveryPersonalResponse quoteResponse;

    /**
     * Gets the value of the quoteResponse property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryPersonalResponse }
     *     
     */
    public DeliveryPersonalResponse getQuoteResponse() {
        return quoteResponse;
    }

    /**
     * Sets the value of the quoteResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryPersonalResponse }
     *     
     */
    public void setQuoteResponse(DeliveryPersonalResponse value) {
        this.quoteResponse = value;
    }

}

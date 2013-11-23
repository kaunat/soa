
package client.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addDeliverie complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addDeliverie">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deliverie" type="{http://services/}deliverie" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addDeliverie", propOrder = {
    "deliverie"
})
public class AddDeliverie {

    protected Deliverie deliverie;

    /**
     * Gets the value of the deliverie property.
     * 
     * @return
     *     possible object is
     *     {@link Deliverie }
     *     
     */
    public Deliverie getDeliverie() {
        return deliverie;
    }

    /**
     * Sets the value of the deliverie property.
     * 
     * @param value
     *     allowed object is
     *     {@link Deliverie }
     *     
     */
    public void setDeliverie(Deliverie value) {
        this.deliverie = value;
    }

}

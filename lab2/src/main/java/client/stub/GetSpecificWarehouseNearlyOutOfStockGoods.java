
package client.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSpecificWarehouseNearlyOutOfStockGoods complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSpecificWarehouseNearlyOutOfStockGoods">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="warehouse" type="{http://services/}warehouse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSpecificWarehouseNearlyOutOfStockGoods", propOrder = {
    "warehouse"
})
public class GetSpecificWarehouseNearlyOutOfStockGoods {

    protected Warehouse warehouse;

    /**
     * Gets the value of the warehouse property.
     * 
     * @return
     *     possible object is
     *     {@link Warehouse }
     *     
     */
    public Warehouse getWarehouse() {
        return warehouse;
    }

    /**
     * Sets the value of the warehouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Warehouse }
     *     
     */
    public void setWarehouse(Warehouse value) {
        this.warehouse = value;
    }

}


package client.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSpecificWarehouseGoodsQuantity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSpecificWarehouseGoodsQuantity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="goodsReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "getSpecificWarehouseGoodsQuantity", propOrder = {
    "goodsReference",
    "warehouse"
})
public class GetSpecificWarehouseGoodsQuantity {

    protected String goodsReference;
    protected Warehouse warehouse;

    /**
     * Gets the value of the goodsReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodsReference() {
        return goodsReference;
    }

    /**
     * Sets the value of the goodsReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodsReference(String value) {
        this.goodsReference = value;
    }

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


package client.stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for removeGoods complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="removeGoods">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="removedGoodsList" type="{http://services/}goods" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="provisionningWarehouse" type="{http://services/}warehouse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeGoods", propOrder = {
    "removedGoodsList",
    "provisionningWarehouse"
})
public class RemoveGoods {

    protected List<Goods> removedGoodsList;
    protected Warehouse provisionningWarehouse;

    /**
     * Gets the value of the removedGoodsList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the removedGoodsList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemovedGoodsList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Goods }
     * 
     * 
     */
    public List<Goods> getRemovedGoodsList() {
        if (removedGoodsList == null) {
            removedGoodsList = new ArrayList<Goods>();
        }
        return this.removedGoodsList;
    }

    /**
     * Gets the value of the provisionningWarehouse property.
     * 
     * @return
     *     possible object is
     *     {@link Warehouse }
     *     
     */
    public Warehouse getProvisionningWarehouse() {
        return provisionningWarehouse;
    }

    /**
     * Sets the value of the provisionningWarehouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Warehouse }
     *     
     */
    public void setProvisionningWarehouse(Warehouse value) {
        this.provisionningWarehouse = value;
    }

    /**
     * Sets the value of the removedGoodsList property.
     * 
     * @param removedGoodsList
     *     allowed object is
     *     {@link Goods }
     *     
     */
    public void setRemovedGoodsList(List<Goods> removedGoodsList) {
        this.removedGoodsList = removedGoodsList;
    }

}

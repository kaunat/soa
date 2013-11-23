
package client.stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addGoods complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addGoods">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addedGoodsList" type="{http://services/}goods" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="providedWarehouse" type="{http://services/}warehouse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addGoods", propOrder = {
    "addedGoodsList",
    "providedWarehouse"
})
public class AddGoods {

    protected List<Goods> addedGoodsList;
    protected Warehouse providedWarehouse;

    /**
     * Gets the value of the addedGoodsList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addedGoodsList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddedGoodsList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Goods }
     * 
     * 
     */
    public List<Goods> getAddedGoodsList() {
        if (addedGoodsList == null) {
            addedGoodsList = new ArrayList<Goods>();
        }
        return this.addedGoodsList;
    }

    /**
     * Gets the value of the providedWarehouse property.
     * 
     * @return
     *     possible object is
     *     {@link Warehouse }
     *     
     */
    public Warehouse getProvidedWarehouse() {
        return providedWarehouse;
    }

    /**
     * Sets the value of the providedWarehouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Warehouse }
     *     
     */
    public void setProvidedWarehouse(Warehouse value) {
        this.providedWarehouse = value;
    }

    /**
     * Sets the value of the addedGoodsList property.
     * 
     * @param addedGoodsList
     *     allowed object is
     *     {@link Goods }
     *     
     */
    public void setAddedGoodsList(List<Goods> addedGoodsList) {
        this.addedGoodsList = addedGoodsList;
    }

}

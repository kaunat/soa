
package client.stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for warehouse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="warehouse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services/}entity">
 *       &lt;sequence>
 *         &lt;element name="warehouseGoods" type="{http://services/}goods" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "warehouse", propOrder = {
    "warehouseGoods"
})
public class Warehouse
    extends Entity
{

    @XmlElement(nillable = true)
    protected List<Goods> warehouseGoods;

    /**
     * Gets the value of the warehouseGoods property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warehouseGoods property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarehouseGoods().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Goods }
     * 
     * 
     */
    public List<Goods> getWarehouseGoods() {
        if (warehouseGoods == null) {
            warehouseGoods = new ArrayList<Goods>();
        }
        return this.warehouseGoods;
    }

    /**
     * Sets the value of the warehouseGoods property.
     * 
     * @param warehouseGoods
     *     allowed object is
     *     {@link Goods }
     *     
     */
    public void setWarehouseGoods(List<Goods> warehouseGoods) {
        this.warehouseGoods = warehouseGoods;
    }

}

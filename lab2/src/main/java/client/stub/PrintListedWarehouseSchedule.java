
package client.stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for printListedWarehouseSchedule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="printListedWarehouseSchedule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="warehouseList" type="{http://services/}warehouse" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "printListedWarehouseSchedule", propOrder = {
    "warehouseList"
})
public class PrintListedWarehouseSchedule {

    protected List<Warehouse> warehouseList;

    /**
     * Gets the value of the warehouseList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warehouseList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarehouseList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Warehouse }
     * 
     * 
     */
    public List<Warehouse> getWarehouseList() {
        if (warehouseList == null) {
            warehouseList = new ArrayList<Warehouse>();
        }
        return this.warehouseList;
    }

    /**
     * Sets the value of the warehouseList property.
     * 
     * @param warehouseList
     *     allowed object is
     *     {@link Warehouse }
     *     
     */
    public void setWarehouseList(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

}

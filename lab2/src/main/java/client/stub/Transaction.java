
package client.stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="goodsList" type="{http://services/}goods" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="transporter" type="{http://services/}transporter" minOccurs="0"/>
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
@XmlType(name = "transaction", propOrder = {
    "date",
    "goodsList",
    "transporter",
    "warehouse"
})
@XmlSeeAlso({
    Order.class,
    Deliverie.class
})
public abstract class Transaction {

    protected String date;
    @XmlElement(nillable = true)
    protected List<Goods> goodsList;
    protected Transporter transporter;
    protected Warehouse warehouse;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the goodsList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the goodsList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGoodsList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Goods }
     * 
     * 
     */
    public List<Goods> getGoodsList() {
        if (goodsList == null) {
            goodsList = new ArrayList<Goods>();
        }
        return this.goodsList;
    }

    /**
     * Gets the value of the transporter property.
     * 
     * @return
     *     possible object is
     *     {@link Transporter }
     *     
     */
    public Transporter getTransporter() {
        return transporter;
    }

    /**
     * Sets the value of the transporter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Transporter }
     *     
     */
    public void setTransporter(Transporter value) {
        this.transporter = value;
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

    /**
     * Sets the value of the goodsList property.
     * 
     * @param goodsList
     *     allowed object is
     *     {@link Goods }
     *     
     */
    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

}

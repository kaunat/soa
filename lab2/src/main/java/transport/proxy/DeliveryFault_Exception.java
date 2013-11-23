
package transport.proxy;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.5.1
 * 2013-11-23T19:40:07.092+01:00
 * Generated source version: 2.5.1
 */

@WebFault(name = "DeliveryFault", targetNamespace = "http://Transporteur2/")
public class DeliveryFault_Exception extends Exception {
    
    private transport.proxy.DeliveryFault deliveryFault;

    public DeliveryFault_Exception() {
        super();
    }
    
    public DeliveryFault_Exception(String message) {
        super(message);
    }
    
    public DeliveryFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public DeliveryFault_Exception(String message, transport.proxy.DeliveryFault deliveryFault) {
        super(message);
        this.deliveryFault = deliveryFault;
    }

    public DeliveryFault_Exception(String message, transport.proxy.DeliveryFault deliveryFault, Throwable cause) {
        super(message, cause);
        this.deliveryFault = deliveryFault;
    }

    public transport.proxy.DeliveryFault getFaultInfo() {
        return this.deliveryFault;
    }
}
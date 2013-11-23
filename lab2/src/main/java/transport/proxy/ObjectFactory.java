
package transport.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the transport.proxy package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeliveryResponse_QNAME = new QName("http://Transporteur2/", "deliveryResponse");
    private final static QName _Quote_QNAME = new QName("http://Transporteur2/", "quote");
    private final static QName _TrackFault_QNAME = new QName("http://Transporteur2/", "TrackFault");
    private final static QName _Track_QNAME = new QName("http://Transporteur2/", "track");
    private final static QName _Number_QNAME = new QName("http://Transporteur2/", "number");
    private final static QName _Delivery_QNAME = new QName("http://Transporteur2/", "delivery");
    private final static QName _DeliveryFault_QNAME = new QName("http://Transporteur2/", "DeliveryFault");
    private final static QName _TrackResponse_QNAME = new QName("http://Transporteur2/", "trackResponse");
    private final static QName _QuoteResponse_QNAME = new QName("http://Transporteur2/", "quoteResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: transport.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeliveryResponse }
     * 
     */
    public DeliveryResponse createDeliveryResponse() {
        return new DeliveryResponse();
    }

    /**
     * Create an instance of {@link Quote }
     * 
     */
    public Quote createQuote() {
        return new Quote();
    }

    /**
     * Create an instance of {@link TrackFault }
     * 
     */
    public TrackFault createTrackFault() {
        return new TrackFault();
    }

    /**
     * Create an instance of {@link Track }
     * 
     */
    public Track createTrack() {
        return new Track();
    }

    /**
     * Create an instance of {@link DeliveryFault }
     * 
     */
    public DeliveryFault createDeliveryFault() {
        return new DeliveryFault();
    }

    /**
     * Create an instance of {@link Delivery }
     * 
     */
    public Delivery createDelivery() {
        return new Delivery();
    }

    /**
     * Create an instance of {@link TrackResponse }
     * 
     */
    public TrackResponse createTrackResponse() {
        return new TrackResponse();
    }

    /**
     * Create an instance of {@link QuoteResponse }
     * 
     */
    public QuoteResponse createQuoteResponse() {
        return new QuoteResponse();
    }

    /**
     * Create an instance of {@link DeliveryProperties }
     * 
     */
    public DeliveryProperties createDeliveryProperties() {
        return new DeliveryProperties();
    }

    /**
     * Create an instance of {@link TrackPersonalResponse }
     * 
     */
    public TrackPersonalResponse createTrackPersonalResponse() {
        return new TrackPersonalResponse();
    }

    /**
     * Create an instance of {@link TrackPersonalRequest }
     * 
     */
    public TrackPersonalRequest createTrackPersonalRequest() {
        return new TrackPersonalRequest();
    }

    /**
     * Create an instance of {@link DeliveryPersonalRequest }
     * 
     */
    public DeliveryPersonalRequest createDeliveryPersonalRequest() {
        return new DeliveryPersonalRequest();
    }

    /**
     * Create an instance of {@link DeliveryPersonalResponse }
     * 
     */
    public DeliveryPersonalResponse createDeliveryPersonalResponse() {
        return new DeliveryPersonalResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeliveryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Transporteur2/", name = "deliveryResponse")
    public JAXBElement<DeliveryResponse> createDeliveryResponse(DeliveryResponse value) {
        return new JAXBElement<DeliveryResponse>(_DeliveryResponse_QNAME, DeliveryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Quote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Transporteur2/", name = "quote")
    public JAXBElement<Quote> createQuote(Quote value) {
        return new JAXBElement<Quote>(_Quote_QNAME, Quote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrackFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Transporteur2/", name = "TrackFault")
    public JAXBElement<TrackFault> createTrackFault(TrackFault value) {
        return new JAXBElement<TrackFault>(_TrackFault_QNAME, TrackFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Track }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Transporteur2/", name = "track")
    public JAXBElement<Track> createTrack(Track value) {
        return new JAXBElement<Track>(_Track_QNAME, Track.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Transporteur2/", name = "number")
    public JAXBElement<String> createNumber(String value) {
        return new JAXBElement<String>(_Number_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delivery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Transporteur2/", name = "delivery")
    public JAXBElement<Delivery> createDelivery(Delivery value) {
        return new JAXBElement<Delivery>(_Delivery_QNAME, Delivery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeliveryFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Transporteur2/", name = "DeliveryFault")
    public JAXBElement<DeliveryFault> createDeliveryFault(DeliveryFault value) {
        return new JAXBElement<DeliveryFault>(_DeliveryFault_QNAME, DeliveryFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrackResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Transporteur2/", name = "trackResponse")
    public JAXBElement<TrackResponse> createTrackResponse(TrackResponse value) {
        return new JAXBElement<TrackResponse>(_TrackResponse_QNAME, TrackResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuoteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Transporteur2/", name = "quoteResponse")
    public JAXBElement<QuoteResponse> createQuoteResponse(QuoteResponse value) {
        return new JAXBElement<QuoteResponse>(_QuoteResponse_QNAME, QuoteResponse.class, null, value);
    }

}


package mx.gob.isem.sistematizacion.soap.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Empleado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Empleado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="primerApellido" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="segundoApellido" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rfc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rfid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="agregado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="modificado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="eliminado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="huellas" type="{http://ws.biometrico.central.isem.gob.mx/}ListaHuellas" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Empleado", propOrder = {
    "id",
    "nombre",
    "primerApellido",
    "segundoApellido",
    "rfc",
    "rfid",
    "agregado",
    "modificado",
    "eliminado",
    "huellas"
})
public class Empleado {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String primerApellido;
    @XmlElement(required = true)
    protected String segundoApellido;
    @XmlElement(required = true)
    protected String rfc;
    protected int rfid;
    @XmlElementRef(name = "agregado", namespace = "http://ws.biometrico.central.isem.gob.mx/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> agregado;
    @XmlElementRef(name = "modificado", namespace = "http://ws.biometrico.central.isem.gob.mx/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> modificado;
    @XmlElementRef(name = "eliminado", namespace = "http://ws.biometrico.central.isem.gob.mx/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> eliminado;
    @XmlElementRef(name = "huellas", namespace = "http://ws.biometrico.central.isem.gob.mx/", type = JAXBElement.class, required = false)
    protected JAXBElement<ListaHuellas> huellas;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad primerApellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * Define el valor de la propiedad primerApellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimerApellido(String value) {
        this.primerApellido = value;
    }

    /**
     * Obtiene el valor de la propiedad segundoApellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Define el valor de la propiedad segundoApellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegundoApellido(String value) {
        this.segundoApellido = value;
    }

    /**
     * Obtiene el valor de la propiedad rfc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Define el valor de la propiedad rfc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRfc(String value) {
        this.rfc = value;
    }

    /**
     * Obtiene el valor de la propiedad rfid.
     * 
     */
    public int getRfid() {
        return rfid;
    }

    /**
     * Define el valor de la propiedad rfid.
     * 
     */
    public void setRfid(int value) {
        this.rfid = value;
    }

    /**
     * Obtiene el valor de la propiedad agregado.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAgregado() {
        return agregado;
    }

    /**
     * Define el valor de la propiedad agregado.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAgregado(JAXBElement<Boolean> value) {
        this.agregado = value;
    }

    /**
     * Obtiene el valor de la propiedad modificado.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getModificado() {
        return modificado;
    }

    /**
     * Define el valor de la propiedad modificado.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setModificado(JAXBElement<Boolean> value) {
        this.modificado = value;
    }

    /**
     * Obtiene el valor de la propiedad eliminado.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getEliminado() {
        return eliminado;
    }

    /**
     * Define el valor de la propiedad eliminado.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setEliminado(JAXBElement<Boolean> value) {
        this.eliminado = value;
    }

    /**
     * Obtiene el valor de la propiedad huellas.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListaHuellas }{@code >}
     *     
     */
    public JAXBElement<ListaHuellas> getHuellas() {
        return huellas;
    }

    /**
     * Define el valor de la propiedad huellas.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListaHuellas }{@code >}
     *     
     */
    public void setHuellas(JAXBElement<ListaHuellas> value) {
        this.huellas = value;
    }

}

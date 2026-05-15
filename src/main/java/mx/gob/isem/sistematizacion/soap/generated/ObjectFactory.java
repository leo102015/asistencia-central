
package mx.gob.isem.sistematizacion.soap.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mx.gob.isem.sistematizacion.soap.generated package. 
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

    private final static QName _EmpleadoHuellas_QNAME = new QName("http://ws.biometrico.central.isem.gob.mx/", "huellas");
    private final static QName _EmpleadoModificado_QNAME = new QName("http://ws.biometrico.central.isem.gob.mx/", "modificado");
    private final static QName _EmpleadoAgregado_QNAME = new QName("http://ws.biometrico.central.isem.gob.mx/", "agregado");
    private final static QName _EmpleadoEliminado_QNAME = new QName("http://ws.biometrico.central.isem.gob.mx/", "eliminado");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.gob.isem.sistematizacion.soap.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SincronizarAsistenciasResponse }
     * 
     */
    public SincronizarAsistenciasResponse createSincronizarAsistenciasResponse() {
        return new SincronizarAsistenciasResponse();
    }

    /**
     * Create an instance of {@link SincronizarHuellaResponse }
     * 
     */
    public SincronizarHuellaResponse createSincronizarHuellaResponse() {
        return new SincronizarHuellaResponse();
    }

    /**
     * Create an instance of {@link SincronizarHuellaRequest }
     * 
     */
    public SincronizarHuellaRequest createSincronizarHuellaRequest() {
        return new SincronizarHuellaRequest();
    }

    /**
     * Create an instance of {@link Huella }
     * 
     */
    public Huella createHuella() {
        return new Huella();
    }

    /**
     * Create an instance of {@link ConsultarEmpleadosCambiosResponse }
     * 
     */
    public ConsultarEmpleadosCambiosResponse createConsultarEmpleadosCambiosResponse() {
        return new ConsultarEmpleadosCambiosResponse();
    }

    /**
     * Create an instance of {@link ListaEmpleados }
     * 
     */
    public ListaEmpleados createListaEmpleados() {
        return new ListaEmpleados();
    }

    /**
     * Create an instance of {@link SincronizarAsistenciasRequest }
     * 
     */
    public SincronizarAsistenciasRequest createSincronizarAsistenciasRequest() {
        return new SincronizarAsistenciasRequest();
    }

    /**
     * Create an instance of {@link ListaAsistencias }
     * 
     */
    public ListaAsistencias createListaAsistencias() {
        return new ListaAsistencias();
    }

    /**
     * Create an instance of {@link ConsultarEmpleadosCambiosRequest }
     * 
     */
    public ConsultarEmpleadosCambiosRequest createConsultarEmpleadosCambiosRequest() {
        return new ConsultarEmpleadosCambiosRequest();
    }

    /**
     * Create an instance of {@link ListaHuellas }
     * 
     */
    public ListaHuellas createListaHuellas() {
        return new ListaHuellas();
    }

    /**
     * Create an instance of {@link Empleado }
     * 
     */
    public Empleado createEmpleado() {
        return new Empleado();
    }

    /**
     * Create an instance of {@link Asistencia }
     * 
     */
    public Asistencia createAsistencia() {
        return new Asistencia();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaHuellas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.biometrico.central.isem.gob.mx/", name = "huellas", scope = Empleado.class)
    public JAXBElement<ListaHuellas> createEmpleadoHuellas(ListaHuellas value) {
        return new JAXBElement<ListaHuellas>(_EmpleadoHuellas_QNAME, ListaHuellas.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.biometrico.central.isem.gob.mx/", name = "modificado", scope = Empleado.class)
    public JAXBElement<Boolean> createEmpleadoModificado(Boolean value) {
        return new JAXBElement<Boolean>(_EmpleadoModificado_QNAME, Boolean.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.biometrico.central.isem.gob.mx/", name = "agregado", scope = Empleado.class)
    public JAXBElement<Boolean> createEmpleadoAgregado(Boolean value) {
        return new JAXBElement<Boolean>(_EmpleadoAgregado_QNAME, Boolean.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.biometrico.central.isem.gob.mx/", name = "eliminado", scope = Empleado.class)
    public JAXBElement<Boolean> createEmpleadoEliminado(Boolean value) {
        return new JAXBElement<Boolean>(_EmpleadoEliminado_QNAME, Boolean.class, Empleado.class, value);
    }

}

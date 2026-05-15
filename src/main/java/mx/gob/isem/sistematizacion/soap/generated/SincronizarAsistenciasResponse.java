
package mx.gob.isem.sistematizacion.soap.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exito" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "exito"
})
@XmlRootElement(name = "SincronizarAsistenciasResponse")
public class SincronizarAsistenciasResponse {

    protected boolean exito;

    /**
     * Obtiene el valor de la propiedad exito.
     * 
     */
    public boolean isExito() {
        return exito;
    }

    /**
     * Define el valor de la propiedad exito.
     * 
     */
    public void setExito(boolean value) {
        this.exito = value;
    }

}

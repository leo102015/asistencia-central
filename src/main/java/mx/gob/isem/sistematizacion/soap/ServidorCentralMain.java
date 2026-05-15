package mx.gob.isem.sistematizacion.soap;

import mx.gob.isem.sistematizacion.soap.ws.BiometricosWSImpl;
import jakarta.xml.ws.Endpoint;

public class ServidorCentralMain {

    public static void main(String[] args) {
    	// La URL donde escuchará nuestro servicio SOAP
        String url = "http://localhost:8080/ws/biometricos";
        
        try {
            // El Endpoint levanta el servidor HTTP y enlaza tu clase de implementación
            Endpoint.publish(url, new BiometricosWSImpl());
            
            System.out.println("¡Servidor en línea y escuchando!");
            System.out.println("El contrato WSDL está disponible en: " + url + "?wsdl");
            System.out.println("Presiona Ctrl+C en la consola para apagar el servidor.");
        } catch (Exception e) {
            System.err.println("Error al intentar levantar el servidor SOAP: " + e.getMessage());
        }
    }
}
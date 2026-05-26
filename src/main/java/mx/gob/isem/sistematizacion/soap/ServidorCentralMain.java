package mx.gob.isem.sistematizacion.soap;

import mx.gob.isem.sistematizacion.soap.ws.BiometricosWSImpl;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;

import jakarta.xml.ws.Endpoint;

public class ServidorCentralMain {

    public static void main(String[] args) {    	
        try {
        	// Configuración del Keystore 
            String rutaKeystore = "central_keystore.p12";
            char[] passwordKeystore = "Is3mSist3mat1z4..".toCharArray();

            KeyStore ks = KeyStore.getInstance("PKCS12");
            try (FileInputStream fis = new FileInputStream(rutaKeystore)) {
                ks.load(fis, passwordKeystore);
            }

            // Inicializar los administradores de llaves y confianza
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, passwordKeystore);

            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ks);

            // Crear el Contexto SSL
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

            // Crear el Servidor HTTPS
            HttpsServer httpsServer = HttpsServer.create(new InetSocketAddress(8443), 0);
            httpsServer.setHttpsConfigurator(new HttpsConfigurator(sslContext));

            // Crear el contexto HTTP y vincular el Servicio Web
            HttpContext context = httpsServer.createContext("/ws/biometricos");
            Endpoint endpoint = Endpoint.create(new BiometricosWSImpl());
            endpoint.publish(context);

            // Arrancamos el servidor
            httpsServer.start();
            
            System.out.println("¡Servidor Central SEGURO en línea y escuchando!");
            System.out.println("El contrato WSDL está disponible en: https://localhost:8443/ws/biometricos?wsdl");
        } catch (Exception e) {
            System.err.println("Error al intentar levantar el servidor SOAP: " + e.getMessage());
        }
    }
}
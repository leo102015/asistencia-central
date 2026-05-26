package mx.gob.isem.sistematizacion.soap.ws;

import java.util.List;
import java.util.Map;

import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.handler.MessageContext;
import mx.gob.isem.sistematizacion.soap.dao.AutenticacionCentralDAO;
import mx.gob.isem.sistematizacion.soap.generated.BiometricosPortType;
import mx.gob.isem.sistematizacion.soap.generated.ConsultarEmpleadosCambiosRequest;
import mx.gob.isem.sistematizacion.soap.generated.ConsultarEmpleadosCambiosResponse;
import mx.gob.isem.sistematizacion.soap.generated.ProbarConexionRequest;
import mx.gob.isem.sistematizacion.soap.generated.ProbarConexionResponse;
import mx.gob.isem.sistematizacion.soap.generated.SincronizarAsistenciasRequest;
import mx.gob.isem.sistematizacion.soap.generated.SincronizarAsistenciasResponse;
import mx.gob.isem.sistematizacion.soap.generated.SincronizarHuellaRequest;
import mx.gob.isem.sistematizacion.soap.generated.SincronizarHuellaResponse;
import mx.gob.isem.sistematizacion.soap.service.*;

@WebService(
	    serviceName = "BiometricosService",
	    portName = "BiometricosPort",
	    endpointInterface = "mx.gob.isem.sistematizacion.soap.generated.BiometricosPortType",
	    targetNamespace = "http://ws.biometrico.central.isem.gob.mx/"
	)
public class BiometricosWSImpl implements BiometricosPortType{
	
	@Resource
	WebServiceContext wsctx;
	
	private EmpleadoService empleadoService = new EmpleadoService();
    private HuellaService huellaService = new HuellaService();
    private AsistenciaService asistenciaService = new AsistenciaService();
    private AutenticacionCentralDAO autenticacionDao = new AutenticacionCentralDAO();
    
    private void autenticarPeticion() {
        MessageContext mctx = wsctx.getMessageContext();        
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);        
        List userList = (List) http_headers.get("Usuario");
        List passList = (List) http_headers.get("Password");
        String usuario = "";
        String password = "";
        if (userList != null && !userList.isEmpty()) {
        	usuario = userList.get(0).toString();
        }        
        if (passList != null && !passList.isEmpty()) {
            password = passList.get(0).toString();
        }
        // Validación contra la Base de Datos
        if (!autenticacionDao.validarCredenciales(usuario, password)) {
            // Detiene la ejecución y devuelve un SOAP Fault al cliente
            throw new RuntimeException("Acceso Denegado: Usuario o contraseña incorrectos.");
        }
    }

	@Override
	public ConsultarEmpleadosCambiosResponse consultarEmpleadosCambios(ConsultarEmpleadosCambiosRequest parameters) {
			autenticarPeticion();
			ConsultarEmpleadosCambiosResponse response = new ConsultarEmpleadosCambiosResponse();
			response.setEmpleados(empleadoService.obtenerCambios(parameters.getCentro(), parameters.getEmpleados()));
			return response;
	}

	@Override
	public SincronizarHuellaResponse sincronizarHuella(SincronizarHuellaRequest parameters) {
			autenticarPeticion();
			SincronizarHuellaResponse response = new SincronizarHuellaResponse();
			response.setProcesada(huellaService.procesarHuella(parameters.getHuella()));		
			return response;
	}

	@Override
	public SincronizarAsistenciasResponse sincronizarAsistencias(SincronizarAsistenciasRequest parameters) {		
			autenticarPeticion();
			SincronizarAsistenciasResponse response = new SincronizarAsistenciasResponse();
			response.setExito(asistenciaService.insertarAsistencias(parameters.getAsistencias(), parameters.getCantidad()));	
			return response;
	}

	@Override
	public ProbarConexionResponse probarConexion(ProbarConexionRequest parameters) {
		autenticarPeticion();
		ProbarConexionResponse response = new ProbarConexionResponse();
		response.setExito(true);
		return response;
	}
	
}

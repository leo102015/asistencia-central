package mx.gob.isem.sistematizacion.soap.ws;

import jakarta.jws.WebService;
import mx.gob.isem.sistematizacion.soap.generated.BiometricosPortType;
import mx.gob.isem.sistematizacion.soap.generated.ConsultarEmpleadosCambiosRequest;
import mx.gob.isem.sistematizacion.soap.generated.ConsultarEmpleadosCambiosResponse;
import mx.gob.isem.sistematizacion.soap.generated.ListaEmpleados;
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
	
	private EmpleadoService empleadoService = new EmpleadoService();
    private HuellaService huellaService = new HuellaService();
    private AsistenciaService asistenciaService = new AsistenciaService();

	@Override
	public ConsultarEmpleadosCambiosResponse consultarEmpleadosCambios(ConsultarEmpleadosCambiosRequest parameters) {
		ConsultarEmpleadosCambiosResponse response = new ConsultarEmpleadosCambiosResponse();
		response.setEmpleados(empleadoService.obtenerCambios(parameters.getCentro(), parameters.getEmpleados()));
		return response;
	}

	@Override
	public SincronizarHuellaResponse sincronizarHuella(SincronizarHuellaRequest parameters) {
		SincronizarHuellaResponse response = new SincronizarHuellaResponse();
		response.setProcesada(huellaService.procesarHuella(parameters.getHuella()));		
		return response;
	}

	@Override
	public SincronizarAsistenciasResponse sincronizarAsistencias(SincronizarAsistenciasRequest parameters) {
		SincronizarAsistenciasResponse response = new SincronizarAsistenciasResponse();
		response.setExito(asistenciaService.insertarAsistencias(parameters.getAsistencias(), parameters.getCantidad()));	
		return response;
	}
	
}

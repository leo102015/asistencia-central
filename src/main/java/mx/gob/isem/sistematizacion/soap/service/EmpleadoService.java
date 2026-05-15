package mx.gob.isem.sistematizacion.soap.service;

import java.util.HashMap;
import java.util.Map;

import mx.gob.isem.sistematizacion.soap.dao.EmpleadoCentralDAO;
import mx.gob.isem.sistematizacion.soap.dao.HuellaCentralDAO;
import mx.gob.isem.sistematizacion.soap.generated.Empleado;
import mx.gob.isem.sistematizacion.soap.generated.ListaEmpleados;
import mx.gob.isem.sistematizacion.soap.generated.ListaHuellas;
import mx.gob.isem.sistematizacion.soap.generated.ObjectFactory;

public class EmpleadoService {
	
	EmpleadoCentralDAO empleadoDao = new EmpleadoCentralDAO();
	HuellaCentralDAO huellaDao = new HuellaCentralDAO();
	
	public ListaEmpleados obtenerCambios (String centro, ListaEmpleados empleados) {
		ObjectFactory factory = new ObjectFactory();
		// Lista que se va a regresar
		ListaEmpleados listaResultado = new ListaEmpleados();		
		ListaEmpleados empleadosCentral = empleadoDao.consultarEmpleados(centro);
		// Utilizamos Mapas para agilizar la comparativa
		Map<String, Empleado> mapaCentral = convertirAMapa(empleadosCentral);
		Map<String, Empleado> mapaLocal = convertirAMapa(empleados);
		// Primero revisamos las bajas y las modificaciones
		for (Empleado local : mapaLocal.values()) {
			Empleado central = mapaCentral.get(local.getId());			
			if (central == null) {
				// En la base central ese empleado ya no está en ese centro
				local.setEliminado(factory.createEmpleadoEliminado(true));
				listaResultado.getEmpleado().add(local);
			} else {
				// El empleado existe, verificamos si sus datos cambiaron
				if (huboCambios(local, central)) {
					central.setModificado(factory.createEmpleadoModificado(true));
					listaResultado.getEmpleado().add(central);
				}
			}
		}
		// Revisamos los que tiene la Central pero no el centro (Altas)
		for (Empleado central : mapaCentral.values()) {
			if (!mapaLocal.containsKey(central.getId())) {
				central.setAgregado(factory.createEmpleadoAgregado(true));

				// Consultamos las huellas de este nuevo empleado en la base central
				ListaHuellas huellasEmpleado = huellaDao.consultarHuellasEmpleado(central.getId());				
				if (huellasEmpleado != null && !huellasEmpleado.getHuella().isEmpty()) {
					central.setHuellas(factory.createEmpleadoHuellas(huellasEmpleado));
				}				
				listaResultado.getEmpleado().add(central);
			}
		}		
		return listaResultado;		
	}
	
	private Map<String, Empleado> convertirAMapa(ListaEmpleados lista) {
		Map<String, Empleado> mapa = new HashMap<>();
		if (lista != null && lista.getEmpleado() != null) {
			for (Empleado empleado : lista.getEmpleado()) {
				mapa.put(empleado.getId(), empleado);
			}
		}
		return mapa;
	}
	
	private boolean huboCambios(Empleado local, Empleado central) {
		// Comparamos los campos clave. Si uno solo es diferente, regresa true.
		return noSonIguales(local.getNombre(), central.getNombre()) ||
			   noSonIguales(local.getPrimerApellido(), central.getPrimerApellido()) ||
			   noSonIguales(local.getSegundoApellido(), central.getSegundoApellido()) ||
			   noSonIguales(local.getRfc(), central.getRfc()) ||
			   local.getRfid() != central.getRfid();
	}
	
	private boolean noSonIguales(String a, String b) {
		// Manejo seguro de nulos para evitar excepciones al comparar textos
		if (a == null && b == null) return false;
		if (a == null || b == null) return true;
		return !a.equals(b);
	}
	
}

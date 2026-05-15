package mx.gob.isem.sistematizacion.soap.service;

import mx.gob.isem.sistematizacion.soap.dao.AsistenciaCentralDAO;
import mx.gob.isem.sistematizacion.soap.generated.ListaAsistencias;

public class AsistenciaService {
	
	private AsistenciaCentralDAO asistenciaDao = new AsistenciaCentralDAO();

	public boolean insertarAsistencias(ListaAsistencias asistencias, int longitud) {
		// Validamos si la lista llegó completa, de lo contrario no hacemos nada
		if (asistencias.getAsistencia().size() == longitud) {			
			return asistenciaDao.guardarAsistencias(asistencias);
		} else return false;		
	}
}

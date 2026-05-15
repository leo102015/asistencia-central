package mx.gob.isem.sistematizacion.soap.service;

import mx.gob.isem.sistematizacion.soap.dao.HuellaCentralDAO;
import mx.gob.isem.sistematizacion.soap.generated.Huella;

public class HuellaService {
	
	private HuellaCentralDAO huellaDao = new HuellaCentralDAO();

	public boolean procesarHuella(Huella huella) {
		// Hacemos consulta para hacer un upsert
		if (huellaDao.consultarHuella(huella)) {
			// Si existe la editamos
			return huellaDao.editarHuella(huella);
		} else {
			// Si no existe la insertamos
			return huellaDao.insertarHuella(huella);
		}		
	}
}

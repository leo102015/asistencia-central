package mx.gob.isem.sistematizacion.soap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import mx.gob.isem.sistematizacion.soap.generated.Asistencia;
import mx.gob.isem.sistematizacion.soap.generated.ListaAsistencias;

public class AsistenciaCentralDAO {

	public boolean guardarAsistencias(ListaAsistencias asistencias) {
		String sql = "INSERT INTO ASISTENCIA.Asistencias (IdEmpleado, Tiempo) VALUES (?, ?)";
		Connection con = null;
		try {
			con = ConexionBD.obtenerConexion();
			// Desactivamos el commit para revertir la operación en caso de un error
			con.setAutoCommit(false);
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				for (Asistencia asistencia : asistencias.getAsistencia()) {
					ps.setString(1, asistencia.getIdEmpleado());
					long milisegundos = asistencia.getTiempo().toGregorianCalendar().getTimeInMillis();
					ps.setTimestamp(2, new Timestamp(milisegundos));
					ps.addBatch();					
				}
				ps.executeBatch();
			}
			con.commit();
			return true;
		} catch (Exception e) {
	        System.err.println("Fallo al insertar el lote. Iniciando Rollback... Error: " + e.getMessage());
	        if (con != null) {
	            try { con.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
	        }
	        return false;
	    } finally {
	        // Devolvemos la conexión a su estado original para que otros procesos la usen
	        if (con != null) {
	            try { con.setAutoCommit(true); } catch (SQLException ex) { ex.printStackTrace(); }
	        }
	    }
	}
	
}
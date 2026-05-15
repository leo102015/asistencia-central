package mx.gob.isem.sistematizacion.soap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mx.gob.isem.sistematizacion.soap.generated.Huella;
import mx.gob.isem.sistematizacion.soap.generated.ListaHuellas;

public class HuellaCentralDAO {
	
	public boolean insertarHuella(Huella huella) {
		String sql = """
			INSERT INTO ASISTENCIA.Huellas (
				IdEmpleado,
				Indice,
				Template
			) VALUES (?, ?, ?)
			""";
		try (Connection con = ConexionBD.obtenerConexion();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, huella.getIdEmpleado());
			ps.setInt(2, huella.getIndice());
			ps.setBytes(3, huella.getTemplate());
			return ps.executeUpdate() > 0;
		}catch (Exception e) {
			System.err.println("Error al insertar la huella del empleado en la BD: "+e.getMessage());
		}
		return false;
	}
	
	public ListaHuellas consultarHuellasEmpleado(String idEmpleado) {
		ListaHuellas listaHuellas = new ListaHuellas();
		String sql = """
			SELECT Indice, Template
			  FROM ASISTENCIA.Huellas
			 WHERE IdEmpleado = ?
			""";
		try (Connection con = ConexionBD.obtenerConexion();
			 PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, idEmpleado);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Huella huella = new Huella();
					huella.setIdEmpleado(idEmpleado);
					huella.setIndice(rs.getInt("Indice"));
					huella.setTemplate(rs.getBytes("Template"));
					listaHuellas.getHuella().add(huella);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al consultar las huellas del empleado en la BD: "+e.getMessage());
		}
		return listaHuellas;
	}
	
	// Aquí la consulta la tendríamos que hacer a la base de datos central
	public boolean consultarHuella(Huella huella) {
		String sql = """
			SELECT 1
			  FROM ASISTENCIA.Huellas
			 WHERE IdEmpleado = ?
			   AND Indice = ?
			""";
		try (Connection con = ConexionBD.obtenerConexion();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, huella.getIdEmpleado());
			ps.setInt(2, huella.getIndice());
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (Exception e) {
			System.err.println("Error al consultar la huella del empleado en la BD: "+e.getMessage());
		}
		return false;
	}
	
	public boolean editarHuella(Huella huella) {		
		String sql = """
			UPDATE ASISTENCIA.Huellas
			   SET Template = ?
			 WHERE IdEmpleado = ?
			   AND Indice = ?
			""";
		try (Connection con = ConexionBD.obtenerConexion();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setBytes(1, huella.getTemplate());
			ps.setString(2, huella.getIdEmpleado());
			ps.setInt(3, huella.getIndice());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println("Error al modificar la huella del empleado en la BD: "+e.getMessage());
		}
		return false;
	}
}

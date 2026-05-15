package mx.gob.isem.sistematizacion.soap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mx.gob.isem.sistematizacion.soap.generated.Empleado;
import mx.gob.isem.sistematizacion.soap.generated.ListaEmpleados;

public class EmpleadoCentralDAO {
	
	// Aquí consultamos de la base central
	public ListaEmpleados consultarEmpleados(String centro) {
		ListaEmpleados empleados = new ListaEmpleados();
		String sql = """
			SELECT Id, Nombre, PrimerApellido, SegundoApellido, RFC, RFID
			  FROM ASISTENCIA.Empleados
			 WHERE Centro = ?
			""";
		try (Connection con = ConexionBD.obtenerConexion();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, centro);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Empleado empleado = new Empleado();
					empleado.setId(rs.getString("Id"));
					empleado.setNombre(rs.getString("Nombre"));
					empleado.setPrimerApellido(rs.getString("PrimerApellido"));
					empleado.setSegundoApellido(rs.getString("SegundoApellido"));
					empleado.setRfc(rs.getString("RFC"));
					empleado.setRfid(rs.getInt("RFID"));
					empleados.getEmpleado().add(empleado);
				}
				return empleados;
			}
		} catch (Exception e) {
			System.err.println("Error al consultar los empleados centrales en la BD: "+e.getMessage());
		}
		return empleados;
	}
	
	
}

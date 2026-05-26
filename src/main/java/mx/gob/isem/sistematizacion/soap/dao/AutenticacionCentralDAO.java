package mx.gob.isem.sistematizacion.soap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AutenticacionCentralDAO {

	public boolean validarCredenciales(String centro, String password) {
        String sql = """
    		SELECT 1 FROM ASISTENCIA.Autenticaciones
    		 WHERE Centro = ? AND Password = ?
    		""";        
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {            
            ps.setString(1, centro);
            ps.setString(2, password);            
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            System.err.println("Error en la BD al validar credenciales: " + e.getMessage());
            return false;
        }
    }
}

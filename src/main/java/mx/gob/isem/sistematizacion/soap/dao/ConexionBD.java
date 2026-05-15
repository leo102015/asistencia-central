package mx.gob.isem.sistematizacion.soap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Credenciales y cadena de conexión a SQL Server
    private static final String URL = "jdbc:sqlserver://10.40.128.02:1433;databaseName=DesaSistemasWeb;encrypt=true;trustServerCertificate=true";
    private static final String USUARIO = "Usr_Pablo"; 
    private static final String PASSWORD = "Is3m2026+";

    private static Connection conexion = null;

    private ConexionBD() {
    }

    public static Connection obtenerConexion() throws SQLException {
        try {
            if (conexion == null || conexion.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error crítico: No se encontró el driver de SQL Server.");
            e.printStackTrace();
        }
        return conexion;
    }

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión a SQL Server cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("Error al intentar cerrar la base de datos: " + e.getMessage());
            }
        }
    }
}

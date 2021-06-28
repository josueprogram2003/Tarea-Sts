package Alumno.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	private static final String url = "jdbc:mysql://localhost:3306/tarea?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String usuario = "root";
	private static final String password = "";
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static Connection cx = null;
	
	
	public static Connection getConexion() {
		try {
			Class.forName(Driver);
			if (cx==null) {
				cx = DriverManager.getConnection(url, usuario, password);
				System.out.println("Conexion Exitosa");
			}
			
		} catch (Exception ex) {
			System.out.println("Error de coneccion: "+ex);
		}
		return cx;
	}
}

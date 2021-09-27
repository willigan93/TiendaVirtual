package com.DAO.TiendaVirtual;

import java.sql.*;
public class Conexion {
	
	//Declarar variables que nos permitan tener especificaciones de la base de datos
	String BD = "DB_tiendaTecnologia";
	String Usuario = "root";
	String Clave = "PinkFloyd13!";
	String url = "jdbc:mysql://localhost/"+BD;
	
	//Crear variable para la conexion	
	Connection con = null;
	
	// Generar constructor de conexión
	public Conexion()
	{
		try {
			//obtenemos el driver de para mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//obtenemos la conexión
			con = DriverManager.getConnection(url,Usuario,Clave);
			
			if (con != null) {
				System.out.println("Conexión a base de datos "+BD+" OK\n");
			}
		}
		catch(SQLException e) {
			System.out.println("Error de coenxión: " + e);
		} 
		catch(ClassNotFoundException e) {
			System.out.println("Error Clase no encontrada: " + e);
		} 
		catch(Exception e) {
			System.out.println("Error conexión: " + e);
		}
	}
	
	/** Permite retornar la conexión **/
	public Connection getConnection() {
		return con;
	}
	
	public void desconectar() {
		con = null;
	}
	
}

package com.DAO.TiendaVirtual;

// Esta clase permite el acceso a la base de datos y realizar CRUD

import java.sql.*;
import java.util.ArrayList;

import com.DTO.TiendaVirtual.UsuarioVO;
public class UsuariosDAO {

	// Crear un primer método para consultar lista usuarios
	
	public ArrayList<UsuarioVO> listaUsuarios()
	{
		ArrayList<UsuarioVO> miLista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		
		try
		{
			PreparedStatement consulta = con.getConnection().prepareStatement("SELECT * from T_Usuarios");
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("cedula_usuario")));
				persona.setNombre(rs.getString("nombre_usuario"));
				persona.setCorreo(rs.getString("correo_usuario"));
				persona.setUsuario(rs.getString("usuario"));
				persona.setClave(rs.getString("password"));
				
				miLista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error de conexión: " + e);
		}
		return miLista;
	}
	
	public ArrayList<UsuarioVO> ConsultarUsuario(int documento)
	{
		ArrayList<UsuarioVO> miLista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		
		try
		{
			
			PreparedStatement consulta = con.getConnection().prepareStatement("SELECT * from T_Usuarios WHERE cedula_usuario = ?");
			consulta.setInt(1, documento);
			ResultSet rs = consulta.executeQuery();
			
			if(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("cedula_usuario")));
				persona.setNombre(rs.getString("nombre_usuario"));
				persona.setCorreo(rs.getString("correo_usuario"));
				persona.setUsuario(rs.getString("usuario"));
				persona.setClave(rs.getString("password"));
				
				miLista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}
		catch(Exception e) 
		{
			System.out.println("Error de Conexión: " + e);
		}
		return miLista;
	}
	
	public void registrarUsuario(UsuarioVO persona)
	{
		Conexion con = new Conexion();
		
		try
		{
			Statement stmt = con.getConnection().createStatement();
			stmt.executeUpdate("INSERT INTO T_Usuarios Values ('"+persona.getCedula()+"','"+ persona.getNombre()+"','"
					+persona.getCorreo()+"','"+persona.getUsuario()+"','"+persona.getClave()+"')");
			System.out.println("El usuario se registro exitosamente");
			stmt.close();
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error Conexión: " + e);
		}
	}
	
	public void eliminarUsuario(int documento)
	{
		Conexion con = new Conexion();
		Statement stmt = null;
		
		try
		{
			stmt = con.getConnection().createStatement();
			stmt.executeUpdate("DELETE FROM T_Usuarios WHERE cedula_usuario ='"+documento+"'");
			System.out.println("Usuario Eliminado");

		}
		catch(Exception e) 
		{
			System.out.println("Error de Conexión: " + e);
		}
	}
	
	public void actualizarUsuario(int documento, String nombrea, String correoa)
	{
		Conexion con = new Conexion();
		
		try
		{
			PreparedStatement sql = con.getConnection().prepareStatement("UPDATE T_Usuarios SET nombre_usuario=?, correo_usuario=? WHERE cedula_usuario=?");
			sql.setString(1, nombrea);;
			sql.setString(2, correoa);;
			sql.setInt(3, documento);;
			sql.executeUpdate();
			System.out.println("Se actualizó la infomación del usuario.");
			
		}
		catch(Exception e) 
		{
			System.out.println("Error de Conexión: " + e);
		}
	}
	
}

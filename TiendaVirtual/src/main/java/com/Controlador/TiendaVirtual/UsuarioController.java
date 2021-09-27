package com.Controlador.TiendaVirtual;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TiendaVirtual.UsuariosDAO;
import com.DTO.TiendaVirtual.UsuarioVO;

@RestController
public class UsuarioController {

	@RequestMapping("/ListaUsuarios")
	public ArrayList<UsuarioVO> listaUsuarios()
	{
		UsuariosDAO Dao = new UsuariosDAO();
		return Dao.listaUsuarios();
	}
	
	@RequestMapping("/ConsultarUsuario")
	public ArrayList<UsuarioVO> consultarUsuario(int documento)
	{
		UsuariosDAO Dao = new UsuariosDAO();
		return Dao.ConsultarUsuario(documento);
	}
	
	@RequestMapping("/RegistrarUsuario")
	public void registrarUsuario(UsuarioVO persona)
	{
		UsuariosDAO Dao = new UsuariosDAO();
		Dao.registrarUsuario(persona);
	}
	
	
	@RequestMapping("/EliminarUsuario")
	public void eliminarUsuario(int documento)
	{
		UsuariosDAO Dao = new UsuariosDAO();
		Dao.eliminarUsuario(documento);
	}
	
	@RequestMapping("/ActualizarUsuario")
	public void actualizarUsuario(int documento, String nombrea, String correoa)
	{
		UsuariosDAO Dao = new UsuariosDAO();
		Dao.actualizarUsuario(documento, nombrea, correoa);
	}
	
}

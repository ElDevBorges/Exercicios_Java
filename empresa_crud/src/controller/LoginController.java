package controller;

import model.entity.Usuario;

import model.dao.UsuarioDAO;

public class LoginController {
	private UsuarioDAO usuarioDAO;
	
	public LoginController () {
		usuarioDAO = new UsuarioDAO();
	}
	
	public boolean autenticarLogin (String usuario, String senha) {
		Usuario u = new Usuario(0, usuario, senha, 1);
		return usuarioDAO.autenticar(u);
		
		
	}
}

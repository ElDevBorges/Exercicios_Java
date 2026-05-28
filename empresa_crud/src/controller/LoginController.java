package controller;

import model.dao.UsuarioDAO;
import model.entity.Usuario;

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

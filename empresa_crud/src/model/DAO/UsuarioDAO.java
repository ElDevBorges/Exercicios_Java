package model.dao;

import model.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConexaoBD;

public class UsuarioDAO {
	
	public boolean autenticar (Usuario usuario) {
		String sql = "SELECT * FROM usuario WHERE usuario =? AND senha =?";
		
		try (
				Connection conn = ConexaoBD.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				) {
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			
			ResultSet rs = stmt.executeQuery();
			return rs.next();
			
		} catch (SQLException e) {
			System.out.println("Erro no login: " + e.getMessage());
			return false;
		}
	}

}

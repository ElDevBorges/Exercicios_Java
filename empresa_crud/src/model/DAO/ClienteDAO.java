package model.DAO;

import com.mysql.cj.protocol.Resultset;
import connection.ConexaoBD;
import model.Cliente;

import java.sql.*;


public class ClienteDAO {
    private final ConexaoBD conexaoBD = new ConexaoBD();



    public void inserir (Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, email) VALUES (?,?)";
        try (

                Connection conn = conexaoBD.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ) {
                    stmt.setString(1, cliente.getNome());
                    stmt.setString (2, cliente.getEmail());
                    stmt.execute();

                    System.out.println("Cliente inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir " + e.getMessage());
        }

    }

    public void listar () {
        String sql = "SELECT * FROM cliente";
        try (
                Connection conn = conexaoBD.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = stmt.executeQuery();
            ){
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        String email = rs.getString("email");
                        System.out.println("Id: " + id + "\nNome: " + nome + "\nEmail: " + email);
                    }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar" + e.getMessage());
        }

    }
}

package model.dao;

import com.mysql.cj.protocol.Resultset;
import connection.ConexaoBD;
import model.entity.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {



    public void inserir (Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, email) VALUES (?,?)";
        try (

                Connection conn = ConexaoBD.getConnection();
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

    public List<Cliente> listar () {
        String sql = "SELECT * FROM cliente";
        List <Cliente> lista = new ArrayList<>();
        try (
                Connection conn = ConexaoBD.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = stmt.executeQuery();
            ){
                    while (rs.next()) {
                    	Cliente cliente = new Cliente ();
                    	
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        String email = rs.getString("email");
           
                        
                        cliente.setId (id);
                        cliente.setNome(nome);
                        cliente.setEmail(email);
                        
                        lista.add(cliente);
                        
                        
                    }
                    return lista;
                    
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
            return lista;
        }

    }

    public void delete (int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (
                Connection conn = ConexaoBD.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);

        ) {
            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();

            if (linhas > 0 ) {
                System.out.println("Cliente excluído com sucesso");
            } else System.out.println("Cliente não foi encontrado");


        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel deletar!");
        }

    }

    public void update (Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ? WHERE id = ?";
        try (
                Connection conn = ConexaoBD.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getId());
            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Cliente atualizado com sucesso");
            } else System.out.println("Cliente não encontrado");

        } catch (SQLException e) {
            throw new RuntimeException ("Erro ao atualizar" + e.getMessage());
        }
    }
}

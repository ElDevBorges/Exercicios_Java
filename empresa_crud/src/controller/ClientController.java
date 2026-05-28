package controller;

import java.util.List;

import model.dao.ClienteDAO;
import model.entity.Cliente;

public class ClientController {
    private ClienteDAO clienteDAO;


    public ClientController () {
        clienteDAO = new ClienteDAO();
    }

    public void inserirCliente (String nome, String email) {
        Cliente cliente = new Cliente(nome, email);
        clienteDAO.inserir(cliente);
    }

    public List<Cliente> listarCliente () {
        return clienteDAO.listar();
    }

    public void atualizarCliente (String nome, String email, int id) {
        Cliente cliente = new Cliente(nome, email, id);
        clienteDAO.update(cliente);
    }

    public void deletarCliente (int id) {
        clienteDAO.delete(id);
    }
}

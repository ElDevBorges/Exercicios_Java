package controller;

import model.entity.Cliente;
import model.dao.ClienteDAO;

public class ClientController {
    private ClienteDAO clienteDAO;


    public ClientController () {
        clienteDAO = new ClienteDAO();
    }

    public void inserirCliente (String nome, String email) {
        Cliente cliente = new Cliente(nome, email);
        clienteDAO.inserir(cliente);
    }

    public void listarCliente () {
        clienteDAO.listar();
    }

    public void atualizarCliente (String nome, String email, int id) {
        Cliente cliente = new Cliente(nome, email, id);
        clienteDAO.update(cliente);
    }

    public void deletarCliente (int id) {
        clienteDAO.delete(id);
    }
}

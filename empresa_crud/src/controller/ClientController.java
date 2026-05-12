package controller;

import model.Cliente;
import model.DAO.ClienteDAO;

public class ClientController {
    private ClienteDAO clienteDAO;


    public ClientController () {
        clienteDAO = new ClienteDAO();
    }

    public void inserirCliente (String nome, String email) {
        Cliente cliente = new Cliente(nome, email);
        clienteDAO.inserir(cliente);
    }
}

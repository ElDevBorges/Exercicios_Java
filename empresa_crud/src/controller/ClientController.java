package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.dao.ClienteDAO;
import model.entity.Cliente;
import view.TelaCliente;

public class ClientController {
    private ClienteDAO clienteDAO;
    private TelaCliente telaCliente;
    

    public ClientController() {
		super();
		this.telaCliente = telaCliente;
	}


    public void inserirCliente () {
        Cliente cliente = new Cliente();
        cliente.setNome(telaCliente.getTextFieldNome().getText());
        cliente.setEmail(telaCliente.getTextField_Email().getText());
        
        clienteDAO.inserir(cliente);
        JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
    }

    public ClientController(TelaCliente telaCliente) {
		super();
		this.telaCliente = telaCliente;
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

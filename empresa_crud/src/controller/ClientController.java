package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.dao.ClienteDAO;
import model.entity.Cliente;
import view.TelaCliente;

public class ClientController {
    private ClienteDAO clienteDAO;
    private TelaCliente telaCliente;
    
    public ClientController (TelaCliente telaCliente, ClienteDAO clienteDAO) {
    	this.telaCliente = telaCliente;
    	this.clienteDAO = clienteDAO;
    }
    
    public ClientController() {
    	
    }
    

    public void inserirCliente (String nome, String email) {
        Cliente cliente = new Cliente();
        telaCliente = new TelaCliente();

      
        clienteDAO = new ClienteDAO();
        cliente.setNome(nome);
        cliente.setEmail(email);
        
        clienteDAO.inserir(cliente);
        JOptionPane.showMessageDialog(telaCliente, "Cliente inserido com sucesso!");
    }




	public List<Cliente> listarCliente () {
		clienteDAO = new ClienteDAO();
        return clienteDAO.listar();
    }
	
	public void limparCampo () {
		telaCliente.getTextField_Id().setText("");
		telaCliente.getTextFieldNome().setText("");
		telaCliente.getTextFieldEmail().setText("");
		System.out.print("rodou limpar campo");
	}

    public void atualizarCliente (String nome, String email, int id) {
        Cliente cliente = new Cliente(nome, email, id);
        clienteDAO.update(cliente);
    }

    public void deletarCliente (int id) {
        clienteDAO.delete(id);
    }
}

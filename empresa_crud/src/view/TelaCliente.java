package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import controller.ClientController;
import model.entity.Cliente;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class TelaCliente extends JFrame {

	JFrame frame;
	private JTextField textField_Id;
	private JTextField textFieldEmail;
	private JTextField textFieldNome;
	private JTable tableClientes;
	private ClientController clientController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente window = new TelaCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
		frame = new JFrame();
			frame.setTitle("Gerenciador de Clientes");
			frame.setPreferredSize(new Dimension(850, 600));
			frame.setBounds(100, 100, 850, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
			frame.getContentPane().setBackground(new Color(240, 240, 245));
		
			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
			mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
			mainPanel.setBackground(new Color(240, 240, 245));
			frame.getContentPane().add(mainPanel);
		
			JLabel titleLabel = new JLabel("Gerenciamento de Clientes");
			titleLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
			titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			titleLabel.setForeground(new Color(0, 51, 102));
			mainPanel.add(titleLabel);
		
			mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
		
			JPanel dados_Cliente = new JPanel();
			dados_Cliente.setMaximumSize(new Dimension(820, 180));
			dados_Cliente.setPreferredSize(new Dimension(820, 180));
			dados_Cliente.setBorder(new CompoundBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), 
					"Dados do Cliente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 51, 102)), 
				new EmptyBorder(12, 12, 12, 12)));
			dados_Cliente.setLayout(new BoxLayout(dados_Cliente, BoxLayout.Y_AXIS));
			dados_Cliente.setBackground(Color.WHITE);
			mainPanel.add(dados_Cliente);
		
			JPanel panel_formCliente = new JPanel();
			panel_formCliente.setLayout(new BoxLayout(panel_formCliente, BoxLayout.Y_AXIS));
			panel_formCliente.setBackground(Color.WHITE);
			dados_Cliente.add(panel_formCliente);
		
			JPanel panel_ID = new JPanel();
			panel_ID.setMaximumSize(new Dimension(800, 40));
			panel_ID.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 8));
			panel_ID.setBackground(Color.WHITE);
			panel_formCliente.add(panel_ID);
		
			JLabel label_Id = new JLabel("ID:");
			label_Id.setFont(new Font("Tahoma", Font.PLAIN, 12));
			label_Id.setPreferredSize(new Dimension(50, 25));
			panel_ID.add(label_Id);
		
			textField_Id = new JTextField();
			textField_Id.setPreferredSize(new Dimension(200, 30));
			textField_Id.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField_Id.setEditable(false);
			textField_Id.setBackground(new Color(245, 245, 245));
			panel_ID.add(textField_Id);
		
			JPanel panel_Cliente = new JPanel();
			panel_Cliente.setMaximumSize(new Dimension(800, 40));
			panel_Cliente.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 8));
			panel_Cliente.setBackground(Color.WHITE);
			panel_formCliente.add(panel_Cliente);
		
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNome.setPreferredSize(new Dimension(50, 25));
			panel_Cliente.add(lblNome);
		
			textFieldNome = new JTextField();
			textFieldNome.setPreferredSize(new Dimension(200, 30));
			textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
			panel_Cliente.add(textFieldNome);
		
			JPanel panel_Email = new JPanel();
			panel_Email.setMaximumSize(new Dimension(800, 40));
			panel_Email.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 8));
			panel_Email.setBackground(Color.WHITE);
			panel_formCliente.add(panel_Email);
		
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblEmail.setPreferredSize(new Dimension(50, 25));
			panel_Email.add(lblEmail);
		
		textFieldEmail = new JTextField();
			textFieldEmail.setPreferredSize(new Dimension(200, 30));
			textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
			panel_Email.add(textFieldEmail);
		
			mainPanel.add(Box.createRigidArea(new Dimension(0, 12)));
		
			JPanel panelButtons1 = new JPanel();
			panelButtons1.setMaximumSize(new Dimension(820, 50));
			panelButtons1.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
			panelButtons1.setBackground(new Color(240, 240, 245));
			mainPanel.add(panelButtons1);
		
			clientController = new ClientController();
		
			JButton saveButton = new JButton("Salvar");
			saveButton.setPreferredSize(new Dimension(100, 35));
			saveButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			saveButton.setBackground(new Color(34, 139, 34));
			saveButton.setForeground(Color.WHITE);
			saveButton.setOpaque(true);
			saveButton.setBorderPainted(false);
			saveButton.addActionListener(e -> {
				String nome = textFieldNome.getText().trim();
				String email = textFieldEmail.getText().trim();
			
				if (nome.isEmpty() || email.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}
			
				if (!email.contains("@")) {
					JOptionPane.showMessageDialog(null, "Email inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}
			
				clientController.inserirCliente(nome, email);
				textFieldNome.setText("");
				textFieldEmail.setText("");
			});
			panelButtons1.add(saveButton);
		
			JButton updateButton = new JButton("Atualizar");
			updateButton.setPreferredSize(new Dimension(100, 35));
			updateButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			updateButton.setBackground(new Color(70, 130, 180));
			updateButton.setForeground(Color.WHITE);
			updateButton.setOpaque(true);
			updateButton.setBorderPainted(false);
			updateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String idText = textField_Id.getText().trim();
					String nome = textFieldNome.getText().trim();
					String email = textFieldEmail.getText().trim();
				
					if (idText.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Selecione um cliente pela ID!", "Aviso", JOptionPane.WARNING_MESSAGE);
						return;
					}
				
					if (nome.isEmpty() || email.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
						return;
					}
				
					if (!email.contains("@")) {
						JOptionPane.showMessageDialog(null, "Email inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
						return;
					}
				
					try {
						int id = Integer.parseInt(idText);
						clientController.atualizarCliente(nome, email, id);
						JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
						textFieldNome.setText("");
						textFieldEmail.setText("");
						textField_Id.setText("");
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "ID deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			panelButtons1.add(updateButton);
		
			JButton deleteButton = new JButton("Deletar");
			deleteButton.setPreferredSize(new Dimension(100, 35));
			deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			deleteButton.setBackground(new Color(220, 20, 60));
			deleteButton.setForeground(Color.WHITE);
			deleteButton.setOpaque(true);
			deleteButton.setBorderPainted(false);
			deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					TelaDeletar telaDeletar = new TelaDeletar();
					telaDeletar.setVisible(true);
				}
			});
			panelButtons1.add(deleteButton);
		
			JButton cleanButton = new JButton("Limpar");
			cleanButton.setPreferredSize(new Dimension(100, 35));
			cleanButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cleanButton.setBackground(new Color(105, 105, 105));
			cleanButton.setForeground(Color.WHITE);
			cleanButton.setOpaque(true);
			cleanButton.setBorderPainted(false);
			cleanButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldNome.setText("");
					textFieldEmail.setText("");
					textField_Id.setText("");
				}
			});
			panelButtons1.add(cleanButton);
		
			mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
			JPanel panelList = new JPanel();
			panelList.setMaximumSize(new Dimension(820, 280));
			panelList.setPreferredSize(new Dimension(820, 280));
			panelList.setBorder(new CompoundBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), 
					"Lista de Clientes", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 51, 102)), 
				new EmptyBorder(10, 10, 10, 10)));
			panelList.setLayout(new BoxLayout(panelList, BoxLayout.X_AXIS));
			panelList.setBackground(Color.WHITE);
			mainPanel.add(panelList);
		
			JScrollPane scrollPane = new JScrollPane();
			panelList.add(scrollPane);
		
			tableClientes = new JTable();
			tableClientes.setFont(new Font("Tahoma", Font.PLAIN, 11));
			tableClientes.setRowHeight(25);
			tableClientes.getSelectionModel().addListSelectionListener(e -> {
				if (tableClientes.getSelectedRow() >= 0) {
					int selectedRow = tableClientes.getSelectedRow();
					Object id = tableClientes.getValueAt(selectedRow, 0);
					Object nome = tableClientes.getValueAt(selectedRow, 1);
					Object email = tableClientes.getValueAt(selectedRow, 2);
				
					textField_Id.setText(id.toString());
					textFieldNome.setText(nome.toString());
					textFieldEmail.setText(email.toString());
				}
			});
			scrollPane.setViewportView(tableClientes);
		
			mainPanel.add(Box.createRigidArea(new Dimension(0, 12)));
		
			JPanel panelListButton = new JPanel();
			panelListButton.setMaximumSize(new Dimension(820, 50));
			panelListButton.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
			panelListButton.setBackground(new Color(240, 240, 245));
			mainPanel.add(panelListButton);
		
			JButton listButton = new JButton("Listar Clientes");
			listButton.setPreferredSize(new Dimension(150, 35));
			listButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			listButton.setBackground(new Color(0, 102, 204));
			listButton.setForeground(Color.WHITE);
			listButton.setOpaque(true);
			listButton.setBorderPainted(false);
			listButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Thread (() -> {
						try {
						List <Cliente> lista = clientController.listarCliente();
					
						SwingUtilities.invokeLater(() -> {
							String [] colunas = {"ID", "Nome", "E-mail"};
							DefaultTableModel modelo = new DefaultTableModel (colunas, 0);
						
							for (Cliente c : lista) {
								Object[] linha = {
								c.getId(),
								c.getNome(),
								c.getEmail()
						
							};
								modelo.addRow(linha);
							}
							tableClientes.setModel(modelo);
						
						
						});
					
						} catch (Exception e1) {
							e1.printStackTrace();
							}

						}).start();
				}
			});
			panelListButton.add(listButton);
		
			frame.pack();
			frame.setLocationRelativeTo(null);
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public void setTextFieldNome(JTextField textFieldNome) {
		this.textFieldNome = textFieldNome;
	}

	public JTextField getTextField_Id() {
		return textField_Id;
	}

	public void setTextField_Id(JTextField textField_Id) {
		this.textField_Id = textField_Id;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public void setTextField_Email(JTextField textFieldEmail) {
		this.textFieldEmail = textFieldEmail;
	}


}

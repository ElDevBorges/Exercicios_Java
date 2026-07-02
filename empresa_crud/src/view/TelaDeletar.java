package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import controller.ClientController;
import model.entity.Cliente;

public class TelaDeletar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTable tableClientes;
	private ClientController clientController;

	public TelaDeletar() {
		setTitle("Deletar Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		clientController = new ClientController();

		JLabel lblTitulo = new JLabel("Deletar Cliente");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblTitulo);

		contentPane.add(Box.createRigidArea(new Dimension(0, 15)));

		JPanel panelId = new JPanel();
		panelId.setMaximumSize(new Dimension(570, 50));
		panelId.setBorder(new CompoundBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), 
						"Selecione o Cliente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 100)), 
				new EmptyBorder(10, 10, 10, 10)));
		panelId.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		contentPane.add(panelId);

		JLabel lblId = new JLabel("ID do Cliente:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelId.add(lblId);

		textFieldId = new JTextField();
		textFieldId.setPreferredSize(new Dimension(100, 28));
		textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelId.add(textFieldId);

		contentPane.add(Box.createRigidArea(new Dimension(0, 15)));

		JPanel panelTable = new JPanel();
		panelTable.setMaximumSize(new Dimension(570, 250));
		panelTable.setBorder(new CompoundBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), 
						"Lista de Clientes", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 100)), 
				new EmptyBorder(10, 10, 10, 10)));
		panelTable.setLayout(new BoxLayout(panelTable, BoxLayout.X_AXIS));
		contentPane.add(panelTable);

		JScrollPane scrollPane = new JScrollPane();
		panelTable.add(scrollPane);

		tableClientes = new JTable();
		tableClientes.getSelectionModel().addListSelectionListener(e -> {
			if (tableClientes.getSelectedRow() >= 0) {
				int selectedRow = tableClientes.getSelectedRow();
				Object id = tableClientes.getValueAt(selectedRow, 0);
				textFieldId.setText(id.toString());
			}
		});
		scrollPane.setViewportView(tableClientes);

		contentPane.add(Box.createRigidArea(new Dimension(0, 15)));

		JPanel panelButtons = new JPanel();
		panelButtons.setMaximumSize(new Dimension(570, 50));
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		contentPane.add(panelButtons);

		JButton btnListar = new JButton("Listar");
		btnListar.setPreferredSize(new Dimension(100, 35));
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(() -> {
					try {
						List<Cliente> lista = clientController.listarCliente();

						SwingUtilities.invokeLater(() -> {
							String[] colunas = { "ID", "Nome", "E-mail" };
							DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

							for (Cliente c : lista) {
								Object[] linha = { c.getId(), c.getNome(), c.getEmail() };
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
		panelButtons.add(btnListar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setPreferredSize(new Dimension(100, 35));
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeletar.setForeground(Color.WHITE);
		btnDeletar.setBackground(new Color(220, 20, 60));
		btnDeletar.setOpaque(true);
		btnDeletar.setBorderPainted(false);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = textFieldId.getText().trim();

				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(TelaDeletar.this, 
						"Por favor, digite o ID do cliente!", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}

				try {
					int id = Integer.parseInt(idText);
					int confirmacao = JOptionPane.showConfirmDialog(TelaDeletar.this,
						"Tem certeza que deseja deletar o cliente com ID " + id + "?", 
						"Confirmar Deleção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (confirmacao == JOptionPane.YES_OPTION) {
						clientController.deletarCliente(id);
						JOptionPane.showMessageDialog(TelaDeletar.this, 
							"Cliente deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
						textFieldId.setText("");
						tableClientes.setModel(new DefaultTableModel());
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(TelaDeletar.this, 
						"ID deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panelButtons.add(btnDeletar);

			JButton btnFechar = new JButton("Fechar");
			btnFechar.setPreferredSize(new Dimension(100, 35));
			btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnFechar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			panelButtons.add(btnFechar);

			setLocationRelativeTo(null);
		
			carregarListaClientes();
		}
	
		private void carregarListaClientes() {
			new Thread(() -> {
				try {
					List<Cliente> lista = clientController.listarCliente();

					SwingUtilities.invokeLater(() -> {
						String[] colunas = { "ID", "Nome", "E-mail" };
						DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

						for (Cliente c : lista) {
							Object[] linha = { c.getId(), c.getNome(), c.getEmail() };
							modelo.addRow(linha);
						}
						tableClientes.setModel(modelo);
					});

				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}
}

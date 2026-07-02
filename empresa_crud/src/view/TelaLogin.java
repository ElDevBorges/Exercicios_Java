package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.LoginController;
import model.entity.Usuario;

import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuarioTextField;
	private JPasswordField senhaTextField;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnEntrar;
	private JButton btnSair;
	private LoginController loginController = new LoginController();
	private String usuarioText;
	private String senhaText;
	static TelaCliente tl = new TelaCliente();
	char [] senhaArray;

	public TelaLogin() {
		setTitle("Login - Gerenciador de Clientes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 150, 480, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 245));
		contentPane.setBorder(new EmptyBorder(30, 30, 30, 30));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JLabel lblTitulo = new JLabel("Acesso ao Sistema");
		lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setForeground(new Color(0, 51, 102));
		contentPane.add(lblTitulo);
		
		contentPane.add(Box.createRigidArea(new Dimension(0, 30)));
		
		JPanel panel_Usuario = new JPanel();
		panel_Usuario.setLayout(new BoxLayout(panel_Usuario, BoxLayout.Y_AXIS));
		panel_Usuario.setBackground(new Color(240, 240, 245));
		panel_Usuario.setMaximumSize(new Dimension(300, 65));
		panel_Usuario.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(panel_Usuario);
		
		JLabel usuarioTextLabel = new JLabel("Usuário:");
		usuarioTextLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		usuarioTextLabel.setForeground(new Color(0, 0, 0));
		usuarioTextLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_Usuario.add(usuarioTextLabel);
		
		panel_Usuario.add(Box.createRigidArea(new Dimension(0, 5)));
		
		usuarioTextField = new JTextField();
		usuarioTextField.setPreferredSize(new Dimension(300, 35));
		usuarioTextField.setMaximumSize(new Dimension(300, 35));
		usuarioTextField.setMinimumSize(new Dimension(300, 35));
		usuarioTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		usuarioTextField.setColumns(20);
		usuarioTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		usuarioTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
		panel_Usuario.add(usuarioTextField);
		
		contentPane.add(Box.createRigidArea(new Dimension(0, 15)));
		
		JPanel panel_Senha = new JPanel();
		panel_Senha.setLayout(new BoxLayout(panel_Senha, BoxLayout.Y_AXIS));
		panel_Senha.setBackground(new Color(240, 240, 245));
		panel_Senha.setMaximumSize(new Dimension(300, 65));
		panel_Senha.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(panel_Senha);
		
		JLabel senhaTextLabel = new JLabel("Senha:");
		senhaTextLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		senhaTextLabel.setForeground(new Color(0, 0, 0));
		senhaTextLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_Senha.add(senhaTextLabel);
		
		panel_Senha.add(Box.createRigidArea(new Dimension(0, 5)));
		
		senhaTextField = new JPasswordField();
		senhaTextField.setPreferredSize(new Dimension(300, 35));
		senhaTextField.setMaximumSize(new Dimension(300, 35));
		senhaTextField.setMinimumSize(new Dimension(300, 35));
		senhaTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		senhaTextField.setColumns(20);
		senhaTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		senhaTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
		panel_Senha.add(senhaTextField);
		
		contentPane.add(Box.createRigidArea(new Dimension(0, 12)));
		
		JPanel panel_Checkbox = new JPanel();
		panel_Checkbox.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
		panel_Checkbox.setBackground(new Color(240, 240, 245));
		panel_Checkbox.setMaximumSize(new Dimension(300, 30));
		panel_Checkbox.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(panel_Checkbox);
		
		chckbxNewCheckBox = new JCheckBox("Mostrar senha");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxNewCheckBox.setBackground(new Color(240, 240, 245));
		chckbxNewCheckBox.setFocusPainted(false);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					senhaTextField.setEchoChar((char) 0);
				} else {
					senhaTextField.setEchoChar('●');
				}
			}
		});
		panel_Checkbox.add(chckbxNewCheckBox);
		
		contentPane.add(Box.createRigidArea(new Dimension(0, 20)));
		
		JPanel panel_Botoes = new JPanel();
		panel_Botoes.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel_Botoes.setBackground(new Color(240, 240, 245));
		panel_Botoes.setMaximumSize(new Dimension(300, 50));
		panel_Botoes.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(panel_Botoes);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setPreferredSize(new Dimension(120, 40));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEntrar.setBackground(new Color(34, 139, 34));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setOpaque(true);
		btnEntrar.setBorderPainted(false);
		btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioText = usuarioTextField.getText().trim();
				
				if (usuarioText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o usuário!", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				senhaArray = senhaTextField.getPassword();
				senhaText = new String (senhaArray);
				
				if (senhaText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite a senha!", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				new Thread (() -> {
					boolean sucesso =  loginController.autenticarLogin(usuarioText, senhaText);
					
					SwingUtilities.invokeLater(() -> {
						if (sucesso) {
							JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
							tl.frame.setVisible(true);
							TelaLogin.this.dispose();
						
						} else JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto!", "Erro", JOptionPane.ERROR_MESSAGE);
					});
					
				}).start();
			}
		});
		panel_Botoes.add(btnEntrar);
		
		btnSair = new JButton("Sair");
		btnSair.setPreferredSize(new Dimension(120, 40));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSair.setBackground(new Color(220, 20, 60));
		btnSair.setForeground(Color.WHITE);
		btnSair.setOpaque(true);
		btnSair.setBorderPainted(false);
		btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_Botoes.add(btnSair);
		
		contentPane.add(Box.createVerticalGlue());
		
		JPanel panel_Rodape = new JPanel();
		panel_Rodape.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_Rodape.setBackground(new Color(240, 240, 245));
		panel_Rodape.setMaximumSize(new Dimension(420, 30));
		panel_Rodape.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(panel_Rodape);
		
		JLabel lblRodape = new JLabel("Digite seu usuário e senha para entrar no sistema");
		lblRodape.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblRodape.setForeground(new Color(100, 100, 100));
		panel_Rodape.add(lblRodape);
		
		setLocationRelativeTo(null);
	}
}

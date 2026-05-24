package view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.LoginController;
import model.entity.Usuario;

import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
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
	private JLabel lblNewLabel_2;
	private Component rigidArea;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel senhaTextLabel;
	private Component rigidArea_1;
	private JPanel panel_2;
	private JLabel usuarioTextLabel;
	private JTextField usuarioTextField;
	private Component rigidArea_2;
	private JPasswordField senhaTextField;
	private JCheckBox chckbxNewCheckBox;
	private JPanel panel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel_4;
	private Component rigidArea_3;
	private JPanel mainPanel;
	private Component rigidArea_4;
	private JLabel lblNewLabel_3;
	private LoginController loginController = new LoginController();
	private String usuarioText;
	private String senhaText;
	char [] senhaArray;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		lblNewLabel_2 = new JLabel("Acesso ao Sistema");
		lblNewLabel_2.setAlignmentX(0.5f);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_2);
		
		rigidArea = Box.createRigidArea(new Dimension(0, 30));
		contentPane.add(rigidArea);
		
		
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
		contentPane.add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		
		panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 85));
		mainPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel_2 = new JPanel();
		panel_2.setMaximumSize(new Dimension(32767, 30));
		panel_2.setPreferredSize(new Dimension(10, 40));
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		usuarioTextLabel = new JLabel("Usuário");
		panel_2.add(usuarioTextLabel);
		
		rigidArea_2 = Box.createRigidArea(new Dimension(30, 20));
		panel_2.add(rigidArea_2);
		
		usuarioTextField = new JTextField();
		usuarioTextField.setPreferredSize(new Dimension(300, 20));
		panel_2.add(usuarioTextField);
		usuarioTextField.setColumns(20);
		
		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(250, 30));
		
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_1.setMaximumSize(new Dimension(32767, 30));
		
		senhaTextLabel = new JLabel("Senha");
		panel_1.add(senhaTextLabel);
		
		rigidArea_1 = Box.createRigidArea(new Dimension(30, 20));
		rigidArea_1.setPreferredSize(new Dimension(37, 20));
		panel_1.add(rigidArea_1);
		
		senhaTextField = new JPasswordField();
		senhaTextField.setPreferredSize(new Dimension(300, 20));
		senhaTextField.setColumns(20);
		senhaTextField.setMaximumSize(new Dimension(300, 2147483647));
		panel_1.add(senhaTextField);
		
		chckbxNewCheckBox = new JCheckBox("Mostrar senha");
		chckbxNewCheckBox.setMaximumSize(new Dimension(230, 23));
		chckbxNewCheckBox.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		chckbxNewCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(chckbxNewCheckBox);
		
		rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_4.setMaximumSize(new Dimension(20, 13));
		rigidArea_4.setMinimumSize(new Dimension(20, 0));
		rigidArea_4.setPreferredSize(new Dimension(20, 13));
		mainPanel.add(rigidArea_4);
		
		panel_3 = new JPanel();
		panel_3.setMaximumSize(new Dimension(200, 40));
		panel_3.setPreferredSize(new Dimension(200, 10));
		mainPanel.add(panel_3);
		FlowLayout fl_panel_3 = new FlowLayout(FlowLayout.LEFT, 15, 5);
		panel_3.setLayout(fl_panel_3);
		
		btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				usuarioText = usuarioTextField.getText();
				
				senhaArray = senhaTextField.getPassword();
				senhaText =  new String (senhaArray);
				
				
				new Thread (() -> {
					boolean sucesso =  loginController.autenticarLogin(usuarioText, senhaText);
					
					SwingUtilities.invokeLater(() -> {
						if (sucesso) {
							JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
						} else JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto");
					});
					
				}).start();
				
			}
		});
		btnNewButton.setMargin(new Insets(2, 7, 2, 7));
		btnNewButton.setPreferredSize(new Dimension(63, 28));
		btnNewButton.setMaximumSize(new Dimension(63, 28));
		panel_3.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.setPreferredSize(new Dimension(63, 28));
		btnNewButton_1.setMaximumSize(new Dimension(63, 23));
		panel_3.add(btnNewButton_1);
		
		rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3.setMaximumSize(new Dimension(30, 40));
		rigidArea_3.setPreferredSize(new Dimension(20, 15));
		contentPane.add(rigidArea_3);
		
		panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_4.setMaximumSize(new Dimension(32767, 20));
		contentPane.add(panel_4);
		
		lblNewLabel_3 = new JLabel("Digite seu usuário e senha para entrar no sistema");
		panel_4.add(lblNewLabel_3);
		
		

	}
}

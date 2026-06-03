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
import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Insets;

public class TelaCliente extends JFrame {

	JFrame frame;
	private JTextField textField_Id;
	private JTextField textField_Email;
	private JTextField textField;
	private JPanel panel_Crud;

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
		frame.setPreferredSize(new Dimension(700, 450));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setPreferredSize(new Dimension(150, 30));
		panel.setBorder(new EmptyBorder(7, 0, 0, 0));
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel dados_Cliente = new JPanel();
		dados_Cliente.setMaximumSize(new Dimension(660, 130));
		
	
		
		dados_Cliente.setToolTipText("Dados do Cliente");
		dados_Cliente.setName("Dados do Cliente");
		dados_Cliente.setBorder(new CompoundBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dados do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)), new EmptyBorder(6, 6, 6, 6)));
		dados_Cliente.setPreferredSize(new Dimension(660, 130));
		panel.add(dados_Cliente);
		dados_Cliente.setLayout(new BoxLayout(dados_Cliente, BoxLayout.X_AXIS));
		
		JPanel panel_formCliente = new JPanel();
		panel_formCliente.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_formCliente.setMaximumSize(new Dimension(230, 32767));
		panel_formCliente.setPreferredSize(new Dimension(230, 10));
		dados_Cliente.add(panel_formCliente);
		panel_formCliente.setLayout(new BoxLayout(panel_formCliente, BoxLayout.Y_AXIS));
		
		JPanel panel_ID = new JPanel();
		panel_ID.setMaximumSize(new Dimension(230, 30));
		panel_formCliente.add(panel_ID);
		panel_ID.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel label_Id = new JLabel("ID");
		panel_ID.add(label_Id);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(35, 20));
		rigidArea.setMaximumSize(new Dimension(35, 20));
		panel_ID.add(rigidArea);
		
		textField_Id = new JTextField();
		panel_ID.add(textField_Id);
		textField_Id.setColumns(10);
		
		JPanel panel_Cliente = new JPanel();
		panel_Cliente.setMaximumSize(new Dimension(230, 30));
		panel_Cliente.setPreferredSize(new Dimension(10, 30));
		panel_formCliente.add(panel_Cliente);
		panel_Cliente.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNome = new JLabel("Nome");
		panel_Cliente.add(lblNome);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(19, 20));
		rigidArea_1.setMaximumSize(new Dimension(19, 20));
		panel_Cliente.add(rigidArea_1);
		
		textField = new JTextField();
		panel_Cliente.add(textField);
		textField.setColumns(14);
		
		JPanel panel_Email = new JPanel();
		panel_Email.setMaximumSize(new Dimension(32767, 30));
		panel_formCliente.add(panel_Email);
		panel_Email.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblEmail = new JLabel("Email");
		panel_Email.add(lblEmail);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2.setPreferredSize(new Dimension(22, 20));
		rigidArea_2.setMaximumSize(new Dimension(21, 20));
		panel_Email.add(rigidArea_2);
		
		textField_Email = new JTextField();
		textField_Email.setPreferredSize(new Dimension(10, 20));
		panel_Email.add(textField_Email);
		textField_Email.setColumns(14);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		dados_Cliente.add(rigidArea_4);
		
		panel_Crud = new JPanel();
		panel_Crud.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_Crud.setMaximumSize(new Dimension(380, 100));
		panel_Crud.setPreferredSize(new Dimension(300, 300));
		dados_Cliente.add(panel_Crud);
		panel_Crud.setLayout(new BoxLayout(panel_Crud, BoxLayout.Y_AXIS));
		
		JPanel panelButtons1 = new JPanel();
		panelButtons1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelButtons1.setMaximumSize(new Dimension(380, 45));
		panel_Crud.add(panelButtons1);
		FlowLayout fl_panelButtons1 = new FlowLayout(FlowLayout.LEFT, 10, 10);
		panelButtons1.setLayout(fl_panelButtons1);
		
		JButton saveButton = new JButton("Salvar");
		saveButton.setMaximumSize(new Dimension(50, 23));
		saveButton.setHorizontalTextPosition(SwingConstants.LEADING);
		saveButton.setPreferredSize(new Dimension(80, 30));
		panelButtons1.add(saveButton);
		
		JButton updateButton = new JButton("Atualizar");
		updateButton.setMaximumSize(new Dimension(80, 23));
		updateButton.setPreferredSize(new Dimension(80, 30));
		panelButtons1.add(updateButton);
		
		JButton deleteButton = new JButton("Deletar");
		deleteButton.setPreferredSize(new Dimension(80, 30));
		panelButtons1.add(deleteButton);
		
		JButton cleanButton = new JButton("Limpar");
		cleanButton.setPreferredSize(new Dimension(80, 30));
		panelButtons1.add(cleanButton);
		panelButtons1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{deleteButton, cleanButton, saveButton, updateButton}));
		
		JPanel panelButtons2 = new JPanel();
		panelButtons2.setBorder(new EmptyBorder(0, 10, 0, 0));
		panelButtons2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelButtons2.setMaximumSize(new Dimension(380, 50));
		panel_Crud.add(panelButtons2);
		panelButtons2.setLayout(new BoxLayout(panelButtons2, BoxLayout.X_AXIS));
		
		JButton listButton = new JButton("Listar");
		listButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		listButton.setMaximumSize(new Dimension(160, 30));
		listButton.setPreferredSize(new Dimension(160, 30));
		panelButtons2.add(listButton);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
	}


}

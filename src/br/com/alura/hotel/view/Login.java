package br.com.alura.hotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;

	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
	setResizable(false);
	//setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/br/com/alura/hotel/images/hotel.png")));
		
		//tamanho da tela
	contentPane.setBackground(UIManager.getColor("Button.highlight"));
	setBounds(250, 120, 910, 537);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
	
		
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Login.class.getResource("/br/com/alura/hotel/images/Ha-100px.png")));
		icone.setBounds(616, 24, 110, 85);
		contentPane.add(icone);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(12, 138, 199));
		panel.setBounds(-6, -20, 456, 561);
		contentPane.add(panel);
		panel.setLayout(null);
			
		
		
		JLabel imgHotel = new JLabel("");
		imgHotel.setVerticalAlignment(SwingConstants.TOP);
		imgHotel.setBackground(Color.BLUE);
		imgHotel.setBounds(64, -19, 417, 488);
	
		imgHotel.setIcon(new ImageIcon(Login.class.getResource("/br/com/alura/hotel/images/img-hotel-login-.png")));
		panel.add(imgHotel);
		
	
		
		JLabel labelTitulo = new JLabel("LOGIN");
		
		labelTitulo.setForeground(SystemColor.textHighlight);
		labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		labelTitulo.setBounds(626, 120, 89, 26);
		contentPane.add(labelTitulo);
		
		
		// texto usuario
		JLabel lblLogin = new JLabel("Usuário");
		lblLogin.setForeground(SystemColor.textInactiveText);
		lblLogin.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblLogin.setBounds(556, 168, 231, 31);
		contentPane.add(lblLogin);
		
		
		//input usuario

		
		
		txtUsuario = new JTextField();
		//clica o mouse o texto some
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
				public void mousePressed(MouseEvent e) {
				if (txtUsuario.getText().equals("Digite seu nome de usuario")) {
					txtUsuario.setText("");
					txtUsuario.setForeground(Color.black);
				}
				if (String.valueOf(txtSenha.getPassword()).isEmpty()) {
					
					txtSenha.setForeground(Color.gray);
				}
			}
		});
		
		txtUsuario.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtUsuario.setText("Digite seu nome de usuario");
		txtUsuario.setBorder(new EmptyBorder(0, 0, 2, 0));
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setBounds(556, 210, 231, 31);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		
	
		
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 120, 215));
		separator.setBounds(557, 241, 250, 2);
		contentPane.add(separator);
		
		
		//texto senha
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(SystemColor.textInactiveText);
		lblSenha.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblSenha.setBounds(556, 279, 86, 22);
		contentPane.add(lblSenha);
		
		
		//input senha
		
		txtSenha = new JPasswordField();

		txtSenha.addMouseListener(new MouseAdapter() {
			//clica o mouse o texto some
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(txtSenha.getPassword()).equals("********")) {
					txtSenha.setText("");
					txtSenha.setForeground(Color.black);
				}
				if (txtUsuario.getText().isEmpty()) {
					txtUsuario.setText("Digite seu usuario");
					txtUsuario.setForeground(Color.gray);
				}
			}
		});
		txtSenha.setForeground(SystemColor.activeCaptionBorder);
		txtSenha.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtSenha.setBounds(556, 312, 231, 31);
		contentPane.add(txtSenha);

			
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		separator_1.setBounds(556, 343, 250, 2);
		contentPane.add(separator_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/br/com/alura/hotel/images/perfil-del-usuario.png")));
		
		//ação do botao
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// verificaçõa
				if(checkLogin(txtUsuario.getText(), new String(txtSenha.getPassword()))) {
				
								
				MenuUsuario MenuUsuario =new MenuUsuario();
				MenuUsuario.setVisible(true);
				JOptionPane.showMessageDialog(null, "Bem vindo ao sistema!");
				
				dispose();			
				
				
				}else {
					JOptionPane.showMessageDialog(null, "Usuario ou Senha incorretos!");
			}}
		});
		
	
		btnLogin.setForeground(SystemColor.desktop);
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnLogin.setBackground(SystemColor.inactiveCaption);
		btnLogin.setBounds(555, 380, 125, 37);
		contentPane.add(btnLogin);
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JButton btnSair = new JButton("Cancelar");
		btnSair.setIcon(new ImageIcon(Login.class.getResource("/br/com/alura/hotel/images/cerrar-24px.png")));
		btnSair.setForeground(SystemColor.desktop);
		btnSair.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnSair.setBackground(SystemColor.inactiveCaption);
		btnSair.setBounds(709, 381, 140, 37);
		contentPane.add(btnSair);
		btnSair.setLayout(null);
		btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
						
				
				//sair
						btnSair.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int sair = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?", "Selecione uma das opções",
										JOptionPane.YES_NO_OPTION);
								if(sair == 0)
									System.exit(0);
							}

							});
						
				btnSair.setBackground(SystemColor.text);
				btnSair.setLayout(null);
				btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));	
						
	
	}
	
//	verificação
		
	public boolean  checkLogin(String login, String senha) {
		return login.equals("adm")&& senha.equals("123");
	}
}





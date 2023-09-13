package br.com.alura.hotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaInicial.class.getResource("/br/com/alura/hotel/images/aH-40px.png")));
	
		//tela nao pode ser maximizada
		setResizable(false);
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// tamanho da tela
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		setBounds(250, 100, 910, 575);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contentPane.setLayout(null);

		
		JLabel imgMenu = new JLabel("");
		imgMenu.setBounds(0, 0, 705, 500);
		contentPane.add(imgMenu);
		imgMenu.setVerticalAlignment(SwingConstants.TOP);
		imgMenu.setBackground(Color.BLUE);
		
			imgMenu.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/alura/hotel/images/menu-img.png")));
		
		
		
			JLabel icone = new JLabel("");
			icone.setBounds(741, 23, 110, 85);
			icone.setIcon(new ImageIcon(Login.class.getResource("/br/com/alura/hotel/images/Ha-100px.png")));
			contentPane.add(icone);
			
			JLabel labelTitulo = new JLabel("LOGIN");
			labelTitulo.setBounds(751, 127, 89, 26);
			
			labelTitulo.setForeground(SystemColor.textHighlight);
			labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
			contentPane.add(labelTitulo);
		
		
		
		
		
		JButton btnLogin = new JButton("");
		btnLogin.setBounds(751, 219, 89, 85);
		btnLogin.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/alura/hotel/images/login.png")));

		// ação do botao
		btnLogin.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogin.setForeground(SystemColor.desktop);
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnLogin.setBackground(SystemColor.controlLtHighlight);
		contentPane.add(btnLogin);
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				// fecha a tela
				dispose();
			}
		});

		JButton btnSair = new JButton("");
		btnSair.setBounds(826, 437, 58, 52);
		btnSair.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/alura/hotel/images/cerrar-sesion 32-px.png")));
		contentPane.add(btnSair);
		btnSair.setLayout(null);
//		btnSair.setBackground(SystemColor.text);
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
				

		// rodape
		JPanel footer  = new JPanel();
		footer.setBounds(0, 500, 910, 37);
		contentPane.add(footer);
		footer.setBackground(new Color(12, 138, 199));
		footer.setLayout(null);
		
		
		
		JLabel lblCopyR = new JLabel("Desenvolvido por Jacqueline Casali © 2023");
		lblCopyR.setBounds(289, 0, 327, 30);
		lblCopyR.setForeground(new Color(240, 248, 255));
		lblCopyR.setFont(new Font("Dialog", Font.PLAIN, 16));
		footer.add(lblCopyR);

			
	
	
	}
	

}

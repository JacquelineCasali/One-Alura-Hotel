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

import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MenuUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
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
	public MenuUsuario() {
		setResizable(false);
	//	setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaInicial.class.getResource("/br/com/alura/hotel/images/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// tamanho da tela
		setBounds(250, 120, 910, 575);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// imagem
		JLabel imgMenu = new JLabel("");
		imgMenu.setBounds(0, 0, 705, 500);
		contentPane.add(imgMenu);
		imgMenu.setVerticalAlignment(SwingConstants.TOP);
		imgMenu.setBackground(Color.BLUE);

		imgMenu.setIcon(new ImageIcon(MenuUsuario.class.getResource("/br/com/alura/hotel/images/menu-img.png")));


		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(MenuUsuario.class.getResource("/br/com/alura/hotel/images/Ha-100px.png")));
		icone.setBounds(746, 25, 110, 85);
		contentPane.add(icone);
		
		//texto reserva
		JLabel lblReserva = new JLabel("Reservas");
		lblReserva.setForeground(SystemColor.textHighlight);
		lblReserva.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblReserva.setBounds(763, 153, 86, 22);
		contentPane.add(lblReserva);
		
		

		
		
		JButton btnreserva = new JButton("");
		btnreserva.setIcon(new ImageIcon(MenuUsuario.class.getResource("/br/com/alura/hotel/images/reservas.png")));

		// ação do botao
		btnreserva.setHorizontalAlignment(SwingConstants.CENTER);
		btnreserva.setForeground(SystemColor.text);
		btnreserva.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnreserva.setBackground(SystemColor.text);
		btnreserva.setBounds(763, 186, 89, 73);
		contentPane.add(btnreserva);
		btnreserva.setLayout(null);
		btnreserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnreserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Reserva Reserva = new Reserva();
				Reserva.setVisible(true);
				dispose();
			}
		});

		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setForeground(SystemColor.textHighlight);
		lblBuscar.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblBuscar.setBounds(763, 282, 86, 22);
		contentPane.add(lblBuscar);
		
		JButton btnbusca = new JButton("");
		btnbusca.setIcon(new ImageIcon(MenuUsuario.class.getResource("/br/com/alura/hotel/images/busqueda.png")));

		// ação do botao
		btnbusca.setHorizontalAlignment(SwingConstants.CENTER);
		btnbusca.setForeground(SystemColor.text);
		btnbusca.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnbusca.setBackground(SystemColor.text);
		btnbusca.setBounds(763, 320, 89, 73);
		contentPane.add(btnbusca);
		btnbusca.setLayout(null);
		btnbusca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnbusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Busca Busca = new Busca();
				Busca.setVisible(true);
				dispose();
			
			
			}
		});


		JButton btnSair = new JButton("");
		btnSair.setIcon(
				new ImageIcon(MenuUsuario.class.getResource("/br/com/alura/hotel/images/cerrar-sesion 32-px.png")));
		btnSair.setBounds(824, 437, 58, 52);
		contentPane.add(btnSair);
		btnSair.setLayout(null);
//			btnSair.setBackground(SystemColor.text);
		btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		// sair
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sair = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?", "Selecione uma das opções",
						JOptionPane.YES_NO_OPTION);
				if (sair == 0)
					System.exit(0);
			}

		});

		btnSair.setBackground(SystemColor.text);
		btnSair.setLayout(null);
		btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		// rodape
		JPanel footer = new JPanel();
		footer.setBounds(75, 519, 659, 7);
		contentPane.add(footer);
		footer.setBounds(0, 500, 910, 37);
		footer.setBackground(new Color(12, 138, 199));
		footer.setLayout(null);

		JLabel lblCopyR = new JLabel("Desenvolvido por Jacqueline Casali © 2023");
		lblCopyR.setBounds(289, 11, 327, 19);
		lblCopyR.setForeground(new Color(240, 248, 255));
		lblCopyR.setFont(new Font("Dialog", Font.PLAIN, 16));
		footer.add(lblCopyR);

	}
}

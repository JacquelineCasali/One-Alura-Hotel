package br.com.alura.hotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.text.Format;


import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


import com.toedter.calendar.JDateChooser;

import br.com.alura.hotel.model.DatasValidas;
import br.com.alura.hotel.controller.ReservasController;
import br.com.alura.hotel.model.Reservas;

@SuppressWarnings("serial")
public class Reserva extends JFrame {

	private JPanel contentPane;
	public static JDateChooser txtDataE;
	public static JDateChooser txtDataS;
	public static JTextField txtValor;
	public static JComboBox<Format> txtFormaPagamanto;
	private Reservas reserva;
	private JLabel lblValorSimbolo;
	private ReservasController reservaController = new ReservasController();
	private DatasValidas datas = new DatasValidas();
	private String dataE;
	private String dataS;
	private long numeroDias;
	private long valorDaDiaria;
	private static String valorDaReserva;
	
	private static int  reservaKey; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reserva frame = new Reserva();
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
	public Reserva() {
		setResizable(false);
		// setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reserva.class.getResource("/br/com/alura/hotel/images/calendario.png")));
		
//			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// tamanho da tela
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		setBounds(250, 20, 910, 680);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 396, 641);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel icone = new JLabel("");
		icone.setBounds(6, 0, 100, 100);
		icone.setIcon(new ImageIcon(MenuUsuario.class.getResource("/br/com/alura/hotel/images/Ha-100px.png")));
		panel.add(icone);

		// texto reserva
		JLabel lblReservas = new JLabel("Sistema de Reservas");
		lblReservas.setForeground(SystemColor.textHighlight);
		lblReservas.setFont(new Font("Dialog", Font.BOLD, 20));
		lblReservas.setBounds(136, 39, 207, 22);
		panel.add(lblReservas);

		
		lblValorSimbolo = new JLabel("$");
		lblValorSimbolo.setEnabled(false);
		lblValorSimbolo.setBounds(49, 384, 18, 21);
		lblValorSimbolo.setForeground(SystemColor.textHighlight);
		lblValorSimbolo.setFont(new Font("Roboto", Font.BOLD, 17));
		panel.add(lblValorSimbolo);
		
		
		JLabel lblDataentrada = new JLabel("Data de Check In");
		lblDataentrada.setForeground(new Color(128, 128, 128));
		lblDataentrada.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDataentrada.setBounds(39, 150, 140, 21);
		panel.add(lblDataentrada);

		txtDataE = new JDateChooser();
		txtDataE.getCalendarButton().setFont(new Font("Dialog", Font.PLAIN, 16));
		txtDataE.setBounds(39, 177, 285, 39);
		panel.add(txtDataE);
		
		txtDataE.getCalendarButton().setIcon(
				new ImageIcon(RegistroHospede.class.getResource("/br/com/alura/hotel/images/icon-reservas.png")));
		txtDataE.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtDataE.setDateFormatString("yyyy-MM-dd");
		txtDataE.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtDataE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		
		JLabel lblDatasaida = new JLabel("Data de Check On");
		lblDatasaida.setForeground(Color.GRAY);
		lblDatasaida.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDatasaida.setBounds(39, 250, 140, 21);

		panel.add(lblDatasaida);
		
		txtDataS = new JDateChooser();
		panel.add(txtDataS);
	
		txtDataS.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtDataS.setDateFormatString("yyyy-MM-dd");
		txtDataS.setBounds(39, 277, 285, 39);
		txtDataS.getCalendarButton().setIcon(new ImageIcon(RegistroHospede.class.getResource("/br/com/alura/hotel/images/icon-reservas.png")));
		txtDataS.getCalendarButton().setBounds(267, 1, 21, 31);
		txtDataS.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtDataS.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				// Ativa o evento, após o usuário selecionar as datas, o valor da reserva deve
				// ser calculado

				if (txtDataE.getDate() != null && txtDataS.getDate() != null) {
					//verifica se as variáveis de data de entrada e sai estão preenchidas
					if(dataE == null && dataS == null) {
						
						//valida as datas no formado "yyyy-MM-dd" aceito pelo banco de dados
						String dataE = datas.validarData(txtDataE.getDate());
						String dataS = datas.validarData(txtDataS.getDate());
						
						//calcula o número de dias transcorrido entre as datas e o valor total da reserva
						numeroDias = datas.calculaDias(dataE, dataS)+1;
						valorDaDiaria = 150;
						valorDaReserva = String.valueOf(numeroDias * valorDaDiaria);
						
						//mostra o valor da reserva ao usuário
						txtValor.setText(valorDaReserva);
						
						//constroe a referência com os dados obtidos
						reserva = new Reservas(dataE, dataS, Double.parseDouble(valorDaReserva),
								txtFormaPagamanto.getSelectedItem().toString());						
					}
					
				}
				
			}
		});
		
	
		
		
		
		
		
		
		

		JLabel lblValor = new JLabel("Valor da Reserva");
		lblValor.setFont(new Font("Dialog", Font.BOLD, 16));
		lblValor.setForeground(new Color(128, 128, 128));
		lblValor.setBounds(39, 343, 157, 21);
		panel.add(lblValor);

		txtValor  = new JTextField();
		
		
		txtValor.setBackground(SystemColor.text);
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setForeground(Color.BLACK);
		txtValor .setColumns(10);
		txtValor .setBounds(39, 375, 285, 39);
		txtValor.setEditable(false);
		txtValor .setFont(new Font("Dialog", Font.BOLD, 16));
		
		
		
		
		
		
		
		panel.add(txtValor );

		JLabel lblPagamento = new JLabel("Forma de Pagamento");
		lblPagamento.setForeground(new Color(128, 128, 128));
		lblPagamento.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPagamento.setBounds(41, 437, 207, 21);
		panel.add(lblPagamento);

		txtFormaPagamanto = new JComboBox();
		txtFormaPagamanto.setEditable(true);
		txtFormaPagamanto.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtFormaPagamanto.setBackground(new Color(255, 255, 255));
		txtFormaPagamanto.setBounds(39, 469, 285, 39);
		txtFormaPagamanto.setModel(
				new DefaultComboBoxModel(new String[] {"Cartão de Crédito", "Cartão de Débito", "Dinheiro" }));
			
		panel.add(txtFormaPagamanto);
		txtFormaPagamanto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JButton btnSalvar = new JButton("Continuar");
		btnSalvar.setIcon(null);
		
		//ação do botao
		
		btnSalvar.setForeground(new Color(255, 255, 255));
		btnSalvar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnSalvar.setBackground(new Color(0, 0, 255));
		btnSalvar.setBounds(78, 543, 160, 52);
		panel.add(btnSalvar);
		btnSalvar.setLayout(null);
		btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					if (Reserva.txtDataE.getDate() != null && Reserva.txtDataS.getDate() != null) {
						
						//seta a forma de pagamento atual	
						reserva.setFORMADEPAGAMENTO(txtFormaPagamanto.getSelectedItem().toString());
						
						
						try {
							
							//insere a referência reserva no banco de dados e retorna o ID gerado
							reservaKey = reservaController.salvar(reserva); 
						
						} catch (Exception e1) {
							e1.printStackTrace();
						}

						RegistroHospede registro = new RegistroHospede();
						registro.setVisible(true);
						
						dispose();
						
					} else {
						JOptionPane.showMessageDialog(null, "Deve preencher todos os campos.");
					}
				}
			});
		
		

		JButton btnSair = new JButton("");
		btnSair.setBounds(297, 543, 58, 52);
		btnSair.setIcon(
				new ImageIcon(Reserva.class.getResource("/br/com/alura/hotel/images/cerrar-sesion 32-px.png")));
		panel.add(btnSair);
		btnSair.setLayout(null);
//		btnSair.setBackground(SystemColor.text);
		btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		// sair
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				MenuUsuario MenuUsuario =new MenuUsuario();
				
				JOptionPane.showConfirmDialog(null, "Deseja mesmo voltar para a tela de Menu?", "Selecione uma das opções",
						JOptionPane.YES_NO_OPTION);
				MenuUsuario.setVisible(true);
				dispose();	
				
						
			
			}

		});

		btnSair.setBackground(SystemColor.text);
		btnSair.setLayout(null);
		btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(12, 138, 199));
		panel_1.setBounds(396, 0, 498, 641);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		

		
		JLabel imgHotel = new JLabel("");
		imgHotel.setVerticalAlignment(SwingConstants.TOP);
		imgHotel.setBackground(Color.BLUE);
		imgHotel.setBounds(10, 86, 481, 519);
	
		imgHotel.setIcon(new ImageIcon(Reserva.class.getResource("/br/com/alura/hotel/images/reservas-img-3.png")));
		panel_1.add(imgHotel);
		

	}

	
	
	public static int getReservaKey() {
		return  reservaKey;
	}
	public static String getValorReserva() {
		return valorDaReserva;
	}
}

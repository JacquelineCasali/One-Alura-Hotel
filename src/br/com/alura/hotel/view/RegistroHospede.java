package br.com.alura.hotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Date;


import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.text.Format;
import com.toedter.calendar.JDateChooser;

import br.com.alura.hotel.model.DatasValidas;
import br.com.alura.hotel.model.Hospedes;

import br.com.alura.hotel.controller.HospedeController;


@SuppressWarnings("serial")
public class RegistroHospede extends JFrame {

	private JPanel contentPane;

	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JDateChooser txtDataN;
	private JTextField txtTelefone;
	private JTextField txtNreserva;
	private JComboBox<Format> txtNacionalidade;
	private HospedeController hospedeController = new HospedeController();
	private DatasValidas dataVal = new DatasValidas();


	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHospede frame = new RegistroHospede();
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
	public RegistroHospede() {
	
		
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHospede.class.getResource("/br/com/alura/hotel/images/persona.png")));
		// setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
//			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// tamanho da tela
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		setBounds(250, 20, 910, 680);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// imagem
		JLabel imgreserva = new JLabel("");
		imgreserva.setBounds(0, 37, 511, 604);
		contentPane.add(imgreserva);
		imgreserva.setVerticalAlignment(SwingConstants.TOP);
		imgreserva.setBackground(Color.BLUE);

		imgreserva.setIcon(new ImageIcon(RegistroHospede.class.getResource("/br/com/alura/hotel/images/registro.png")));

		JPanel panel = new JPanel();
		panel.setBounds(514, 0, 396, 641);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel icone = new JLabel("");
		icone.setBounds(256, 11, 100, 100);
		icone.setIcon(new ImageIcon(MenuUsuario.class.getResource("/br/com/alura/hotel/images/Ha-100px.png")));
		panel.add(icone);

		// texto reserva
		JLabel lblRegistro = new JLabel("Registro de Hóspede");
		lblRegistro.setForeground(SystemColor.textHighlight);
		lblRegistro.setFont(new Font("Dialog", Font.BOLD, 20));
		lblRegistro.setBounds(39, 49, 207, 22);
		panel.add(lblRegistro);
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(128, 128, 128));
		lblNome.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNome.setBounds(39, 102, 67, 21);
		panel.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(39, 129, 257, 39);
		panel.add(txtNome);
		txtNome.setColumns(10);
		txtNome.setFont(new Font("Dialog", Font.PLAIN, 16));

		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setForeground(new Color(128, 128, 128));
		lblSobrenome.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSobrenome.setBounds(39, 179, 112, 21);
		panel.add(lblSobrenome);

		// input
		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(39, 211, 257, 39);
		panel.add(txtSobrenome);
		txtSobrenome.setFont(new Font("Dialog", Font.PLAIN, 16));

		JLabel lblData = new JLabel("Data de Nascimento");
		lblData.setForeground(new Color(128, 128, 128));
		lblData.setVerticalAlignment(SwingConstants.TOP);
		lblData.setFont(new Font("Dialog", Font.BOLD, 16));
		lblData.setBounds(39, 261, 167, 21);
		panel.add(lblData);

		txtDataN = new JDateChooser();
		txtDataN.setBounds(39, 287, 285, 39);
		txtDataN.getCalendarButton().setIcon(
				new ImageIcon(RegistroHospede.class.getResource("/br/com/alura/hotel/images/icon-reservas.png")));
		txtDataN.getCalendarButton().setBackground(SystemColor.textHighlight);
			txtDataN.setDateFormatString("yyyy-MM-dd");
	
		panel.add(txtDataN);
		txtDataN.setBounds(39, 287, 257, 39);
		txtDataN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JLabel lblNacionalidade = new JLabel("Nacionalidade");
		lblNacionalidade.setForeground(new Color(128, 128, 128));
		lblNacionalidade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNacionalidade.setBounds(39, 338, 140, 21);
		panel.add(lblNacionalidade);

		txtNacionalidade = new JComboBox();
		txtNacionalidade.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtNacionalidade.setEditable(true);
		txtNacionalidade.setBackground(new Color(255, 255, 255));
		txtNacionalidade.setBounds(39, 371, 257, 39);
		txtNacionalidade.setModel(new DefaultComboBoxModel(new String[] {"afegão-afegã", "alemão-", "alemã", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileiro-brasileira", "cambojano-cambojana", "canadense-canadense", "chileno-chilena", "chinês-chinesa", "colombiano-colombiana", "coreano-coreana", "costa-riquenho-costa-riquenha", "cubano-cubana", "dinamarquês-dinamarquesa", "equatoriano-equatoriana", "egípcio-egípcia", "salvadorenho-salvadorenha", "escocês-escocesa", "espanhol-espanhola", "estadounidense-estadounidense", "estoniano-estoniana", "etíope-etíope", "filipino-filipina", "finlandês-finlandesa", "francês-francesa", "galês-galesa", "grego-grega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandês-holandesa", "hondurenho-hondurenha", "indonésio-indonésia", "inglês-inglesa", "iraquiano-iraquiana", "iraniano-iraniana", "irlandês-irlandesa", "israelita-israelita", "italiano-italiana", "japonês-japonesa", "jordaniano-jordaniana", "laosiano-laosiana", "letão-letã", "libanês-libanesa", "maliano-maliana", "marroquino-marroquina", "mexicano-mexicana", "nicaraguense-nicaraguense", "norueguês-norueguesa", "neozelandês-neozelandesa", "panamenho-panamenha", "paraguaio-paraguaia", "peruano-peruana", "polonês-polonesa", "português-portuguesa", "portorriquenho-portorriquenha", "dominicano-dominicana", "romeno-romena", "russo-russa", "sueco-sueca", "suíço-suíça", "tailandês-tailandesa", "taiwanês-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguaio-uruguaia", "venezuelano-venezuelana", "vietnamita-vietnamita"}));
		
		panel.add(txtNacionalidade);
		txtNacionalidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTelefone.setForeground(new Color(128, 128, 128));
		lblTelefone.setBounds(39, 421, 112, 21);
		panel.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(39, 446, 257, 39);
		txtTelefone.setFont(new Font("Dialog", Font.PLAIN, 16));
		panel.add(txtTelefone);

		JLabel lblNumero = new JLabel("Número de Reserva");
		lblNumero.setForeground(new Color(128, 128, 128));
		lblNumero.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNumero.setBounds(39, 484, 207, 21);
		panel.add(lblNumero);

		txtNreserva = new JTextField();
		txtNreserva.setColumns(10);
		txtNreserva.setBounds(39, 512, 257, 39);
		txtNreserva.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtNreserva.setEditable(false);
	
		txtNreserva.setText(String.valueOf(Reserva.getReservaKey()));
		
			panel.add(txtNreserva);

		JButton btnsalvar = new JButton("");
		btnsalvar.setIcon(new ImageIcon(RegistroHospede.class.getResource("/br/com/alura/hotel/images/disquete.png")));
		btnsalvar.setBackground(SystemColor.text);
		btnsalvar.setBounds(160, 567, 58, 52);
		panel.add(btnsalvar);
		btnsalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnsalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//valida data de nascimento para o formado do banco de dados
				Date dataNascimento = txtDataN.getDate();
				String dataNconvertida = dataVal.validarData(dataNascimento);
				
				//constroe a referência com os dados validados
				Hospedes hospede = new Hospedes(
						txtNome.getText(),
						txtSobrenome.getText(),
						dataNconvertida,
						txtNacionalidade.getSelectedItem().toString(),
						txtTelefone.getText(),
						Reserva.getReservaKey());//codigo da reserva gerado na classe ReservasView
				
				try {
					
					//armazena os dados da referência no banco e retorna o ID gerado;
					int hospedeID = hospedeController.salvar(hospede);
					
					JOptionPane.showMessageDialog(null, "Registro Salvo Com Sucesso! O Número"
							+ " da Reserva foi: " + hospede.getIdReserva());
					
					Sucesso sucesso = new Sucesso();
					sucesso.setVisible(true);
					dispose();
					
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Registro Não Efetuado, chame o Bat Man!");
					throw new RuntimeException(e1);
				}
				
				
				
			}
			
			
		});
		JButton btnCancelar = new JButton("");
		btnCancelar
				.setIcon(new ImageIcon(RegistroHospede.class.getResource("/br/com/alura/hotel/images/cancelar.png")));
		btnCancelar.setBackground(SystemColor.text);
		btnCancelar.setBounds(231, 567, 58, 52);
		btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel.add(btnCancelar);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario principal = new MenuUsuario();
				int sair = JOptionPane.showConfirmDialog(null, "Deseja mesmo Cancelar sem salvar?",
						"Selecione uma das opções", JOptionPane.YES_NO_OPTION);
				if (sair == 0)

					principal.setVisible(true);
//						reservaController.deleta(reservasKey); 
				dispose();
			}

		});

		JButton btnSair = new JButton("");
		btnSair.setBounds(298, 567, 58, 52);
		btnSair.setIcon(
				new ImageIcon(RegistroHospede.class.getResource("/br/com/alura/hotel/images/cerrar-sesion 32-px.png")));
		panel.add(btnSair);
		btnSair.setLayout(null);
//		btnSair.setBackground(SystemColor.text);
		btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		// sair
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sair =

						JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?", "Selecione uma das opções",
								JOptionPane.YES_NO_OPTION);
				if (sair == 0)
					System.exit(0);

			}

		});

		btnSair.setBackground(SystemColor.text);
		btnSair.setLayout(null);
		btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	}


	}


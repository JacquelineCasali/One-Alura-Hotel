package br.com.alura.hotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.util.List;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.com.alura.hotel.controller.HospedeController;
import br.com.alura.hotel.controller.ReservasController;
import br.com.alura.hotel.model.Hospedes;
import br.com.alura.hotel.model.Reservas;



@SuppressWarnings("serial")
public class Busca extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tableHospedes;
	private JTable tableReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHospedes;
	private HospedeController HospedeController = new HospedeController();
	private ReservasController ReservasController = new ReservasController();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busca frame = new Busca();
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
	public Busca() {
		setResizable(false);
		//setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
//			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// tamanho da tela
		contentPane.setBackground(SystemColor.control);
		setBounds(250, 80, 910, 580);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Busca.class.getResource("/br/com/alura/hotel/images/Ha-100px.png")));
		icone.setBounds(42, 11, 118, 98);
		contentPane.add(icone);

		JLabel lblSistemaDeBusca = new JLabel("Sistema de Busca");
		lblSistemaDeBusca.setForeground(new Color(12, 138, 199));
		lblSistemaDeBusca.setFont(new Font("Dialog", Font.BOLD, 24));
		lblSistemaDeBusca.setBounds(170, 40, 280, 42);
		contentPane.add(lblSistemaDeBusca);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(609, 51, 193, 31);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		// buscar
		JButton btnbusca = new JButton("");

		btnbusca.setIcon(new ImageIcon(Busca.class.getResource("/br/com/alura/hotel/images/lupa2.png")));
		btnbusca.setBackground(SystemColor.text);
		btnbusca.setBounds(812, 40, 52, 42);
		contentPane.add(btnbusca);
		btnbusca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnbusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				limparTabela();
				preencherTabelaReservasId();
				preencherTabelaHospedesId();
			}
		});

		// tabela
		JTabbedPane panel = new JTabbedPane(JTabbedPane.SCROLL_TAB_LAYOUT);
		panel.setBackground(SystemColor.text);
		panel.setFont(new Font("Dialog", Font.PLAIN, 16));
		panel.setBounds(20, 130, 865, 328);
		contentPane.add(panel);

		tableHospedes = new JTable();
		tableHospedes.setFillsViewportHeight(true);
		tableHospedes.setBackground(new Color(255, 255, 255));
		tableHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableHospedes.setFont(new Font("Dialog", Font.PLAIN, 16));

		modeloHospedes = (DefaultTableModel) tableHospedes.getModel();
		modeloHospedes.addColumn("Id");
		modeloHospedes.addColumn("Nome");
		modeloHospedes.addColumn("Sobrenome");
		modeloHospedes.addColumn("Data de Nascimento");
		modeloHospedes.addColumn("Nacionalidade");
		modeloHospedes.addColumn("Telefone");
		modeloHospedes.addColumn("Numero de Reserva");
		JScrollPane scrool_Hospede = new JScrollPane(tableHospedes);
		panel.addTab("Hóspedes", new ImageIcon(Busca.class.getResource("/br/com/alura/hotel/images/persona.png")),
				scrool_Hospede, null);

		scrool_Hospede.setVisible(true);
		preencherTabelaHospedes();

		tableReservas = new JTable();
		tableReservas.setFillsViewportHeight(true);
		tableReservas.setBackground(SystemColor.controlLtHighlight);

		tableReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableReservas.setFont(new Font("Dialog", Font.PLAIN, 16));

		modelo = (DefaultTableModel) tableReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Data Check In");
		modelo.addColumn("Data Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pagamento");
		JScrollPane scrool_Reservas = new JScrollPane(tableReservas);
		panel.addTab("Reservas", new ImageIcon(Busca.class.getResource("/br/com/alura/hotel/images/calendario.png")),
				scrool_Reservas, null);

		scrool_Reservas.setVisible(true);
		System.out.println("Lido");
		populaTabelaReservas();

		// botoes
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(Busca.class.getResource("/br/com/alura/hotel/images/editar-texto.png")));
		btnEditar.setForeground(SystemColor.control);
		btnEditar.setBackground(SystemColor.control);
		btnEditar.setBounds(572, 469, 58, 52);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);

		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int reservasSelecionadas = tableReservas.getSelectedRow();
				int hoespedesSelecionados = tableHospedes.getSelectedRow();

				if (reservasSelecionadas >= 0) {
					try {
						atualizarReservas();
					} catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					} finally {
						populaTabelaReservas();
					}
				} else if (hoespedesSelecionados >= 0) {
					try {
						alterarHospede();
					} catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					} finally {
						preencherTabelaHospedes();
					}
				}
			}
		});

			
			
			
			
		JButton btnDeletar = new JButton("");
		btnDeletar.setIcon(new ImageIcon(Busca.class.getResource("/br/com/alura/hotel/images/deletar.png")));
		btnDeletar.setForeground(SystemColor.control);
		btnDeletar.setBackground(SystemColor.control);
		btnDeletar.setBounds(650, 469, 58, 52);
		contentPane.add(btnDeletar);
		btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int reservasSelecionadas = tableReservas.getSelectedRow();
				int hospedesSelecionados = tableHospedes.getSelectedRow();

				if (reservasSelecionadas >= 0) {
					int confirmar = JOptionPane.showConfirmDialog(null, "Deseja mesmo deletar os dados?");
					if (confirmar == JOptionPane.YES_OPTION) {
						Object selecionado = (Object) modelo.getValueAt(tableReservas.getSelectedRow(),
								tableReservas.getSelectedColumn());
						Integer id = (Integer) selecionado;
						try {
							ReservasController.deleta(id);
							JOptionPane.showMessageDialog(null, "Item excluído com sucesso!");
							
							
							limparTabela();
							populaTabelaReservas();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									"Você possui um hospede cadastrado para essa reserva. Se deseja continuar, deverá excluí-lo primeiro.");
						}
					}
				} else if (hospedesSelecionados >= 0) {
					Object selecionado = (Object) modeloHospedes.getValueAt(tableHospedes.getSelectedRow(),
							tableHospedes.getSelectedColumn());
					if (selecionado instanceof Integer) {
						Integer id = (Integer) selecionado;
						HospedeController.deletaByIdReserva(id);
						JOptionPane.showMessageDialog(null, "Item excluído com sucesso!");
						
						limparTabela();
						preencherTabelaHospedes();
					} else {
						JOptionPane.showMessageDialog(null, "Por favor, selecionar o ID");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecionar o ID");
				}
			}
		});
		JButton btncancelar = new JButton("");
		btncancelar.setIcon(new ImageIcon(Busca.class.getResource("/br/com/alura/hotel/images/cancelar.png")));
		btncancelar.setBackground(SystemColor.control);
		btncancelar.setBounds(723, 469, 58, 52);
		contentPane.add(btncancelar);
		btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btncancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario menu = new MenuUsuario();
				menu.setVisible(true);
				dispose();
			}
		});

		JButton btnSair = new JButton("");
		btnSair.setIcon(
				new ImageIcon(Busca.class.getResource("/br/com/alura/hotel/images/cerrar-sesion 32-px.png")));
		btnSair.setBounds(827, 469, 58, 52);
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

	}

	private void limparTabela() {
		((DefaultTableModel) tableHospedes.getModel()).setRowCount(0);
		((DefaultTableModel) tableReservas.getModel()).setRowCount(0);
	}
	
	
	private void populaTabelaReservas() {
		List<Reservas> listaReservas = ReservasController.lista();

		for (Reservas item : listaReservas) {
			modelo.addRow(new Object[] { item.getId(), item.getDataEntrada(), item.getDataSaida(), item.getValor(),
					item.getFORMADEPAGAMENTO() });
		}
	}
	private void preencherTabelaHospedes() {
	    //Preencher Tabela
		List<Hospedes> hospedesLista = HospedeController.lista();
		try {
			for (Hospedes hospede : hospedesLista) {
				modeloHospedes.addRow(new Object[] { hospede.getId(), hospede.getNome(), hospede.getSobrenome(), hospede.getDataNascimento(), hospede.getNacionalidade(), hospede.getTelefone(), hospede.getIdReserva() });
			}
		} catch (Exception e) {
			throw e;
		}
	}
		
	private void preencherTabelaReservasId() {

	    // Povoar tabela
		List<Reservas> reservaLista = ReservasController.buscarId(txtBuscar.getText());
		try {
			for (Reservas reserva : reservaLista) {
				modelo.addRow(new Object[] { reserva.getId(), reserva.getDataEntrada(), reserva.getDataSaida(), reserva.getValor(), reserva.getFORMADEPAGAMENTO() });
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void preencherTabelaHospedesId() {
	    //Preencher Tabela
		List<Hospedes> hospedesLista = HospedeController.listarHospedesId(txtBuscar.getText());
		
	
		try {
			for (Hospedes hospede : hospedesLista) {
				modeloHospedes.addRow(new Object[] { hospede.getId(), hospede.getNome(), hospede.getSobrenome(), hospede.getDataNascimento(), hospede.getNacionalidade(), hospede.getTelefone(), hospede.getIdReserva() });
			}
		} catch (Exception e) {
			throw e;
		}
	}
	private void atualizarReservas() {
		Object objetoDaLinha = (Object) modelo.getValueAt(tableReservas.getSelectedRow(), tableReservas.getSelectedColumn());
if(objetoDaLinha instanceof Integer) {
	Integer id = (Integer) objetoDaLinha;
	String dataEntrada = (String) modelo.getValueAt(tableReservas.getSelectedRow(), 1);
	String dataSaida = (String) modelo.getValueAt(tableReservas.getSelectedRow(), 2);
	String valor = (String) modelo.getValueAt(tableReservas.getSelectedRow(), 3);
	String FORMADEPAGAMENTO = (String) modelo.getValueAt(tableReservas.getSelectedRow(), 4);
	
	
	ReservasController.atualizar(dataEntrada, dataSaida, Double.parseDouble(valor), FORMADEPAGAMENTO.toUpperCase(), id);
	
}else {
	JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
}
}
	private void alterarHospede() {
		Object objetoDaLinha = (Object) modeloHospedes.getValueAt(tableHospedes.getSelectedRow(), tableHospedes.getSelectedColumn());
		if (objetoDaLinha instanceof Integer) {
			Integer id = (Integer) objetoDaLinha;
			String nome = (String) modeloHospedes.getValueAt(tableHospedes.getSelectedRow(), 1);
			String sobreNome = (String) modeloHospedes.getValueAt(tableHospedes.getSelectedRow(), 2);
			String dataNascimento = (String) modeloHospedes.getValueAt(tableHospedes.getSelectedRow(), 3);
			String nacionalidade = (String) modeloHospedes.getValueAt(tableHospedes.getSelectedRow(), 4);
			String telefone = (String) modeloHospedes.getValueAt(tableHospedes.getSelectedRow(), 5);
			HospedeController.atualizar(nome.toUpperCase(), sobreNome.toUpperCase(),dataNascimento, nacionalidade.toUpperCase(), telefone, id);
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
		}
	}		
	

	
}



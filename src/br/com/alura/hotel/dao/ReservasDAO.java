package br.com.alura.hotel.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.hotel.model.Reservas;



public class ReservasDAO {
	private Connection connection;

	public ReservasDAO(Connection connection) {
		this.connection = connection;
	}

	public int salvar(Reservas reserva) {
		try {

			String sql = "INSERT INTO reservas " + "(DATAENTRADA, DATASAIDA, VALOR, FORMADEPAGAMENTO) "
					+ "VALUES(?,?,?,?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, reserva.getDataEntrada());
				pstm.setString(2, reserva.getDataSaida());
				pstm.setDouble(3, reserva.getValor());
				pstm.setString(4, reserva.getFORMADEPAGAMENTO().toUpperCase());
			
				
				pstm.executeUpdate();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						reserva.setId(rst.getInt(1));
					}
				}
			}
			return reserva.getId();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public List<Reservas> listar() {
		List<Reservas> reservas = new ArrayList<Reservas>();
		
		try {
				
					String sql = "SELECT id,DATAENTRADA, DATASAIDA, valor, FORMADEPAGAMENTO FROM reservas";
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();
				transformarResultSetEmReserva(reservas, pstm);
			}
			
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
			
			

				}
			}

		

	public List<Reservas> buscarId(String id) {
		List<Reservas> reservas = new ArrayList<Reservas>();
		try {

			String sql = "SELECT id, DATAENTRADA, DATASAIDA, valor, FORMADEPAGAMENTO FROM reservas WHERE id = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();

				transformarResultSetEmReserva(reservas, pstm);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	public void deletar(int id) {
		try {
			String sql = "DELETE FROM RESERVAS WHERE ID = ?";
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setInt(1, id);
				pstm.execute();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public void atualizar(String  dataEntrada, String  dataSaida, Double valor, String formaPagamento, Integer id) {
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE reservas SET DATAENTRADA = ?, DATASAIDA = ?, valor = ?, FORMADEPAGAMENTO = ? WHERE id = ?")) {
			stm.setString(1, dataEntrada);
			stm.setString(2, dataSaida);
			stm.setDouble(3, valor);
			stm.setString(4, formaPagamento);
			stm.setInt(5, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void transformarResultSetEmReserva(List<Reservas> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Reservas reserva = new Reservas(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getString(5));

				reservas.add(reserva);
			}
		}
	}
}
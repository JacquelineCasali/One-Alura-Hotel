package br.com.alura.hotel.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.hotel.model.Hospedes;



public class HospedesDAO {
	private Connection connection;

	public HospedesDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Hospedes hospedes) {
		try {

			String sql = "INSERT INTO HOSPEDES "
					+ "(NOME, SOBRENOME, DATANASCIMENTO, NACIONALIDADE, TELEFONE, IdRESERVA) " + "VALUES(?,?,?,?,?,?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, hospedes.getNome().toUpperCase().trim());
				pstm.setString(2, hospedes.getSobrenome().toUpperCase().trim());
				pstm.setString(3, hospedes.getDataNascimento());
				pstm.setString(4, hospedes.getNacionalidade().toUpperCase());
				pstm.setString(5, hospedes.getTelefone());
				pstm.setInt(6, hospedes.getIdReserva());

				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						hospedes.setId(rst.getInt(1));
					}
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public List<Hospedes> listar() {
		List<Hospedes> hospedes = new ArrayList<>();
		try {
			String sql = "SELECT id, nome, sobrenome, dataNascimento, nacionalidade, telefone, idReserva FROM hospedes";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();
				transformarResultSetEmHospede(hospedes, pstm);
			}
			return hospedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Hospedes> buscaNome(String nome) {
			List<Hospedes> hospedes  = new ArrayList<Hospedes>();
			try {

				String sql = "SELECT id, nome, sobrenome, dataNascimento, nacionalidade, telefone, idReserva FROM hospedes WHERE nome=?";
						

				try (PreparedStatement pstm = connection.prepareStatement(sql)) {
					pstm.setString(1, nome);
					pstm.execute();
					transformarResultSetEmHospede(hospedes, pstm);
					
				}
				return hospedes ;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	
	public void atualizar(String nome, String sobrenome, String dataNascimento, String nacionalidade, String telefone,  Integer id) {
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE hospedes SET nome = ?, sobrenome = ?, dataNascimento = ?, nacionalidade = ?, telefone = ?, idReserva = ? WHERE id = ?")) {
			stm.setString(1, nome);
			stm.setString(2, sobrenome);
			stm.setString(3, dataNascimento);
			stm.setString(4, nacionalidade);
			stm.setString(5, telefone);
			stm.setInt(7, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletaByreserva(int id) {
		String sql = "DELETE FROM HOSPEDES WHERE id = ?";
		try {
			try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pstm.setInt(1, id);
				pstm.execute();
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}
	
	private void transformarResultSetEmHospede(List<Hospedes> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Hospedes hospedes = new Hospedes(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getInt(7));
				reservas.add(hospedes);
			}
		}	
	
}
	}
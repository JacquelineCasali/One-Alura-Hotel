package br.com.alura.hotel.controller;

import java.sql.Connection;

import java.util.List;

import br.com.alura.hotel.conexao.Conexao;
import br.com.alura.hotel.dao.HospedesDAO;
import br.com.alura.hotel.model.Hospedes;


public class HospedeController {
 private HospedesDAO hospedesDAO;

 public HospedeController() {
			Connection connection = new Conexao().criaConexao();
		this.hospedesDAO = new HospedesDAO(connection);
		}

	public int salvar(Hospedes hospedes) {
		this.hospedesDAO.salvar(hospedes);
		return hospedes.getId();
	}
 
	public List<Hospedes> lista() {
		return this.hospedesDAO.listar();
	}
	
	public List<Hospedes> listarHospedesId(String nome) {
		return this.hospedesDAO.buscaNome(nome);
	}
		
	
	public void atualizar(String nome, String sobreNome, String dataNascimento, String nacionalidade, String telefone,
			Integer id) {
		hospedesDAO.atualizar(nome, sobreNome, dataNascimento, nacionalidade, telefone, id);
		
	}
	public void deletaByIdReserva(int id) {
		hospedesDAO.deletaByreserva(id);
	}
}
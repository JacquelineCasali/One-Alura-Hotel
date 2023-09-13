package br.com.alura.hotel.controller;


import java.sql.Connection;

import java.util.List;

import br.com.alura.hotel.conexao.Conexao;

import br.com.alura.hotel.dao.ReservasDAO;
import br.com.alura.hotel.model.Reservas;

public class ReservasController {
	private ReservasDAO reservasDao;
	
	
	public   ReservasController(){
		Connection connection = new Conexao().criaConexao();
		this.reservasDao = new ReservasDAO(connection);
	}
	
	public int salvar(Reservas reserva) {
		this.reservasDao.salvar(reserva);
		return reserva.getId();
	}
	
	public List<Reservas> lista(){
		return reservasDao.listar();
	}
	
	public List<Reservas> buscarId(String id) {
		return this.reservasDao.buscarId(id);
	}
	public void atualizar(String dataEntrada, String dataSaida, Double valor, String FORMADEPAGAMENTO, Integer id) {
		reservasDao.atualizar(dataEntrada, dataSaida, valor, FORMADEPAGAMENTO, id);
		
	}
	
	public void deleta(int id) {
		reservasDao.deletar(id);
	}
}

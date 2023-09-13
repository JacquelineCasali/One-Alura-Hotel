package br.com.alura.hotel.conexao;






import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Conexao {
public DataSource dataSource;


public Conexao (){
	ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
	comboPooledDataSource.setJdbcUrl("jdbc:mysql://127.0.0.1/hotel");
	comboPooledDataSource.setUser("root");
	comboPooledDataSource.setPassword("");
	this.dataSource = comboPooledDataSource;
}

public Connection criaConexao() {
	try {
		return this.dataSource.getConnection();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}
}
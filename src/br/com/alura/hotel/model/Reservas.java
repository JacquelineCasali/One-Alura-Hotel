package br.com.alura.hotel.model;





public class Reservas {

	public int id;
	public String  dataEntrada;
	public String  dataSaida;
	public double  valor;
	public String FORMADEPAGAMENTO;

	

	public Reservas(String  dataEntrada, String  dataSaida,  double  valor, String FORMADEPAGAMENTO) {
		
		
			
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.FORMADEPAGAMENTO = FORMADEPAGAMENTO;
	}
	
	public Reservas(int id, String  dataEntrada, String  dataSaida, double  valor, String FORMADEPAGAMENTO) {
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.FORMADEPAGAMENTO = FORMADEPAGAMENTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String  getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String  dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String  getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String  dataSaida) {
		this.dataSaida = dataSaida;
	}

	public double  getValor() {
		return valor;
	}

	public void setValor(double  valor) {
		this.valor = valor;
	}

	
	

	public String getFORMADEPAGAMENTO() {
		return FORMADEPAGAMENTO;
	}

	public void setFORMADEPAGAMENTO(String FORMADEPAGAMENTO) {
		this.FORMADEPAGAMENTO = FORMADEPAGAMENTO;
	}
	
	
	
	
	
	

}

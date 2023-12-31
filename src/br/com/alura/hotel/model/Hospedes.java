package br.com.alura.hotel.model;



public class Hospedes {
	private int Id;
	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private String nacionalidade;
	private String telefone;
	private int idReserva;
	 
	public Hospedes(String nome, String sobrenome,String dataNascimento, String nacionalidade, String telefone,
			int idReserva) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.telefone =telefone;
		this.idReserva = idReserva;
		
	}
	
	public Hospedes(int id, String nome, String sobrenome, String dataNascimento, String nacionalidade, String telefone,
			int idReserva) {
		super();
		Id=id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.telefone =telefone;
		this.idReserva = idReserva;
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	
	
}
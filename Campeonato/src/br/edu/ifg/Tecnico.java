package br.edu.ifg;

public class Tecnico extends Pessoa{
	private String nomeDoTimmeQueComanda;
	
	public Tecnico(String nome, String funcao, String nomeTimeQueComanda) {
		super(nome,funcao);
		this.nomeDoTimmeQueComanda = nomeTimeQueComanda;
	}

	public String getNomeDoTimmeQueComanda() {
		return nomeDoTimmeQueComanda;
	}

	public void setNomeDoTimmeQueComanda(String nomeDoTimmeQueComanda) {
		this.nomeDoTimmeQueComanda = nomeDoTimmeQueComanda;
	}
}
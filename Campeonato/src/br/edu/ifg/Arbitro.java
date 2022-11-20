package br.edu.ifg;

public class Arbitro extends Pessoa{
	private String[] nomeJogoArbitragem;
	
	public Arbitro(String nome, String funcao) {
		super(nome,funcao);
	}

	public String[] getNomeJogoArbitragem() {
		return nomeJogoArbitragem;
	}

	public void setNomeJogoArbitragem(String[] nomeJogoArbitragem) {
		this.nomeJogoArbitragem = nomeJogoArbitragem;
	}
	
	
}
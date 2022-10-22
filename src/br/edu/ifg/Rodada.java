package br.edu.ifg;

public class Rodada {
	private int numRodada;
	private Jogo[] jogosDaRodada;
	
	public Rodada(Jogo[] jogosDaRodada) {
		this.jogosDaRodada = jogosDaRodada;
	}

	public int getNumRodada() {
		return numRodada;
	}

	public void setNumRodada(int numRodada) {
		this.numRodada = numRodada;
	}

	public Jogo[] getJogosDaRodada() {
		return jogosDaRodada;
	}

	public void setJogosDaRodada(Jogo[] jogosDaRodada) {
		this.jogosDaRodada = jogosDaRodada;
	}
}
package br.edu.ifg;

import java.util.Map;

public class Rodada {
	private int numRodada;
	private Map<Integer,Jogo> jogosDaRodada;
	
	public Rodada(Map<Integer,Jogo> jogosDaRodada,int numRodada) {
		this.jogosDaRodada = jogosDaRodada;
		this.numRodada = numRodada;
	}

	public int getNumRodada() {
		return numRodada;
	}

	public void setNumRodada(int numRodada) {
		this.numRodada = numRodada;
	}

	public Map<Integer,Jogo> getJogosDaRodada() {
		return jogosDaRodada;
	}

	public void setJogosDaRodada(Map<Integer,Jogo> jogosDaRodada) {
		this.jogosDaRodada = jogosDaRodada;
	}
}
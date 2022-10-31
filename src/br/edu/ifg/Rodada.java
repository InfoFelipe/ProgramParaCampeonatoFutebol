package br.edu.ifg;

import java.util.ArrayList;

public class Rodada {
	private int numRodada;
	private ArrayList<Jogo> jogosDaRodada;
	
	public Rodada(ArrayList<Jogo> jogosDaRodada,int numRodada) {
		this.jogosDaRodada = jogosDaRodada;
		this.numRodada = numRodada;
	}

	public int getNumRodada() {
		return numRodada;
	}

	public void setNumRodada(int numRodada) {
		this.numRodada = numRodada;
	}

	public ArrayList<Jogo> getJogosDaRodada() {
		return jogosDaRodada;
	}

	public void setJogosDaRodada(ArrayList<Jogo> jogosDaRodada) {
		this.jogosDaRodada = jogosDaRodada;
	}
}
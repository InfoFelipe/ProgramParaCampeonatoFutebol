package br.edu.ifg;

public class Jogador extends Pessoa{
	private String timeEmQueJoga;
	
	public Jogador(String nome, String funcao, String timeEmQueJoga) {
		super(nome,funcao);
		this.timeEmQueJoga = timeEmQueJoga;
	}

	public String getTimeEmQueJoga() {
		return timeEmQueJoga;
	}

	public void setTimeEmQueJoga(String timeEmQueJoga) {
		this.timeEmQueJoga = timeEmQueJoga;
	}
}
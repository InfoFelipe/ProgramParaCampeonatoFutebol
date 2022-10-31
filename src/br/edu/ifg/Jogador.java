package br.edu.ifg;

public class Jogador extends Pessoa{
	private String timeEmQueJoga;
	private TipoJogador tipoDoJogador;
	private String tipoJogador;
	
	public Jogador(String nome, String funcao, String timeEmQueJoga,String tipoJogador) {
		super(nome,funcao);
		this.timeEmQueJoga = timeEmQueJoga;
		this.tipoDoJogador = TipoJogador.valueOf(tipoJogador);
		this.tipoDoJogador();
	}
	public void tipoDoJogador() {
		switch (tipoDoJogador) {
		case IMPORTANTE:
			this.tipoJogador = "Importante";
			break;
		case ROTATIVO:
			this.tipoJogador = "Rotativo";
			break;
		}
	}

	public String getTimeEmQueJoga() {
		return timeEmQueJoga;
	}

	public void setTimeEmQueJoga(String timeEmQueJoga) {
		this.timeEmQueJoga = timeEmQueJoga;
	}
	public TipoJogador getTipoDoJogador() {
		return tipoDoJogador;
	}
	public void setTipoDoJogador(TipoJogador tipoDoJogador) {
		this.tipoDoJogador = tipoDoJogador;
	}
	public String getTipoJogador() {
		return tipoJogador;
	}
	public void setTipoJogador(String tipoJogador) {
		this.tipoJogador = tipoJogador;
	}
	
	
}
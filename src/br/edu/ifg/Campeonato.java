package br.edu.ifg;

public class Campeonato {
	private int quantTotalRodadas;
	private int numTotalEquipes;
	private String vencedorDoCampeonato;
	private TipoCampeonato tipoDoCampeonato;
	private String tipoCampeonato;
	
	public Campeonato(int numTotalEquipes,String tipoDoCampeonato) {
		this.numTotalEquipes = numTotalEquipes;
		this.tipoDoCampeonato = TipoCampeonato.valueOf(tipoDoCampeonato);
		this.calcularNumRodadas();
		this.tipoCampeonato();	
	}
	
	public void tipoCampeonato() {
		switch (tipoDoCampeonato) {
			case PRIMEIRA_DIVISAO:
				this.tipoCampeonato = "Primiera Divisao";
				break;
			case SEGUNDA_DIVISAO:
				this.tipoCampeonato = "Segunda Divisao";
				break;
			case ESTADUAL:
				this.tipoCampeonato = "Estadual";
				break;
		}
	}
	
	public void calcularNumRodadas() {
		int totalRodadas;
		totalRodadas = (this.getNumTotalEquipes() - 1) * 2;
		this.setQuantTotalRodadas(totalRodadas);
	}
	
	public void mostrarCampeao() {
		//Falta a implementação 
	}
	
	public int getQuantTotalRodadas() {
		return quantTotalRodadas;
	}
	public void setQuantTotalRodadas(int quantTotalRodadas) {
		this.quantTotalRodadas = quantTotalRodadas;
	}
	public int getNumTotalEquipes() {
		return numTotalEquipes;
	}
	public void setNumTotalEquipes(int numTotalEquipes) {
		this.numTotalEquipes = numTotalEquipes;
	}
	public String getVencedorDoCampeonato() {
		return vencedorDoCampeonato;
	}
	public void setVencedorDoCampeonato(String vencedorDoCampeonato) {
		this.vencedorDoCampeonato = vencedorDoCampeonato;
	}

	public TipoCampeonato getTipoDoCampeonato() {
		return tipoDoCampeonato;
	}

	public void setTipoDoCampeonato(TipoCampeonato tipoDoCampeonato) {
		this.tipoDoCampeonato = tipoDoCampeonato;
	}

	public String getTipoCampeonato() {
		return tipoCampeonato;
	}

	public void setTipoCampeonato(String tipoCampeonato) {
		this.tipoCampeonato = tipoCampeonato;
	}
	
	 
}

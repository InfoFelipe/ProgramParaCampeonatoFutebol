package br.edu.ifg;

public class Campeonato {
	private int quantTotalRodadas;
	private int numTotalEquipes;
	private String vencedorDoCampeonato;
	//Estudar como funciona o enum ainda
	
	//public enum tipoDoCampeonato{
		//A('Primeira Divisao'), B('Sengunda Divisao'), C('Estadual');
		
		//public void tipoCampeonato
	//}
	
	public Campeonato(int numTotalEquipes) {
		this.numTotalEquipes = numTotalEquipes;
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
	 
}

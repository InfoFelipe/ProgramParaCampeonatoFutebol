package br.edu.ifg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Time {
	private String nomeTime;
	private Map<String, Jogador> jogadores = new HashMap<>();
	private String nomeDoEstadio;
	private Tecnico tecnico;
	private int pontuacaoTimeCampeonato;
	private int quantGolsFeitos;
	private int quantGolsTomados;
	private int saldoDeGols;
	private int numVitoria;
	private int numDerrota;
	private int numEmpate;
	
	public Time(String nomeTime,
			Map<String, Jogador> jogadores,
				String nomeDoEstadio,
				Tecnico tecnico) {
		this.nomeTime = nomeTime;
		this.jogadores = jogadores;
		this.nomeDoEstadio = nomeDoEstadio;
		this.tecnico = tecnico;
		this.pontuacaoTimeCampeonato = 0;
		this.numDerrota = 0;
		this.numEmpate = 0;
		this.numVitoria = 0;
		this.quantGolsFeitos = 0;
		this.quantGolsTomados = 0;
		this.saldoDeGols = 0;
	}
	
	public void somarVitoria() {
		int vitoria = this.getNumVitoria() + 1;
		this.setNumVitoria(vitoria);
	}
	
	public void somarDerrota() {
		int derrota = this.getNumDerrota() + 1;
		this.setNumDerrota(derrota);
	}

	public void somarEmpate() {
		int empate = this.getNumEmpate() + 1;
		this.setNumEmpate(empate);
	}
	
	public void somarGolsFeitos(int gols) {
		int numGol = this.getQuantGolsFeitos() + gols;
		this.setQuantGolsFeitos(numGol);
	}
	
	public void somarGolsTomados(int gols) {
		int numGols = this.getQuantGolsTomados() + gols;
		this.setQuantGolsTomados(numGols);
	}
	
	public void somarSaldoDeGols() {
		int saldoGol = this.getQuantGolsFeitos() - this.getQuantGolsTomados();
		this.setSaldoDeGols(saldoGol);
 	}
	
	public void calcularPontuacao() {
		int pontuacao;
		pontuacao = (this.getNumVitoria() * 3) + this.getNumEmpate();
		this.setPontuacaoTimeCampeonato(pontuacao);
	}
	
	public void exibirEscalacao() {
		int count = 1;
		Map<String,Jogador> jogadores = this.getJogadores();
			for (String key : jogadores.keySet()) {
				System.out.println(jogadores.get(key).getNome());
				count++;
				if(count == 12) {
					break;
				}
			}
	}

	/*
	 * Inicio dos metodos gets e setters
	 */
	public String getNomeTime() {
		return nomeTime;
	}

	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}

	public Map<String, Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(Map<String, Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public String getNomeDoEstadio() {
		return nomeDoEstadio;
	}

	public void setNomeDoEstadio(String nomeDoEstadio) {
		this.nomeDoEstadio = nomeDoEstadio;
	}

	public int getPontuacaoTimeCampeonato() {
		return pontuacaoTimeCampeonato;
	}

	public void setPontuacaoTimeCampeonato(int pontuacaoTimeCampeonato) {
		this.pontuacaoTimeCampeonato = pontuacaoTimeCampeonato;
	}

	public int getQuantGolsFeitos() {
		return quantGolsFeitos;
	}

	public void setQuantGolsFeitos(int quantGolsFeitos) {
		this.quantGolsFeitos = quantGolsFeitos;
	}

	public int getQuantGolsTomados() {
		return quantGolsTomados;
	}

	public void setQuantGolsTomados(int quantGolsTomados) {
		this.quantGolsTomados = quantGolsTomados;
	}

	public int getSaldoDeGols() {
		return saldoDeGols;
	}

	public void setSaldoDeGols(int saldoDeGols) {
		this.saldoDeGols = saldoDeGols;
	}

	public int getNumVitoria() {
		return numVitoria;
	}

	public void setNumVitoria(int numVitoria) {
		this.numVitoria = numVitoria;
	}

	public int getNumDerrota() {
		return numDerrota;
	}

	public void setNumDerrota(int numDerrota) {
		this.numDerrota = numDerrota;
	}

	public int getNumEmpate() {
		return numEmpate;
	}

	public void setNumEmpate(int numEmpate) {
		this.numEmpate = numEmpate;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
}
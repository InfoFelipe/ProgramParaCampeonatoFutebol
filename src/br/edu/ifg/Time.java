package br.edu.ifg;
import java.util.Random;

public class Time {
	private String nomeTime;
	private Jogador[] jogadores;
	private String nomeDoEstadio;
	private int pontuacaoTimeCampeonato;
	private int quantGolsFeitos;
	private int quantGolsTomados;
	private int saldoDeGols;
	private int numVitoria;
	private int numDerrota;
	private int numEmpate;
	
	public Time(String nomeTime,
				Jogador[] jogadores,
				String nomeDoEstadio) {
		this.nomeTime = nomeTime;
		this.jogadores = jogadores;
		this.nomeDoEstadio = nomeDoEstadio;
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
	
	public void exibirEscalacao() {
		//Implementar a regra de negocio ainda
		int count = 0;
		Random aleatorio = new Random();
		for (int i = 0; i < this.jogadores.length; i++) {
			if(count == 22) {
				break;
			}
			int num = aleatorio.nextInt(3);
			if((num < 2  && count == 0) && jogadores[i].getTipoJogador() ==  "Importante") {
				System.out.println(jogadores[i].getNome()+" Funcao: " +jogadores[i].getFuncao());
			}else if((num == 2 && count == 0) && jogadores[i+1].getTipoJogador() ==  "Rotativo") {
				System.out.println(jogadores[i+1].getNome()+" Funcao: " +jogadores[i+1].getFuncao());
			}else if((num < 2 && count == 2) && jogadores[i].getTipoJogador() == "Importante") {
				System.out.println(jogadores[i].getNome()+" Funcao: " +jogadores[i].getFuncao());
			}else if((num == 2 && count == 2) && jogadores[i+1].getTipoJogador() ==  "Rotativo") {
				System.out.println(jogadores[i+1].getNome()+" Funcao: " +jogadores[i+1].getFuncao());
			}else if((num < 2 && count == 4) && jogadores[i].getTipoJogador() == "Importante") {
				System.out.println(jogadores[i].getNome()+" Funcao: " +jogadores[i].getFuncao());
			}else if((num == 2 && count == 4) && jogadores[i+1].getTipoJogador() ==  "Rotativo") {
				System.out.println(jogadores[i+1].getNome()+" Funcao: " +jogadores[i+1].getFuncao());
			}else if((num < 2 && count == 6) && jogadores[i].getTipoJogador() == "Importante") {
				System.out.println(jogadores[i].getNome()+" Funcao: " +jogadores[i].getFuncao());
			}else if((num == 2 && count == 6) && jogadores[i+1].getTipoJogador() ==  "Rotativo") {
				System.out.println(jogadores[i+1].getNome()+" Funcao: " +jogadores[i+1].getFuncao());
			}else if((num < 2 && count == 8) && jogadores[i].getTipoJogador() == "Importante") {
				System.out.println(jogadores[i].getNome()+" Funcao: " +jogadores[i].getFuncao());
			}else if((num == 2 && count == 8) && jogadores[i+1].getTipoJogador() ==  "Rotativo") {
				System.out.println(jogadores[i+1].getNome()+" Funcao: " +jogadores[i+1].getFuncao());
			}else if((num < 2 && count == 10) && jogadores[i].getTipoJogador() == "Importante") {
				System.out.println(jogadores[i].getNome()+" Funcao: " +jogadores[i].getFuncao());
			}else if((num == 2 && count == 10) && jogadores[i+1].getTipoJogador() ==  "Rotativo") {
				System.out.println(jogadores[i+1].getNome()+" Funcao: " +jogadores[i+1].getFuncao());
			}else if((num < 2 && count == 12) && jogadores[i].getTipoJogador() == "Importante") {
				System.out.println(jogadores[i].getNome()+" Funcao: " +jogadores[i].getFuncao());
			}else if((num == 2 && count == 12) && jogadores[i+1].getTipoJogador() ==  "Rotativo") {
				System.out.println(jogadores[i+1].getNome()+" Funcao: " +jogadores[i+1].getFuncao());
			}else if((num < 2 && count == 14) && jogadores[i].getTipoJogador() == "Importante") {
				System.out.println(jogadores[i].getNome()+" Funcao: " +jogadores[i].getFuncao());
			}else if((num == 2 && count == 14) && jogadores[i+1].getTipoJogador() ==  "Rotativo") {
				System.out.println(jogadores[i+1].getNome()+" Funcao: " +jogadores[i+1].getFuncao());
			}else if((num < 2 && count == 16) && jogadores[i].getTipoJogador() == "Importante") {
				System.out.println(jogadores[i].getNome()+" Funcao: " +jogadores[i].getFuncao());
			}else if((num == 2 && count == 16) && jogadores[i+1].getTipoJogador() ==  "Rotativo") {
				System.out.println(jogadores[i+1].getNome()+" Funcao: " +jogadores[i+1].getFuncao());
			}else if((num < 2 && count == 18) && jogadores[i].getTipoJogador() == "Importante") {
				System.out.println(jogadores[i].getNome()+" Funcao: " +jogadores[i].getFuncao());
			}else if((num == 2 && count == 18) && jogadores[i+1].getTipoJogador() ==  "Rotativo") {
				System.out.println(jogadores[i+1].getNome()+" Funcao: " +jogadores[i+1].getFuncao());
			}else if((num < 2 && count == 20) && jogadores[i].getTipoJogador() == "Importante") {
				System.out.println(jogadores[i].getNome()+" Funcao: " +jogadores[i].getFuncao());
			}else if((num == 2 && count == 20) && jogadores[i+1].getTipoJogador() ==  "Rotativo") {
				System.out.println(jogadores[i+1].getNome()+" Funcao: " +jogadores[i+1].getFuncao());
			}else if((num < 2 && count == 22) && jogadores[i].getTipoJogador() == "Importante") {
				System.out.println(jogadores[i].getNome()+" Funcao: " +jogadores[i].getFuncao());
			}else if((num == 2 && count == 22) && jogadores[i+1].getTipoJogador() ==  "Rotativo") {
				System.out.println(jogadores[i+1].getNome()+" Funcao: " +jogadores[i+1].getFuncao());
			}
			count++;
		}
	}
	
	public void calcularPontuacao() {
		int pontuacao;
		pontuacao = (this.getNumVitoria() * 3) + this.getNumEmpate();
		this.setPontuacaoTimeCampeonato(pontuacao);
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

	public Jogador[] getJogadores() {
		return jogadores;
	}

	public void setJogadores(Jogador[] jogadores) {
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

}
package br.edu.ifg;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Time {
	private String nomeTime;
	private Map<String, Jogador> jogadores = new HashMap<String,Jogador>();
	private String nomeDoEstadio;
	private int pontuacaoTimeCampeonato;
	private int quantGolsFeitos;
	private int quantGolsTomados;
	private int saldoDeGols;
	private int numVitoria;
	private int numDerrota;
	private int numEmpate;
	
	public Time(String nomeTime,
			Map<String, Jogador> jogadores,
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
		int count = 1;
		Map<String,Jogador> jogadores = this.jogadores;
		Random aleatorio = new Random();
		for(int i = 0;i<11;i++) {
			int num = aleatorio.nextInt(3);
			for (String key : jogadores.keySet()) {
				if((num > 2 && count == 1) 
					&& (jogadores.get(key).getTipoJogador() == "Importante"
					&& jogadores.get(key).getFuncao() == "GOLEIRO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num == 2 && count == 1) 
					&& (jogadores.get(key).getTipoJogador() == "Rotativo" 
					&& jogadores.get(key).getFuncao() == "GOLEIRO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num > 2 && count == 2) 
						&& (jogadores.get(key).getTipoJogador() == "Importante" 
						&& jogadores.get(key).getFuncao() == "LATERAL-DIREITO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num == 2 && count == 2) 
						&& (jogadores.get(key).getTipoJogador() == "Rotativo" 
						&& jogadores.get(key).getFuncao() == "LATERAL-DIREITO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num > 2 && count == 3) 
						&& (jogadores.get(key).getTipoJogador() == "Importante" 
						&& jogadores.get(key).getFuncao() == "ZAGUEIRO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num == 2 && count == 3) 
						&& (jogadores.get(key).getTipoJogador() == "Rotativo" 
						&& jogadores.get(key).getFuncao() == "ZAGUEIRO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num > 2 && count == 4) 
						&& (jogadores.get(key).getTipoJogador() == "Importante" 
						&& jogadores.get(key).getFuncao() == "ZAGUEIRO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num == 2 && count == 4) 
						&& (jogadores.get(key).getTipoJogador() == "Rotativo" 
						&& jogadores.get(key).getFuncao() == "ZAGUEIRO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num > 2 && count == 5) 
						&& (jogadores.get(key).getTipoJogador() == "Importante" 
						&& jogadores.get(key).getFuncao() == "LATERAL-ESQUERDO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num == 2 && count == 5) 
						&& (jogadores.get(key).getTipoJogador() == "Rotativo" 
						&& jogadores.get(key).getFuncao() == "LATERAL-ESQUERDO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num > 2 && count == 6) 
						&& (jogadores.get(key).getTipoJogador() == "Importante" 
						&& jogadores.get(key).getFuncao() == "MEIO DE CAMPO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num == 2 && count == 6) 
						&& (jogadores.get(key).getTipoJogador() == "Rotativo" 
						&& jogadores.get(key).getFuncao() == "MEIO DE CAMPO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num > 2 && count == 7) 
						&& (jogadores.get(key).getTipoJogador() == "Importante" 
						&& jogadores.get(key).getFuncao() == "MEIO DE CAMPO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num == 2 && count == 7) 
						&& (jogadores.get(key).getTipoJogador() == "Rotativo" 
						&& jogadores.get(key).getFuncao() == "MEIO DE CAMPO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num > 2 && count == 8) 
						&& (jogadores.get(key).getTipoJogador() == "Importante" 
						&& jogadores.get(key).getFuncao() == "MEIO DE CAMPO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num == 2 && count == 8) 
						&& (jogadores.get(key).getTipoJogador() == "Rotativo" 
						&& jogadores.get(key).getFuncao() == "MEIO DE CAMPO")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num > 2 && count == 9) 
						&& (jogadores.get(key).getTipoJogador() == "Importante" 
						&& jogadores.get(key).getFuncao() == "ATACANTE")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num == 2 && count == 9) 
						&& (jogadores.get(key).getTipoJogador() == "Rotativo" 
						&& jogadores.get(key).getFuncao() == "ATACANTE")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num > 2 && count == 10) 
						&& (jogadores.get(key).getTipoJogador() == "Importante" 
						&& jogadores.get(key).getFuncao() == "ATACANTE")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num == 2 && count == 10) 
						&& (jogadores.get(key).getTipoJogador() == "Rotativo" 
						&& jogadores.get(key).getFuncao() == "ATACANTE")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num > 2 && count == 11) 
						&& (jogadores.get(key).getTipoJogador() == "Importante" 
						&& jogadores.get(key).getFuncao() == "ATACANTE")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
				if((num == 2 && count == 11) 
						&& (jogadores.get(key).getTipoJogador() == "Rotativo" 
						&& jogadores.get(key).getFuncao() == "ATACANTE")) {
					
					System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
				}
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

}
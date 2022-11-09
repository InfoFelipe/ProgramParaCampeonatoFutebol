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
		Random aleatorio = new Random();
		String zagueiro = "";
		ArrayList<String> meioCampo = new ArrayList<String>();
		ArrayList<String> ataque = new ArrayList<String>();
		Map<String,Jogador> jogadores = this.jogadores;
			for (String key : jogadores.keySet()) {
				System.out.println(jogadores.get(key).getNome());
				count++;
				if(count == 12) {
					break;
				}
			}
			/*int num = aleatorio.nextInt(3);
			for (String key : jogadores.keySet()) {
				
				if(count == 1 && jogadores.get(key).getFuncao().equals("GOLEIRO")) {
					//System.out.println("Entrei aqui");
					if(num < 2 && jogadores.get(key).getTipoJogador().equals("Importante")) {
						System.out.println(jogadores.get(key).getNome());
					}
					if(num == 2 && jogadores.get(key).getTipoJogador().equals("Reserva")) {
						System.out.println(jogadores.get(key).getNome());
					}
				}
				if((count == 2) && jogadores.get(key).getFuncao().equals("LATERAL-DIREITO")) {
					if(num < 2 && jogadores.get(key).getTipoJogador().equals("Importante")) {
						System.out.println(jogadores.get(key).getNome());
					}
					if(num == 2 && jogadores.get(key).getTipoJogador().equals("Reserva")) {
						System.out.println(jogadores.get(key).getNome());
					}
				
				}
				if((count == 3 || count == 4)&& jogadores.get(key).getFuncao().equals("ZAGUEIRO")) {
					//System.out.println(count);
					//System.out.println(chave);
					if(zagueiro.equals("")) {
						if(num < 2 && jogadores.get(key).getTipoJogador().equals("Importante")) {
							System.out.println(jogadores.get(key).getNome());
							zagueiro = key;
							
						}
						if(num == 2 && jogadores.get(key).getTipoJogador().equals("Reserva")) {
							System.out.println(jogadores.get(key).getFuncao()+" "+jogadores.get(key).getNome());
							zagueiro = key;
						}
					}else if(!key.equals(zagueiro) && count == 4){
						if(num < 2 && jogadores.get(key).getTipoJogador().equals("Importante")) {
							System.out.println(jogadores.get(key).getNome());
							
						}
						if(num == 2 && jogadores.get(key).getTipoJogador().equals("Reserva")) {
							System.out.println(jogadores.get(key).getNome());
							
						}
					}
					
				}
				if(count == 5 && jogadores.get(key).getFuncao() == "LATERAL-ESQUERDO") {
					if(num < 2 && jogadores.get(key).getTipoJogador().equals("Importante")) {
						System.out.println(jogadores.get(key).getNome());
					}
					if(num == 2 && jogadores.get(key).getTipoJogador().equals("Reserva")) {
						System.out.println(jogadores.get(key).getNome());
					}
				}
				if((count >= 6 && count > 9 ) && jogadores.get(key).getFuncao() == "MEIO DE CAMPO") {
					if(meioCampo.isEmpty()) {
						if(num < 2 && jogadores.get(key).getTipoJogador().equals("Importante")) {
							System.out.println(jogadores.get(key).getNome());
							meioCampo.add(key);
							
						}
						if(num == 2 && jogadores.get(key).getTipoJogador().equals("Reserva")) {
							System.out.println(jogadores.get(key).getNome());
							meioCampo.add(key);
						}
					}else if(!key.equals(meioCampo.get(0)) && count > 6){
						if(num < 2 && jogadores.get(key).getTipoJogador().equals("Importante")) {
							System.out.println(jogadores.get(key).getNome());
							meioCampo.add(key);
						}
						if(num == 2 && jogadores.get(key).getTipoJogador().equals("Reserva")) {
							System.out.println(jogadores.get(key).getNome());
							meioCampo.add(key);
						}
					}else if((!key.equals(meioCampo.get(1)) && !key.equals(meioCampo.get(0))) && count>6){
						if(num < 2 && jogadores.get(key).getTipoJogador().equals("Importante")) {
							System.out.println(jogadores.get(key).getNome());
						}
						if(num == 2 && jogadores.get(key).getTipoJogador().equals("Reserva")) {
							System.out.println(jogadores.get(key).getNome());
						}
					}
				}
				if((count >= 9 && count >= 11 ) && jogadores.get(key).getFuncao() == "ATACANTE") {
					if(ataque.isEmpty()) {
						if(num < 2 && jogadores.get(key).getTipoJogador().equals("Importante")) {
							System.out.println(jogadores.get(key).getNome());
							ataque.add(key);
							
						}
						if(num == 2 && jogadores.get(key).getTipoJogador().equals("Reserva")) {
							System.out.println(jogadores.get(key).getNome());
							ataque.add(key);
						}
					}else if(!key.equals(ataque.get(0)) && count > 6){
						if(num < 2 && jogadores.get(key).getTipoJogador().equals("Importante")) {
							System.out.println(jogadores.get(key).getNome());
							ataque.add(key);
						}
						if(num == 2 && jogadores.get(key).getTipoJogador().equals("Reserva")) {
							System.out.println(jogadores.get(key).getNome());
							ataque.add(key);
						}
					}else if((!key.equals(ataque.get(1)) && !key.equals(ataque.get(0))) && count>6){
						if(num < 2 && jogadores.get(key).getTipoJogador().equals("Importante")) {
							System.out.println(jogadores.get(key).getNome());
						}
						if(num == 2 && jogadores.get(key).getTipoJogador().equals("Reserva")) {
							System.out.println(jogadores.get(key).getNome());
						}
					}
				}
				
			}*/
			
		
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
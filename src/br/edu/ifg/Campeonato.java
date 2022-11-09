package br.edu.ifg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Campeonato {
	private int quantTotalRodadas;
	private int numTotalEquipes;
	private Map<String, Time> times = new HashMap<String,Time>();
	private String vencedorDoCampeonato;
	private TipoCampeonato tipoDoCampeonato;
	private String tipoCampeonato;
	
	public Campeonato(int numTotalEquipes,String tipoDoCampeonato, Map<String, Time> times) {
		this.numTotalEquipes = numTotalEquipes;
		this.tipoDoCampeonato = TipoCampeonato.valueOf(tipoDoCampeonato);
		this.times = times;
		this.calcularNumRodadas();
		this.tipoCampeonato();	
	}
	
	public void tipoCampeonato() {
		switch (tipoDoCampeonato) {
			case PRIMEIRA_DIVISAO:
				this.tipoCampeonato = "Primeira Divisao";
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
	
	public Map<Integer,Rodada> definirCalendarioDePartidas(Scanner sc) {
		Map<String,Time> times = this.getTimes();
		Map<Integer,Rodada> rodadas = new HashMap<>();
		int numRodada = 1;
		int i = 0;
		int numJogosRodada;
		numJogosRodada = this.getNumTotalEquipes()/2;
		
		while(numRodada <= this.getQuantTotalRodadas()) {
			Map<Integer,Jogo> jogosDaRodada = new HashMap<>();
			
			while(i < numJogosRodada) {
				String nomeTimeCasa;
				String nomeTimeVisitante;
				String nomeArbitro;
				Arbitro arbitro;
				Time timeCasa;
				Time timeVisitante;
				Jogo jogo;
				
				System.out.println("Digite o time da casa do "+(i+1)+" jogo da "+numRodada+" rodada");
				nomeTimeCasa = sc.nextLine();
				nomeTimeCasa = nomeTimeCasa.toUpperCase();
				
				System.out.println("Digite o time visitante do "+(i+1)+" jogo da "+numRodada+" rodada");
				nomeTimeVisitante = sc.nextLine();
				nomeTimeVisitante = nomeTimeVisitante.toUpperCase();
				
				timeCasa = times.get(nomeTimeCasa);
				timeVisitante = times.get(nomeTimeVisitante);
				
				System.out.println("Digite o nome do arbitro da partida:");
				nomeArbitro = sc.nextLine();
				arbitro = new Arbitro(nomeArbitro,"Arbitro");
				
				jogo = new Jogo(timeCasa, timeVisitante, arbitro);
				jogo.definirHorarioJogo(sc);
				jogosDaRodada.put(i,jogo);
				
				i++;
			}
			Rodada rodada = new Rodada(jogosDaRodada,numRodada);
			rodadas.put(numRodada, rodada);
			numJogosRodada = this.getNumTotalEquipes()/2;
			i=0;
			numRodada++;
		}
		return rodadas;
    }
		
	
	public void exibirTabela() {
		ArrayList<Time> times = new ArrayList<Time>();
		for(String nomeTime : this.getTimes().keySet()) {
			times.add(this.getTimes().get(nomeTime));
		}
		for(int i=0;i<times.size()-1;i++) {
				if(times.get(i).getPontuacaoTimeCampeonato() < times.get(i+1).getPontuacaoTimeCampeonato()) {
					Time time2 = times.get(i+1);
					times.remove(i+1);
					times.add(i,time2);
				}else if(times.get(i).getPontuacaoTimeCampeonato() == times.get(i+1).getPontuacaoTimeCampeonato()) {
					if(times.get(i).getSaldoDeGols() < times.get(i+1).getSaldoDeGols()) {
						Time time2 = times.get(i+1);
						times.remove(i+1);
						times.add(i, time2);
					}
					if(times.get(i).getSaldoDeGols() == times.get(i+1).getSaldoDeGols()) {
						if(times.get(i).getNumVitoria() < times.get(i+1).getNumVitoria()) {
							Time time2 = times.get(i+1);
							times.remove(i+1);
							times.add(i, time2);
						}
					}
				}
			
		}
		System.out.printf("Times \t\t\t PT | V | D | E | GF | GT | SG\n");
		for(int i=0;i<times.size();i++) {
			System.out.println(times.get(i).getNomeTime()+" \t\t "+times.get(i).getPontuacaoTimeCampeonato()+"  | "
								+times.get(i).getNumVitoria()+" | "+times.get(i).getNumDerrota()+" | "
								+times.get(i).getNumEmpate()+" | "+times.get(i).getQuantGolsFeitos()+"  | "
								+times.get(i).getQuantGolsTomados()+"  | "+times.get(i).getSaldoDeGols());
		}
		int totalRodadas = times.get(0).getNumVitoria()+times.get(0).getNumDerrota()+times.get(0).getNumEmpate();
		
		if(totalRodadas == this.getQuantTotalRodadas()) {
			this.setVencedorDoCampeonato(times.get(0).getNomeTime());
			System.out.println("O campeao do(a) "+this.getTipoCampeonato()+" foi:");
			System.out.printf("\t\t %s \t\t",this.getVencedorDoCampeonato());
		}
	}
	
	public void mostrarCampeao() {
		this.exibirTabela();
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

	public Map<String, Time> getTimes() {
		return times;
	}

	public void setTimes(Map<String, Time> times) {
		this.times = times;
	} 
	
	
}

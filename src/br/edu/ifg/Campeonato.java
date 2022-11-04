package br.edu.ifg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
	
	public void definirCalendarioDePartidas(ArrayList<Time> times) {
		
		int numRodada = 1;
		int z = 1;
		int count = 1;
		int y = 0;
		ArrayList<Integer> indices = new ArrayList<Integer>();
		Map<Integer,ArrayList<Jogo>> rodadas = new LinkedHashMap<>();
		Map<String,Time> timesCampeonato = new HashMap<>();
		System.out.println(times.size());
		for(int u=0;u<times.size();u++) {
			timesCampeonato.put(times.get(u).getNomeTime(), times.get(u));
		}
		for (String key : timesCampeonato.keySet()) {
			System.out.println(key+": "+timesCampeonato.get(key).getNomeDoEstadio());
		}
		System.out.println(this.getQuantTotalRodadas());
		for(int i =0;i<this.getQuantTotalRodadas();i++) {
			ArrayList<Jogo> jogo = new ArrayList<Jogo>();
			for (int j=0;j<this.getNumTotalEquipes()/2;j++) {
				Jogo partida;
				if(y>=times.size()) {
					y = 0;
				}
				if(numRodada == 1) {
					if(y == 1 || y == 3) {
						y++;
					}
					if(y%2==0) {
						partida = new Jogo(times.get(y),times.get(z));
						jogo.add(partida);
						z += 2;
					}
					
					
				}
				if(numRodada >= 2 && numRodada<=this.getQuantTotalRodadas()/2) {
					if(z>=times.size()) {
						z = times.size()-1;
					}
					if(z == 0) {
						z = times.size()-1;
					}
					if(y == 5) {
						y=0;
					}
					if(y == times.size()/2 - 1 && numRodada>1) {
						partida = new Jogo(times.get(z),times.get(y));
						jogo.add(partida);
					}else if(z == times.size()-1 && numRodada>2) {
						partida = new Jogo(times.get(z),times.get(0));
						jogo.add(partida);
					}else {
						partida = new Jogo(times.get(y),times.get(z));
						jogo.add(partida);
					}
					z--;
					
				}
				if(numRodada == this.getQuantTotalRodadas()/2 +1) {
					if(z>=times.size()) {
						z = times.size()-1;
					}
					if(z != 1) {
						z = 1;
					}
					partida = new Jogo(times.get(z),times.get(y));
					jogo.add(partida);
					z += 2;
				}
				y++;
				
			}
			rodadas.put(numRodada,jogo);
			numRodada++;
		}
		for (Integer key : rodadas.keySet()) {
			for(int l=0;l<rodadas.get(key).size();l++) {
				System.out.println(key+": "+rodadas.get(key).get(l).getTimeCasa().getNomeTime()+" X "+rodadas.get(key).get(l).getTimeVisitante().getNomeTime());
			}
		}
    }
		
	
	public void exibirTabela(ArrayList<Time> times) {
		for (Time time : times) {
			
		}
		
		for (Time time : times) {
			System.out.println(time.getNomeTime()+" | "+time.getPontuacaoTimeCampeonato()+" | "+time.getNumVitoria()+" | "+time.getNumEmpate()+" | "+time.getNumDerrota()+" | "+time.getSaldoDeGols());
		}
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

	public Map<String, Time> getTimes() {
		return times;
	}

	public void setTimes(Map<String, Time> times) {
		this.times = times;
	} 
	
	
}

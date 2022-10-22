package br.edu.ifg;

public class Main {

	public static void main(String[] args) {
		Campeonato campeonato;
		campeonato = new Campeonato(20,"SEGUNDA_DIVISAO");
		System.out.println( campeonato.getTipoCampeonato());
		System.out.println( campeonato.getQuantTotalRodadas());
		
		Jogador[] teste1 = new Jogador[1];
		teste1[0] = new Jogador("Rodinei","Lateral-Esquerdo","Sao Paulo");
		
		Time time1 = new Time("Sao Paulo", teste1, "Morumbi");
		Time time2 = new Time("Santos", null, "Vila");
		Jogo jogo = new Jogo(time1, time2);
		jogo.definirGanhador();
		time1 = jogo.getTimeCasa();
		time2 = jogo.getTimeVisitante();
		System.out.println(jogo.getVencedor());
		System.out.println(jogo.getGolsTimeCasa());
		System.out.println(jogo.getGolsTimeVisitante());
		time1.exibirEscalacao();
		
		}

}

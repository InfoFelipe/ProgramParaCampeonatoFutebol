package br.edu.ifg;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//String time;
		Campeonato campeonato;
		System.out.println("Digite qual time desseja adicionar jogadores: ");
		//time = sc.next();
		campeonato = new Campeonato(6,"PRIMEIRA_DIVISAO");
		campeonato.calcularNumRodadas();
		System.out.println( campeonato.getTipoCampeonato());
		System.out.println( campeonato.getQuantTotalRodadas());
		
		Jogador[] teste1 = new Jogador[22];
		Time santos = new Time("Santos", null, "Vila");
		Time saoPaulo = new Time("Sao Paulo", null, "Morumbi");
		Time flamengo = new Time("Flamengo",null,"Maracana");
		Time vasco = new Time("Vasco", null,"sadia");
		Time palmeira = new Time("Palmeira",null,"Allianz Arena");
		Time vitoria =  new Time("Vitoria", null,"Sao Januario");
		ArrayList<Time> timeArray = new ArrayList<Time>();
	 	timeArray.add(santos);
	 	timeArray.add(saoPaulo);
		timeArray.add(palmeira);
		timeArray.add(vasco);
		timeArray.add(flamengo);
		timeArray.add(vitoria);
		/*
		Jogo jogo = new Jogo(timeArray.get(4),timeArray.get(1));
		
		for (Time time : timeArray) {
			
			jogo.definirGanhador();
		}
		System.out.println("A pontuacao do "+timeArray.get(4).getNomeTime()+ " foi de: "+timeArray.get(4).getPontuacaoTimeCampeonato());
		System.out.println("Saldo de Gols do " +timeArray.get(4).getNomeTime()+ " foi de: "+ timeArray.get(4).getSaldoDeGols());
		System.out.println("A pontuacao do "+timeArray.get(1).getNomeTime()+" foi de: "+timeArray.get(1).getPontuacaoTimeCampeonato());
		System.out.println("Saldo de Gols do"+timeArray.get(1).getNomeTime()+" foi de: "+ timeArray.get(1).getSaldoDeGols());
		*/
		campeonato.definirCalendarioDePartidas(timeArray);
		//campeonato.exibirTabela(timeArray);
	}
	
	public static void arrayJogadores(Jogador[] teste1, Scanner sc,String time) {
		String[] jogadores = new String[22];
		System.out.println("Digite os nomes dos jogadores: ");
		for(int i = 0;i < 22;i++) {
			jogadores[i] = sc.next();
		}
		teste1[0] = new Jogador(jogadores[0], "Goleiro", time, "IMPORTANTE");
		teste1[1] = new Jogador(jogadores[1], "Goleiro", time, "ROTATIVO");
		teste1[2] = new Jogador(jogadores[2],"Lateral-Esquerdo",time,"IMPORTANTE");
		teste1[3] = new Jogador(jogadores[3],"Lateral-Esquerdo",time,"ROTATIVO");
		teste1[4] = new Jogador(jogadores[4],"Lateral-Direito",time,"IMPORTANTE");
		teste1[5] = new Jogador(jogadores[5],"Lateral-Direito",time,"ROTATIVO");
		teste1[6] = new Jogador(jogadores[6],"Zagueiro",time,"IMPORTANTE");
		teste1[7] = new Jogador(jogadores[7],"Zagueiro",time,"ROTATIVO");
		teste1[8] = new Jogador(jogadores[8],"Zagueiro",time,"IMPORTANTE");
		teste1[9] = new Jogador(jogadores[9],"Zagueiro",time,"ROTATIVO");
		teste1[10] = new Jogador(jogadores[10],"Meia",time,"IMPORTANTE");
		teste1[11] = new Jogador(jogadores[11],"Meia",time,"ROTATIVO");
		teste1[12] = new Jogador(jogadores[12],"Meia",time,"IMPORTANTE");
		teste1[13] = new Jogador(jogadores[13],"Meia",time,"ROTATIVO");
		teste1[14] = new Jogador(jogadores[14],"Meia",time,"IMPORTANTE");
		teste1[15] = new Jogador(jogadores[15],"Meia",time,"ROTATIVO");
		teste1[16] = new Jogador(jogadores[16],"Atacante",time,"IMPORTANTE");
		teste1[17] = new Jogador(jogadores[17],"Atacante",time,"ROTATIVO");
		teste1[18] = new Jogador(jogadores[18],"Atacante",time,"IMPORTANTE");
		teste1[19] = new Jogador(jogadores[19],"Atacante",time,"ROTATIVO");
		teste1[20] = new Jogador(jogadores[20],"Atacante",time,"IMPORTANTE");
		teste1[21] = new Jogador(jogadores[21],"Atacante",time,"ROTATIVO");
	}

}

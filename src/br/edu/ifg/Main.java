package br.edu.ifg;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tipoCampeonato;
		Map<String,Campeonato> campeonatos = new HashMap<>();
		Map<Integer,Rodada> rodadas = new HashMap<>();
		Campeonato campeonato;
		int numLine = 1;
		String path;
		String opcao;
		int numquipes;
		int i = 1;
		
		path = "C:\\Users\\pedrp\\OneDrive\\Área de Trabalho\\Java\\Campeonato\\src\\br\\edu\\ifg\\jogadores.txt";
		do {
			Map<String, Time> times = new HashMap<String,Time>();
			System.out.println("Qual campeonato quer criar primeiro:\nPrimeira Divisao, Segunda Divisao ou Estadual");
			tipoCampeonato = sc.nextLine();
			tipoCampeonato = tipoCampeonato.toUpperCase();
			
			System.out.println("Qualtas equipes vai ter: OBS Tem que ser um numero par");
			numquipes = sc.nextInt();
			clearBuffer(sc);
			
			while(numquipes%2 != 0) {
				System.out.println("Digite o numero de equipes par:");
				numquipes = sc.nextInt();
				clearBuffer(sc);
			}
			
			while(i <= numquipes) {
				Map<String,Jogador> jogadores = new HashMap<String,Jogador>();
				String nomeDoTime;
				Tecnico tecnico;
				String nomeDoEstadio;
				System.out.println("Digite o nome do " + i+" time");
				nomeDoTime = sc.nextLine();
				nomeDoTime = nomeDoTime.toUpperCase();
				
				System.out.println("Digite agora o nome do Estadio desse time:");
				nomeDoEstadio = sc.nextLine();
				nomeDoEstadio = nomeDoEstadio.toUpperCase();

				jogadores = criacaoJogadores(path,sc,nomeDoTime,numLine);
				tecnico = definirTecnico(nomeDoTime,sc);
				
				if(times.get(nomeDoTime) == null) {
					Time time = new Time(nomeDoTime,jogadores,nomeDoEstadio,tecnico);
					
					times.put(nomeDoTime,time);
				}else {
					System.out.println("Esse time já existe crie outro");
				}
				numLine += jogadores.size();
				i++;
			}
			
			if("PRIMEIRA DIVISAO".equals(tipoCampeonato)) {
				tipoCampeonato = tipoCampeonato.substring(0, 8) + '_'+ tipoCampeonato.substring(8 + 1);
				campeonato = new Campeonato(numquipes, tipoCampeonato,times);
				campeonatos.put(tipoCampeonato, campeonato);
			}
			if("SEGUNDA DIVISAO".equals(tipoCampeonato)) {
				tipoCampeonato = tipoCampeonato.substring(0, 7) + '_'+ tipoCampeonato.substring(7 + 1);
				campeonato = new Campeonato(numquipes, tipoCampeonato,times);
				campeonatos.put(tipoCampeonato, campeonato);
			}
			if("ESTADUAL".equals(tipoCampeonato)) {
				campeonato = new Campeonato(numquipes, tipoCampeonato,times);
				campeonatos.put(tipoCampeonato, campeonato);
			}
			
			System.out.println("Quer criar outro campeonato: Sim ou Nao");
			opcao = sc.nextLine();
			opcao = opcao.toLowerCase();
		} while (opcao.equals("sim"));
		
		campeonatos = realizarJogos(campeonatos, rodadas, sc);
		
		sc.close();
	}
	
	public static Map<String, Jogador> criacaoJogadores(String path, Scanner sc,String nomeDoTime, int numLine) {
		Map<String, Jogador> jogadores = new HashMap<String,Jogador>();
		try(BufferedReader arquvo = new BufferedReader(new FileReader(path))){
			
			System.out.println("Quantos jogadores o time "+nomeDoTime+" vai ter:");
			int numJogadores = sc.nextInt();
			clearBuffer(sc);
			int count = 0;
			int line = 1;
			String linha = arquvo.readLine(); 
			while(linha != null) {
				
				Jogador jogador;
				String[] separacao = linha.split(",");
				String nome = separacao[0];
				separacao[1] = separacao[1].toUpperCase();
				String funcao = separacao[1];
				separacao[2] = separacao[2].toUpperCase();
				String statusNaEquipe = separacao[2];
				System.out.println(count);
				System.out.println(numLine);
			
				if(line >= numLine) {
					if(numJogadores > count ) {
						if(jogadores.get(nome) == null) {
							jogador = new Jogador(nome, funcao, nomeDoTime,statusNaEquipe);
							jogadores.put(nome,jogador);
						}else {
							System.out.println("Ja existe um jogador com esse nome: "
												+ "\nDigite o sbrenome dele");
							String sobrenome = sc.nextLine();
							nome = nome +" "+sobrenome;
							jogador = new Jogador(nome, funcao,nomeDoTime,statusNaEquipe);
							jogadores.put(nome,jogador);
						}
					}
					count++;
					
				}
				line++;
				linha = arquvo.readLine();				
				
			}
		} catch (IOException e) {
			System.out.println("Error: "+e.getMessage());			
		}
		return jogadores;
	}
	
	public static Tecnico definirTecnico(String nomeDoTime,Scanner sc) {
		String funcao = "Tecnico";
		String nome;
		
		System.out.println("Digio nome do TECNICO do time "+nomeDoTime);
		nome = sc.nextLine();
		
		Tecnico tecnico = new Tecnico(nome, funcao, nomeDoTime);
		
		return tecnico;
	}
	
	public static Map<String,Campeonato> realizarJogos(Map<String,Campeonato> campeonatos,Map<Integer,Rodada> rodadas,Scanner sc) {

		for(String chave : campeonatos.keySet()) {	
			rodadas = campeonatos.get(chave).definirCalendarioDePartidas(sc);
			for(int key : rodadas.keySet()) {
				
				for(int numJogo : rodadas.get(key).getJogosDaRodada().keySet()) {
					String nomeTimeCasa = rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeCasa().getNomeTime().toUpperCase();
					String nomeTimeVisitante = rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeVisitante().getNomeTime().toUpperCase();
					Time timeCasa;
					Time timeVisitante;
					
					
					System.out.println(rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeCasa().getNomeTime()+" X "
							+rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeVisitante().getNomeTime());
					
					System.out.println("\nLocal da partida "+rodadas.get(key).getJogosDaRodada().get(numJogo).getLocal());
					System.out.println("\nData da partida "+rodadas.get(key).getJogosDaRodada().get(numJogo).getDataJogo());
					System.out.println("\nHorario da partida: "+rodadas.get(key).getJogosDaRodada().get(numJogo).getHorario());
					System.out.println("\nArbitro da partida: "+rodadas.get(key).getJogosDaRodada().get(numJogo).getArbitro().getNome());
					
					System.out.println("\nEscalacao "+rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeCasa().getNomeTime());
					System.out.println("\nTecnico "+rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeCasa().getTecnico().getNome()+"\n");
					
					rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeCasa().exibirEscalacao();
					
					System.out.println("\nEscalacao "+rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeVisitante().getNomeTime());
					System.out.println("\nTecnico "+rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeVisitante().getTecnico().getNome()+"\n");
					rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeVisitante().exibirEscalacao();
					
					rodadas.get(key).getJogosDaRodada().get(numJogo).definirGanhador();
					
					System.out.println("\n"+rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeCasa().getNomeTime()+" "+
							rodadas.get(key).getJogosDaRodada().get(numJogo).getGolsTimeCasa()
							+" X "+
							rodadas.get(key).getJogosDaRodada().get(numJogo).getGolsTimeVisitante()+" "
							+rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeVisitante().getNomeTime());
					
					timeCasa = rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeCasa();
					timeVisitante = rodadas.get(key).getJogosDaRodada().get(numJogo).getTimeVisitante();
					
					campeonatos.get(chave).getTimes().get(nomeTimeCasa).setNumDerrota(timeCasa.getNumDerrota());
					campeonatos.get(chave).getTimes().get(nomeTimeCasa).setNumEmpate(timeCasa.getNumEmpate());
					campeonatos.get(chave).getTimes().get(nomeTimeCasa).setNumVitoria(timeCasa.getNumVitoria());
					campeonatos.get(chave).getTimes().get(nomeTimeCasa).setQuantGolsFeitos(timeCasa.getQuantGolsFeitos());
					campeonatos.get(chave).getTimes().get(nomeTimeCasa).setQuantGolsTomados(timeCasa.getQuantGolsTomados());
					campeonatos.get(chave).getTimes().get(nomeTimeCasa).somarSaldoDeGols();
					campeonatos.get(chave).getTimes().get(nomeTimeCasa).calcularPontuacao();
					
					campeonatos.get(chave).getTimes().get(nomeTimeVisitante).setNumDerrota(timeVisitante.getNumDerrota());
					campeonatos.get(chave).getTimes().get(nomeTimeVisitante).setNumEmpate(timeVisitante.getNumEmpate());
					campeonatos.get(chave).getTimes().get(nomeTimeVisitante).setNumVitoria(timeVisitante.getNumVitoria());
					campeonatos.get(chave).getTimes().get(nomeTimeVisitante).setQuantGolsFeitos(timeVisitante.getQuantGolsFeitos());
					campeonatos.get(chave).getTimes().get(nomeTimeVisitante).setQuantGolsTomados(timeVisitante.getQuantGolsTomados());
					campeonatos.get(chave).getTimes().get(nomeTimeVisitante).somarSaldoDeGols();
					campeonatos.get(chave).getTimes().get(nomeTimeVisitante).calcularPontuacao();
					
					
					
				}
				if(key < campeonatos.get(chave).getQuantTotalRodadas()) {
					System.out.println("\nDeseja ver como a tabela esta: Sim ou Nao");
					String opcao = sc.nextLine();
					opcao = opcao.toLowerCase();
					System.out.println(opcao);
					
					if(opcao.equals("sim")) {
						campeonatos.get(chave).exibirTabela();
					}
				}
				if(key == campeonatos.get(chave).getQuantTotalRodadas()) {
					campeonatos.get(chave).exibirTabela();
				}
				
			}
		}
		
		return campeonatos;
	}
	
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

}

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
		Campeonato campeonato;
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
			System.out.println(tipoCampeonato);
			
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
				String nomeDoEstadio;
				System.out.println("Digite o nome do " + i+" time");
				nomeDoTime = sc.nextLine();
				nomeDoTime = nomeDoTime.toUpperCase();
				
				System.out.println("Digite agora o nome do Estadio desse time:");
				nomeDoEstadio = sc.nextLine();
				nomeDoEstadio = nomeDoEstadio.toUpperCase();

				jogadores = criacaoJogadores(path,sc,nomeDoTime);
				jogadores.get("Pedro Gabriel").getFuncao();
				
				if(times.get(nomeDoTime) == null) {
					System.out.println(nomeDoTime);
					Time time = new Time(nomeDoTime,jogadores,nomeDoEstadio);
					time.getNomeTime();
					times.put(nomeDoTime,time);
				}else {
					System.out.println("Esse time já existe crie outro");
				}
				
				i++;
			}
			
			if("PRIMEIRA DIVISAO".equals(tipoCampeonato)) {
				tipoCampeonato = tipoCampeonato.substring(0, 8) + '_'+ tipoCampeonato.substring(8 + 1);
				System.out.println(tipoCampeonato);
				campeonato = new Campeonato(numquipes, tipoCampeonato,times);
				times.get("SAO PAULO").getNomeTime();
			}
			
			System.out.println("Quer criar outro campeonato: Sim ou Nao");
			opcao = sc.nextLine();
			opcao = opcao.toLowerCase();
		} while (opcao.equals("sim"));
		
		
		sc.close();
	}
	
	public static Map<String, Jogador> criacaoJogadores(String path, Scanner sc,String nomeDoTime) {
		Map<String, Jogador> jogadores = new HashMap<String,Jogador>();
		try(BufferedReader arquvo = new BufferedReader(new FileReader(path))){
			
			String linha = arquvo.readLine();
			while(linha != null) {
				
				Jogador jogador;
				String[] separacao = linha.split(",");
				String nome = separacao[0];
				separacao[1] = separacao[1].toUpperCase();
				String funcao = separacao[1];
				separacao[2] =  separacao[2].toUpperCase();
				String timeEmQueJoga = separacao[2];
				separacao[3] = separacao[3].toUpperCase();
				String statusNaEquipe = separacao[3];
			
				if(nomeDoTime.equals(timeEmQueJoga)) {
					if(jogadores.get(nome) == null) {
						jogador = new Jogador(nome, funcao, timeEmQueJoga, statusNaEquipe);
						jogadores.put(nome,jogador);
					}else {
						System.out.println("Ja existe um jogador com esse nome: "
											+ "\nDigite o sbrenome dele");
						String sobrenome = sc.nextLine();
						nome = nome +" "+sobrenome;
						jogador = new Jogador(nome, funcao, timeEmQueJoga, statusNaEquipe);
						jogadores.put(nome,jogador);
					}
				}
				
				linha = arquvo.readLine();				
				
			}
		} catch (IOException e) {
			System.out.println("Error: "+e.getMessage());			
		}
		return jogadores;
	}
	
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

}

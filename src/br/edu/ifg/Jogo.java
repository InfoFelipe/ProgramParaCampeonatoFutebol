package br.edu.ifg;
import java.util.Calendar;
import java.util.Random;

public class Jogo {
	private Time timeCasa;
	private Time timeVisitante;
	private String vencedor;
	private int golsTimeCasa;
	private int golsTimeVisitante;
	private Calendar dataJogo;
	private Calendar horario;
	private String local;
	
	public Jogo(Time timeCasa,Time timeVisitante) {
		this.timeCasa = timeCasa;
		this.timeVisitante = timeVisitante;
		this.local = timeCasa.getNomeDoEstadio();
	}
	
	public void definirGanhador() {
		Random numeroAleatorio = new Random();
		int num = numeroAleatorio.nextInt(3);
		Time timeCasa = this.getTimeCasa();
		Time timeVisitante = this.getTimeVisitante();
		if(num == 0) {
			String vencedor = timeCasa.getNomeTime();
			this.setVencedor(vencedor);
			timeCasa.somarVitoria();
			timeVisitante.somarDerrota();	
		} else if(num == 1) {
			String vencendor = timeVisitante.getNomeTime();
			this.setVencedor(vencendor);
			timeCasa.somarDerrota();
			timeVisitante.somarVitoria();
		} else {
			String vencedor = "Empate";
			this.setVencedor(vencedor);
			timeCasa.somarEmpate();
			timeVisitante.somarEmpate();
		}
		this.gerarResultado();
		timeCasa.calcularPontuacao();
		timeCasa.somarSaldoDeGols();
		timeVisitante.calcularPontuacao();
		timeVisitante.somarSaldoDeGols();
		this.setTimeCasa(timeCasa);
		this.setTimeVisitante(timeVisitante);
	}
	
	public void gerarResultado() {
		Time timeCasa = this.getTimeCasa();
		Time timeVisitante = this.getTimeVisitante();
		int numeroGolsTimeCasa;
		int numeroGolsTimeVisitante;
		Random num = new Random();
		if(timeCasa.getNomeTime() == this.getVencedor()) {
			numeroGolsTimeCasa = num.nextInt(6);
			while(numeroGolsTimeCasa < 1) {
				numeroGolsTimeCasa = num.nextInt(6);
			}
			numeroGolsTimeVisitante = num.nextInt(5);
			while (numeroGolsTimeVisitante >= numeroGolsTimeCasa) {
				numeroGolsTimeVisitante = num.nextInt(5);
			}
			this.setGolsTimeCasa(numeroGolsTimeCasa);
			this.setGolsTimeVisitante(numeroGolsTimeVisitante);
			timeCasa.somarGolsFeitos(this.getGolsTimeCasa());
			timeVisitante.somarGolsFeitos(this.getGolsTimeVisitante());
			timeCasa.somarGolsTomados(this.getGolsTimeVisitante());
			timeVisitante.somarGolsTomados(this.getGolsTimeCasa());
		}else if(timeVisitante.getNomeTime() == this.getVencedor()) {
			numeroGolsTimeVisitante = num.nextInt(5);
			while(numeroGolsTimeVisitante < 1) {
				numeroGolsTimeVisitante = num.nextInt(5);
			}
			numeroGolsTimeCasa = num.nextInt(4);
			while (numeroGolsTimeCasa >= numeroGolsTimeVisitante) {
				numeroGolsTimeCasa = num.nextInt(4);
			}
			this.setGolsTimeCasa(numeroGolsTimeCasa);
			this.setGolsTimeVisitante(numeroGolsTimeVisitante);
			timeCasa.somarGolsFeitos(this.getGolsTimeCasa());
			timeVisitante.somarGolsFeitos(this.getGolsTimeVisitante());
			timeCasa.somarGolsTomados(this.getGolsTimeVisitante());
			timeVisitante.somarGolsTomados(this.getGolsTimeCasa());
		} else {
			int numGols = num.nextInt(5);
			this.setGolsTimeCasa(numGols);
			this.setGolsTimeVisitante(numGols);
			timeCasa.somarGolsFeitos(this.getGolsTimeCasa());
			timeVisitante.somarGolsFeitos(this.getGolsTimeVisitante());
			timeCasa.somarGolsTomados(this.getGolsTimeVisitante());
			timeVisitante.somarGolsTomados(this.getGolsTimeCasa());
		}
	}

	public Time getTimeCasa() {
		return timeCasa;
	}

	public void setTimeCasa(Time timeCasa) {
		this.timeCasa = timeCasa;
	}

	public Time getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public String getVencedor() {
		return vencedor;
	}

	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}

	public int getGolsTimeCasa() {
		return golsTimeCasa;
	}

	public void setGolsTimeCasa(int golsTimeCasa) {
		this.golsTimeCasa = golsTimeCasa;
	}

	public int getGolsTimeVisitante() {
		return golsTimeVisitante;
	}

	public void setGolsTimeVisitante(int golsTimeVisitante) {
		this.golsTimeVisitante = golsTimeVisitante;
	}

	public Calendar getDataJogo() {
		return dataJogo;
	}

	public void setDataJogo(Calendar dataJogo) {
		this.dataJogo = dataJogo;
	}

	public Calendar getHorario() {
		return horario;
	}

	public void setHorario(Calendar horario) {
		this.horario = horario;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
}
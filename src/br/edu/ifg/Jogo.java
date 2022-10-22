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
	}
	
	public void definirGanhador() {
		Random aleatorio = new Random();
		int num = aleatorio.nextInt(3);
		Time timeC = this.getTimeCasa();
		Time timeV = this.getTimeVisitante();
		if(num == 0) {
			String venc = timeC.getNomeTime();
			this.setVencedor(venc);
			timeC.somarVitoria();
			timeV.somarDerrota();	
		} else if(num == 1) {
			String venc = timeV.getNomeTime();
			this.setVencedor(venc);
			timeC.somarDerrota();
			timeV.somarVitoria();
		} else {
			String venc = "Empate";
			this.setVencedor(venc);
			timeC.somarEmpate();
			timeV.somarEmpate();
		}
		this.gerarResultado();
		this.setTimeCasa(timeC);
		this.setTimeVisitante(timeV);
	}
	
	public void gerarResultado() {
		Time timeC = this.getTimeCasa();
		Time timeV = this.getTimeVisitante();
		int numGolsC;
		int numGolsV;
		Random num = new Random();
		if(timeC.getNomeTime() == this.getVencedor()) {
			numGolsC = num.nextInt(6);
			while(numGolsC < 1) {
				numGolsC = num.nextInt(6);
			}
			numGolsV = num.nextInt(5);
			while (numGolsV >= numGolsC) {
				numGolsV = num.nextInt(5);
			}
			this.setGolsTimeCasa(numGolsC);
			this.setGolsTimeVisitante(numGolsV);
			timeC.somarGolsFeitos(this.getGolsTimeCasa());
			timeV.somarGolsFeitos(this.getGolsTimeVisitante());
			timeC.somarGolsTomados(this.getGolsTimeVisitante());
			timeV.somarGolsTomados(this.getGolsTimeCasa());
		}else if(timeV.getNomeTime() == this.getVencedor()) {
			numGolsV = num.nextInt(5);
			while(numGolsV < 1) {
				numGolsV = num.nextInt(5);
			}
			numGolsC = num.nextInt(4);
			while (numGolsC >= numGolsV) {
				numGolsC = num.nextInt(4);
			}
			this.setGolsTimeCasa(numGolsC);
			this.setGolsTimeVisitante(numGolsV);
			timeC.somarGolsFeitos(this.getGolsTimeCasa());
			timeV.somarGolsFeitos(this.getGolsTimeVisitante());
			timeC.somarGolsTomados(this.getGolsTimeVisitante());
			timeV.somarGolsTomados(this.getGolsTimeCasa());
		} else {
			int numGols = num.nextInt(5);
			this.setGolsTimeCasa(numGols);
			this.setGolsTimeVisitante(numGols);
			timeC.somarGolsFeitos(this.getGolsTimeCasa());
			timeV.somarGolsFeitos(this.getGolsTimeVisitante());
			timeC.somarGolsTomados(this.getGolsTimeVisitante());
			timeV.somarGolsTomados(this.getGolsTimeCasa());
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
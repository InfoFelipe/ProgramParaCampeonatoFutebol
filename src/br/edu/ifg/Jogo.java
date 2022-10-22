package br.edu.ifg;
import java.util.Calendar;

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

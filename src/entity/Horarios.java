package entity;

import java.util.ArrayList;

public class Horarios {

	private ArrayList<Hora> horariosDeTrabalho = new ArrayList<>();
	private ArrayList<Hora> marcacoesFeitas = new ArrayList<>();
	private ArrayList<Hora> atrasos = new ArrayList<>();
	private ArrayList<Hora> horasExtras = new ArrayList<>();

	private int contadorHorarios = 0;

	public ArrayList<Hora> getHorariosDeTrabalho() {
		return horariosDeTrabalho;
	}

	public void setHorariosDeTrabalho(ArrayList<Hora> horariosDeTrabalho) {
		this.horariosDeTrabalho = horariosDeTrabalho;
	}

	public ArrayList<Hora> getMarcacoesFeitas() {
		return marcacoesFeitas;
	}

	public void setMarcacoesFeitas(ArrayList<Hora> marcacoesFeitas) {
		this.marcacoesFeitas = marcacoesFeitas;
	}

	public ArrayList<Hora> getAtrasos() {
		return atrasos;
	}

	public void setAtrasos(ArrayList<Hora> atrasos) {
		this.atrasos = atrasos;
	}

	public ArrayList<Hora> getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(ArrayList<Hora> horasExtras) {
		this.horasExtras = horasExtras;
	}

	public int getContadorHorarios() {
		return contadorHorarios;
	}

	public void setContadorHorarios(int contadorHorarios) {
		this.contadorHorarios = contadorHorarios;
	}
}

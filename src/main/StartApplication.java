package main;

import model.Hora;
import model.Horarios;
import view.Atrasos;
import view.InserirMarcacoes;

public class StartApplication {

	public static void main(String[] args) {
		
		Hora hora = new Hora("08:00", "09:30");
		Hora hora2 = new Hora("12:00", "13:00");
		
		
		Horarios horarios = new Horarios();
		horarios.getHorasExtras().add(hora);
		horarios.getHorasExtras().add(hora2);
		
		horarios.getAtrasos().add(hora);
		horarios.getAtrasos().add(hora2);
		
		//HorasExtras horasExtras = new HorasExtras(horarios.getHorasExtras());
		
		//InserirHorarioDeTrabalho horarioTrabalho = new InserirHorarioDeTrabalho(horarios.getHorariosDeTrabalho());
		
		//Atrasos atrasos = new Atrasos(horarios.getAtrasos());
		
		InserirMarcacoes inserirMarcacoes =  new InserirMarcacoes(horarios.getMarcacoesFeitas());
	}
}
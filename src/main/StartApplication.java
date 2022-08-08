package main;

import entity.Hora;
import entity.Horarios;
import view.Atrasos;

public class StartApplication {

	public static void main(String[] args) {
		
		Hora hora = new Hora("08:00", "09:30");
		Hora hora2 = new Hora("12:00", "13:00");
		
		
		Horarios horarios = new Horarios();
		horarios.getHorasExtras().add(hora);
		horarios.getHorasExtras().add(hora2);
		
		horarios.getAtrasos().add(hora);
		horarios.getAtrasos().add(hora2);
		
		//HorasExtras horasExtras = new HorasExtras(horarios);
		
		//InserirHorarioDeTrabalho horarioTrabalho = new InserirHorarioDeTrabalho(horarios.getHorariosDeTrabalho(), horarios);
		
		Atrasos atrasos = new Atrasos(horarios);
		
		//InserirMarcacoes inserirMarcacoes =  new InserirMarcacoes(horarios.getMarcacoesFeitas(), horarios);
	}
}
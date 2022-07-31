package main;

import model.Hora;
import model.Horarios;
import view.InserirHorarioDeTrabalho;

public class StartApplication {

	public static void main(String[] args) {
		
		Hora hora = new Hora("08:00", "09:30");
		Hora hora2 = new Hora("12:00", "13:00");
		
		
		Horarios horarios = new Horarios();
		horarios.getHorasExtras().add(hora);
		horarios.getHorasExtras().add(hora2);
		
		//HorasExtras horasExtras = new HorasExtras(horarios.getHorasExtras());
		
		InserirHorarioDeTrabalho horarioTrabalho = new InserirHorarioDeTrabalho(null);
	}
}
package main;

import entity.Horarios;
import view.Atrasos;
import view.HorasExtras;
import view.InserirHorarioDeTrabalho;
import view.InserirMarcacoes;

public class StartApplication {

	public static void main(String[] args) {
		Horarios horarios = new Horarios();
		
		//MenuPrincipal menu = new MenuPrincipal(horarios);
		
		//InserirHorarioDeTrabalho inserirHorarioDeTrabalho = new InserirHorarioDeTrabalho(horarios.getHorariosDeTrabalho(), horarios);
		
		//InserirMarcacoes marcacoes = new InserirMarcacoes(horarios.getMarcacoesFeitas(), horarios);
		
		//Atrasos atrasos = new Atrasos(horarios);
		
		HorasExtras horasExtras = new HorasExtras(horarios);
	}
}
package model;

import java.util.ArrayList;

import entity.Hora;

public class AtrasosController {

	public ArrayList<Hora> calculaAtrasos(ArrayList<Hora> horariosDeTrabalho, ArrayList<Hora> marcacoesFeitas, ArrayList<Hora> atrasos){
		
		atrasos.clear();
		
		if(marcacoesFeitas.isEmpty()) {
			atrasos = horariosDeTrabalho;
		}
		
		return atrasos;
	}
}

package model;

public class TratamentoDeDados {
	
	public String tratarHorario(int horario) {
		String str_horario;
		
		if(horario < 1000) {
			str_horario = "0" + Integer.toString(horario).substring(0, 1) + ":" + Integer.toString(horario).substring(1, 3);
		} else {
			str_horario = Integer.toString(horario).substring(0, 2) + ":" + Integer.toString(horario).substring(2, 4);
		}
		
		return str_horario;
	}

}
package model;

import java.util.ArrayList;

import entity.Hora;

public class AtrasosController {

	public ArrayList<Hora> calculaAtrasos(ArrayList<Hora> horariosDeTrabalho, ArrayList<Hora> marcacoesFeitas,
			ArrayList<Hora> atrasos) {

		Hora hora;
		TratamentoDeDados tratamentoDeDados = new TratamentoDeDados();
		
		int controlador = 0;
		
		atrasos.clear();

		if (marcacoesFeitas.isEmpty()) {
			atrasos = horariosDeTrabalho;
			return atrasos;
		} else if (horariosDeTrabalho.isEmpty()) {
			atrasos.clear();
			return atrasos;
		} else {
			
			atrasos = horariosDeTrabalho;

			for (Hora horasMarcadas : marcacoesFeitas) {

				String str_horarioDeEntradaMarcacao = horasMarcadas.getEntrada().substring(0, 2)
						+ horasMarcadas.getEntrada().substring(3, 5);
				String str_horarioDeSaidaMarcacao = horasMarcadas.getSaida().substring(0, 2)
						+ horasMarcadas.getSaida().substring(3, 5);
				int horarioDeEntradaMarcacao = Integer.parseInt(str_horarioDeEntradaMarcacao);
				int horarioDeSaidaMarcacao = Integer.parseInt(str_horarioDeSaidaMarcacao);

				for (Hora horasTrabalhadas : atrasos) {

					String str_horarioDeEntradaTrabalho = horasTrabalhadas.getEntrada().substring(0, 2)
							+ horasTrabalhadas.getEntrada().substring(3, 5);
					String str_horarioDeSaidaTrabalho = horasTrabalhadas.getSaida().substring(0, 2)
							+ horasTrabalhadas.getSaida().substring(3, 5);
					int horarioDeEntradaTrabalho = Integer.parseInt(str_horarioDeEntradaTrabalho);
					int horarioDeSaidaTrabalho = Integer.parseInt(str_horarioDeSaidaTrabalho);

					if(horarioDeEntradaMarcacao < horarioDeSaidaMarcacao) {
						if(horarioDeEntradaTrabalho < horarioDeSaidaTrabalho) {
							if(horarioDeSaidaMarcacao <= horarioDeEntradaTrabalho || horarioDeEntradaMarcacao >= horarioDeSaidaTrabalho) {
								controlador++;
							} else {
								if(horarioDeEntradaMarcacao <= horarioDeEntradaTrabalho && horarioDeSaidaMarcacao >= horarioDeSaidaTrabalho) {
									atrasos.remove(horasTrabalhadas);
								} else {
									if(horarioDeEntradaMarcacao <= horarioDeEntradaTrabalho && horarioDeSaidaMarcacao <= horarioDeSaidaTrabalho) {
										atrasos.remove(horasTrabalhadas);
										atrasos.add(new Hora(tratamentoDeDados.tratarHorario(horarioDeSaidaMarcacao), tratamentoDeDados.tratarHorario(horarioDeSaidaTrabalho)));
										
									} else if(horarioDeEntradaMarcacao >= horarioDeEntradaTrabalho && horarioDeSaidaMarcacao >= horarioDeSaidaTrabalho) {
										atrasos.remove(horasTrabalhadas);
										atrasos.add(new Hora(tratamentoDeDados.tratarHorario(horarioDeEntradaTrabalho), tratamentoDeDados.tratarHorario(horarioDeEntradaMarcacao)));
										
									} else if(horarioDeEntradaMarcacao >= horarioDeEntradaTrabalho && horarioDeSaidaMarcacao <= horarioDeSaidaTrabalho) {
										atrasos.remove(horasTrabalhadas);
										atrasos.add(new Hora(tratamentoDeDados.tratarHorario(horarioDeEntradaTrabalho), tratamentoDeDados.tratarHorario(horarioDeEntradaMarcacao)));
										atrasos.add(new Hora(tratamentoDeDados.tratarHorario(horarioDeSaidaMarcacao), tratamentoDeDados.tratarHorario(horarioDeSaidaTrabalho)));
										
									}
								}
							}
						} else {
							if(horarioDeSaidaMarcacao <= horarioDeEntradaTrabalho && horarioDeEntradaMarcacao >= horarioDeSaidaTrabalho) {
								
							} else if(horarioDeSaidaMarcacao >= horarioDeEntradaTrabalho && horarioDeEntradaMarcacao <= horarioDeSaidaTrabalho) {
								atrasos.remove(horasTrabalhadas);
								atrasos.add(new Hora(tratamentoDeDados.tratarHorario(horarioDeSaidaMarcacao), tratamentoDeDados.tratarHorario(horarioDeEntradaMarcacao)));
								
							} else if(horarioDeSaidaMarcacao >= horarioDeEntradaTrabalho && horarioDeEntradaMarcacao >= horarioDeSaidaTrabalho) {
								atrasos.remove(horasTrabalhadas);
								atrasos.add(new Hora(tratamentoDeDados.tratarHorario(horarioDeSaidaMarcacao), tratamentoDeDados.tratarHorario(horarioDeSaidaTrabalho)));
							}
						}
					}
				}
			}
		}

		return atrasos;
	}
}











package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import entity.Hora;
import entity.Horarios;

public class HorariosDeTrabalhoController {
	
	private Hora hora;
	
	public boolean validaHorariosDiferentes(String horarioEntrada, String horarioSaida) {
		if(horarioEntrada.equalsIgnoreCase(horarioSaida)) {
			JOptionPane.showMessageDialog(null, "Horários de entrada e saída devem ser diferentes");
			return false;
		} else {
			return true;
		}
	}

	public boolean validaHorario(String horarioEntrada, String horarioSaida) {

		boolean horarioEntradaValido = Integer.parseInt(horarioEntrada.substring(0, 2)) < 24
				&& Integer.parseInt(horarioEntrada.substring(3, 5)) < 60;

		boolean horarioSaidaValido = Integer.parseInt(horarioSaida.substring(0, 2)) < 24
				&& Integer.parseInt(horarioSaida.substring(3, 5)) < 60;

		if (horarioEntradaValido && horarioSaidaValido) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Informe horários válido");
			return false;
		}
	}

	public boolean verificaDisponibilidadeDeHorario(String horarioEntrada, String horarioSaida,
			ArrayList<Hora> horariosDeTrabalho) {
		
		int contador = 0;
		boolean horarioDisponivel = false;
		
		int hrEntrada = Integer.parseInt((horarioEntrada.substring(0, 2) + horarioEntrada.substring(3, 5)));
		int hrSaida = Integer.parseInt((horarioSaida.substring(0, 2) + horarioSaida.substring(3, 5)));
		
		for(Hora hora : horariosDeTrabalho) {
			int entradaRegistrada = Integer.parseInt((hora.getEntrada().substring(0, 2) + hora.getEntrada().substring(3, 5)));
			int saidaRegistrada = Integer.parseInt((hora.getSaida().substring(0, 2) + hora.getSaida().substring(3, 5)));
			
			if(entradaRegistrada > saidaRegistrada) {
				if(hrEntrada >= saidaRegistrada && hrSaida <= entradaRegistrada) {
					contador++;
				}
			} else if(entradaRegistrada < saidaRegistrada) {
				if(hrEntrada <= entradaRegistrada && hrSaida <= entradaRegistrada) {
					contador++;
				}
				if(hrEntrada >= saidaRegistrada && hrSaida >= saidaRegistrada) {
					contador++;
				}
				if(hrEntrada >= saidaRegistrada && hrSaida <= entradaRegistrada) {
					contador++;
				}
			}
		}
		
		if(contador >= horariosDeTrabalho.size()) {
			horarioDisponivel = true;
		} else {
			horarioDisponivel = false;
		}
		
		return horarioDisponivel;
	}

	public void adcionandoHorarioDeTrabalho(String horaEntrada, String horaSaida, Horarios horarios) {
		try {
			hora = new Hora(horaEntrada, horaSaida);
			horarios.getHorariosDeTrabalho().add(hora);
			
			JOptionPane.showMessageDialog(null, "Horário Cadastrado");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO " + e.getMessage());
		}
	}
}

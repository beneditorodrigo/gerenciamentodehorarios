package model;

import entity.Horarios;

public class ResetDosDados {

	public boolean limparDados(Horarios horarios) {

		try {
			horarios.getHorariosDeTrabalho().clear();
			horarios.getMarcacoesFeitas().clear();
			horarios.getAtrasos().clear();
			horarios.getHorasExtras().clear();

			horarios.setContadorHorarios(0);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

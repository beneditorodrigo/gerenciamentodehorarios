package entity;

public class Hora {

	private String entrada;
	private String saida;
	
	public Hora() {
		
	}

	public Hora(String entrada, String saida) {
		super();
		this.entrada = entrada;
		this.saida = saida;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}
}

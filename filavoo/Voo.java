package filavoo;

public class Voo {
	private int horaChegada;
	private int horaSaida;
	private String origem;
	private String destino;
	
	public Voo(int horaChegada, int horaSaida, String origem,
				String destino) {
		setHoraChegada(horaChegada);
		setHoraSaida(horaSaida);
		setOrigem(origem);
		setDestino(destino);
	}
	public int getHoraChegada() {
		return horaChegada;
	}
	public void setHoraChegada(int horaChegada) {
		this.horaChegada = horaChegada;
	}
	public int getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(int horaSaida) {
		this.horaSaida = horaSaida;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
}

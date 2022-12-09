package add.p12.juego;

public class Record {

	private String iniciales;
	private int puntuacionTotal;

	public Record(String iniciales, int puntuacionTotal) {
		this.iniciales = iniciales;
		this.puntuacionTotal = puntuacionTotal;
	}

	public Record() {

	}

	public String getIniciales() {
		return iniciales;
	}

	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}

	public int getPuntuacionTotal() {
		return puntuacionTotal;
	}

	public void setPuntuacionTotal(int puntuacionTotal) {
		this.puntuacionTotal = puntuacionTotal;
	}

}

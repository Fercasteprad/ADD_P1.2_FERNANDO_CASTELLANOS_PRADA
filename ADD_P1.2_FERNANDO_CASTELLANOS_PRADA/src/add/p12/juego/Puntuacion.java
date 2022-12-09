package add.p12.juego;

public class Puntuacion {

	private int puntos;
	private String respuestaIncorrecta;
	private String respuestaCorrecta;

	public Puntuacion() {

	}

	public Puntuacion(int puntos, String respuestaIncorrecta, String respuestaCorrecta) {
		this.puntos = puntos;
		this.respuestaIncorrecta = respuestaIncorrecta;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getRespuestaIncorrecta() {
		return respuestaIncorrecta;
	}

	public void setRespuestaIncorrecta(String respuestaIncorrecta) {
		this.respuestaIncorrecta = respuestaIncorrecta;
	}

	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

}

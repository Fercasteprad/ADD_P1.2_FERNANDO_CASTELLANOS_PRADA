package add.p12.juego;

import java.io.IOException;
import java.util.ArrayList;

import add.p12.DAO.PreguntaDAO;
import add.p12.PDF.CrearPDF;
import add.p12.menu.MenuService;
import add.p12.pregunta.Pregunta;

public class Juego {
	
	
	public void jugar() {
		
		ArrayList<Pregunta> listaPreguntas = PreguntaDAO.crearPreguntas();
		ArrayList<Puntuacion> puntuacion = new ArrayList<Puntuacion>();
		
		for (int i = 0;i<listaPreguntas.size();i++) {
			
			ArrayList<String> respuestas = new ArrayList<String>();
			Pregunta preguntaSeleccionada = listaPreguntas.get(i);
			respuestas.add(preguntaSeleccionada.getRespuesta1());
			respuestas.add(preguntaSeleccionada.getRespuesta2());
			respuestas.add(preguntaSeleccionada.getRespuesta3());
			System.out.println(preguntaSeleccionada.getPregunta());
			System.out.println("1 - "+preguntaSeleccionada.getRespuesta1());
			System.out.println("2 - "+preguntaSeleccionada.getRespuesta2());
			System.out.println("3 - "+preguntaSeleccionada.getRespuesta3());
			int opcion = MenuService.validar(1,3);
			String respuestaCorrecta = preguntaSeleccionada.getCorrecta();
			int correctaInt = Integer.parseInt(respuestaCorrecta);
			Puntuacion respuestaPuntuacion = new Puntuacion();
			if (respuestas.get(correctaInt-1).equals(respuestas.get(opcion-1))) {
				respuestaPuntuacion.setPuntos(10);
				respuestaPuntuacion.setRespuestaCorrecta(respuestas.get(correctaInt-1));
				respuestaPuntuacion.setRespuestaIncorrecta("");
				puntuacion.add(respuestaPuntuacion);
				System.out.println("Respuesta correcta");
			}
			else {
				respuestaPuntuacion.setPuntos(0);
				respuestaPuntuacion.setRespuestaCorrecta(respuestas.get(correctaInt-1));
				respuestaPuntuacion.setRespuestaIncorrecta(respuestas.get(opcion-1));
				puntuacion.add(respuestaPuntuacion);
				System.err.println("INCORRECTO! la respuesta era "+respuestas.get(correctaInt-1));
			}
			
		}
		
		String iniciales = JuegoService.pasarIniciales();
		int puntosObtenidos = JuegoService.calcularPuntuacion(puntuacion);
		Record record = new Record(iniciales,puntosObtenidos);
		try {
			JuegoService.guardarPuntos(record);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CrearPDF.GenerarPDF(record, puntuacion, listaPreguntas);
		
		
		
		
		
	}

}

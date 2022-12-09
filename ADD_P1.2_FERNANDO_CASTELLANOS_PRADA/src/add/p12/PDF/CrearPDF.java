package add.p12.PDF;


import java.io.FileOutputStream;

import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import add.p12.juego.Record;
import add.p12.pregunta.Pregunta;
import add.p12.juego.Puntuacion;

public class CrearPDF {
	
	public static void GenerarPDF (Record record, ArrayList<Puntuacion> puntuacion, ArrayList<Pregunta> listaPreguntas) {
		
		PdfWriter writer = null;
		Document documento = new Document(PageSize.A4, 20, 20, 70, 50);
		String nombreFichero = record.getIniciales();
		
		try {
			
			writer = PdfWriter.getInstance(documento, new FileOutputStream("./ficheros/"+nombreFichero+"_Partida.pdf"));
			documento.open();
			Paragraph pregunta = new Paragraph();
			for (int i = 0; i<listaPreguntas.size();i++) {
				
				Pregunta escribirPregunta = listaPreguntas.get(i);
				Puntuacion escribirPuntuacion = puntuacion.get(i);
				String numeroPregunta = "Pregunta -"+(i+1);
				
				pregunta.add(numeroPregunta);
				pregunta.add(escribirPregunta.getPregunta());
				pregunta.add(escribirPregunta.getRespuesta1()+"\n");
				pregunta.add(escribirPregunta.getRespuesta2()+"\n");
				pregunta.add(escribirPregunta.getRespuesta3()+"\n");
				pregunta.add(""+nombreFichero+" ha respondido: \n");
				
				if (escribirPuntuacion.getRespuestaIncorrecta().equals("")) {
					pregunta.add(escribirPuntuacion.getRespuestaCorrecta()+"\n");
					pregunta.add("Respuesta Correcta \n");
				}
				
				else {
					pregunta.add(escribirPuntuacion.getRespuestaIncorrecta());
					pregunta.add("Respuesta Incorrecta \n");
				}
				
				
			}
			
			documento.add(pregunta);
			documento.close();
			writer.close();
						
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}

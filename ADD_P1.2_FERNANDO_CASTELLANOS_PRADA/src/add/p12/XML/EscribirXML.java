package add.p12.XML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


import add.p12.pregunta.Pregunta;

public class EscribirXML {

	public static void inicioxml() {
		
		File xml = new File("./ficheros/preguntas.xml");
		
		if (xml.exists()) {
			
		}
		
		else {
			
			String nuevoDocumento = "";

			try {

				Document docNuevo = new Document();

				Element nodoRaiz = new Element("juego");
				docNuevo.addContent(nodoRaiz);

				Element pregunta = new Element("pregunta");
				pregunta.setText("En que año llego el hombre a la Luna?");
				nodoRaiz.addContent(pregunta);

				Element respuesta1 = new Element("respuesta1");
				respuesta1.setText("En 1970");
				pregunta.addContent(respuesta1);

				Element respuesta2 = new Element("respuesta2");
				respuesta2.setText("En 1969");
				pregunta.addContent(respuesta2);

				Element respuesta3 = new Element("respuesta3");
				respuesta3.setText("En 1968");
				pregunta.addContent(respuesta3);

				Element correcta = new Element("correcta");
				correcta.setText("2");
				pregunta.addContent(correcta);

				Element pregunta2 = new Element("pregunta");
				pregunta2.setText("Quien fue el primer presidente de la democracia espanola despues del franquismo?");
				nodoRaiz.addContent(pregunta2);

				Element respuesta01 = new Element("respuesta1");
				respuesta01.setText("Adolfo Suarez");
				pregunta2.addContent(respuesta01);

				Element respuesta02 = new Element("respuesta2");
				respuesta02.setText("Pedro Sanchez");
				pregunta2.addContent(respuesta02);

				Element respuesta03 = new Element("respuesta3");
				respuesta03.setText("Jose maria Aznar");
				pregunta2.addContent(respuesta03);

				Element correcta01 = new Element("correcta");
				correcta01.setText("1");
				pregunta2.addContent(correcta01);

				Element pregunta3 = new Element("pregunta");
				pregunta3.setText("Quien marco el gol que hizo ganar a España el mundial en 2010?");
				nodoRaiz.addContent(pregunta3);

				Element respuesta04 = new Element("respuesta1");
				respuesta04.setText("Puyol");
				pregunta3.addContent(respuesta04);

				Element respuesta05 = new Element("respuesta2");
				respuesta05.setText("Fernando Torres");
				pregunta3.addContent(respuesta05);

				Element respuesta06 = new Element("respuesta3");
				respuesta06.setText("Iniesta");
				pregunta3.addContent(respuesta06);

				Element correcta02 = new Element("correcta");
				correcta02.setText("3");
				pregunta3.addContent(correcta02);

				Element pregunta4 = new Element("pregunta");
				pregunta4.setText("Cual es la montana mas alta de Europa?");
				nodoRaiz.addContent(pregunta4);

				Element respuesta07 = new Element("respuesta1");
				respuesta07.setText("Monte Elbrus");
				pregunta4.addContent(respuesta07);

				Element respuesta08 = new Element("respuesta2");
				respuesta08.setText("Everest");
				pregunta4.addContent(respuesta08);

				Element respuesta09 = new Element("respuesta3");
				respuesta09.setText("Montblanc");
				pregunta4.addContent(respuesta09);

				Element correcta03 = new Element("correcta");
				correcta03.setText("1");
				pregunta4.addContent(correcta03);

				Element pregunta5 = new Element("pregunta");
				pregunta5.setText("Cual es la lengua mas hablada del mundo?");
				nodoRaiz.addContent(pregunta5);

				Element respuesta10 = new Element("respuesta1");
				respuesta10.setText("Ingles");
				pregunta5.addContent(respuesta10);

				Element respuesta11 = new Element("respuesta2");
				respuesta11.setText("Chino");
				pregunta5.addContent(respuesta11);

				Element respuesta12 = new Element("respuesta3");
				respuesta12.setText("Espanol");
				pregunta5.addContent(respuesta12);

				Element correcta04 = new Element("correcta");
				correcta04.setText("2");
				pregunta5.addContent(correcta04);

				Format format = Format.getPrettyFormat();
				XMLOutputter xmloutputter = new XMLOutputter(format);
				nuevoDocumento = xmloutputter.outputString(docNuevo);


			} catch (Exception e) {
				e.printStackTrace();
			}

			FileWriter fichero = null;
			try {
				fichero = new FileWriter("./ficheros/preguntas.xml");
				PrintWriter pw = new PrintWriter(fichero);
				pw.println(nuevoDocumento);
				fichero.close();

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("No existe el fichero");
			}

			
		}
		
		
	}

	public static void escribirPregunta(Pregunta preguntadd) {
		
		
		File xml = new File("./ficheros/preguntas.xml");
		String nuevoDocumento = "";
		SAXBuilder builder = new SAXBuilder();
		
		//boolean repetida = DAOservice.preguntaRepetida(preguntadd.getPregunta());
		
		
			try {
				Document document = builder.build(xml);
				Element rootNode = document.getRootElement();
	
				Pregunta importacion = preguntadd;
				Element pregunta = new Element("pregunta");
				pregunta.setText(importacion.getPregunta());
				rootNode.addContent(pregunta);
	
				Element respuesta1 = new Element("respuesta1");
				respuesta1.setText(importacion.getRespuesta1());
				pregunta.addContent(respuesta1);
	
				Element respuesta2 = new Element("respuesta2");
				respuesta2.setText(importacion.getRespuesta2());
				pregunta.addContent(respuesta2);
	
				Element respuesta3 = new Element("respuesta3");
				respuesta3.setText(importacion.getRespuesta3());
				pregunta.addContent(respuesta3);
	
				Element correcta = new Element("correcta");
				correcta.setText(importacion.getCorrecta());
				pregunta.addContent(correcta);
	
				Format format = Format.getPrettyFormat();
	
				XMLOutputter xmloutputter = new XMLOutputter(format);
				nuevoDocumento = xmloutputter.outputString(document);

	
			} catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			FileWriter fichero = null;
			try {
				fichero = new FileWriter("./ficheros/preguntas.xml");
				PrintWriter pw = new PrintWriter(fichero);
				pw.println(nuevoDocumento);
				fichero.close();
	
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("No existe el fichero");
			}
	
		}

}

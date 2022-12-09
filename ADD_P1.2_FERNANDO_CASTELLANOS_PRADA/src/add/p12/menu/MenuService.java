package add.p12.menu;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import add.p12.DAO.DAOservice;
import add.p12.DAO.PreguntaDAO;
import add.p12.XML.EscribirXML;
import add.p12.juego.JuegoService;
import add.p12.juego.Record;
import add.p12.pregunta.Pregunta;



public class MenuService {
	
	public static Scanner sc = new Scanner (System.in);
	public static Scanner pr = new Scanner (System.in);
	public static Scanner r1 = new Scanner (System.in);
	public static Scanner r2 = new Scanner (System.in);
	public static Scanner r3 = new Scanner (System.in);
	public static Scanner c = new Scanner (System.in);
	
	public int opcionMenuAdmin() {
			
		int opcion = -1;
		
		do {
			
			System.out.println("Elige una de las siguientes opciones");
			System.out.println("1 - Jugar");
			System.out.println("2 - Añadir preguntas");
			System.out.println("3 - Importar preguntas");
			System.out.println("4 - Ver records");
			System.out.println("5 - Instrucciones");
			System.out.println("0 - Salir");
			opcion = sc.nextInt();
			
		} while (opcion < 0 || opcion >5);
		
		
		return opcion;
		
		
		
	}
	
	public int opcionMenuUser() {
		
		int opcion = -1;
		
		do {
			
			System.out.println("Elige una de las siguientes opciones");
			System.out.println("1 - Jugar");
			System.out.println("2 - Ver records");
			System.out.println("3 - Instrucciones");
			System.out.println("0 - Salir");
			opcion = sc.nextInt();
			
		} while (opcion < 0 || opcion >3);
		
		
		return opcion;
		
		
		
	}
	
	public static int validar (int minimo, int maximo) {
		
		
		
		int opcion = -1;
		
		while (opcion < minimo || opcion>maximo) {
			System.out.println("Elija una de las opciones");
			opcion = sc.nextInt();
		}
		
	
		return opcion;
		
	}
	
	public static void imprimir (String texto) {
		System.out.println(texto);
	}
	
	public static void addPregunta() {
		
		System.out.println("Que pregunta quieres anadir?");
		String pregunta = pr.nextLine();
		System.out.println("primera respuesta");
		String respuesta1 = r1.next();
		System.out.println("segunda respuesta");
		String respuesta2 = r2.next();
		System.out.println("tercera respuesta");
		String respuesta3 = r3.next();
		System.out.println("cual de las tres es la respuesta correcta? Usa numero");
		String correcta = c.next();
		
		Pregunta preguntaAdd = new Pregunta (pregunta,respuesta1,respuesta2,respuesta3,correcta);
		EscribirXML.escribirPregunta(preguntaAdd);
		System.out.println("Pregunta subida correctamente");
		
		
	}
	
	public static void importarExcel() {
		
		String opcion = "";
		
		System.out.println("Estas seguro de importar el excel?S/N");
		opcion = sc.next();
		
		
		if (opcion.equalsIgnoreCase("S")) {
			DAOservice.importarExcel();	
			System.out.println("Se ha importado correctamente");
		}
		
		else {
			System.out.println("Se ha cancelado la importacion");
		}
		
	}
	
	public static void mostrarRecords() {
		
		
		ArrayList<Record> listadoRecordsDesordenado = JuegoService.devolverRecords();
		if (listadoRecordsDesordenado.size() != 0) {
			Collections.sort(listadoRecordsDesordenado,new Comparator<Record>() {

				@SuppressWarnings("removal")
				@Override
				public int compare(Record p1, Record p2) {
					return new Integer(p2.getPuntuacionTotal()).compareTo(new Integer(p1.getPuntuacionTotal()));
				}
				
			});
		
			
			for (int i = 0;i<listadoRecordsDesordenado.size();i++) {
				System.out.println(listadoRecordsDesordenado.get(i).getIniciales()+" = "+listadoRecordsDesordenado.get(i).getPuntuacionTotal());
			}
		}
		else {
			System.out.println("No hay records que mostrar");
		}
		

		
	}
	
	public static void mostrarInstrucciones() {
		
		ArrayList<Pregunta> listaPreguntas = PreguntaDAO.crearPreguntas();
		int numeroPreguntas = listaPreguntas.size();
		System.out.println("El juego consta de "+numeroPreguntas+" preguntas");
		System.out.println("Cada pregunta tiene 3 opciones, una vez elijas una el juego te dira si es correcta o no");
		System.out.println("En el caso de acertar la pregunta sumaras 10 puntos, al final del juego se sumara todos los puntos y registrara tu partida");
		System.out.println("Puedes acertar todas las preguntas?");
		System.out.println("Intenta superar el record de Fer, todos sabemos que no seras capaz!");
		
	}
		

}

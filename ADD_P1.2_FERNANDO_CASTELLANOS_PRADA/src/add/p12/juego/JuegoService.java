package add.p12.juego;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class JuegoService {
	
	public static String pasarIniciales () {
		
		@SuppressWarnings("resource")
		Scanner scNombre = new Scanner (System.in);
		System.out.println("Introduce tu nombre y apellidos seguidos de un espacio");
		String nombre = scNombre.nextLine();
		
		String inicialNombre = nombre.substring(0, 1);
		String inicialApellido = " ";
		String inicialSegundoApellido = "";
		
		for (int i = 0;i<nombre.length();i++) {
			
			String comparador = nombre.substring(i, i+1);
			
			if (comparador.equals(" ")) {
				
				if (inicialApellido.equals(" ")) {
					inicialApellido = nombre.substring(i+1, i+2);
				}
				else {
					inicialSegundoApellido = nombre.substring(i+1, i+2);
				}
				
			}
				
			
		}
		
		String inicialesMayus = inicialNombre + inicialApellido + inicialSegundoApellido;
		inicialesMayus = inicialesMayus.toUpperCase();
		
	
		
		return inicialesMayus;
	}
	
	public static int calcularPuntuacion (ArrayList<Puntuacion> puntuacion) {
		
		int puntos = 0;
		
		for (int i = 0;i<puntuacion.size();i++) {
			
			puntos = puntos + (puntuacion.get(i).getPuntos()*10);
			
		}
		
		return puntos;
		
	}
	
	public static void guardarPuntos(Record record) throws IOException {
		
		File records = new File ("./ficheros/records.txt");
		if (records.exists()) {
			Record inicialConRecord = comprobarRecordFichero(record.getIniciales());
			//Si es diferente de null y el record del registro es menor que la puntuacion actual entra
			if ((inicialConRecord.getIniciales() != null) && (inicialConRecord.getPuntuacionTotal() < record.getPuntuacionTotal())) {
				sobreescribirRecord(record);
				System.out.println("Has batido tu propio record !!");
			}
			
			else if (inicialConRecord.getIniciales() == null){
				guardarRecord(record);
				System.out.println("Se ha registrado tu puntuacion");
			}
			
			
		}
		
		else {
			guardarPrimerRecord(record);
			System.out.println("Se ha registrado tu puntuacion");
		}
		
	}
	
	public static Record comprobarRecordFichero(String iniciales) throws IOException {
		
		
		Record recordConmismasIniciales = new Record();
		try {
		
		FileReader leoArchivo = new FileReader("./ficheros/records.txt");
		@SuppressWarnings("resource")
		BufferedReader loLeo = new BufferedReader(leoArchivo);
		String comparador = loLeo.readLine();
		
		while (comparador != null) {
			String compararIniciales = sacarInicialesFichero(comparador);
			int puntuacion = sacarPuntuacionFichero(comparador);
			
			if (iniciales.equals(compararIniciales)) {
				
				Record guardado = new Record(compararIniciales,puntuacion);
				recordConmismasIniciales = guardado;
				   
			}
			comparador=loLeo.readLine();
		}
		
		loLeo.close();
		leoArchivo.close();
		return recordConmismasIniciales;
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return recordConmismasIniciales;
		}
	}
	
	public static String sacarInicialesFichero(String texto) {
		
			String iniciales = "";
			for (int i = 0; i < texto.length(); i++) {
				String ver = texto.substring(i,i+1);
				if (ver.equals("=")) {
					iniciales = texto.substring(0, i-1);
				}
			}
			
			return iniciales;
		
	}
	
	public static int sacarPuntuacionFichero(String texto) {
		
		String puntuacionString = "";
		for (int i = 0; i < texto.length(); i++) {
			String ver = texto.substring(i,i+1);
			if (ver.equals("=")) {
				puntuacionString = texto.substring(i+2, texto.length());
			}
		}
		
		int puntuacion = Integer.parseInt(puntuacionString);
		return puntuacion;
		
		
	}
	
	public static void guardarPrimerRecord (Record record) {
		try {
			File records = new File ("./ficheros/records.txt");
			FileWriter escribir = new FileWriter(records);
			BufferedWriter escribirRecord = new BufferedWriter(escribir);
			escribirRecord.write(record.getIniciales() + " = " + record.getPuntuacionTotal());
			escribirRecord.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error al escribir el archivo");
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo");
		}
	}
	
	public static void guardarRecord (Record record) {
		try {
			File records = new File ("./ficheros/records.txt");
			FileWriter escribir = new FileWriter(records,true);
			BufferedWriter escribirRecord = new BufferedWriter(escribir);
			escribirRecord.newLine();
			escribirRecord.write(record.getIniciales() + " = " + record.getPuntuacionTotal());
			escribirRecord.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error al escribir el archivo");
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo");
		}
	}
	
	public static void sobreescribirRecord (Record record) {
		
		File newRecord = new File("./ficheros/auxiliar.txt");
		File records = new File("./ficheros/records.txt");
		
		try {
			
			FileReader leoArchivo = new FileReader(records);
			@SuppressWarnings("resource")
			BufferedReader loLeo = new BufferedReader(leoArchivo);
			String comparador = loLeo.readLine();
			FileWriter sobreEscribirRecord = new FileWriter(newRecord);
			BufferedWriter escribirRecord = new BufferedWriter(sobreEscribirRecord);
			int contador = 0;
			while (comparador != null) {

				if (comparador.substring(0, 3).equals(record.getIniciales())) {
					if (contador == 0) {
						escribirRecord.write(record.getIniciales() + " = " + record.getPuntuacionTotal());
					}
					else {
						escribirRecord.newLine();
						escribirRecord.write(record.getIniciales() + " = " + record.getPuntuacionTotal());
					}
					
				}
				else {
					if (contador == 0) {
						escribirRecord.write(comparador);
					}
					else {
						escribirRecord.newLine();
						escribirRecord.write(comparador);
					}
										
				}
				contador++;
				comparador = loLeo.readLine();
			}
			
			loLeo.close();
			escribirRecord.close();
			leoArchivo.close();
			sobreEscribirRecord.close();
			

			


		} catch (FileNotFoundException e) {
			System.out.println("Error al escribir el archivo");
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo");
		}
		
		records.delete();
		File nuevoNombre = new File("./ficheros/records.txt");
		newRecord.renameTo(nuevoNombre);
	}
	
	public static ArrayList<Record> devolverRecords(){
		
		ArrayList<Record> listadoRecords = new ArrayList<Record>();
		
		File records = new File ("./ficheros/records.txt");
		
		if (records.exists()) {
			try {
				
				FileReader leoArchivo = new FileReader(records);
				@SuppressWarnings("resource")
				BufferedReader loLeo = new BufferedReader(leoArchivo);
				String comparador;
				
				comparador = loLeo.readLine();
				
				while (comparador != null) {
					String compararIniciales = sacarInicialesFichero(comparador);
					int puntuacion = sacarPuntuacionFichero(comparador);
					Record anadirRecord = new Record(compararIniciales,puntuacion);
					listadoRecords.add(anadirRecord);
					comparador=loLeo.readLine();
				}
				
				loLeo.close();
				leoArchivo.close();
				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					return null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
				
		return listadoRecords;
		
	}

}

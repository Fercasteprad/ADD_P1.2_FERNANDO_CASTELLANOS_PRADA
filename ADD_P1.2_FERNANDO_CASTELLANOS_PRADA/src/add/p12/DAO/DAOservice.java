package add.p12.DAO;

import java.util.ArrayList;

import add.p12.XLS.LeerXLS;
import add.p12.XML.EscribirXML;

import add.p12.pregunta.Pregunta;

public class DAOservice {
	
//	private static ArrayList<Pregunta> preguntas = LeerXML.xmlsetArray();
	
	/*public static boolean preguntaRepetida(String texto) {
		
		boolean repetida = false;
		for (int i = 0; i<preguntas.size();i++) {
			
			Pregunta comparador = preguntas.get(i);
			
			String comparadorPregunta = "\n    "+texto+"\n    \n    \n    \n";
					
			
			if (comparador.getPregunta().equalsIgnoreCase(texto)) {
				repetida = true;
			}
		}
				
		return repetida;
		
	}*/
	
	public static void importarExcel() {
		
		ArrayList<Pregunta> inputXLS = LeerXLS.importacionExcel();
		if (inputXLS != null) {
			
			for (int i = 0;i<inputXLS.size();i++) {
				Pregunta importada = inputXLS.get(i);
				EscribirXML.escribirPregunta(importada);
								
			}
			
		}
		
	}
	
	public static void creaFicheroXML() {
		
		EscribirXML.inicioxml();
				
	}
	
	public static Usuario devolverUsuario(String nombre, String pass) {
		
		ArrayList<Usuario> listaUsuarios = UsuarioDAO.listaUsuarios;
		
		Usuario usuarioDevuelto = new Usuario();
		
		for (int i = 0; i<listaUsuarios.size();i++) {
			Usuario comparador = listaUsuarios.get(i);
			if (comparador.getUsuario().equalsIgnoreCase(nombre) && comparador.getPass().equalsIgnoreCase(pass)) {
				usuarioDevuelto = comparador;
			}
		}
		
		
		return usuarioDevuelto;
		
	}

}

package add.p12.DAO;

import java.util.ArrayList;


import add.p12.XML.LeerXML;
import add.p12.pregunta.Pregunta;

public class PreguntaDAO {
	
	private static ArrayList<Pregunta> preguntas = crearPreguntas();
	
	public static ArrayList<Pregunta> getPreguntas(){
		return preguntas;
	}
			
	public static ArrayList<Pregunta> crearPreguntas() {
			
		ArrayList<Pregunta> setXML = LeerXML.xmlsetArray();
		return setXML;
		
	}
	
	
}

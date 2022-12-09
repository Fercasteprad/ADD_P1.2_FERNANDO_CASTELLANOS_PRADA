package add.p12.XML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import add.p12.pregunta.Pregunta;

public class LeerXML {

	public static ArrayList <Pregunta> xmlsetArray() {
		
		SAXBuilder builder = new SAXBuilder();
		
		File xmlFile = new File("./ficheros/preguntas.xml");
		
		ArrayList <Pregunta> preguntasJuego = new ArrayList <Pregunta>();
		
		try {
			
			Document document = builder.build(xmlFile);
			
			Element rootNode = document.getRootElement();
						
			List<Element> lista_preguntas = rootNode.getChildren("pregunta");
			
			for (int i = 0; i<lista_preguntas.size();i++) {
				
				Element pregunta = (Element) lista_preguntas.get(i);
				String pregunta1 = pregunta.getText();
				String respuesta1 = pregunta.getChildText("respuesta1");
				String respuesta2 = pregunta.getChildText("respuesta2");
				String respuesta3 = pregunta.getChildText("respuesta3");
				String correcta = pregunta.getChildText("correcta");
				
				Pregunta preg = new Pregunta (pregunta1,respuesta1,respuesta2,respuesta3,correcta);
				preguntasJuego.add(preg);
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return preguntasJuego;

	}

}

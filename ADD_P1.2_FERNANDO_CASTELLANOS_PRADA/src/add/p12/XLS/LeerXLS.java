package add.p12.XLS;

import java.io.File;
import java.util.ArrayList;

import add.p12.pregunta.Pregunta;
import jxl.Sheet;
import jxl.Workbook;

public class LeerXLS {
	
	public static ArrayList<Pregunta> importacionExcel() {
		
		File fichero = new File("./ficheros/preguntas.xls");
		ArrayList<Pregunta> importPreguntasXLS = new ArrayList<Pregunta>();
		
		try {
			
			Workbook w = Workbook.getWorkbook(fichero);
			
			Sheet sheet = w.getSheet(0);
			
			
			
			for (int f=1; f<sheet.getRows();f++) {
				
				String pregunta = sheet.getCell(0, f).getContents();
				String respuesta1 = sheet.getCell(1, f).getContents();
				String respuesta2 = sheet.getCell(2, f).getContents();
				String respuesta3 = sheet.getCell(3, f).getContents();
				String correcta = sheet.getCell(4, f).getContents();
				Pregunta addPregunta = new Pregunta(pregunta,respuesta1,respuesta2,respuesta3,correcta);
				importPreguntasXLS.add(addPregunta);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return importPreguntasXLS;
		
	}

}

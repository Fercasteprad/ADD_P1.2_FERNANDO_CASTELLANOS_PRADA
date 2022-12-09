package add.p12.menu;


import add.p12.juego.Juego;

public class Menu {
	
	public static void menuAdmin() {
		
		boolean salir = false;
		
		while (!salir) {
			
			int menu = new MenuService().opcionMenuAdmin();
			if (menu == 1) {
				
				new Juego().jugar();
				
			}
			
			else if (menu == 2) {
				
				MenuService.addPregunta();
				
			}
			
			else if (menu == 3) {
				
				MenuService.importarExcel();
				
			}
			
			else if (menu == 4) {
				
				MenuService.mostrarRecords();
				
			}
			
			else if (menu ==5) {
				
				MenuService.mostrarInstrucciones();
				
			}
			
			else {
				salir = true;
				System.out.println("Has salido del juego");
			}
			
		}
		
	}
	
public static void menuUser() {
		
		boolean salir = false;
		
		while (!salir) {
			
			int menu = new MenuService().opcionMenuUser();
			if (menu == 1) {
				
				new Juego().jugar();
				
			}
			
			else if (menu == 2) {
				
				MenuService.mostrarRecords();
				
			}
			
			else if (menu == 3 ) {
				
				MenuService.mostrarInstrucciones();
				
			}
			
			else {
				salir = true;
				System.out.println("Has salido del juego");
			}
			
		}
		
	}

}

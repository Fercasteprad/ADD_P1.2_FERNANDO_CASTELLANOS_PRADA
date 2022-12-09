package add.p12.main;


import add.p12.DAO.DAOservice;
import add.p12.menu.Menu;


public class MainP12 {

	public static void main(String[] args) {
		
		DAOservice.creaFicheroXML();
		
		boolean salir = false;
		
		while(!salir) {
			
			boolean usuarioAdmin = MainService.logJuego();
			if (usuarioAdmin) {
				
				Menu.menuAdmin();
				
			}
			
			else {
				
				Menu.menuUser();
				
			}
			
			
		}
		
		
		
	}

}

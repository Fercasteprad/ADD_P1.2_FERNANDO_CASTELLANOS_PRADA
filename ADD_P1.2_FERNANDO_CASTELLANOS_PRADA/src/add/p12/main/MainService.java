package add.p12.main;

import java.util.Scanner;

import add.p12.DAO.DAOservice;
import add.p12.DAO.Usuario;

public class MainService {
	
	public static Scanner nombre = new Scanner(System.in);
	public static Scanner contrasena = new Scanner(System.in);
	
	public static boolean logJuego() {
		
		
		System.out.println("Introduce tu nombre");
		String nombreUsuario = nombre.next();
		System.out.println("Introduce tu contrasena");
		String pass = contrasena.next();
		
		Usuario usuario = DAOservice.devolverUsuario(nombreUsuario,pass);
		if (usuario.getUsuario() != null) {
			boolean esAdmin = usuario.isAdmin();
			return esAdmin;
		}
		
		else {
			System.out.println("Ese usuario no existe");
			return false;
		}
	}

}

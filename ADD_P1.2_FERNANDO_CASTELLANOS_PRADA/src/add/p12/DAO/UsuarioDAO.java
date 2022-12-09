package add.p12.DAO;

import java.util.ArrayList;

public class UsuarioDAO {
	
	public static ArrayList<Usuario> listaUsuarios = listaUsuarios();	
	
	public static ArrayList<Usuario> listaUsuarios(){
		
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Usuario admin = new Usuario("Fer","1234",true);
		listaUsuarios.add(admin);
		Usuario alicia = new Usuario("Alicia","samsung1",false);
		listaUsuarios.add(alicia);
		return listaUsuarios;
	}

}

package add.p12.DAO;

public class Usuario {

	private String usuario;
	private String pass;
	private boolean admin;

	public Usuario() {
	}

	public Usuario(String usuario, String pass, boolean admin) {
		this.usuario = usuario;
		this.pass = pass;
		this.admin = admin;
	}
	
	public Usuario(String usuario, String pass) {
		this.usuario = usuario;
		this.pass = pass;
		this.admin = false;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}

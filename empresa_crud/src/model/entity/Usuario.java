package model.entity;

public class Usuario {
	private int id;
	private String usuario;
	private String senha;
	private int nivel;
	
	public Usuario(int id, String usuario, String senha, int nivel) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.nivel = nivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	

}

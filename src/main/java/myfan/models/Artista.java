package myfan.models;

import java.util.ArrayList;

import myfan.models.UserEntity;;

public class Artista extends UserEntity {
	private String login;
	private String password;
	private String nombre;
	private String ubicacion;
	
	private String correo;
	private String hashtag;
	private String añoCreacion;
	//private ArrayList<String> generos;
	private String biografia;
	private String integrantes;
	private String foto;
	
	
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getAñoCreacion() {
		return añoCreacion;
	}

	public void setAñoCreacion(String añoCreacion) {
		this.añoCreacion = añoCreacion;
	}

	

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(String integrantes) {
		this.integrantes = integrantes;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	


}

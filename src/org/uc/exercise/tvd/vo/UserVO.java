package org.uc.exercise.tvd.vo;

import java.util.Arrays;

public class UserVO {
	private Integer idUser;
	private String nombre;
	private String paterno;
	private String materno;
	private String username;
	private String password;
	private String rol;
	private String email;
	private byte[] foto;
	/**
	 * @return the idUser
	 */
	public Integer getIdUser() {
		return idUser;
	}
	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the paterno
	 */
	public String getPaterno() {
		return paterno;
	}
	/**
	 * @param paterno the paterno to set
	 */
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	/**
	 * @return the materno
	 */
	public String getMaterno() {
		return materno;
	}
	/**
	 * @param materno the materno to set
	 */
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}
	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	/**
	 * @return the foto
	 */
	public byte[] getFoto() {
		return foto;
	}
	/**
	 * @param foto the foto to set
	 */
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserVO [idUser=" + idUser + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno
				+ ", username=" + username + ", password=" + password + ", rol=" + rol + ", email=" + email + ", foto="
				+ Arrays.toString(foto) + "]";
	}
	
	
}

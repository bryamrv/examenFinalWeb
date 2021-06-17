package com.bryam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String email;

	private String pass;

	private short state;

	private String usuario;

	//bi-directional many-to-one association to Connectiontoken
	@OneToMany(mappedBy="usuario")
	private List<Connectiontoken> connectiontokens;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="role")
	private Rol rol;

	public Usuario() {
	}
	

	public Usuario(String email, String pass, short state, String usuario, Rol rol) {
		this.email = email;
		this.pass = pass;
		this.state = state;
		this.usuario = usuario;
		this.rol = rol;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public short getState() {
		return this.state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Connectiontoken> getConnectiontokens() {
		return this.connectiontokens;
	}

	public void setConnectiontokens(List<Connectiontoken> connectiontokens) {
		this.connectiontokens = connectiontokens;
	}

	public Connectiontoken addConnectiontoken(Connectiontoken connectiontoken) {
		getConnectiontokens().add(connectiontoken);
		connectiontoken.setUsuario(this);

		return connectiontoken;
	}

	public Connectiontoken removeConnectiontoken(Connectiontoken connectiontoken) {
		getConnectiontokens().remove(connectiontoken);
		connectiontoken.setUsuario(null);

		return connectiontoken;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
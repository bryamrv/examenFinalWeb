package com.bryam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typedb database table.
 * 
 */
@Entity
@NamedQuery(name="Typedb.findAll", query="SELECT t FROM Typedb t")
public class Typedb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String aditional;

	private String description;

	private String driver;

	//bi-directional many-to-one association to Connectiontoken
	@OneToMany(mappedBy="typedb")
	private List<Connectiontoken> connectiontokens;

	public Typedb() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAditional() {
		return this.aditional;
	}

	public void setAditional(String aditional) {
		this.aditional = aditional;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDriver() {
		return this.driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public List<Connectiontoken> getConnectiontokens() {
		return this.connectiontokens;
	}

	public void setConnectiontokens(List<Connectiontoken> connectiontokens) {
		this.connectiontokens = connectiontokens;
	}

	public Connectiontoken addConnectiontoken(Connectiontoken connectiontoken) {
		getConnectiontokens().add(connectiontoken);
		connectiontoken.setTypedb(this);

		return connectiontoken;
	}

	public Connectiontoken removeConnectiontoken(Connectiontoken connectiontoken) {
		getConnectiontokens().remove(connectiontoken);
		connectiontoken.setTypedb(null);

		return connectiontoken;
	}

}
package com.bryam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the seguimiento database table.
 * 
 */
@Entity
@NamedQuery(name="Seguimiento.findAll", query="SELECT s FROM Seguimiento s")
public class Seguimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp dategenerate;

	private String detailrequest;

	private String filegenerate;

	private String result;

	private short state;

	private String type;

	//bi-directional many-to-one association to Reporte
	@ManyToOne
	@JoinColumn(name="report")
	private Reporte reporte;

	public Seguimiento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDategenerate() {
		return this.dategenerate;
	}

	public void setDategenerate(Timestamp dategenerate) {
		this.dategenerate = dategenerate;
	}

	public String getDetailrequest() {
		return this.detailrequest;
	}

	public void setDetailrequest(String detailrequest) {
		this.detailrequest = detailrequest;
	}

	public String getFilegenerate() {
		return this.filegenerate;
	}

	public void setFilegenerate(String filegenerate) {
		this.filegenerate = filegenerate;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public short getState() {
		return this.state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Reporte getReporte() {
		return this.reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}

}
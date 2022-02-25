package com.lasviewer.lasview.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WELL_INFORMATION")
public class WellInformation  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idWell;
	@Column(name = "name_well")
	private String nameWell;
	private String description;

	public WellInformation() {
		super();
	}
	
	public String getIdWell() {
		return idWell;
	}
	public void setIdWell(String idWell) {
		this.idWell = idWell;
	}
	public String getNameWell() {
		return nameWell;
	}
	public void setNameWell(String nameWell) {
		this.nameWell = nameWell;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}

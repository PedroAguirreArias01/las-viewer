package com.lasviewer.lasview.models.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "WELL_INFORMATION")
public class WellInformation  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_well")
	private String idWell;
	@Column(name = "name_well")
	private String nameWell;
	private String company;

    @OneToMany(mappedBy = "WellInformation")
    private Set<LogWell> listLogWell = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "id_location")
    private LocationWell locationWell;
    
	public WellInformation() {
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Set<LogWell> getListLogWell() {
		return listLogWell;
	}

	public void setListLogWell(Set<LogWell> listLogWell) {
		this.listLogWell = listLogWell;
	}

	public LocationWell getLocationWell() {
		return locationWell;
	}

	public void setLocationWell(LocationWell locationWell) {
		this.locationWell = locationWell;
	}
	
}

package com.lasviewer.lasview.models.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "LOCATION_WELL")
public class LocationWell implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_location")
	private Long idLocation;
	private String field;
	private String Location;
	private String county;
	private String state;
	private String section;
	private String township;
	private String range;
	
	@OneToMany(mappedBy="locationWell")
    private Set<WellInformation> listWell = new HashSet<>();
	
	public Set<WellInformation> getListWell() {
		return listWell;
	}

	public void setListWell(Set<WellInformation> listWell) {
		this.listWell = listWell;
	}

	public LocationWell() {
		super();
	}
	
	public Long getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(Long idLocation) {
		this.idLocation = idLocation;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getTownship() {
		return township;
	}
	public void setTownship(String township) {
		this.township = township;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	

}

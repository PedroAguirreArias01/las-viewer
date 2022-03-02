package com.lasviewer.lasview.models.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CURVE_INFORMATION_PARAMS")
public class CurveInformationParam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String name;
	private String units;
	private String description;
	
    @OneToMany(mappedBy="curveInformationParam")
    private Set<CurveData> listCurveDatas = new HashSet<>();
	
	public CurveInformationParam() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Set<CurveData> getListCurveDatas() {
		return listCurveDatas;
	}

	public void setListCurveDatas(Set<CurveData> listCurveDatas) {
		this.listCurveDatas = listCurveDatas;
	}
	
}

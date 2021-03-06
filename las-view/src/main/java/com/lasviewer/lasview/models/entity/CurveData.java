package com.lasviewer.lasview.models.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "CURVE_DATA")
public class CurveData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_curve_data")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCurveData;
	private Double Value;
	private Double depth;
	//@Column(name = "fk_curve_information_param")
	@ManyToOne
	@JoinColumn(name = "name")
	private CurveInformationParam curveInformationParam;
	
	 @OneToMany(mappedBy = "curveData")
	 private Set<LogWell> listLogWell = new HashSet<>();
	
	public CurveData() {
		super();
	}
	
	
	public Double getValue() {
		return Value;
	}


	public void setValue(Double value) {
		Value = value;
	}


	public Double getDepth() {
		return depth;
	}


	public void setDepth(Double depth) {
		this.depth = depth;
	}


	public CurveInformationParam getCurveInformationParam() {
		return curveInformationParam;
	}
	public void setCurveInformationParam(CurveInformationParam curveInformationParam) {
		this.curveInformationParam = curveInformationParam;
	}

	public Long getIdCurveData() {
		return idCurveData;
	}

	public void setIdCurveData(Long idCurveData) {
		this.idCurveData = idCurveData;
	}

	public Set<LogWell> getListLogWell() {
		return listLogWell;
	}

	public void setListLogWell(Set<LogWell> listLogWell) {
		this.listLogWell = listLogWell;
	}
	
	
}

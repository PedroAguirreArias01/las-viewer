package com.lasviewer.lasview.models.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOG_WELL")
public class LogWell implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Date log_date;
	@Column(name = "start_depth")
	private Double startDepth;
	@Column(name = "end_depth")
	private Double endDepth;
	private Double step;
	
	@Column(name = "fk_curve_data")
	@ManyToOne
    @JoinColumn(name = "id_curve_data")
	private CurveData curveData;
	
	@Column(name = "fk_well")
	@ManyToOne
	@JoinColumn(name = "id_well")
	private WellInformation WellInformation;
	
	
	public LogWell() {
		super();
	}
	
	public Date getLog_date() {
		return log_date;
	}
	public void setLog_date(Date log_date) {
		this.log_date = log_date;
	}
	public CurveData getCurveData() {
		return curveData;
	}
	public void setCurveData(CurveData curveData) {
		this.curveData = curveData;
	}
	public WellInformation getWellInformation() {
		return WellInformation;
	}
	public void setWellInformation(WellInformation wellInformation) {
		WellInformation = wellInformation;
	}
	public Double getStartDepth() {
		return startDepth;
	}
	public void setStartDepth(Double startDepth) {
		this.startDepth = startDepth;
	}
	public Double getEndDepth() {
		return endDepth;
	}
	public void setEndDepth(Double endDepth) {
		this.endDepth = endDepth;
	}
	public Double getStep() {
		return step;
	}
	public void setStep(Double step) {
		this.step = step;
	}
	
}

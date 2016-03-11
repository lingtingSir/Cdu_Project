package org.vo;

import java.sql.Timestamp;

/**
 * Record entity. @author MyEclipse Persistence Tools
 */

public class Record implements java.io.Serializable {

	// Fields

	private Integer recordId;
	private ProjectPaper projectPaper;
	private Timestamp presentDate;
	private String des;
	private String x;

	// Constructors

	/** default constructor */
	public Record() {
	}

	/** full constructor */
	public Record(ProjectPaper projectPaper, Timestamp presentDate, String des,
			String x) {
		this.projectPaper = projectPaper;
		this.presentDate = presentDate;
		this.des = des;
		this.x = x;
	}

	// Property accessors

	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public ProjectPaper getProjectPaper() {
		return this.projectPaper;
	}

	public void setProjectPaper(ProjectPaper projectPaper) {
		this.projectPaper = projectPaper;
	}

	public Timestamp getPresentDate() {
		return this.presentDate;
	}

	public void setPresentDate(Timestamp presentDate) {
		this.presentDate = presentDate;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getX() {
		return this.x;
	}

	public void setX(String x) {
		this.x = x;
	}

}
package org.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ProjectPaper entity. @author MyEclipse Persistence Tools
 */

public class ProjectPaper implements java.io.Serializable {

	// Fields

	private Integer ppid;
	private PaperType paperType;
	private Department department;
	private Client client;
	private String name;
	private String selfResource;
	private Timestamp registerDate;
	private Timestamp overDate;
	private Timestamp fhdateTime;
	private String ppdesc;
	private String projectHead;
	private Integer state;
	private Set records = new HashSet(0);

	// Constructors

	/** default constructor */
	public ProjectPaper() {
	}

	/** full constructor */
	public ProjectPaper(PaperType paperType, Department department,
			Client client, String name, String selfResource,
			Timestamp registerDate, Timestamp overDate, Timestamp fhdateTime,
			String ppdesc, String projectHead, Integer state, Set records) {
		this.paperType = paperType;
		this.department = department;
		this.client = client;
		this.name = name;
		this.selfResource = selfResource;
		this.registerDate = registerDate;
		this.overDate = overDate;
		this.fhdateTime = fhdateTime;
		this.ppdesc = ppdesc;
		this.projectHead = projectHead;
		this.state = state;
		this.records = records;
	}

	// Property accessors

	public Integer getPpid() {
		return this.ppid;
	}

	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	public PaperType getPaperType() {
		return this.paperType;
	}

	public void setPaperType(PaperType paperType) {
		this.paperType = paperType;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSelfResource() {
		return this.selfResource;
	}

	public void setSelfResource(String selfResource) {
		this.selfResource = selfResource;
	}

	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public Timestamp getOverDate() {
		return this.overDate;
	}

	public void setOverDate(Timestamp overDate) {
		this.overDate = overDate;
	}

	public Timestamp getFhdateTime() {
		return this.fhdateTime;
	}

	public void setFhdateTime(Timestamp fhdateTime) {
		this.fhdateTime = fhdateTime;
	}

	public String getPpdesc() {
		return this.ppdesc;
	}

	public void setPpdesc(String ppdesc) {
		this.ppdesc = ppdesc;
	}

	public String getProjectHead() {
		return this.projectHead;
	}

	public void setProjectHead(String projectHead) {
		this.projectHead = projectHead;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set getRecords() {
		return this.records;
	}

	public void setRecords(Set records) {
		this.records = records;
	}

}
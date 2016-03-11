package org.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * PaperType entity. @author MyEclipse Persistence Tools
 */

public class PaperType implements java.io.Serializable {

	// Fields

	private Integer ptid;
	private String ptname;
	private String ptdesc;
	private Set projectPapers = new HashSet(0);

	// Constructors

	/** default constructor */
	public PaperType() {
	}

	/** full constructor */
	public PaperType(String ptname, String ptdesc, Set projectPapers) {
		this.ptname = ptname;
		this.ptdesc = ptdesc;
		this.projectPapers = projectPapers;
	}

	// Property accessors

	public Integer getPtid() {
		return this.ptid;
	}

	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	public String getPtname() {
		return this.ptname;
	}

	public void setPtname(String ptname) {
		this.ptname = ptname;
	}

	public String getPtdesc() {
		return this.ptdesc;
	}

	public void setPtdesc(String ptdesc) {
		this.ptdesc = ptdesc;
	}

	public Set getProjectPapers() {
		return this.projectPapers;
	}

	public void setProjectPapers(Set projectPapers) {
		this.projectPapers = projectPapers;
	}

}
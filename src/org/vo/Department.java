package org.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer departmentId;
	private String departmentName;
	private String departmentDes;
	private String x;
	private String y;
	private String z;
	private Set userses = new HashSet(0);
	private Set managers = new HashSet(0);
	private Set classeses = new HashSet(0);
	private Set projectPapers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** full constructor */
	public Department(String departmentName, String departmentDes, String x,
			String y, String z, Set userses, Set managers, Set classeses,
			Set projectPapers) {
		this.departmentName = departmentName;
		this.departmentDes = departmentDes;
		this.x = x;
		this.y = y;
		this.z = z;
		this.userses = userses;
		this.managers = managers;
		this.classeses = classeses;
		this.projectPapers = projectPapers;
	}

	// Property accessors

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDes() {
		return this.departmentDes;
	}

	public void setDepartmentDes(String departmentDes) {
		this.departmentDes = departmentDes;
	}

	public String getX() {
		return this.x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return this.y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getZ() {
		return this.z;
	}

	public void setZ(String z) {
		this.z = z;
	}

	public Set getUserses() {
		return this.userses;
	}

	public void setUserses(Set userses) {
		this.userses = userses;
	}

	public Set getManagers() {
		return this.managers;
	}

	public void setManagers(Set managers) {
		this.managers = managers;
	}

	public Set getClasseses() {
		return this.classeses;
	}

	public void setClasseses(Set classeses) {
		this.classeses = classeses;
	}

	public Set getProjectPapers() {
		return this.projectPapers;
	}

	public void setProjectPapers(Set projectPapers) {
		this.projectPapers = projectPapers;
	}

}
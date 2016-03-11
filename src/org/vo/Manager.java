package org.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager implements java.io.Serializable {

	// Fields

	private String managerId;
	private Powers powers;
	private Department department;
	private String managerName;
	private String managerPwd;
	private String managerImage;
	private String managerDes;
	private String x;
	private String y;
	private String z;
	private Set managerPagePowers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Manager() {
	}

	/** full constructor */
	public Manager(Powers powers, Department department, String managerName,
			String managerPwd, String managerImage, String managerDes,
			String x, String y, String z, Set managerPagePowers) {
		this.powers = powers;
		this.department = department;
		this.managerName = managerName;
		this.managerPwd = managerPwd;
		this.managerImage = managerImage;
		this.managerDes = managerDes;
		this.x = x;
		this.y = y;
		this.z = z;
		this.managerPagePowers = managerPagePowers;
	}

	// Property accessors

	public String getManagerId() {
		return this.managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public Powers getPowers() {
		return this.powers;
	}

	public void setPowers(Powers powers) {
		this.powers = powers;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPwd() {
		return this.managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}

	public String getManagerImage() {
		return this.managerImage;
	}

	public void setManagerImage(String managerImage) {
		this.managerImage = managerImage;
	}

	public String getManagerDes() {
		return this.managerDes;
	}

	public void setManagerDes(String managerDes) {
		this.managerDes = managerDes;
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

	public Set getManagerPagePowers() {
		return this.managerPagePowers;
	}

	public void setManagerPagePowers(Set managerPagePowers) {
		this.managerPagePowers = managerPagePowers;
	}

}
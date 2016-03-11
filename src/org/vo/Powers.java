package org.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Powers entity. @author MyEclipse Persistence Tools
 */

public class Powers implements java.io.Serializable {

	// Fields

	private Integer powerId;
	private String powerName;
	private String powerDes;
	private String x;
	private String y;
	private String z;
	private Set managers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Powers() {
	}

	/** full constructor */
	public Powers(String powerName, String powerDes, String x, String y,
			String z, Set managers) {
		this.powerName = powerName;
		this.powerDes = powerDes;
		this.x = x;
		this.y = y;
		this.z = z;
		this.managers = managers;
	}

	// Property accessors

	public Integer getPowerId() {
		return this.powerId;
	}

	public void setPowerId(Integer powerId) {
		this.powerId = powerId;
	}

	public String getPowerName() {
		return this.powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public String getPowerDes() {
		return this.powerDes;
	}

	public void setPowerDes(String powerDes) {
		this.powerDes = powerDes;
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

	public Set getManagers() {
		return this.managers;
	}

	public void setManagers(Set managers) {
		this.managers = managers;
	}

}
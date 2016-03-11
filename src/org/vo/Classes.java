package org.vo;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

	// Fields

	private Integer classId;
	private Department department;
	private String className;
	private String classDes;
	private String x;
	private String y;
	private String z;

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** full constructor */
	public Classes(Department department, String className, String classDes,
			String x, String y, String z) {
		this.department = department;
		this.className = className;
		this.classDes = classDes;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// Property accessors

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDes() {
		return this.classDes;
	}

	public void setClassDes(String classDes) {
		this.classDes = classDes;
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

}
package org.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Client entity. @author MyEclipse Persistence Tools
 */

public class Client implements java.io.Serializable {

	// Fields

	private String clientId;
	private String clientName;
	private String clientPwd;
	private String clientImage;
	private String clientDes;
	private String x;
	private String y;
	private String z;
	private Set projectPapers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Client() {
	}

	/** full constructor */
	public Client(String clientName, String clientPwd, String clientImage,
			String clientDes, String x, String y, String z, Set projectPapers) {
		this.clientName = clientName;
		this.clientPwd = clientPwd;
		this.clientImage = clientImage;
		this.clientDes = clientDes;
		this.x = x;
		this.y = y;
		this.z = z;
		this.projectPapers = projectPapers;
	}

	// Property accessors

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPwd() {
		return this.clientPwd;
	}

	public void setClientPwd(String clientPwd) {
		this.clientPwd = clientPwd;
	}

	public String getClientImage() {
		return this.clientImage;
	}

	public void setClientImage(String clientImage) {
		this.clientImage = clientImage;
	}

	public String getClientDes() {
		return this.clientDes;
	}

	public void setClientDes(String clientDes) {
		this.clientDes = clientDes;
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

	public Set getProjectPapers() {
		return this.projectPapers;
	}

	public void setProjectPapers(Set projectPapers) {
		this.projectPapers = projectPapers;
	}

}
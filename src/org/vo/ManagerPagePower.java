package org.vo;

/**
 * ManagerPagePower entity. @author MyEclipse Persistence Tools
 */

public class ManagerPagePower implements java.io.Serializable {

	// Fields

	private Integer tppId;
	private Manager manager;
	private Pages pages;

	// Constructors

	/** default constructor */
	public ManagerPagePower() {
	}

	/** full constructor */
	public ManagerPagePower(Manager manager, Pages pages) {
		this.manager = manager;
		this.pages = pages;
	}

	// Property accessors

	public Integer getTppId() {
		return this.tppId;
	}

	public void setTppId(Integer tppId) {
		this.tppId = tppId;
	}

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Pages getPages() {
		return this.pages;
	}

	public void setPages(Pages pages) {
		this.pages = pages;
	}

}
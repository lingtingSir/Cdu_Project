package org.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Pages entity. @author MyEclipse Persistence Tools
 */

public class Pages implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer pageSort;
	private Integer parentId;
	private Integer pid;
	private String pageName;
	private String pageUrl;
	private String pageDes;
	private Set managerPagePowers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Pages() {
	}

	/** full constructor */
	public Pages(Integer pageSort, Integer parentId, Integer pid,
			String pageName, String pageUrl, String pageDes,
			Set managerPagePowers) {
		this.pageSort = pageSort;
		this.parentId = parentId;
		this.pid = pid;
		this.pageName = pageName;
		this.pageUrl = pageUrl;
		this.pageDes = pageDes;
		this.managerPagePowers = managerPagePowers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPageSort() {
		return this.pageSort;
	}

	public void setPageSort(Integer pageSort) {
		this.pageSort = pageSort;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPageName() {
		return this.pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageUrl() {
		return this.pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getPageDes() {
		return this.pageDes;
	}

	public void setPageDes(String pageDes) {
		this.pageDes = pageDes;
	}

	public Set getManagerPagePowers() {
		return this.managerPagePowers;
	}

	public void setManagerPagePowers(Set managerPagePowers) {
		this.managerPagePowers = managerPagePowers;
	}

}
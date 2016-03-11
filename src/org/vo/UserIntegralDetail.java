package org.vo;

/**
 * UserIntegralDetail entity. @author MyEclipse Persistence Tools
 */

public class UserIntegralDetail implements java.io.Serializable {

	// Fields

	private Integer detailId;
	private Users users;
	private Integer integralChange;
	private String changeDes;

	// Constructors

	/** default constructor */
	public UserIntegralDetail() {
	}

	/** full constructor */
	public UserIntegralDetail(Users users, Integer integralChange,
			String changeDes) {
		this.users = users;
		this.integralChange = integralChange;
		this.changeDes = changeDes;
	}

	// Property accessors

	public Integer getDetailId() {
		return this.detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Integer getIntegralChange() {
		return this.integralChange;
	}

	public void setIntegralChange(Integer integralChange) {
		this.integralChange = integralChange;
	}

	public String getChangeDes() {
		return this.changeDes;
	}

	public void setChangeDes(String changeDes) {
		this.changeDes = changeDes;
	}

}
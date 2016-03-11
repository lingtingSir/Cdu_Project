package org.vo;

import java.sql.Timestamp;

/**
 * UserHoliday entity. @author MyEclipse Persistence Tools
 */

public class UserHoliday implements java.io.Serializable {

	// Fields

	private Integer userHolidayId;
	private Users users;
	private String userHolidayDes;
	private String managerBack;
	private Timestamp dateUp;
	private Integer recordState;

	// Constructors

	/** default constructor */
	public UserHoliday() {
	}

	/** full constructor */
	public UserHoliday(Users users, String userHolidayDes, String managerBack,
			Timestamp dateUp, Integer recordState) {
		this.users = users;
		this.userHolidayDes = userHolidayDes;
		this.managerBack = managerBack;
		this.dateUp = dateUp;
		this.recordState = recordState;
	}

	// Property accessors

	public Integer getUserHolidayId() {
		return this.userHolidayId;
	}

	public void setUserHolidayId(Integer userHolidayId) {
		this.userHolidayId = userHolidayId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getUserHolidayDes() {
		return this.userHolidayDes;
	}

	public void setUserHolidayDes(String userHolidayDes) {
		this.userHolidayDes = userHolidayDes;
	}

	public String getManagerBack() {
		return this.managerBack;
	}

	public void setManagerBack(String managerBack) {
		this.managerBack = managerBack;
	}

	public Timestamp getDateUp() {
		return this.dateUp;
	}

	public void setDateUp(Timestamp dateUp) {
		this.dateUp = dateUp;
	}

	public Integer getRecordState() {
		return this.recordState;
	}

	public void setRecordState(Integer recordState) {
		this.recordState = recordState;
	}

}
package org.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private String userId;
	private Department department;
	private String userPwd;
	private String userName;
	private String userImage;
	private String userDes;
	private Timestamp registerDate;
	private Timestamp overDate;
	private Integer userIntegral;
	private Set userIntegralDetails = new HashSet(0);
	private Set userHolidayDetails = new HashSet(0);
	private Set userHolidaies = new HashSet(0);
	private Set rewardProblems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(Department department, String userPwd, String userName,
			String userImage, String userDes, Timestamp registerDate,
			Timestamp overDate, Integer userIntegral, Set userIntegralDetails,
			Set userHolidayDetails, Set userHolidaies, Set rewardProblems) {
		this.department = department;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userImage = userImage;
		this.userDes = userDes;
		this.registerDate = registerDate;
		this.overDate = overDate;
		this.userIntegral = userIntegral;
		this.userIntegralDetails = userIntegralDetails;
		this.userHolidayDetails = userHolidayDetails;
		this.userHolidaies = userHolidaies;
		this.rewardProblems = rewardProblems;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserImage() {
		return this.userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserDes() {
		return this.userDes;
	}

	public void setUserDes(String userDes) {
		this.userDes = userDes;
	}

	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public Timestamp getOverDate() {
		return this.overDate;
	}

	public void setOverDate(Timestamp overDate) {
		this.overDate = overDate;
	}

	public Integer getUserIntegral() {
		return this.userIntegral;
	}

	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = userIntegral;
	}

	public Set getUserIntegralDetails() {
		return this.userIntegralDetails;
	}

	public void setUserIntegralDetails(Set userIntegralDetails) {
		this.userIntegralDetails = userIntegralDetails;
	}

	public Set getUserHolidayDetails() {
		return this.userHolidayDetails;
	}

	public void setUserHolidayDetails(Set userHolidayDetails) {
		this.userHolidayDetails = userHolidayDetails;
	}

	public Set getUserHolidaies() {
		return this.userHolidaies;
	}

	public void setUserHolidaies(Set userHolidaies) {
		this.userHolidaies = userHolidaies;
	}

	public Set getRewardProblems() {
		return this.rewardProblems;
	}

	public void setRewardProblems(Set rewardProblems) {
		this.rewardProblems = rewardProblems;
	}

}
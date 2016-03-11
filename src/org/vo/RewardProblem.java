package org.vo;

import java.sql.Timestamp;

/**
 * RewardProblem entity. @author MyEclipse Persistence Tools
 */

public class RewardProblem implements java.io.Serializable {

	// Fields

	private Integer rewardProblemId;
	private Users users;
	private String des;
	private String managerBack;
	private Timestamp dateUp;
	private Integer recordState;

	// Constructors

	/** default constructor */
	public RewardProblem() {
	}

	/** full constructor */
	public RewardProblem(Users users, String des, String managerBack,
			Timestamp dateUp, Integer recordState) {
		this.users = users;
		this.des = des;
		this.managerBack = managerBack;
		this.dateUp = dateUp;
		this.recordState = recordState;
	}

	// Property accessors

	public Integer getRewardProblemId() {
		return this.rewardProblemId;
	}

	public void setRewardProblemId(Integer rewardProblemId) {
		this.rewardProblemId = rewardProblemId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
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
package com.emv;

import java.util.Date;

public class ActivitLogs {
	private long id;
	private long userId;
	private Date loggedIn;
	private Date loggedOut;
	private int invalidLoginAttempts;
	private Date creationTime;
	private String createdBy;
	private Date lastUpdateTime;
	private String lastUpdatedBy;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Date loggedIn) {
		this.loggedIn = loggedIn;
	}
	public Date getLoggedOut() {
		return loggedOut;
	}
	public void setLoggedOut(Date loggedOut) {
		this.loggedOut = loggedOut;
	}
	public int getInvalidLoginAttempts() {
		return invalidLoginAttempts;
	}
	public void setInvalidLoginAttempts(int invalidLoginAttempts) {
		this.invalidLoginAttempts = invalidLoginAttempts;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
}

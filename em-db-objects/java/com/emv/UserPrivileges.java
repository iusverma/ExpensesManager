package com.emv;

import java.util.Date;

public class UserPrivileges {
	private long id;
	private long privilegeType;
	private String privilegeTypes;
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
	public long getPrivilegeType() {
		return privilegeType;
	}
	public void setPrivilegeType(long privilegeType) {
		this.privilegeType = privilegeType;
	}
	public String getPrivilegeTypes() {
		return privilegeTypes;
	}
	public void setPrivilegeTypes(String privilegeTypes) {
		this.privilegeTypes = privilegeTypes;
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

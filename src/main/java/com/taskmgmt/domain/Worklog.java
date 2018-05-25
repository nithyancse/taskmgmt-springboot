package com.taskmgmt.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="worklog")
public class Worklog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="worklog_id")
	private int worklogId;
	
	@Column(name="backlog_id")
	private int backlogId;
	
	@Column(name="worked_time")
	private int workedTime;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="updated_by")
	private int updatedBy;

	public int getWorklogId() {
		return worklogId;
	}

	public void setWorklogId(int worklogId) {
		this.worklogId = worklogId;
	}

	public int getBacklogId() {
		return backlogId;
	}

	public void setBacklogId(int backlogId) {
		this.backlogId = backlogId;
	}

	public int getWorkedTime() {
		return workedTime;
	}

	public void setWorkedTime(int workedTime) {
		this.workedTime = workedTime;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
}
package com.taskmgmt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="sprint")
public class Sprint implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="nativeWay")
	@GenericGenerator(name = "nativeWay", strategy = "native")
	@Column(name="id")
	private Long id;
	
	@Column(name="project_id")
	private Long projectId;
	
	@NotBlank
	@Size(max=45, message="Sprint title should be less than 45 chars")
	@Column(name="sprint_name", nullable = false, columnDefinition = "VARCHAR(45)", length = 45)
	private String sprintName;
	
	@NotBlank
	@Size(max=10, message="Start date should be less than 10 chars")
	@Column(name="start_date", nullable = false, columnDefinition = "VARCHAR(10)", length = 10)
	private String startDate;
	
	@NotBlank
	@Size(max=10, message="End date should be less than 10 chars")
	@Column(name="end_date", nullable = false, columnDefinition = "VARCHAR(10)", length = 10)
	private String endDate;
	
	@Column(name="created_by")
	private Long createdBy;
	
	@Column(name="updated_by")
	private Long updatedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
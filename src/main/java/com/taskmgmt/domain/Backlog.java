package com.taskmgmt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="backlog")
public class Backlog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="nativeWay")
	@GenericGenerator(name = "nativeWay", strategy = "native")
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Project.class)
	@JoinColumn(name = "project_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Long projectId;
	
	@NotBlank
	@Size(max=500, message="Title length should be less than 500 chars")
	@Column(name="title", nullable = false, columnDefinition = "VARCHAR(500)", length = 500)
	private String title;
	
	@NotBlank
	@Size(max=5000, message="Description length should be less than 5000 chars")
	@Column(name="description", nullable = false, columnDefinition = "VARCHAR(5000)", length = 5000)
	private String description;
	
	@Column(name="reporter")
	private Long reporter;
	
	@Column(name="assignee")
	private Long assignee;
	
	@NotBlank
	@Column(name="type", nullable = false, columnDefinition = "VARCHAR(20)", length = 20)
	private String type;
	
	@NotBlank
	@Column(name="status", nullable = false, columnDefinition = "VARCHAR(20)", length = 20)
	private String status;
	
	@NotBlank
	@Column(name="methodolgy", nullable = false, columnDefinition = "VARCHAR(20)", length = 20)
	private String methodolgy;
	
	@Column(name="methodolgy_id")
	private Long methodolgyId;
	
	@Pattern(regexp = "\\d+", message="Story points should be Number")
	@Column(name="story_points")
	private int storyPoints;
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getReporter() {
		return reporter;
	}

	public void setReporter(Long reporter) {
		this.reporter = reporter;
	}

	public Long getAssignee() {
		return assignee;
	}

	public void setAssignee(Long assignee) {
		this.assignee = assignee;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMethodolgy() {
		return methodolgy;
	}

	public void setMethodolgy(String methodolgy) {
		this.methodolgy = methodolgy;
	}

	public Long getMethodolgyId() {
		return methodolgyId;
	}

	public void setMethodolgyId(Long methodolgyId) {
		this.methodolgyId = methodolgyId;
	}

	public int getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
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
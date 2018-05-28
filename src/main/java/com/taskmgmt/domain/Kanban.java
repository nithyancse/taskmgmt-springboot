package com.taskmgmt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="kanban")
public class Kanban implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="nativeWay")
	@GenericGenerator(name = "nativeWay", strategy = "native")
	@Column(name="id")
	private Long id;
	
	@Column(name="project_id")
	private Long projectId;
	
	@NotBlank
	@Size(max=45, message="Kanban title should be less than 45 chars")
	@Column(name="title", nullable = false, columnDefinition = "VARCHAR(45)", length = 45)
	private String title;
	
	@NotBlank
	@Pattern(regexp = "\\d+", message="Limit count should be Number")
	@Column(name="count")
	private int count;
	
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
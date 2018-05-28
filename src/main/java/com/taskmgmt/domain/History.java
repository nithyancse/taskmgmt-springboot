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
@Table(name="history")
public class History implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="nativeWay")
	@GenericGenerator(name = "nativeWay", strategy = "native")
	@Column(name="id")
	private Long id;
	
	@NotBlank
	@Size(max=50, message="Table name length should be < 50 chars")
	@Column(name="table_name", nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
	private String table_name;
	
	@NotBlank
	@Pattern(regexp = "\\d+", message="Table id should be Number")
	@Column(name="table_id")
	private Long tableId;
	
	@NotBlank
	@Size(max=50, message="Column name length should be < 50 chars")
	@Column(name="column_name", nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
	private String columnName;
	
	@NotBlank
	@Size(max=5000, message="Value length should be < 5000 chars")
	@Column(name="value", nullable = false, columnDefinition = "VARCHAR(5000)", length = 5000)
	private String value;
	
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

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
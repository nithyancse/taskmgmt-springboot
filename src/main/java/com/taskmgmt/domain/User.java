package com.taskmgmt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class User extends AuditModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="nativeWay")
	@GenericGenerator(name = "nativeWay", strategy = "native")
	@Column(name="id")
	private Long id;
	
	@Column(name="name", columnDefinition = "VARCHAR(45)", length = 45)
	private String name;
	
	@NotBlank(message="Please enter Password")
	@Size(min=6, message="Password length should be Minimum 6")
	@Size(max=25, message="Password length should be Maximum 25")
	@Column(name="password", nullable = false, columnDefinition = "VARCHAR(25)", length = 25)
	private String password;
	
	@NotBlank(message="Please enter Email Id")
	@Email(message="Please enter valid Email Id")
	@Column(name="email_id", nullable = false, columnDefinition = "VARCHAR(45)", length = 45)
	private String emailId;
	
	@Column(name="status", columnDefinition = "VARCHAR(2) DEFAULT 'A'", length = 2)
	private String status;
	
	@Column(name="company_id")
	private Long companyId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


}
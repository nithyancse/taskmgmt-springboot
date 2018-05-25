package com.taskmgmt.domain.wrapper;

import com.taskmgmt.domain.Company;
import com.taskmgmt.domain.User;

public class UserCompanyWrap {

	private User user;
	private Company company;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
}

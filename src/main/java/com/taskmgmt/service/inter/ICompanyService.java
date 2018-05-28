package com.taskmgmt.service.inter;

import com.taskmgmt.domain.Company;

public interface ICompanyService {

	public void addCompany(Company company);

	public Company getCompanyDetails(Long id);
	
}

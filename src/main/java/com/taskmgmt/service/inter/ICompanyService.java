package com.taskmgmt.service.inter;

import com.taskmgmt.domain.Company;

public interface ICompanyService {

	public Company addCompany(Company company);

	public Company getCompanyDetails(Long id);
	
}

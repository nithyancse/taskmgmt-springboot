package com.taskmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taskmgmt.domain.Company;
import com.taskmgmt.repository.CompanyRepository;
import com.taskmgmt.service.inter.ICompanyService;

@Service
public class CompanyService implements ICompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public Company addCompany(Company company) {	
		return companyRepository.save(company);
	}

	@Override
	public Company getCompanyDetails(Long id) {
		return companyRepository.findById(id).get();
	}

	
}
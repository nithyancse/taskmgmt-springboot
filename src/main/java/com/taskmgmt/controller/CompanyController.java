package com.taskmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taskmgmt.domain.Company;
import com.taskmgmt.service.inter.ICompanyService;

@RestController
@RequestMapping("/")
public class CompanyController {

	@Autowired
	private ICompanyService iCompanyService;

	@PostMapping("addCompany")
	public Company addCompany(@RequestBody Company company) {
		iCompanyService.addCompany(company);
		return company;
	}

	@GetMapping("getCompanyDetails")
	public Company getCompanyDetails(@RequestParam(value = "id") long id) {
		Company company = iCompanyService.getCompanyDetails(id);
		return company;
	}
}

package com.taskmgmt.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.taskmgmt.domain.Company;
import com.taskmgmt.service.inter.ICompanyService;

@RestController
@RequestMapping("/")
public class CompanyController {

	@Autowired
	private ICompanyService iCompanyService;

	@PostMapping("addCompany")
	public Company addCompany(HttpServletRequest request, 
			@RequestParam(value = "name") String name,
			@RequestParam(value = "created_by") String created_by,
			@RequestParam(value = "updated_by") String updated_by,
			@RequestParam("logo") MultipartFile logo) throws IllegalStateException, IOException {
		
		File file = new File(logo.getOriginalFilename());
		//String aa= logo.getOriginalFilename().substring(logo.getOriginalFilename().lastIndexOf('.'));
		
		logo.transferTo(file);
		
		Company company = new Company();
		company.setName(name);
		company.setLogo(file);
		//company.setCreatedBy(Long.parseLong(created_by));
		//company.setUpdatedBy(Long.parseLong(updated_by));
		//iCompanyService.addCompany(company);
		return null;
	}

	@GetMapping("getCompanyDetails")
	public Company getCompanyDetails(@RequestParam(value = "id") long id) {
		Company company = iCompanyService.getCompanyDetails(id);
		return company;
	}
}

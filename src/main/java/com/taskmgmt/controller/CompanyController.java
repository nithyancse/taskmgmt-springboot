package com.taskmgmt.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.taskmgmt.domain.Company;
import com.taskmgmt.domain.CustError;
import com.taskmgmt.domain.wrapper.UserCompanyWrap;
import com.taskmgmt.service.inter.ICompanyService;
import com.taskmgmt.service.inter.IUserService;
import com.taskmgmt.util.Utils;

@RestController
@RequestMapping("/")
public class CompanyController {
	
	@Autowired
	private IUserService iUserService;

	@Autowired
	private ICompanyService iCompanyService;

	@PostMapping("addCompany")
	public ResponseEntity<?> addCompany(HttpServletRequest request, 
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "created_by") long created_by,
			@RequestParam(value = "updated_by") long updated_by,
			@RequestParam(value = "logo", required = false) MultipartFile logo) throws IllegalStateException, IOException {
		
		String errorMsg = null;
		String logoName = null;
		if (!Utils.isEmpty(name)) {
			if(name.length() > 100)
				errorMsg = "Company Name should be not more than 100 digits";
		} else {
			errorMsg = "Company Name should not be empty";
		}
		
		if (!Utils.isEmpty(errorMsg)) {
			CustError error = new CustError(errorMsg);
			if (error != null) {
				return ResponseEntity.badRequest().body(error);
			}
		}
		
		if(logo != null) {
			logoName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"_"+logo.getOriginalFilename();
			String fileDirPath = "C:/Users/Nithya/Documents/taskmgmt/company/";
			File fileDir = new File(fileDirPath);
			File destFile = new File(fileDir,  logoName); 
			logo.transferTo(destFile);
		}
		
		Company company = new Company();
		company.setName(name);
		company.setLogoName(logoName);
		company.setCreatedBy(created_by);
		company.setUpdatedBy(updated_by);
		Company comp = iCompanyService.addCompany(company); // Store company details
		iUserService.updateCompanyId(comp.getCreatedBy(), comp.getId()); // update company id in user table
		return new ResponseEntity<Company>(comp, HttpStatus.CREATED);
	}

	@GetMapping("getCompanyDetails")
	public Company getCompanyDetails(@RequestParam(value = "id") long id) {
		Company company = iCompanyService.getCompanyDetails(id);
		return company;
	}
}

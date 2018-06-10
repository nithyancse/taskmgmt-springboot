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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.taskmgmt.GlobalProperties;
import com.taskmgmt.domain.Company;
import com.taskmgmt.domain.CustError;
import com.taskmgmt.service.inter.ICompanyService;
import com.taskmgmt.service.inter.IUserService;
import com.taskmgmt.util.Utils;
import com.taskmgmt.validator.ImageValidator;

@RestController
@RequestMapping("/")
public class CompanyController {
	
	public static final String LOGO_PATH = "C:/Users/Nithya/Documents/taskmgmt/company/";

	@Autowired
	private IUserService iUserService;

	@Autowired
	private ICompanyService iCompanyService;
	
	@Autowired
	private GlobalProperties global;

	@PostMapping("addCompany")
	public ResponseEntity<?> addCompany(HttpServletRequest request, @RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "userId") long userId,
			@RequestParam(value = "logo", required = false) MultipartFile logo)
			throws IllegalStateException, IOException {
		//should not use HttpServletRequest its bad idea.. change in future
		//https://stackoverflow.com/questions/34774957/spring-boot-httpservletrequest-not-properly-available-through-test

		String logoName = null;
		String errorMsg = addCompanyValidate(name, logo);
		if (!Utils.isEmpty(errorMsg)) {
			CustError error = new CustError(errorMsg);
			if (error != null) {
				return ResponseEntity.badRequest().body(error);
			}
		}
		
		String temp = global.getLogoPath();
		
		if (logo != null) {
			logoName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + logo.getOriginalFilename();
			File fileDir = new File(global.getLogoPath());
			File destFile = new File(fileDir, logoName);
			logo.transferTo(destFile);
		}

		Company company = new Company();
		company.setName(name);
		company.setLogoName(logoName);
		company.setCreatedBy(userId);
		company.setUpdatedBy(userId);
		company = iCompanyService.addCompany(company); // Store company details and get it with company Id
		iUserService.updateCompanyId(company.getCreatedBy(), company.getId()); // update company id in user table
		return new ResponseEntity<Company>(company, HttpStatus.CREATED);
	}

	private String addCompanyValidate(String name, MultipartFile logo) {
		String errorMsg = null;
		String logoName = null;
		ImageValidator imageValidator = null;
		if (!Utils.isEmpty(name)) {
			if (name.length() > 100)
				errorMsg = "Company Name should be not more than 100 digits";
		} else {
			errorMsg = "Company Name should not be empty";
		}

		if (logo != null) {
			imageValidator = new ImageValidator();
			logoName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + logo.getOriginalFilename();
			if (!imageValidator.validate(logoName)) {
				errorMsg = "Image should be in the format of .png, .jpeg, .jpg, .bmp";
			} 
		}
		return errorMsg;
	}

	@GetMapping("getCompanyDetails")
	public Company getCompanyDetails(@RequestParam(value = "id") long id) {
		Company company = iCompanyService.getCompanyDetails(id);
		return company;
	}
}

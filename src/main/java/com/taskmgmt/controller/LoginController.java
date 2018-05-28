package com.taskmgmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taskmgmt.domain.Company;
import com.taskmgmt.domain.User;
import com.taskmgmt.domain.wrapper.UserCompanyWrap;
import com.taskmgmt.service.inter.ICompanyService;
import com.taskmgmt.service.inter.IUserService;

@RestController
@RequestMapping("/")
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IUserService iUserService;

	@Autowired
	private ICompanyService iCompanyService;

	@Autowired
	private UserCompanyWrap userCompanyWrap;

	@GetMapping("login")
	public ResponseEntity<?> validateLogin(@RequestParam(value = "emailId") String emailId,
			@RequestParam(value = "password") String password) {
		Long userId = iUserService.validateUser(emailId, password);
		if (userId == 0) {
			logger.info("Authendication failed --> emailId:"+emailId+", password: "+password);
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		User user = iUserService.fetchUserDetail(userId);
		Company company = iCompanyService.getCompanyDetails(user.getCompanyId());
		userCompanyWrap.setUser(user);
		userCompanyWrap.setCompany(company);
		return new ResponseEntity<UserCompanyWrap>(userCompanyWrap, HttpStatus.OK);

	}

}

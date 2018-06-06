package com.taskmgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.taskmgmt.constant.IConstant;
import com.taskmgmt.domain.CustError;
import com.taskmgmt.domain.CustResponse;
import com.taskmgmt.domain.User;
import com.taskmgmt.service.inter.IUserService;
import com.taskmgmt.util.Utils;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private IUserService iUserService;

	@PostMapping("addUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody User user, UriComponentsBuilder builder, Errors errors) {
		boolean flag = iUserService.addUser(user);
		if (flag == false) {
			CustResponse restAlready = new CustResponse("You are Already Registered !!!");
			return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(restAlready);
		}
		CustResponse success = new CustResponse("Successfully you are Resgistered with us !!!");
		return ResponseEntity.created(null).body(success);
	}

	@PostMapping("addName")
	public ResponseEntity<?> addName(@RequestParam(value = "id") long id, @RequestParam(value = "name") String name) {
		String errorMsg = null;
		if (!Utils.isEmpty(name)) {
			if(name.length() > 45)
				errorMsg = "Name Should be empty < 45 chars";
		} else {
			errorMsg = "Name Should not be empty";
		}
		
		if (!Utils.isEmpty(errorMsg)) {
			CustError error = new CustError(errorMsg);
			if (error != null) {
				return ResponseEntity.badRequest().body(error);
			}
		}

		iUserService.addName(id, name);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("fetchUserDetail")
	public User fetchUserDetail(@RequestParam(value = "userId") long id) {
		User user = iUserService.fetchUserDetail(id);
		return user;
	}

	@GetMapping("fetchAllUsers")
	public List<User> fetchAllUsers() {
		List<User> allUserList = iUserService.fetchAllUsers();
		return allUserList;
	}

	@PutMapping("updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		iUserService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping("deleteUser")
	public ResponseEntity<Void> deleteUser(@RequestParam(value = "id") long id) {
		User user = iUserService.fetchUserDetail(id);
		user.setStatus(IConstant.DELETE);
		iUserService.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
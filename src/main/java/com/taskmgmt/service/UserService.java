package com.taskmgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmgmt.domain.User;
import com.taskmgmt.repository.CompanyRepository;
import com.taskmgmt.repository.UserRepository;
import com.taskmgmt.service.inter.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CompanyRepository companyRepository;

	public User fetchUserDetail(int userId){
		User obj = userRepository.findById(userId).get();
		return obj;
		
	}

	@Override
	public List<User> fetchAllUsers() {
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(e -> userList.add(e));
		return userList;
	}

	@Override
	public boolean addUser(User user) {
		List<User> list = userRepository.findByEmailId(user.getEmailId()); 	
        if (list.size() > 0) {
        	return false;
        } else {
        	userRepository.save(user);
        }
        return true;
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public void addName(Integer userId, String name) {
		User user = userRepository.findById(userId).get();
		user.setName(name);
		userRepository.save(user);
	}
	
}
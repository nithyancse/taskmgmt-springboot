package com.taskmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmgmt.domain.User;
import com.taskmgmt.repository.UserRepository;
import com.taskmgmt.service.inter.ILoginService;

@Service
public class LoginService implements ILoginService {
	
	@Autowired
	UserRepository userRepository;
	
	public int validateUser(User user){
		List<User> list = userRepository.findByEmailIdAndPassword(user.getEmailId(), user.getPassword()); 	
        if (list.size() > 0) {
        	return list.get(0).getId();
        } 
        return 0;
	}

}
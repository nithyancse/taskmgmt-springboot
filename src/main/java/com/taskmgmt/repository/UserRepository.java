package com.taskmgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.taskmgmt.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByEmailId(String emailId);
	List<User> findByEmailIdAndPasswordAndStatus(String emailId, String password, String status);
    
}
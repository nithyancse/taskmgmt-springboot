package com.taskmgmt.service.inter;

import java.util.List;
import com.taskmgmt.domain.User;

public interface IUserService {

	public User fetchUserDetail(int userId);

	public List<User> fetchAllUsers();

	public boolean addUser(User userRegistration);

	public void updateUser(User userRegistration);

	public void deleteUser(int userId);

	public void addName(Integer userId, String name);

}
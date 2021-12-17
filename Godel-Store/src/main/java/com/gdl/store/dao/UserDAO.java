package com.gdl.store.dao;

import java.util.List;
import java.util.Set;

import com.gdl.store.entity.Address;
import com.gdl.store.entity.Role;
import com.gdl.store.entity.User;

 
public interface UserDAO {

 
	User registration(User user);

	List<User> getAllUser();
	
	User findByUserEmail(String email);
	
	User findById(int id);
	
	boolean checkPasswordUsed(String userPassword);

	void changeUserInfo(User user);

	User getUserInfo(int id);

	void deleteUser(int id);

	void addAddress(int userId, Address address);

	Set<Role> getAllRole();

	void addRole(String roleName);

	void addRoleUser(int userId, int roleId);

	void deleteRoleUser(int userId, int roleId);

}

package com.gdl.store.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdl.store.dao.UserDAO;
import com.gdl.store.entity.Address;
import com.gdl.store.entity.Role;
import com.gdl.store.entity.User;
import com.gdl.store.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public User findByUserEmail(String email) {

		User user = userDAO.findByUserEmail(email);

		return user;
	}

	@Override
	@Transactional
	public User registration(User user) {

		return userDAO.registration(user);
	}

	@Override
	@Transactional
	public List<User> getAllUser() {
 		return userDAO.getAllUser();
	}

	@Override
	@Transactional
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {

		userDAO.deleteUser(id);
	}

	@Override
	@Transactional
	public void changeUserInfo(User user) {

		userDAO.changeUserInfo(user);

	}

	@Override
	public User getUserInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAddress(int userId, Address address) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Role> getAllRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRole(String roleName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRoleUser(int userId, int roleId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRoleUser(int userId, int roleId) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkPasswordUsed(String userPassword) {
		// TODO Auto-generated method stub
		return false;
	}

}

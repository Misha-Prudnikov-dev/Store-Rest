package com.gdl.store.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Repository;

import com.gdl.store.dao.UserDAO;
import com.gdl.store.entity.Address;
import com.gdl.store.entity.Role;
import com.gdl.store.entity.StatusUser;
import com.gdl.store.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final String PASSWORD = "passwordUser";
	private static final String EMAIL = "emailUser";

	private static final String SELECT_Email_AND_PASSWORD = "from UserShort where email = :emailUser  and   password = :passwordUser";
	
	private static final String SELECT_ALL_USERS = "from User";
	
	private static final String SELECT_USER_BY_EMAIL = "from User where email = :emailUserParam";
	private static final String USER_EMAIL_PARAM = "emailUserParam";

	private final SessionFactory sessionFactory;
 
	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory ) {
		this.sessionFactory = sessionFactory;
 	}

	@Override
	public User registration(User user) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		Role roleUser = currentSession.get(Role.class,2);  
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(roleUser);

		user.setPassword( user.getPassword() );
		user.setRoles(userRoles);
		user.setStatus(StatusUser.ACTIVE);

		User registeredUser = (User) currentSession.save(user);

		return registeredUser;
	}

	@Override
	public List<User> getAllUser() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<User> users = currentSession.createQuery(SELECT_ALL_USERS,User.class).getResultList();
		return users;
	}

	@Override
	public User findByUserEmail(String email) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		User user = currentSession.createQuery(SELECT_USER_BY_EMAIL, User.class).setParameter(USER_EMAIL_PARAM, email).getSingleResult();
		
		return user;
	}

	@Override
	public User findById(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		User user = currentSession.get(User.class, id);

		if (user == null) {
			return null;
		}

		return user;
	}

	@Override
	public void deleteUser(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		User user = new User();
		user.setId(id);
		user.setStatus(StatusUser.DELETED);
		
		currentSession.update(user);
		
	}

	public boolean checkPasswordUsed(String userPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	public void changeUserInfo(User user) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.update(user);

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

}

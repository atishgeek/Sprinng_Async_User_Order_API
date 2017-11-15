package com.imaginea.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginea.api.dao.UserDetailsDao;
import com.imaginea.api.entity.User;
import com.imaginea.api.service.UserDetailsService;

@Service("userService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDetailsDao userDao;
	
	
	@Override
	public Iterable<User> getAllUsers() {
		
		return userDao.findAll();
	}

	@Override
	public User getUserDetails(int userid) {
		
		return userDao.findOne(userid);
	
	}

}

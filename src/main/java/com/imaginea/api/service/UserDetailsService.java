package com.imaginea.api.service;

import com.imaginea.api.entity.User;

public interface UserDetailsService {

	public Iterable<User> getAllUsers();

	User getUserDetails(int userid);

}

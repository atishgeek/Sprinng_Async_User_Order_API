package com.imaginea.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imaginea.api.entity.User;

@Repository
public interface UserDetailsDao extends CrudRepository<User, Integer>{



}

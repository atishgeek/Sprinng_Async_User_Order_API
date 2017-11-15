package com.imaginea.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imaginea.api.entity.Orders;

@Repository
public interface OrderDetailsDao extends CrudRepository<Orders, Integer>{

	

}

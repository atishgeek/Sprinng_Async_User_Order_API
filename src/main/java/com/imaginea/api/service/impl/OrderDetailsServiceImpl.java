package com.imaginea.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginea.api.dao.OrderDetailsDao;
import com.imaginea.api.entity.Orders;
import com.imaginea.api.service.OrderDetailsService;


@Service("orderService")
public class OrderDetailsServiceImpl implements OrderDetailsService{

	
	@Autowired
	OrderDetailsDao orderDao;
	
	@Override
	public Iterable<Orders> getAllOrders() {
		return orderDao.findAll();
	}

	@Override
	public Orders getOrderDetails(int id) {
		return orderDao.findOne( id);
	}

}

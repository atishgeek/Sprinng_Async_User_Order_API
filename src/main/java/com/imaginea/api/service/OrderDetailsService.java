package com.imaginea.api.service;

import com.imaginea.api.entity.Orders;

public interface OrderDetailsService {

	Iterable<Orders> getAllOrders();

	Orders getOrderDetails(int id);

}

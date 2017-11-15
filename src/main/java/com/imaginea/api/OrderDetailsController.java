package com.imaginea.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imaginea.api.dto.OrderDto;
import com.imaginea.api.entity.Orders;
import com.imaginea.api.service.OrderDetailsService;

@Controller
public class OrderDetailsController {


	@Autowired
	OrderDetailsService orderService;
	
	
	@RequestMapping(value="/OrderDetails",method=RequestMethod.GET)
	@ResponseBody
	@Async
	public CompletableFuture<List<OrderDto>> orderDetails() throws InterruptedException {
		
		Iterable<Orders> iterableOrder = orderService.getAllOrders();
		List<OrderDto> orderList = new ArrayList<>();
		
		iterableOrder.forEach( order -> {
			OrderDto dto = new  OrderDto();
			dto.setOrderid(order.getOrderid());
			dto.setOrdername(order.getOrdername());
			
			orderList.add(dto);
		});
		
		Thread.sleep(20000);
		
		return CompletableFuture.completedFuture(orderList);
	}
	
	

	
	
	
	
/*	@RequestMapping(value="/OrderDetails/id/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Order trackOrder(@PathVariable int id) throws InterruptedException {
		Order list = orderService.getOrderDetails(id);

		Iterable<Order> iterableOrder = orderService.getAllOrders();
		List<UserDto> userList = new ArrayList<>();
		
		iterableOrder.forEach( user -> {
			UserDto dto = new  UserDto();
			dto.setUserId(user.getOrderid());
			dto.setUsername(user.getOrdername());
			
			userList.add(dto);
		});
		
		Thread.sleep(20000);
		return list;
	}
*/	
	
	

}

package com.imaginea.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imaginea.api.dto.UserDto;
import com.imaginea.api.entity.User;
import com.imaginea.api.service.UserDetailsService;

@Controller
public class UserDetailsController {

	@Autowired
	UserDetailsService userService;

	
	
	@RequestMapping(value="/UserDetails",method=RequestMethod.GET)
	@ResponseBody
	@Async
	public CompletableFuture<List<UserDto>> userDetails() throws InterruptedException {
		
		Iterable<User> iterableUser = userService.getAllUsers();
		List<UserDto> userList = new ArrayList<>();
		
		iterableUser.forEach( user -> {
			UserDto dto = new  UserDto();
			dto.setUserId(user.getUserid());
			dto.setUsername(user.getUsername());
			
			userList.add(dto);
		});
		
		// Artificial delay of 1s for demonstration purposes
        Thread.sleep(5000);
		
		return CompletableFuture.completedFuture(userList);
	}
	
	
	@RequestMapping(value="/UserDetails/id/{userid}",method=RequestMethod.GET)
	@ResponseBody
	@Async
	public User userWithName(@PathVariable int userid) throws InterruptedException {
		User list = userService.getUserDetails(userid);
		// Artificial delay of 1s for demonstration purposes
        Thread.sleep(5000);		
		return list;
	}
}

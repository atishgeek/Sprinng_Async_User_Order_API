package com.imaginea.api;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.imaginea.api.dto.UserDto;
import com.imaginea.api.service.UserDetailsService;

@Component
public class AppRunner implements CommandLineRunner{

	@Autowired
	UserDetailsController userController ;
	
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		 // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<List<UserDto>> page1 = userController.userDetails();
        CompletableFuture<List<UserDto>> page2 = userController.userDetails();
        CompletableFuture<List<UserDto>> page3 = userController.userDetails();

        // Wait until they are all done
        CompletableFuture.allOf(page1,page2,page3).join();

        // Print results, including elapsed time
        System.out.println("Test vals:"+(System.currentTimeMillis() - start));
	}

}

package com.piggymetrics.auth.controller;

import com.piggymetrics.auth.domain.User;
import com.piggymetrics.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

//adding a simple comment to force a change. Will only UserController.java get scanned?`
//feature branch mod only
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public Principal getUser(Principal principal) {
		return principal;
	}

	@PreAuthorize("#oauth2.hasScope('server')")
	@RequestMapping(method = RequestMethod.POST)
	public void createUser(@Valid @RequestBody User user) {
		userService.create(user);
	}

	//adding a test method to see if code triggers action in the scanner 
	public void testMethod(@Valid @RequestBody User user, String inputString)
	{
		//lets use the inputString object before null checking it to see if the scanner finds it
		Integer i = inputString.length();
		if(i>0)
		{
			//do stuff	
			//do more stuff		
		}
		userService.create(user);
	}
}

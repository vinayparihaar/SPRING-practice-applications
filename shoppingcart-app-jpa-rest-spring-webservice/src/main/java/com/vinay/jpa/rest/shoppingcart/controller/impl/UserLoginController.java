package com.vinay.jpa.rest.shoppingcart.controller.impl;

/**
 * @author VinayParihar
 * @date May 10, 2020 @time 12:25:26 PM 
 */

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vinay.jpa.rest.shoppingcart.bean.LogIn;
import com.vinay.jpa.rest.shoppingcart.bean.User;
import com.vinay.jpa.rest.shoppingcart.exceptions.InvalidInputException;
import com.vinay.jpa.rest.shoppingcart.exceptions.UserNotFoundException;
import com.vinay.jpa.rest.shoppingcart.service.IUserLogInService;
import com.vinay.jpa.rest.shoppingcart.utils.Utils;

@Controller
@Path("/login")
public class UserLoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
	@Autowired
	IUserLogInService iUserLogInService;

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 * 
	 * @Path("/{email}") public User getUserbyEmail(@PathParam("email") String
	 * email,@Context HttpHeaders httpheaders) {
	 * LOGGER.debug("Entered getUserbyEmail. ");
	 * System.out.println(httpheaders.getRequestHeader("Authorization")); if
	 * (Utils.isEmpty(email)) {
	 * LOGGER.error("Email empty or null in getUserbyEmail. "); throw new
	 * InvalidInputException("*Invalid email. "); } iUserLogInService = new
	 * UserLogInService(); return iUserLogInService.getUserbyEmail(email); }
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{email}")
	public User getUserbyEmail(@PathParam("email") String email) {

		LOGGER.debug("Entered getUserbyEmail. ");

		if (Utils.isEmpty(email)) {
			LOGGER.error("Email empty or null in getUserbyEmail. ");
			throw new InvalidInputException("*Invalid email. ");
		}
		// iUserLogInService = new UserLogInService();
		return iUserLogInService.getUserbyEmail(email);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	// @Path("/login")
	public User authenticateUser(LogIn logIn) {
		LOGGER.debug("Entered authenticateUser.  ");
		/*
		 * if (logIn == null || logIn.getEmail() == null ||
		 * logIn.getEmail().trim().length() <= 0 || logIn.getPassword().trim().length()
		 * <= 0 || logIn.getPassword() == null)
		 */
		if (logIn == null || Utils.isEmpty(logIn.getEmail()) || Utils.isEmpty(logIn.getPassword())) {
			LOGGER.error("Email or Password is Invalid. ");
			throw new InvalidInputException("*Invalid Email or Password. ");
		}
		// iUserLogInService = new UserLogInService();
		return iUserLogInService.authenticateUser(logIn);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getusers")
	public List<User> getAllUsers(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {

		LOGGER.debug("Entered getAllUsers.  ");
		// iUserLogInService = new UserLogInService();
		List<User> users = iUserLogInService.getAllUsers(offset, limit);
		if (users == null) {
			LOGGER.error("Data not found. ");
			throw new UserNotFoundException("Data not found. ");

		}
		return users;
	}

}

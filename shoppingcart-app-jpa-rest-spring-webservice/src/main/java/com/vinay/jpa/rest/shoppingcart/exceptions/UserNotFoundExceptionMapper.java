package com.vinay.jpa.rest.shoppingcart.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author VinayParihar
 * @date May 10, 2020 @time 12:25:26 PM 
 */

import com.vinay.jpa.rest.shoppingcart.bean.ErrorMessage;



@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {
	@Override
	public Response toResponse(UserNotFoundException userNotFoundException) {
		ErrorMessage errorMessage = new ErrorMessage(userNotFoundException.getMessage(), 404,
				"https://www.google.com/");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		
		
	}

}

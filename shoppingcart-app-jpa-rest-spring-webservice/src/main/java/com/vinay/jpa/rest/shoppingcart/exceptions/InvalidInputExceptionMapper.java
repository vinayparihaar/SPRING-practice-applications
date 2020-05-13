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
public class InvalidInputExceptionMapper implements ExceptionMapper<InvalidInputException> {

	@Override
	public Response toResponse(InvalidInputException invalidInputException) {
		ErrorMessage errorMessage= new ErrorMessage(invalidInputException.getMessage(), 406, "https://www.google.com/");
		return Response.status(Status.NOT_ACCEPTABLE).entity(errorMessage).build();
	
	}
}

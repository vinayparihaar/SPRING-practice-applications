/**
 * 
 */
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
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable throwableEx) {
		ErrorMessage errorMessage = new ErrorMessage(throwableEx.getMessage(), 500, "https://www.google.com/");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

}

package com.vinay.jpa.rest.shoppingcart.exceptions;

/**
 * @author VinayParihar
 * @date May 10, 2020 @time 12:25:26 PM 
 */

public class UserNotFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1692057825589603224L;

	public UserNotFoundException(String message)
	{
		super(message);
		
	}

}

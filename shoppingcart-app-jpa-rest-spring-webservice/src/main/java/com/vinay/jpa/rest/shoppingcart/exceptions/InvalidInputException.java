package com.vinay.jpa.rest.shoppingcart.exceptions;

/**
 * @author VinayParihar
 * @date May 10, 2020 @time 12:25:26 PM 
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidInputException extends RuntimeException {
	
private static final Logger LOGGER=LoggerFactory.getLogger(InvalidInputException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1822024792546423791L;

	public InvalidInputException(String message) {
		super(message);
		LOGGER.error("Throwing Error form InvalidInputException(String message) method of InvalidInputException class.  ");
		
	}

}

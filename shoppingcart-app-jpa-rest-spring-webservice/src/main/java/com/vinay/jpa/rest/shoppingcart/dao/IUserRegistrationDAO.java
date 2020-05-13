package com.vinay.jpa.rest.shoppingcart.dao;

/**
 * @author VinayParihar
 * @date May 10, 2020 @time 12:25:26 PM 
 */

import com.vinay.jpa.rest.shoppingcart.model.UserDetails;

public interface IUserRegistrationDAO {
	
	public boolean createUser(UserDetails userDetails);
	public boolean ifUserExist(String email);

}

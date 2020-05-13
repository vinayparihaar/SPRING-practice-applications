package com.vinay.jpa.rest.shoppingcart.service;

/**
 * @author VinayParihar
 * @date May 10, 2020 @time 12:25:26 PM 
 */

import com.vinay.jpa.rest.shoppingcart.bean.User;

public interface IUserRegistrationService {
	public boolean createUser(User user);
	public boolean ifUserExist(String email);

}

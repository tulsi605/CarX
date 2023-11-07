package com.carapplication.RegistrationLogin.service;

import com.carapplication.RegistrationLogin.entity.User;

public interface UserService {

	public User saveUser(User user);

	public void removeSessionMessage();

}
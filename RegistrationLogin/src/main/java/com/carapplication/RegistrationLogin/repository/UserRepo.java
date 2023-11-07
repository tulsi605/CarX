package com.carapplication.RegistrationLogin.repository;
import com.carapplication.RegistrationLogin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.carapplication.RegistrationLogin.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

}

package com.exampotal.services;

import java.util.Set;
import com.exampotal.models.User;
import com.exampotal.models.UserRole;
public interface UserService {
	
public User createUser(User user,Set<UserRole>userRoles) throws Exception;

}

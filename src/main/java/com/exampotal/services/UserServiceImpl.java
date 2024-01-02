package com.exampotal.services;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.exampotal.models.User;
import com.exampotal.models.UserRole;
import com.exampotal.repositories.RoleRepository;
import com.exampotal.repositories.UserRepository;

@Service
public class UserServiceImpl  implements UserService  {
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private RoleRepository roleReository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

   
    

	/*
	 * 
	 */
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User localuser=this.userRepository.findByUsername(user.getUsername());
		if(localuser!=null) {
			System.out.println("User Already Exists:");
			throw new Exception("User Already Exists:");
		}else {
			for(UserRole ur:userRoles) {
				roleReository.save(ur.getRole());
			}
			user.getUserRole().addAll(userRoles);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			localuser=this.userRepository.save(user);
		}
		return localuser;
	}
	
	

 /*
  * Get user by userid
  */

    public User getUser(String username) {
        // Add custom logic if needed
      return  userRepository.findByUsername(username);
    }
    
    
    public void deleteUser(Long userId) {
        // Add custom logic if needed
        userRepository.deleteById(userId);
    }
    
    
    /*
     * Update user
     */
    
    public User upadteUser(String username,User user) throws Exception {
    	User localuser=userRepository.findByUsername(username);
    	if(localuser==null) {
			System.out.println("User not present in data base:");
			throw new Exception("User not Exists:");
		}else {
			localuser.setAbout(user.getAbout());
	    	localuser.setEmail(user.getEmail());
	    	localuser.setFname(user.getFname());
	    	localuser.setLname(user.getLname());
	    	localuser.setMobile(user.getMobile());
	    	localuser.setProfile(user.getProfile());
	    	localuser.setPassword(passwordEncoder.encode(user.getPassword()));
	    	localuser.setUsername(user.getUsername());
	    	userRepository.save(localuser);
		}
		return localuser;	
    }
    

	
}


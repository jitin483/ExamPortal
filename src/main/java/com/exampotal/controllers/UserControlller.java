package com.exampotal.controllers;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampotal.Security.JwtTokenUtil;
import com.exampotal.models.JwtRequest;
import com.exampotal.models.JwtResponse;
import com.exampotal.models.Role;
import com.exampotal.models.User;
import com.exampotal.models.UserRole;
import com.exampotal.repositories.UserRepository;
import com.exampotal.services.UserDetailsServiceImpl;
import com.exampotal.services.UserServiceImpl;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class UserControlller {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private AuthenticationManager authenticationManager; 
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceimpl;
	@Autowired
	private JwtTokenUtil jwtUtiltoken;
	
	
	 @GetMapping("/welcome")
	  @PreAuthorize("hasAuthority('NORMAL')")
	    public String welcome() {
	        return "Welcome this endpoint is not secure";
	    }
	 
	 
	 
	 
	 @GetMapping("admin/all")
	    @PreAuthorize("hasAuthority('[NORMAL]')")
	    public String welcome1() {
	        return "Welcome this endpoint Admin ";
	    }
	 
	
	
	 
	 
	/*
	 * This For  creation user
	 */
	  @PostMapping("/")
	  
	public User createUser(@RequestBody User user) throws Exception {

		Set<UserRole>userRole=new HashSet<>();
		Role role=new Role();
		role.setRoleName("ADMIN");
		role.setRoleid(46L);
		UserRole urole=new UserRole();
		urole.setUser(user);
		urole.setRole(role);
		userRole.add(urole);
		return this.userServiceImpl.createUser(user, userRole);
	}
	
	
	
	/*
	 * for get user
	 */
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		System.out.println("Url Hit Successfully");
		return userServiceImpl.getUser(username);
	}
	

	/*
	 * for Delete user
	 */
	@DeleteMapping("/{userid}")
	public String deleteUser(@PathVariable("userid") Long userid) {
		
		userServiceImpl.deleteUser(userid);
		return "User deleted successfully";
	}
	
	/*
	 * For user update
	 */
	@PutMapping("/{username}")
	public User updateUser(@PathVariable("username") String username,@RequestBody User user) throws Exception {
		
		return this.userServiceImpl.upadteUser(username, user);
	}
	
	
	
	

	
	@PostMapping("/login")

    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

		System.out.println("Request : " +request);
        this.doAuthenticate(request.getUsername(), request.getPassword());


        UserDetails userDetails = userDetailsServiceimpl.loadUserByUsername(request.getUsername());
        String token = this.jwtUtiltoken.generateToken(userDetails.getUsername());

        JwtResponse response =  new JwtResponse();
        response.setJwttoken(token);     
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
        	authenticationManager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
    
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal) {
    	
    	return ((User) this.userDetailsServiceimpl.loadUserByUsername(principal.getName()));
    }
}

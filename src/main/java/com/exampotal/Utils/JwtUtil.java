package com.exampotal.Utils;

import org.springframework.stereotype.Component;

import com.exampotal.models.User;

@Component
public class JwtUtil {
    private String secret = "your-secret-key";

    public String generateToken(User userDetails) {
        // Generate JWT token
    	return "token";
    }

    public Boolean validateToken(String token, User userDetails) {
        // Validate JWT token
    	return true;
    }
}

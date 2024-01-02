package com.exampotal.Security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exampotal.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
  @Autowired
  private JwtAuthEntryPoint jwtAuthenticationEntryPoint;
  @Autowired
  private JwtRequestAuthFilter jwtRequestFilter;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	/*
	   * Bcrypt password
	   */
	 
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	 @Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable())
	        .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthenticationEntryPoint))
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .authorizeHttpRequests(auth -> 
	          auth.requestMatchers("/api/auth/**").permitAll()
	              .requestMatchers("/api/auth/login**").permitAll()
	              .anyRequest().authenticated()
	        );
	    
	    http.authenticationProvider(authenticationProvider());

	    http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	    
	    return http.build();
	  }
	
  
  
  @Bean
  public AuthenticationProvider authenticationProvider(){
      DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
      authenticationProvider.setUserDetailsService(this.userDetailsServiceImpl);
      authenticationProvider.setPasswordEncoder(this.passwordEncoder());
      return authenticationProvider;
  }
  
  
  

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
      return builder.getAuthenticationManager();
  }
  

}

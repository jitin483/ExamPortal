package com.exampotal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExamportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamportalApplication.class, args);
	}

	
//	@Autowired
//	private   UserServiceImpl userService;
//	@Override
//	public void run(String... args) throws Exception {
//		
//	
//		User u1=new User();
//
//				u1.setEmail("kmabhi£gmail.com");
//				u1.setFname("Jitin");
//			    u1.setUsername("Kmabhi");
//			    u1.setPassword("12345");
//		
//		
//
//	    
//		
//		Role r1=new Role();
//		r1.setRoleName("User");
//		
//		
//		
//	
//		UserRole ur1=new UserRole();
//		ur1.setRole(r1);
//		ur1.setUser(u1);
//		
//		Set<UserRole>urset=new HashSet<UserRole>();
//		
//		urset.add(ur1);
//	
//	User user=userService.createUser(u1, urset);
//		System.out.println(user.getUsername());
//		
//	
//		
//		
//	}

}

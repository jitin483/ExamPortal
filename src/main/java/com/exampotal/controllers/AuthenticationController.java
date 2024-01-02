package com.exampotal.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	

   

    @RequestMapping("/test")
    public String test() {
      System.out.println("Tetsing complete");
        return "Testing message";
    }
}
	  
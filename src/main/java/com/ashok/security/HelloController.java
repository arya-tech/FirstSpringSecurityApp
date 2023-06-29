package com.ashok.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "First spring security application!!";
	}
	
	@GetMapping("/bye")
	public String sayBye() {
		return "get lost from security application!!";
	}

}

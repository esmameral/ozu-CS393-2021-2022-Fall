package com.student.rs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class ApplicationServices {
	
	@RequestMapping(value = "/tr",method = RequestMethod.POST)
	public String sayHello() {
		return "Hello World";
	}

}

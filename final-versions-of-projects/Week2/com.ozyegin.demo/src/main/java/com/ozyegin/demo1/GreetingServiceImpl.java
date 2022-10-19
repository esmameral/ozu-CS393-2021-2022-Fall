package com.ozyegin.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("greetingService")
//@Scope("prototype")
public class GreetingServiceImpl implements GreetingService {
	@Value("Hi, how are you?")
	private String greeting;

	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	@Override
	public String sayGreeting(String name) {
		if (name.length() == 0)
			return greeting + ", guest!";
		else
			return greeting + ", " + name + "!";
	}
}

package com.ozyegin.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ozyegin.Application;

public class TestDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

		
	    GreetingService bean = context.getBean("greetingService", GreetingService.class);
	    System.out.println(bean.sayGreeting(""));
	    System.out.println(bean.sayGreeting("Esma"));
	    System.out.println(bean);
	    GreetingService bean1 = context.getBean("greetingService", GreetingService.class);
	    System.out.println(bean1.sayGreeting(""));
	    System.out.println(bean1);

	   
	}

}

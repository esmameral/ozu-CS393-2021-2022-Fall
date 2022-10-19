package com.ozyegin;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application implements CommandLineRunner, ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Hello world from Command Line Runner");
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("Hello World from Application Runner");
	}

	/*
	 * Java Based Bean Definition Example
	 * 
	 * @Bean public ProductRepository createProductRepo() { //Object Creation
	 * ProductRepository repo=new ProductRepository();
	 * repo.setUrl("jdbc:derby://localhost:1527/demodb;create=true");
	 * repo.setUsername("emeral"); repo.setPassword("password"); return repo; }
	 */

}

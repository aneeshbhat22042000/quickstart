package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.example.demo.model.Customer;
import com.example.demo.model.Invoice;
import com.example.demo.model.Product;

@SpringBootApplication
public class UnderstandingAutowiredApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(UnderstandingAutowiredApplication.class, args);
		
		Invoice inv=ctx.getBean(Invoice.class);
	
		System.out.println(inv);
	}
	
	
	@Bean
	//@Primary
	public Customer manju() {
		return new Customer(303,"Manju nath","manju@abc.com");
	
    }
	@Bean
	public Customer vikas() {
		return new Customer(203,"Vikas Khanna","vikas@abc.com");
	
    }
	
	@Bean
	public Product tv() {
		return new Product(2020,"sony tv",34000);
	}
}

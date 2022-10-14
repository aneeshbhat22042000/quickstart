package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Product;
import com.example.demo.services.ProductService;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringDataJpaApplication.class, args);
//	Product obj=ctx.getBean(Product.class);
//	
//	ProductService service=ctx.getBean(ProductService.class);
//	
//	System.out.println("One Product with  following Details Added"+service.save(obj));
//	
//	//service.findByProductName("SamSung Galaxy Tab").forEach(System.out::println);
//	
//	ctx.close();
	
	}
	@Bean
	public Product tv() {
		
		return new Product(105,"SamSung Galaxy Tab",16000);
	}
}

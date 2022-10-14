package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerService;

@SpringBootApplication
public class SpringJdbcApplication {
    public static void addData() {}



   public static void main(String[] args) {
        ConfigurableApplicationContext ctx=SpringApplication.run(SpringJdbcApplication.class, args);
        int key=2;
        CustomerService service=ctx.getBean(CustomerService.class);
        if(key==1) {
        Customer obj=ctx.getBean(Customer.class);
        
        
        // obj={0,null,null}
        obj.setCustomerId(Integer.parseInt(args[1]));
        obj.setCustomerName(args[2]);
        obj.setCustomerEmail(args[3]);
        // obj={101,"ramesh","ram@abc.com"}
        
        
        
        
        System.out.println("Is added:="+service.save(obj));
        }
        if(key==2) {
            service.findAll().forEach(System.out::println);
        }
        
        ctx.close();
    }



}
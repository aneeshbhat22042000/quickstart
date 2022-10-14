package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@Data 
@AllArgsConstructor


@Component  //Class annotated with @Component will be registered as a BEAN

public class Customer {
	int customerId;
	String customerName;
	String email;
	
}

package com.example.demo.model;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@Data 
@AllArgsConstructor
public class Invoice {
	int invoicenumber;
	Customer customer;
	LocalDate invoiceDate;
	double price;
	

}

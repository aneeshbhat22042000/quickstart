package com.example.demo.module1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;



import java.time.LocalDate;



import org.springframework.stereotype.Component;




// instead of generating setters and gettrs we are using this annotations from lombok.
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component



public class Address {
    String addressLine1;
    String addressLine2;
    long pinCode;



}
package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.services.DoctorService;

@SpringBootApplication
public class DayTwoTasksApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext 	ctx =SpringApplication.run(DayTwoTasksApplication.class, args);
	
	  Doctor doctor = ctx.getBean(Doctor.class);
	  
	  DoctorService service = ctx.getBean(DoctorService.class);
	  
	  service.add(doctor);
	  
	}
	 
	
	//change above serice.add by commenting that line and remove the closing bracket
//	    service.add(doctor);
//	  
	
	
//	   Doctor found = service.findById(9823);
//	   
//	   System.out.println("Doctor Name:="+found.getDoctorName());
//	   System.out.println("Department:="+found.getDepartment());
//	   
//	   System.out.println("List of Patients");
//	   
//	   for(Patient eachPatient: found.getPatients()) {
//		   System.out.println(eachPatient);
//	   }
//	
	
	
	
	
	
	
	@Bean
	public Patient ram() {
		return new Patient(105,"ramkumar");
		
	}
	
	@Bean
	public Patient shyam() {
		return new Patient(106,"shyamkumar");
		
	}
	
	
	@Bean
    public Doctor rajesh() {
        
        Set<Patient> patientList = new HashSet<>();
        patientList.add(ram());
        patientList.add(shyam());
        
        return new Doctor(9832,"Rajesh","ent",patientList);
	   
	}

	
}
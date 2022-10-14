package com.example.demo.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital,Integer> {
	public List<Hospital> findByHospitalName(String qryString);
	
	
	//public Hospital findById(int id); 

	//public List<Hospital> deleteByHospitalName(String rchString);

	//public Hospital update(Hospital entity);
}

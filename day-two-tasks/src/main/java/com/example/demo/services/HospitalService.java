package com.example.demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Hospital;
import com.example.demo.repos.HospitalRepo;
@Service
public class HospitalService {
	private HospitalRepo repo;
	@Autowired
	public HospitalService(HospitalRepo repo) {
		super();
		this.repo = repo;
	}
	public Hospital save(Hospital entity) {
		return this.repo.save(entity);	
	}
	public List<Hospital> findAll(){
		return this.repo.findAll();
	}
	
	public List<Hospital> findByHospitalName(String srchString){
		return this.repo.findByHospitalName(srchString);
	}
	public Hospital findById(int id){
		return this.repo.findById(id).get();
		
	}
	public Hospital update(Hospital entity) {
		return this.repo.save(entity);	
	}
	public void deleteById(int id) {
		this.repo.deleteById(id);	
	}
}

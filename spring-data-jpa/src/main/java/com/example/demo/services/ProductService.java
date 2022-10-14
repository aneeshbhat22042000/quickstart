package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Product;
import com.example.demo.repos.ProductRepo;

@Service
public class ProductService {
	private ProductRepo repo;
	
	@Autowired
	public ProductService(ProductRepo repo) {
		super();
		this.repo = repo;
	}
	public Product save(Product entity) {
		return this.repo.save(entity);	
	}
	public List<Product> findAll(){
		return this.repo.findAll();
	}
	
	public Optional<Product> findById(int id){
		return this.repo.findById(id);
	}
	
	public List<Product> findByProductName(String srchString){
		return this.repo.findByProductName(srchString);
	}
	
	
	
	public List<Product> findByRatePerUnit(double rate){
		return this.repo.findByRatePerUnit(rate);
	}
	
	public void deleteById(int id) {
		if(this.repo.existsById(id)) {
			 this.repo.deleteById(id);
			}else {
				
				throw new RuntimeException("Element not found !!!");
			}
	}
	
	public Product update(Product prod) {
		return this.repo.save(prod);
	}
	
	
	
	public List<Product> sortByPrice( double limit ){
		return this.repo.sortByPrice(limit);
	}
	
//	public List<Product> findByRatePerUnitGrtThan(double rateGrt) {
//		
//		return this.repo.findByRatePerUnitGrtThan(rateGrt);
//	}
	
}




package com.example.demo.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping(path="/api/v1/products")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping
	public List<Product> findAllProduct(){
		
		return this.service.findAll();
		
	}
	@GetMapping(path="/{id}")
	public Product findById(@PathVariable("id")int id) {
		
		return this.service.findById(id).orElseThrow(()-> new RuntimeException("Element not found!!"));
		
		
	}
	
	@GetMapping(path="/name/{productName}")
	public List<Product> findAllProduct(@PathVariable("productName")String name){
		
		return this.service.findByProductName(name);
		
	}
	
	@GetMapping(path="/rate/{ratePerUnit}")
	public List<Product> findAllProductByRate(@PathVariable("ratePerUnit")double ratePerUnit) {
		return this.service.findByRatePerUnit(ratePerUnit);
	}
	
//	@GetMapping(path = "/byPrice")
//    public List<Product> findByRateGrtThan(@RequestParam("rate") double rate){
//        
//        return this.service.findByRatePerUnitGrtThan(rate);
//    }
	
	 @PostMapping
	    public ResponseEntity<Product> add(@RequestBody Product entity) throws URISyntaxException{
	        Product added = this.service.save(entity);
	        return ResponseEntity.created(new URI("/api/v1/products/"+entity.getId())).body(added);
	    }
	
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Product prod) throws URISyntaxException{
		Product addedEntity=this.service.update(prod);
		
		return ResponseEntity.ok("Updated");
	}
	
	@DeleteMapping(path="/{id}")
    public void deleteById(@PathVariable("id")int id) {
    	this.service.deleteById(id);
    }
	
//	@PutMapping(path="/{id}/{ratePerUnit}")
//    public ResponseEntity<String> update(@PathVariable ("id")int id,@PathVariable("ratePerUnit") int ratePerUnit) 
//    {
//       int rowUpdated = this.service.update(id,ratePerUnit);
//        
//        return ResponseEntity.ok("Row updated= "+rowUpdated);
//    }
	
//	@PutMapping(path="/{ratePerUnit}/{id}")
//    public ResponseEntity<String> update(@PathVariable("ratePerUnit") int ratePerUnit,@PathVariable ("id")int id) 
//    {
//       int rowUpdated = this.service.update(ratePerUnit,id);
//        
//        return ResponseEntity.ok("Row updated= "+rowUpdated);
//    }
	
	@GetMapping(path="/sort/{limit}")
	public List<Product> sortByPrice(@PathVariable("limit")double limit) {
		return this.service.sortByPrice(limit);
	}
	
	

}

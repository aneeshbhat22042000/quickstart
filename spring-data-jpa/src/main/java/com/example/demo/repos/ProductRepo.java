package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {
	public List<Product> findByProductName(String qryString);
	public List<Product> findByRatePerUnit(double rate);
	
	@Query(value="From Product where ratePerUnit>=:limit",nativeQuery=false)
	public List<Product> sortByPrice(@Param ("limit")double limit );
	
	
	
	
	
	@Query(value="update tieto_fee set ratePerUnit=:ratePerUnit where id=:id",nativeQuery=true)
	
	public int update(@Param("ratePerUnit") double ratePerUnit,@Param("id")int id);
//	
//	public List<Product> findByRatePerUnitGrtThan(double rateGrt);
}
	//public List<Product> getProjectByRate(@Param)
	//findByPropertyName 
	//public List<Product> findByRatePerUnit(int rate);

//}

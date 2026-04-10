package com.example.ecommercespring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommercespring.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}

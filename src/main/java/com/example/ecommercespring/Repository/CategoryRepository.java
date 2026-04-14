package com.example.ecommercespring.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ecommercespring.Entity.Category;
import com.example.ecommercespring.Entity.Product;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);


}

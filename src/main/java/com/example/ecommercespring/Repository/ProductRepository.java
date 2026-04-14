package com.example.ecommercespring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ecommercespring.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    //this is a custom query method using HQL. Explicitly define the query logic
    @Query("SELECT p From Product p WHERE p.price >: minPrice")
    List<Product> FindExpensiveProducts(@Param("minPrice") double minPrice);

    // //LIMIT ,REGEX, advanced query
    //  @Query(value="Select * FROM product WHERE MATCH(name, description) AGAINST (:keyword)", nativeQuery = true)
    // List<Product> searchFullText(@Param("keyword") String keyword);
    
    
    //:minPrice <"minPrice" in @Param("minPrice")
    //:brand<"brand" in @Param("brand")
    @Query("Select p from Product p where p.price>:minPrice and p.brand=:brand")
    List<Product> findByBrandAndPrice(
        @Param("minPrice") int price,
        @Param("brand") String brandName
    );
}
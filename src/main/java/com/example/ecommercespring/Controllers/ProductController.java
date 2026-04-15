package com.example.ecommercespring.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommercespring.DTO.ProductDTO;
import com.example.ecommercespring.DTO.ProductWithCategoryDTO;
import com.example.ecommercespring.Exception.ProductNotFoundException;
import com.example.ecommercespring.Services.IProductService;
import com.example.ecommercespring.gateway.IProductGateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    private final IProductService productService;
    public ProductController(IProductService productService){
        this.productService=productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws Exception{  //path variabld maps the id used in path to the argument given in function
      
        ProductDTO result=this.productService.getProductById(id);

      return ResponseEntity.ok(result);
  }
 
@PostMapping
public ResponseEntity<?> createProduct(@RequestBody ProductDTO dto) {
    try {
        ProductDTO result = productService.createProduct(dto);
        return ResponseEntity.ok(result);

    } catch (Exception e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}

@GetMapping("/{id}/details")
public ResponseEntity<ProductWithCategoryDTO> getProductWithCategory(@PathVariable long id) throws Exception{
  ProductWithCategoryDTO dto=productService.getProductWithCategory(id);
  return ResponseEntity.ok(dto);
}

@ExceptionHandler(ProductNotFoundException.class)
public ResponseEntity<String> handleProductNotFound(ProductNotFoundException e){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
}

}

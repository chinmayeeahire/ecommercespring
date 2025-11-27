package com.example.ecommercespring.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommercespring.DTO.ProductDTO;
import com.example.ecommercespring.Services.IProductService;
import com.example.ecommercespring.gateway.IProductGateway;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


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
}

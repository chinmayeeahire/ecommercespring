package com.example.ecommercespring.Services;

import org.springframework.stereotype.Service;

import com.example.ecommercespring.DTO.ProductDTO;
import com.example.ecommercespring.Entity.Product;
import com.example.ecommercespring.Repository.ProductRepository;
import com.example.ecommercespring.mappers.ProductMapper;

@Service
public class ProductService implements IProductService{

private final ProductRepository repo;

public ProductService(ProductRepository repo){
    this.repo=repo;
}

public ProductDTO getProductById(Long id) throws Exception{
    // return repo.findById(id)
    //            .map(ProductMapper::toDto)
    //            .orElseThrow(()-> new Exception("Product not found"));

    Product product=repo.findById(id)
            .orElseThrow(()-> new Exception("Product not found"));
    
    ProductDTO dto=ProductMapper.toDto(product);
    return dto;
}

@Override
public ProductDTO createProduct(ProductDTO dto){
    Product saved=repo.save(ProductMapper.toEntity((dto)));
    return ProductMapper.toDto(saved);
}

}

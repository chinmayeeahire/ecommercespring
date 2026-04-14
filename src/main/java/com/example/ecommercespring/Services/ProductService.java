package com.example.ecommercespring.Services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ecommercespring.DTO.ProductDTO;
import com.example.ecommercespring.DTO.ProductWithCategoryDTO;
import com.example.ecommercespring.Entity.Category;
import com.example.ecommercespring.Entity.Product;
import com.example.ecommercespring.Repository.CategoryRepository;
import com.example.ecommercespring.Repository.ProductRepository;
import com.example.ecommercespring.mappers.ProductMapper;

@Service
public class ProductService implements IProductService{

private final ProductRepository repo;
private final CategoryRepository categoryRepository;

public ProductService(ProductRepository repo, CategoryRepository categoryRepository){
    this.repo=repo;
    this.categoryRepository=categoryRepository;
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
public ProductDTO createProduct(ProductDTO dto) throws Exception{
    Category category=categoryRepository.findById(dto.getCategoryId())
             .orElseThrow(()-> new Exception("Category not found"));
    
    Product saved=repo.save(ProductMapper.toEntity(dto, category));
    return ProductMapper.toDto(saved);
}

@Override
public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception{
  Product product=repo.findById(id)
          
.orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Product not found"
                )
            );

  
  return ProductMapper.toProductWithCategoryDTO(product);
}

}

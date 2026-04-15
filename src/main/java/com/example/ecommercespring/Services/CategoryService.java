package com.example.ecommercespring.Services;

import com.example.ecommercespring.Entity.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ecommercespring.DTO.CategoryDTO;
import com.example.ecommercespring.DTO.CategoryWithProductDTO;
import com.example.ecommercespring.DTO.ProductDTO;
import com.example.ecommercespring.Entity.Product;
import com.example.ecommercespring.Exception.CategoryNotFoundException;
import com.example.ecommercespring.Repository.CategoryRepository;
import com.example.ecommercespring.mappers.CategoryMapper;
import com.example.ecommercespring.mappers.ProductMapper;

@Service
public class CategoryService implements ICategoryService{
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo){
        this.repo=repo;
    }

//     public ProductDTO getProductById(Long id) throws Exception{
//     // return repo.findById(id)
//     //            .map(ProductMapper::toDto)
//     //            .orElseThrow(()-> new Exception("Product not found"));

//     Product product=repo.findById(id)
//             .orElseThrow(()-> new Exception("Product not found"));
    
//     ProductDTO dto=ProductMapper.toDto(product);
//     return dto;
// }

public CategoryDTO getCategoryById(Long id){
    Category category = null;
    try {
        category = repo.findById(id)
                 .orElseThrow(()->new Exception("Category not found with id"+id));
    } catch (Exception e) {
        e.printStackTrace();
    }
    CategoryDTO dto=CategoryMapper.toDto(category);
    return dto;
}

 @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> dtos = new ArrayList<>();
        for (Category category : repo.findAll()) {
            dtos.add(CategoryMapper.toDto(category));
        }
        return dtos;
    }

// @Override
// public ProductDTO createProduct(ProductDTO dto){
//     Product saved=repo.save(ProductMapper.toEntity((dto)));
//     return ProductMapper.toDto(saved);
// }

@Override
public CategoryDTO createCategory(CategoryDTO dto){
   Category category=CategoryMapper.toEntity(dto);
   Category saved=repo.save(category);
   return CategoryMapper.toDto(saved);
}

@Override 
public CategoryDTO getByName(String name) throws Exception{
    Category category = repo.findByName(name)
             .orElseThrow(()->new CategoryNotFoundException("Category not found by name"+name));

             return CategoryMapper.toDto(category);
}

@Override
public CategoryWithProductDTO getCategoryWithProduct(long id) throws Exception{
    Category category=repo.findById(id)
            .orElseThrow(()->new Exception("Category not found"));

     List<ProductDTO> productDTOs = category.getProducts()
                .stream()
                .map(product -> ProductMapper.toDto(product))
                .collect(Collectors.toList());

        return CategoryWithProductDTO.builder()
                .CategoryId(category.getId())
                .name(category.getName())
                .product(productDTOs)
                .build();
    }

 
}

package com.example.ecommercespring.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommercespring.DTO.CategoryDTO;
import com.example.ecommercespring.DTO.CategoryWithProductDTO;

@Service
public interface ICategoryService {
   List<CategoryDTO> getAllCategories() throws IOException;
   CategoryDTO getCategoryById(Long id) ;
   CategoryDTO createCategory(CategoryDTO dto);
   CategoryDTO getByName(String name) throws Exception;
   CategoryWithProductDTO getCategoryWithProduct(long id) throws Exception;
}

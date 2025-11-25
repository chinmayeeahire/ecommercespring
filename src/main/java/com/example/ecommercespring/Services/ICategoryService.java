package com.example.ecommercespring.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommercespring.DTO.CategoryDTO;

@Service
public interface ICategoryService {
   List<CategoryDTO> getAllCategories() throws IOException;
}

package com.example.ecommercespring.gateway;

import java.io.IOException;
import java.util.List;

import com.example.ecommercespring.DTO.CategoryDTO;

public interface ICategoryGateway {
    List<CategoryDTO> getAllCategories() throws IOException;
}

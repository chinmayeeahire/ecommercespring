package com.example.ecommercespring.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommercespring.DTO.CategoryDTO;
import com.example.ecommercespring.gateway.ICategoryGateway;

@Service
public class FakestoreCategoryService implements ICategoryService {
    private final ICategoryGateway categoryGateway;

    public FakestoreCategoryService(ICategoryGateway categoryGateway){
        this.categoryGateway=categoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException{
        return this.categoryGateway.getAllCategories();
    }}

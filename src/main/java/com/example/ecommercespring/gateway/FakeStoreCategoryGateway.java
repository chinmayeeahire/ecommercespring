package com.example.ecommercespring.gateway;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.ecommercespring.DTO.CategoryDTO;
import com.example.ecommercespring.DTO.FakestoreCategoryResponseDTO;
import com.example.ecommercespring.gateway.api.FakestoreCategoryApi;

import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway {
 
 private final FakestoreCategoryApi fakestoreCategoryApi;
 
 public FakeStoreCategoryGateway(FakestoreCategoryApi fakestoreCategoryApi){
    this.fakestoreCategoryApi=fakestoreCategoryApi;
 }
 
 @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        // 1. Make the HTTP request to the FakeStore API to fetch all categories
        FakestoreCategoryResponseDTO response = this.fakestoreCategoryApi.getAllFakeCategories().execute().body();

        // 2. Check if the response is null and throw an IOException if it is
        if(response == null) {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }

        // 3. Map the response to a list of CategoryDTO objects
        return response.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }

}

package com.example.ecommercespring.gateway.api;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.ecommercespring.DTO.FakestoreCategoryResponseDTO;

import retrofit2.Call;
import retrofit2.http.GET;

@Component
public interface FakestoreCategoryApi {


  @GET("products/category")
  Call<FakestoreCategoryResponseDTO> getAllFakeCategories() throws IOException;
}

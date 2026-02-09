package com.example.ecommercespring.gateway;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.ecommercespring.DTO.CategoryDTO;
import com.example.ecommercespring.DTO.FakestoreCategoryResponseDTO;
import com.example.ecommercespring.mappers.GetAllCategoriesMapper;
@Component

public class FakeStoreRestTemplateGateway implements ICategoryGateway{
    
 
    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreRestTemplateGateway(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    // @Override
    // public List<CategoryDTO> getAllCategories() throws IOException {
    //    RestTemplate restTemplate=restTemplateBuilder.build();
    //    String url="https://fakestoreapi.com/products/categories";

    //    ResponseEntity<FakestoreCategoryResponseDTO> response=restTemplate.getForEntity(url, FakestoreCategoryResponseDTO.class);
    //    if(response.getBody()==null){
    //     throw new IOException("Failed to fetch categories from fakestore api");
    //    }
    //    return response.getBody().getCategories().stream()
    //             .map(category -> CategoryDTO.builder()
    //                     .name(category)
    //                     .build())
    //             .toList();
    // }


    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        String url = "https://fakestoreapi.com/products/categories";

        // Step 1: Parse response as String[]
        ResponseEntity<String[]> response =
                restTemplate.getForEntity(url, String[].class);

        if (response.getBody() == null) {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }

        // // Step 2: Wrap into your FakestoreCategoryResponseDTO
        // FakestoreCategoryResponseDTO dto =
        //         new FakestoreCategoryResponseDTO(Arrays.asList(response.getBody()));

        // // Step 3: Convert DTO → List<CategoryDTO>
        // return dto.getCategories().stream()
        //         .map(category -> CategoryDTO.builder()
        //                 .name(category)
        //                 .build())
        //         .toList();

        FakestoreCategoryResponseDTO dto=GetAllCategoriesMapper.toFakeStoreCategoryDTO(response.getBody());

        return GetAllCategoriesMapper.toCategoryDto(dto);
    }
}
    


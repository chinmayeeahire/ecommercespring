package com.example.ecommercespring.mappers;

import java.util.Arrays;
import java.util.List;

import com.example.ecommercespring.DTO.CategoryDTO;
import com.example.ecommercespring.DTO.FakeStoreProductResponseDTO;
import com.example.ecommercespring.DTO.FakestoreCategoryResponseDTO;

public class GetAllCategoriesMapper {
// public static FakestoreCategoryResponseDTO toFakeStoreCategoryDTO(){
//     return null;
// }

public static FakestoreCategoryResponseDTO toFakeStoreCategoryDTO(String[] categories){
return FakestoreCategoryResponseDTO.builder()
.categories(Arrays.asList(categories))
.build();
}
public static List<CategoryDTO> toCategoryDto(FakestoreCategoryResponseDTO dto){
    return dto.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();

}
}

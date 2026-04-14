package com.example.ecommercespring.mappers;



import com.example.ecommercespring.DTO.CategoryDTO;
import com.example.ecommercespring.DTO.CategoryWithProductDTO;
import com.example.ecommercespring.Entity.Category;

public class CategoryMapper {

    public static CategoryDTO toDto(Category category){
         return CategoryDTO.builder()
                        //    .id(category.getId())
                        //    .name(category.getName())
                           .id(category.getId())
                           .name(category.getName())
                           .build();
  }

  public static Category toEntity(CategoryDTO dto){
     return Category.builder()
                    .name(dto.getName())
                    .build();
  }

 
}

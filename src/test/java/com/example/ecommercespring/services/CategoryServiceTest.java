package com.example.ecommercespring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.ecommercespring.DTO.CategoryDTO;
import com.example.ecommercespring.Entity.Category;
import com.example.ecommercespring.Repository.CategoryRepository;
import com.example.ecommercespring.Services.CategoryService;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class) //This annotation is used to enable Mockito for the test class with Junit
public class CategoryServiceTest {
    
    @Mock
    private CategoryRepository categoryRepository;
    

    @InjectMocks
    private CategoryService categoryService;

    private CategoryDTO categoryDTO;
    private Category category1;
    private Category category2;
    private Category category3;


    @BeforeEach
    void setUp(){
       categoryDTO = CategoryDTO.builder()
        .name("Electronics")
        .build();
      
     category1 = Category.builder()
        .name("Electronics")
        .build();
       category1.setId(1L);
     category2 = Category.builder()
        .name("Books")
        .build();
       category2.setId(2L);
     category3 = Category.builder()
        .name("Movies")
        .build();
       category2.setId(3L);
    }

    @Test
    @DisplayName("should return all categories succesfully")
    void getAllCategories_shouldReturnAllCategories(){
       //arrange
       List<Category> categories=new ArrayList<>();
       
 
       categories.add(category1);
       categories.add(category2);
       categories.add(category3);
        when(categoryRepository.findAll()).thenReturn(categories);
       //act
       List<CategoryDTO> result=categoryService.getAllCategories();
       //assert
      assertEquals(result.size(), 3);
      verify(categoryRepository, times(1)).findAll();
    }


    @Test
    void createCategory_shouldCreateCategory(){
      //arrange
      
      Category savedCategory=Category.builder().name("Electronics").build();

   
    when(categoryRepository.save(any(Category.class))).thenReturn(savedCategory);
    //act
    CategoryDTO res=categoryService.createCategory(categoryDTO);

    //assert
   assertEquals("Electronics", res.getName());
    }
    

    @Test
    @DisplayName("should return empty list when no category exist ")
    void getAllCategories_shouldReturnEmptyListWhenNoCategoryExist(){
      when(categoryRepository.findAll()).thenReturn(new ArrayList<>());

      //act
      List<CategoryDTO> res=categoryService.getAllCategories();

      //assert
      assertEquals(res.size(), 0);
      verify(categoryRepository, times(1)).findAll();
    }
}

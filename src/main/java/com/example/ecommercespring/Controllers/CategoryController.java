package com.example.ecommercespring.Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommercespring.DTO.CategoryDTO;
import com.example.ecommercespring.Services.CategoryService;
import com.example.ecommercespring.Services.FakestoreCategoryService;
import com.example.ecommercespring.Services.ICategoryService;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/categories")
public class CategoryController {

//   @GetMapping
//    public String getCategory(){
//     return "Electronics";
//   }
//   @GetMapping("/count")
//   public int getCategoryCount() {
//       return 5;
//   }
// //   @DeleteMapping
// //   public String deleteCategory(){
// //     return "Category deleted";
// //   }

//   @PostMapping
//   public String getPostCategory() {
      
//       return "Post electronics";
//   }
  

//day 2

// @Autowired
private final ICategoryService categoryService;

public CategoryController(ICategoryService categoryService){
    this.categoryService=categoryService;
}



@GetMapping
public List<CategoryDTO> getAllCategories() throws IOException{
    return this.categoryService.getAllCategories();
}

 }

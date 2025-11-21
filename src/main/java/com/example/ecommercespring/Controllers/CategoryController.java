package com.example.ecommercespring.Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/categories")
public class CategoryController {

  @GetMapping
   public String getCategory(){
    return "Electronics";
  }
  @GetMapping("/count")
  public int getCategoryCount() {
      return 5;
  }
//   @DeleteMapping
//   public String deleteCategory(){
//     return "Category deleted";
//   }

  @PostMapping()
  public String getPostCategory() {
      
      return "Post electronics";
  }
  
 }

package com.example.ecommercespring.Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommercespring.DTO.CategoryDTO;
import com.example.ecommercespring.DTO.CategoryWithProductDTO;
import com.example.ecommercespring.Services.CategoryService;
import com.example.ecommercespring.Services.FakestoreCategoryService;
import com.example.ecommercespring.Services.ICategoryService;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public ResponseEntity<?> getAllCategories(@RequestParam(required=false) String name) throws Exception{
    if(name!=null && !name.isBlank()){
        CategoryDTO categoryDTO=categoryService.getByName(name);
        return ResponseEntity.ok(categoryDTO);
    }else{
    List<CategoryDTO> result= this.categoryService.getAllCategories();
    return ResponseEntity.ok(result);
    }
}


@PostMapping("/create-category")
public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto) throws Exception{
    return ResponseEntity.ok(categoryService.createCategory(dto));
}

@GetMapping("/{id}/details")
public ResponseEntity<CategoryWithProductDTO> getCategoryWithProduct(@PathVariable long id) throws Exception{
    CategoryWithProductDTO dto=categoryService.getCategoryWithProduct(id);
    return ResponseEntity.ok(dto);
}
 }

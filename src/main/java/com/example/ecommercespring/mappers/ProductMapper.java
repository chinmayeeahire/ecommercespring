package com.example.ecommercespring.mappers;



import java.util.List;

import com.example.ecommercespring.DTO.CategoryWithProductDTO;
import com.example.ecommercespring.DTO.ProductDTO;
import com.example.ecommercespring.DTO.ProductWithCategoryDTO;
import com.example.ecommercespring.Entity.Product;
import com.example.ecommercespring.Entity.Category;
public class ProductMapper {

    public static ProductDTO toDto(Product product){
        return ProductDTO.builder()
                         .id(product.getId())
                         .image(product.getImage())
                         .color(product.getColor())
                         .price(product.getPrice())
                         .description(product.getDescription())
                         .discount(product.getDiscount())
                         .model(product.getModel())
                         .title(product.getTitle())
                         .categoryId(product.getCategory().getId())
                         .brand(product.getBrand())
                         .popular(product.isPopular())
                         .build();
    }

    public static Product toEntity(ProductDTO dto, Category category){
        return Product.builder()
                      .image(dto.getImage())
                      .color(dto.getColor())
                      .price(dto.getPrice())
                      .description(dto.getDescription())
                      .discount(dto.getDiscount())
                      .model(dto.getModel())
                      .title(dto.getTitle())
                      .category(category)
                      .brand(dto.getBrand())
                      .popular(dto.isPopular())
                      .build();
    }

    public static ProductWithCategoryDTO toProductWithCategoryDTO (Product product){
        return ProductWithCategoryDTO.builder()
                                     .id(product.getId())
                                     .image(product.getImage())
                                     .color(product.getColor())
                                     .price(product.getPrice())
                                     .description(product.getDescription())
                                     .discount(product.getDiscount())
                                     .model(product.getModel())
                                     .title(product.getTitle())
                                     .category(CategoryMapper.toDto(product.getCategory()))
                                     .brand(product.getBrand())
                                     .popular(product.isPopular())
                                     .build();
                                      
    }

   
}

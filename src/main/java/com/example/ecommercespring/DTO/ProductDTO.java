package com.example.ecommercespring.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
   private String image;
   private String color;
   private int price;
   private String description;
   private int discount;
   private String model;
   private int id;
   private String title;
   private String category;
   private String brand;
   private boolean popular;
}

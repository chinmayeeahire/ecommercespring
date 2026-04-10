package com.example.ecommercespring.Entity;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity{

 private String image;
   private String color;
   private int price;
   private String description;
   private int discount;
   private String model;
   private long id;
   private String title;
   private String category;
   private String brand;
   private boolean popular;

}

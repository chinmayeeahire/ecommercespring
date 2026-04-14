package com.example.ecommercespring.DTO;

import lombok.*;



@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Builder
public class  CategoryDTO {
  private Long id;
  private String name;
}

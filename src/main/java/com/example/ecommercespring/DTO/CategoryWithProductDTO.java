package com.example.ecommercespring.DTO;

import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryWithProductDTO {
  private Long CategoryId;
  private String name;
  private List<ProductDTO> product;

}

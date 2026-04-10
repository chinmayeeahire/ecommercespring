package com.example.ecommercespring.DTO;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductResponseDTO {
  private ProductDTO product;
  private String message;
  private String status;
  public Collection<CategoryDTO> getCategories() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCategories'");
  }

}

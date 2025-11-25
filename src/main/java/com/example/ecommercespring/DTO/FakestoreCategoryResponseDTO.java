package com.example.ecommercespring.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakestoreCategoryResponseDTO {
//    private String status;
//    private String message;
   private List<String> categories;
}

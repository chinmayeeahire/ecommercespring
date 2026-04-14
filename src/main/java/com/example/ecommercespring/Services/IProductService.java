package com.example.ecommercespring.Services;

import com.example.ecommercespring.DTO.ProductDTO;
import com.example.ecommercespring.DTO.ProductWithCategoryDTO;

public interface IProductService {
ProductDTO getProductById(Long id) throws Exception;
ProductDTO createProduct(ProductDTO dto) throws Exception;
ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception;

}

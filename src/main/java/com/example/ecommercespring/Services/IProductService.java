package com.example.ecommercespring.Services;

import com.example.ecommercespring.DTO.ProductDTO;

public interface IProductService {
ProductDTO getProductById(Long id) throws Exception;
}

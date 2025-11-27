package com.example.ecommercespring.gateway;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.ecommercespring.DTO.ProductDTO;

import lombok.extern.apachecommons.CommonsLog;

@Service
@Component
public interface IProductGateway {
   ProductDTO getProductById(Long id) throws Exception;
}

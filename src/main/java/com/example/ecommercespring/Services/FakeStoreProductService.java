package com.example.ecommercespring.Services;

import org.springframework.stereotype.Service;

import com.example.ecommercespring.Controllers.ProductController;
import com.example.ecommercespring.DTO.ProductDTO;
import com.example.ecommercespring.DTO.ProductWithCategoryDTO;
import com.example.ecommercespring.gateway.IProductGateway;

@Service
public class FakeStoreProductService implements IProductService{
    
    private final IProductGateway productGateway;
    public FakeStoreProductService(IProductGateway productGateway){
        this.productGateway=productGateway;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
         return this.productGateway.getProductById(id);
    }

    public ProductDTO createProduct(ProductDTO dto){
    return null;
    }
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception{
        return null;
    }
}

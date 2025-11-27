package com.example.ecommercespring.gateway;

import org.springframework.stereotype.Component;

import com.example.ecommercespring.DTO.FakeStoreProductResponseDTO;
import com.example.ecommercespring.DTO.ProductDTO;
import com.example.ecommercespring.gateway.api.FakeStoreProductApi;

@Component
public class FakeStoreProductGateway implements IProductGateway {


    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi){
        this.fakeStoreProductApi=fakeStoreProductApi;
    }

@Override
 public ProductDTO getProductById(Long id) throws Exception{
    FakeStoreProductResponseDTO response =this.fakeStoreProductApi.getFakeProduct(id).execute().body();
    if(response==null){
        throw new Exception("Product not found");
    }
    return response.getProduct();
 }
}

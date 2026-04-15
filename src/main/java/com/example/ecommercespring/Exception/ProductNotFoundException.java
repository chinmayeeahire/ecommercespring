package com.example.ecommercespring.Exception;

public class ProductNotFoundException extends RuntimeException {
   
    public ProductNotFoundException(String message){
        super(message);
    }
}


//why extend runtime exception?

//marks it an unchecked exception. Callers are not forced to declare to declare or catch it.
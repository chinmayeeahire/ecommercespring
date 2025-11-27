package com.example.ecommercespring.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ecommercespring.gateway.api.FakeStoreProductApi;
import com.example.ecommercespring.gateway.api.FakestoreCategoryApi;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.Retrofit;

@Configuration
public class RetrofitConfig {
  @Bean
  public Retrofit retrofit(){
   return new Retrofit.Builder()
           .baseUrl("https://fakestoreapi.com/")
           .addConverterFactory(GsonConverterFactory.create())
           .build();
  }

  @Bean
  public FakestoreCategoryApi fakestoreCategoryApi(Retrofit retrofit){
    return retrofit.create(FakestoreCategoryApi.class);
  } //this method is now responsible for providing an object of fakestorecategoryapi
  

  @Bean
  public FakeStoreProductApi fakeStoreProductApi(Retrofit retrofit){
    return retrofit.create(FakeStoreProductApi.class);
  }
}

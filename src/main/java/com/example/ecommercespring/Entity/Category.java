package com.example.ecommercespring.Entity;

import java.util.List;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity{


    

    @Column(nullable = false, unique = true)
    private String name;
    
    //one category has many products
    //this does not mean that we are trying to store a list of products inside category table
    //Telling JPA that , the relationship is already owned by the product entity, so just read from there
    @OneToMany(mappedBy = "category", fetch=FetchType.LAZY)
    private List<Product> products;
    


}

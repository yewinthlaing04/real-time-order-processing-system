package com.ye.ecommerce.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;

    @OneToMany( mappedBy =  "category" , cascade = CascadeType.REMOVE)
    private List<Product> productList;

}

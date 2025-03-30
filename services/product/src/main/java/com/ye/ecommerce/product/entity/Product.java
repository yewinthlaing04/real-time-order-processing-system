package com.ye.ecommerce.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}

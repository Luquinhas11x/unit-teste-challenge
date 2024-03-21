package com.talent.unittestdemo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private final String id;
    private String name;
    private Double price;

    public Product(String id){
        this.id = id;

        validation();
    }

    private void validation() {
        if (id.isEmpty() || id.isBlank()) {
            throw new IllegalArgumentException("Product id is required");
        }
    }
}



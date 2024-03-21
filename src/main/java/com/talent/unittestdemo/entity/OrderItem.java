package com.talent.unittestdemo.entity;

import lombok.Getter;

@Getter
public class OrderItem {
    private final String id;
    private final String name;
    private final Double price;
    private final Product productId;
    private final Integer quantity;

    public OrderItem(String id, String name, Double price, Product productId, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productId = productId;
        this.quantity = quantity;

        validation();
    }

    public Double finalPrice(){
       return this.price * this.quantity;
    }

    private void validation() {
        if (id.isEmpty() || id.isBlank()) {
            throw new IllegalArgumentException("Order item id is required");
        }
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Order item name is required");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Order item price must be greater than zero");
        }
        if(quantity <= 0){
            throw new IllegalArgumentException("Product quantity must be greater than zero");
        }
    }
}

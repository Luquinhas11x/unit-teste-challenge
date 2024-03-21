package com.talent.unittestdemo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {
    private final String id;
    private final String customerId;
    private final List<OrderItem> items;
    private Double total;
    private Double totalAfterDiscount;

    public Order(String id, String customerId, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
        validation();
        total();
    }

    public Double total() {
        return this.total = items.stream().mapToDouble(orderItem -> orderItem.getPrice() * orderItem.getQuantity()).sum();
    }

    public Double calculateCustomerRewardPoints() {
        return total() * 0.10;
    }

    public void calculate25Percent(Double totalPrice) {
        if (total >= 200) {
            this.totalAfterDiscount = totalPrice * 0.75;
        } else {
            this.totalAfterDiscount = totalPrice;
//            throw new IllegalArgumentException("To have discount of 20%, the total order must be greater than 200");
        }
    }

    public String toString() {
        return String.format("Order %s for customer %s with total of $%s", id, customerId, total);
    }

    private void validation() {
        if (id.isEmpty() || id.isBlank()) {
            throw new IllegalArgumentException("Order id is required");
        }
        if (customerId.isEmpty() || customerId.isBlank()) {
            throw new IllegalArgumentException("Customer id is required");
        }
    }
}

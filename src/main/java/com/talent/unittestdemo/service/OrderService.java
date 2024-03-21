package com.talent.unittestdemo.service;

import com.talent.unittestdemo.entity.Customer;
import com.talent.unittestdemo.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    public static Double getTotal(List<Order> orders) {
        return orders.stream().mapToDouble(Order::getTotal).sum();
    }

    public static void incrementRewardPoints(Customer customer, Order order){
        customer.incrementRewardPoints(order.calculateCustomerRewardPoints());
    }

    public static void decrementRewardPoints(Customer customer, Order order){
        customer.decrementRewardPoints(order.calculateCustomerRewardPoints());
    }

}

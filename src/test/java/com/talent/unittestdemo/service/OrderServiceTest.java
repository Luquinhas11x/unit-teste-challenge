package com.talent.unittestdemo.service;

import com.talent.unittestdemo.entity.Customer;
import com.talent.unittestdemo.entity.Order;
import com.talent.unittestdemo.entity.OrderItem;
import com.talent.unittestdemo.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    //total price
    @Test
    public void shouldSumAllOrdersTotal_whenCallingGetTotal() {
        Product product = new Product("1");

        List<Order> orders = List.of(
                new Order("1", "1", List.of(
                        new OrderItem("1", "Product 1", 10.0, product, 1),
                        new OrderItem("2", "Product 2", 20.0, product, 2)
                )),
                new Order("2", "2", List.of(new OrderItem("1", "Product 1", 10.0, product, 1))),
                new Order("3", "3", List.of(
                        new OrderItem("1", "Product 1", 10.0, product, 1),
                        new OrderItem("10", "Product 10", 20.0, product, 2),
                        new OrderItem("11", "Product 11", 30.0, product, 3),
                        new OrderItem("12", "Product 12", 40.0, product, 4)
                ))
        );

        Double expectedTotalSum = 360.0;

        Double currentTotalSum = OrderService.getTotal(orders);

        assertEquals(expectedTotalSum, currentTotalSum);
    }

    //increment reward
    @Test
    public void shouldRewardTenPercentOfTheOrder_WhenCreatingAnOrder() {
        Customer customer = new Customer("1", "Lucas");

        Product product = new Product("1");
        Product product2 = new Product("2");

        List<OrderItem> items = List.of(
                new OrderItem("1", "Product 1", 10.0, product, 1),
                new OrderItem("2", "Product 2", 20.0, product2, 2)
        );

        List<OrderItem> items2 = List.of(
                new OrderItem("1", "Product 1", 10.0, product, 1),
                new OrderItem("2", "Product 2", 20.0, product2, 2),
                new OrderItem("2", "Product 2", 20.0, product2, 3)

        );

        Order order = new Order("1", "1", items);
        Order order2 = new Order("2", "1", items2);

        Double expectedCustomerRewardPoints = 16.0;

        OrderService.incrementRewardPoints(customer, order);
        OrderService.incrementRewardPoints(customer, order2);

        assertEquals(expectedCustomerRewardPoints, customer.getRewardPoints());
    }

    //decrement reward
    @Test
    public void shouldTakeTheLastRewardPointsFromTheOrder_WhenTakeTheOrderItemFromTheOrder() {
        Customer customer = new Customer("1", "Lucas");

        Product product = new Product("1");
        Product product2 = new Product("2");

        List<OrderItem> items = List.of(
                new OrderItem("1", "Product 1", 10.0, product, 1),
                new OrderItem("2", "Product 2", 20.0, product2, 2)
        );

        List<OrderItem> items2 = List.of(
                new OrderItem("1", "Product 1", 10.0, product, 1),
                new OrderItem("2", "Product 2", 20.0, product2, 2),
                new OrderItem("3", "Product 2", 20.0, product2, 3)

        );

        Order order = new Order("1", "1", items);
        Order order2 = new Order("2", "1", items2);

        Double expectedCustomerRewardPoints = 11.0;

        OrderService.incrementRewardPoints(customer, order);
        OrderService.incrementRewardPoints(customer, order2);

        OrderService.decrementRewardPoints(customer, order);

        assertEquals(expectedCustomerRewardPoints, customer.getRewardPoints());
    }
}

package com.talent.unittestdemo.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class OrderTest {
    private final Product product = new Product("1");
    private final Product product2 = new Product("2");
    private final Product product3 = new Product("3");

    private final List<OrderItem> items = List.of(
            new OrderItem("1", "Product 1", 10.0, product, 1),
            new OrderItem("2", "Product 2", 10.0, product2, 2),
            new OrderItem("3", "Product 3", 10.0, product3, 3)
    );

    //total price
    @Test
    public void shouldSumAllItemsPrice_whenCreatingAnOrder() {

        Order order = new Order("1", "1", items);
        Order order2 = new Order("2", "2", List.of(new OrderItem("1", "Product 1", 10.0, product, 1)));

        Double expectedPrice = 60.0;
        Double actualPrice = order.getTotal();

        Double expectedPrice2 = 10.0;
        Double actualPrice2 = order2.getTotal();

        assertEquals(expectedPrice, actualPrice);
        assertEquals(expectedPrice2, actualPrice2);
    }

    //validation
    @Test
    public void shouldThrowError_whenOrderIdIsEmpty() {

        String expectedMessage = "Order id is required";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Order("", "2", items);
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }


    @Test
    public void shouldThrowError_whenOrderIdIsBlank() {

        String expectedMessage = "Order id is required";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Order("  ", "1", items);
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_whenCustomerIdIsEmpty() {

        String expectedMessage = "Customer id is required";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Order("1", "", items);
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_whenCustomerIdIsBlank() {

        String expectedMessage = "Customer id is required";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Order("2", "", items);
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    //discount of 25% using TDD
    @Test
    public void shouldGive25PercentOfDiscount_WhenOrderGoesOver200() {
        Customer customer = new Customer("1", "Lucas");

        Product product = new Product("1");
        Product product2 = new Product("2");
        Product product3 = new Product("3");
        Product product4 = new Product("4");

        List<OrderItem> items = List.of(
                new OrderItem("1", "Product 1", 10.0, product, 1),
                new OrderItem("2", "Product 2", 20.0, product2, 2),
                new OrderItem("3", "Product 3", 30.0, product3, 3),
                new OrderItem("4", "Product 4", 40.0, product, 4)
        );

        Order order = new Order("1", "1", items);

        Double expectedTotalPriceAfterDiscount = 225.0;

        order.calculate25Percent(order.getTotal());

        assertEquals(expectedTotalPriceAfterDiscount, order.getTotalAfterDiscount());
    }

    @Test
    public void shouldKeepTheFinalPrice_WhenOrderIsLessThan200() {

        Customer customer = new Customer("1", "Lucas");

        Order order = new Order("1", "1", items);

        Double expectedTotalPriceAfterDiscount = 60.0;

        order.calculate25Percent(order.getTotal());

        assertEquals(expectedTotalPriceAfterDiscount, order.getTotalAfterDiscount());
    }
}

package com.talent.unittestdemo.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class OrderItemTest {

    private final Product product = new Product("1");

    //validation
    @Test
    public void shouldThrowError_whenOrderItemIdIsEmpty() {

        String expectedMessage = "Order item id is required";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem("", "Product 1", 10.0, product, 1);
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_whenOrderItemIdIsBlank() {

        String expectedMessage = "Order item id is required";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem("  ", "Product 1", 10.0, product, 1);
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_whenOrderItemNameIsEmpty() {

        String expectedMessage = "Order item name is required";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem("1", "", 10.0, product, 1);
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_whenOrderItemNameIsBlank() {

        String expectedMessage = "Order item name is required";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem("1", "  ", 10.0, product, 1);
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_WhenOrderItemPriceItIsLessThenZero(){

        String expectedMessage = "Order item price must be greater than zero";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem("1", "Product 1", -10.0, product, 1);
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_WhenOrderItemQuantityItIsLessThenZero(){

        String expectedMessage = "Product quantity must be greater than zero";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem("1", "Product 1", 10.0, product, 0);
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }
}

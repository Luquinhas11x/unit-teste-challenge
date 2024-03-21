package com.talent.unittestdemo.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ProductTest {

    private final String expectedMessage = "Product id is required";

    //validation
    @Test
    public void shouldThrowError_WhenProductIdIsEmpty(){

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Product("");
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_WhenProductIdIsBlank(){

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Product("  ");
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }
}


package com.talent.unittestdemo.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class AddressTest {

    //validation
    @Test
    public void shouldThrowError_WhenStreetNameIsEmpty() {
        String expectedMessage = "Street cannot be empty";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Address("", 1, "São Paulo", "São Paulo", "232132");
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_WhenStreetNameIsBlank() {
        String expectedMessage = "Street cannot be empty";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Address(" ", 1, "São Paulo", "São Paulo", "232132");
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_WhenCityNameIsEmpty() {
        String expectedMessage = "City cannot be empty";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Address("Rua 1", 1, "", "São Paulo", "232132");
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_WhenCityNameIsBlank() {
        String expectedMessage = "City cannot be empty";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Address("Rua 1", 1, "  ", "São Paulo", "232132");
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_WhenStateNameIsEmpty() {
        String expectedMessage = "State cannot be empty";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Address("Rua 1", 1, "São Paulo", "", "232132");
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_WhenStateNameIsBlank() {
        String expectedMessage = "State cannot be empty";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Address("Rua 1", 1, "São Paulo", "   ", "232132");
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_WhenAddressZipIsEmpty() {
        String expectedMessage = "Zip cannot be empty";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Address("Rua 1", 1, "São Paulo", "São Paulo", "");
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowError_WhenAddressZipIsBlank() {
        String expectedMessage = "Zip cannot be empty";

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            new Address("Rua 1", 1, "São Paulo", "São Paulo", "  ");
        });

        assertEquals(expectedMessage, actualException.getMessage());
    }
}

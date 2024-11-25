package org.CS5800.VendingMachine;

import static org.junit.jupiter.api.Assertions.*;
import com.CS5800.VendingMachine.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SnackTests {
    private Snack snack;

    @BeforeEach
    public void setUp() {
        snack = new Snack("Coke", 1.25, 10);
    }

    @Test
    public void testConstructor() {
        assertEquals("Coke", snack.getName());
        assertEquals(1.25, snack.getPrice(), 0.001);
        assertEquals(10, snack.getQuantity());
    }

    @Test
    public void testNameGetter() {
        assertEquals("Coke", snack.getName());
    }

    @Test
    public void testPriceGetter() {
        assertEquals(1.25, snack.getPrice(), 0.001);
    }

    @Test
    public void testQuantityGetter() {
        assertEquals(10, snack.getQuantity());
    }

    @Test
    public void testQuantitySetter() {
        snack.setQuantity(15);
        assertEquals(15, snack.getQuantity());
    }

    @Test
    public void testPriceSetter() {
        snack.setPrice(1.50);
        assertEquals(1.50, snack.getPrice(), 0.001);
    }
}


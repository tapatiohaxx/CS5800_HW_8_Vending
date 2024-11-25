package org.CS5800.VendingMachine;

import static org.junit.Assert.*;

import com.CS5800.VendingMachine.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTests {
    private VendingMachine machine;

    @BeforeEach
    void setUp() {
        machine = new VendingMachine();  // Assumes setupSnacks and setupHandlers are called within the constructor
    }

    @Test
    public void testSelectValidSnack() {
        machine.selectSnack("Coke");
        assertTrue(machine.getCurrentState() instanceof WaitingForMoneyState, "Machine should be in WaitingForMoneyState after valid snack selection");
    }

    @Test
    public void testSelectInvalidSnack() {
        machine.selectSnack("Water");
        assertTrue(machine.getCurrentState() instanceof IdleState, "Machine should stay in IdleState after invalid snack selection");
    }

    @Test
    public void testInsertCorrectAmount() {
        machine.selectSnack("Coke");
        machine.insertMoney(1.25);
        assertTrue(machine.getCurrentState() instanceof DispensingState, "Machine should transition to DispensingState after correct amount is inserted");
        assertEquals(9, machine.getSnacks().get("Coke").getQuantity(), "Snack quantity should decrease by one");
    }

    @Test
    public void testInsertInsufficientAmount() {
        machine.selectSnack("Coke");
        machine.insertMoney(1.00);
        assertTrue(machine.getCurrentState() instanceof WaitingForMoneyState, "Machine should remain in WaitingForMoneyState after insufficient amount is inserted");
    }

    @Test
    public void testOutOfStock() {
        machine.selectSnack("Snickers");
        // Simulate buying all Snickers
        for (int i = 0; i < 5; i++) {
            machine.insertMoney(1.50);
        }
        machine.selectSnack("Snickers");
        machine.insertMoney(1.50);
        assertTrue(machine.getCurrentState() instanceof IdleState, "Machine should return to IdleState when Snickers are out of stock");
        assertEquals(0, machine.getSnacks().get("Snickers").getQuantity(), "No Snickers should be left");
    }

    @Test
    public void testReturnToIdleState() {
        machine.selectSnack("Coke");
        machine.insertMoney(1.25);
        machine.getCurrentState().handleRequest();  
        assertTrue(machine.getCurrentState() instanceof IdleState, "Machine should return to IdleState after dispensing");
    }
}

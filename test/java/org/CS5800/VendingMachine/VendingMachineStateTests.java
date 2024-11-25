package org.CS5800.VendingMachine;

import static org.junit.jupiter.api.Assertions.*;

import com.CS5800.VendingMachine.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineStateTests {
    private VendingMachine machine;

    @BeforeEach
    public void setup() {
        machine = new VendingMachine();
    }

    @Test
    public void testIdleStateTransitionToWaitingForMoney() {
        machine.setCurrentState(new IdleState(machine));
        machine.selectSnack("Coke");
        assertTrue(machine.getCurrentState() instanceof WaitingForMoneyState);
    }

    @Test
    public void testWaitingForMoneyStateTransitionToDispensing() {
        machine.setCurrentState(new WaitingForMoneyState(machine));
        machine.selectSnack("Coke"); // Assuming selectSnack must be called to set up correct snack name
        machine.insertMoney(2.00); // Correct the syntax error, removed the comma after 2.00
        assertTrue(machine.getCurrentState() instanceof DispensingState);
    }

    @Test
    public void testDispensingStateTransitionToIdle() {
        machine.setCurrentState(new DispensingState(machine));
        machine.selectSnack("Coke"); // Ensure a snack is selected before inserting money
        machine.insertMoney(2.00); // Ensure the correct snack and amount
        assertTrue(machine.getCurrentState() instanceof IdleState);
    }

    @Test
    public void testIdleStateNoTransitionOnInvalidSelection() {
        machine.setCurrentState(new IdleState(machine));
        machine.selectSnack("InvalidSnack"); // Testing invalid snack selection
        assertTrue(machine.getCurrentState() instanceof IdleState);
    }

    @Test
    public void testDispensingStateHandlesEmptyStock() {
        machine.setCurrentState(new DispensingState(machine));
        machine.selectSnack("Coke");
        Snack coke = machine.getSnacks().get("Coke");
        coke.setQuantity(0);
        machine.insertMoney(2.00);
        assertTrue(machine.getCurrentState() instanceof IdleState);
    }
}


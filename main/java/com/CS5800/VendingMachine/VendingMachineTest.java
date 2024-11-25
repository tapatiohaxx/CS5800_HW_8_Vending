package com.CS5800.VendingMachine;

public class VendingMachineTest {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();  // Initialize the vending machine

        // Array of snacks to test
        String[] snacks = {"Coke", "Pepsi", "Cheetos", "Doritos", "KitKat", "Snickers"};

        // Test purchasing each snack with sufficient money
        for (String snack : snacks) {
            System.out.println("\n--- Testing selection of: " + snack + " ---");
            machine.selectSnack(snack);  // Selecting snack
            machine.insertMoney(2.00);   // Inserting more than enough money
            System.out.println("State after transaction: " + machine.getCurrentState().getClass().getSimpleName());
        }

        // Testing insufficient funds for a snack
        System.out.println("\n--- Testing insufficient funds for Coke ---");
        machine.selectSnack("Coke");
        machine.insertMoney(0.75);  // Not enough for Coke
        System.out.println("State after inserting insufficient funds: " + machine.getCurrentState().getClass().getSimpleName());

        // Testing purchasing Snickers until it is out of stock
        System.out.println("\n--- Testing purchasing Snickers until out of stock ---");
        while (machine.getSnacks().get("Snickers").getQuantity() > 0) {
            machine.selectSnack("Snickers");
            machine.insertMoney(2.00);
            System.out.println("Snickers stock left: " + machine.getSnacks().get("Snickers").getQuantity());
        }

        // Try to purchase Snickers one more time after stock is depleted
        System.out.println("\n--- Final test for Snickers out of stock scenario ---");
        machine.selectSnack("Snickers");
        machine.insertMoney(2.00);
        System.out.println("Final state: " + machine.getCurrentState().getClass().getSimpleName());
    }
}



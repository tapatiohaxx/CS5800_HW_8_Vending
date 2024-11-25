package com.CS5800.VendingMachine;

public class IdleState extends StateOfVendingMachine {
    public IdleState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void handleRequest() {
        System.out.println("Machine is idle. Please select a snack.");
    }
}


package com.CS5800.VendingMachine;

public class WaitingForMoneyState extends StateOfVendingMachine {
    public WaitingForMoneyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void handleRequest() {
        System.out.println("Waiting for money. Please insert the correct amount.");
    }
}


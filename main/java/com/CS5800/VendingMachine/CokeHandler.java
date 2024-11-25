package com.CS5800.VendingMachine;

public class CokeHandler extends SnackDispenseHandler {
    @Override
    public void dispense(Snack requestSnack) {
        if (requestSnack.getName().equalsIgnoreCase("Coke")) {
            System.out.println("Dispensing Coke");
        } else if (nextHandler != null) {
            nextHandler.dispense(requestSnack);
        }
    }
}


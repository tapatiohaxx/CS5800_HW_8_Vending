package com.CS5800.VendingMachine;

public class PepsiHandler extends SnackDispenseHandler {
    @Override
    public void dispense(Snack requestSnack) {
        if (requestSnack.getName().equalsIgnoreCase("Pepsi")) {
            System.out.println("Dispensing Pepsi");
        } else if (nextHandler != null) {
            nextHandler.dispense(requestSnack);
        }
    }
}

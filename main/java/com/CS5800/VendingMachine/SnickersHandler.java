package com.CS5800.VendingMachine;

public class SnickersHandler extends SnackDispenseHandler {
    @Override
    public void dispense(Snack requestSnack) {
        if (requestSnack.getName().equalsIgnoreCase("Snickers")) {
            System.out.println("Dispensing Snickers");
        } else if (nextHandler != null) {
            nextHandler.dispense(requestSnack);
        }
    }
}


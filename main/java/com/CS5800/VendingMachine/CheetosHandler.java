package com.CS5800.VendingMachine;

public class CheetosHandler extends SnackDispenseHandler {
    @Override
    public void dispense(Snack requestSnack) {
        if (requestSnack.getName().equalsIgnoreCase("Cheetos")) {
            System.out.println("Dispensing Cheetos");
        } else if (nextHandler != null) {
            nextHandler.dispense(requestSnack);
        }
    }
}


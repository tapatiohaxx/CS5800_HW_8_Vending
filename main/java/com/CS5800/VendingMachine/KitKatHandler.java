package com.CS5800.VendingMachine;

public class KitKatHandler extends SnackDispenseHandler {
    @Override
    public void dispense(Snack requestSnack) {
        if (requestSnack.getName().equalsIgnoreCase("KitKat")) {
            System.out.println("Dispensing KitKat");
        } else if (nextHandler != null) {
            nextHandler.dispense(requestSnack);
        }
    }
}


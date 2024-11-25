package com.CS5800.VendingMachine;

public class DoritosHandler extends SnackDispenseHandler {
    @Override
    public void dispense(Snack requestSnack) {
        if (requestSnack.getName().equalsIgnoreCase("Doritos")) {
            System.out.println("Dispensing Doritos");
        } else if (nextHandler != null) {
            nextHandler.dispense(requestSnack);
        }
    }
}

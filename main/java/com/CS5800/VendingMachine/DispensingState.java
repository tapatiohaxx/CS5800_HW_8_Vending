package com.CS5800.VendingMachine;

public class DispensingState extends StateOfVendingMachine {
    public DispensingState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void handleRequest() {
        Snack selectedSnack = vendingMachine.getSnacks().get(vendingMachine.getSelectedSnackName());
        if (selectedSnack != null && selectedSnack.getQuantity() > 0) {
            selectedSnack.setQuantity(selectedSnack.getQuantity() - 1);
            System.out.println("Dispensing: " + selectedSnack.getName());
        } else {
            System.out.println("Out of stock or snack not selected.");
        }
        vendingMachine.setCurrentState(new IdleState(vendingMachine));
    }
}

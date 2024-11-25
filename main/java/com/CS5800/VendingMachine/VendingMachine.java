package com.CS5800.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<String, Snack> snacks = new HashMap<>();
    private SnackDispenseHandler handlerChain;
    private StateOfVendingMachine currentState;
    private String selectedSnackName; // To keep track of the currently selected snack

    public VendingMachine() {
        setupSnacks();
        setupHandlers();
        currentState = new IdleState(this); // Vending machine starts in the Idle state
    }

    private void setupSnacks() {
        snacks.put("Coke", new Snack("Coke", 1.25, 10));
        snacks.put("Pepsi", new Snack("Pepsi", 1.20, 15));
        snacks.put("Cheetos", new Snack("Cheetos", 1.75, 20));
        snacks.put("Doritos", new Snack("Doritos", 1.50, 25));
        snacks.put("KitKat", new Snack("KitKat", 1.00, 30));
        snacks.put("Snickers", new Snack("Snickers", 1.50, 5)); // Limited stock for test case
    }

    private void setupHandlers() {
        SnackDispenseHandler coke = new CokeHandler();
        SnackDispenseHandler pepsi = new PepsiHandler();
        SnackDispenseHandler cheetos = new CheetosHandler();
        SnackDispenseHandler doritos = new DoritosHandler();
        SnackDispenseHandler kitkat = new KitKatHandler();
        SnackDispenseHandler snickers = new SnickersHandler();

        coke.setNextHandler(pepsi);
        pepsi.setNextHandler(cheetos);
        cheetos.setNextHandler(doritos);
        doritos.setNextHandler(kitkat);
        kitkat.setNextHandler(snickers);

        handlerChain = coke;
    }

    public void selectSnack(String snackName) {
        if (snacks.containsKey(snackName)) {
            selectedSnackName = snackName;
            System.out.println("Snack selected: " + snackName + ". Please insert money.");
            currentState = new WaitingForMoneyState(this);
        } else {
            System.out.println("Snack not available. Please select another snack.");
        }
    }

    public void insertMoney(double money) {
        Snack snack = snacks.get(selectedSnackName);
        if (snack != null && money >= snack.getPrice()) {
            if (snack.getQuantity() > 0) {
                snack.setQuantity(snack.getQuantity() - 1);
                System.out.println("Money accepted. Dispensing " + selectedSnackName);
                handlerChain.dispense(snack);
                currentState = new DispensingState(this);
            } else {
                System.out.println(selectedSnackName + " is out of stock.");
                currentState = new IdleState(this);
            }
        } else {
            System.out.println("Not enough money or snack not available. Money needed: $" + (snack != null ? snack.getPrice() : "N/A"));
            currentState = new WaitingForMoneyState(this);
        }
    }

    public StateOfVendingMachine getCurrentState() {
        return currentState;
    }

    public void setCurrentState(StateOfVendingMachine state) {
        this.currentState = state;
    }

    public Map<String, Snack> getSnacks() {
        return snacks;
    }

    public String getSelectedSnackName() {
        return selectedSnackName;
    }
}






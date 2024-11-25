package com.CS5800.VendingMachine;

public abstract class SnackDispenseHandler {
    protected SnackDispenseHandler nextHandler;

    /**
     * Sets the next handler in the chain of responsibility.
     *
     * @param nextHandler the next handler that will be responsible for handling the request if the current one cannot.
     */
    public void setNextHandler(SnackDispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * Attempts to dispense the specified snack. If this handler cannot dispense the snack,
     * it passes the request to the next handler in the chain.
     *
     * @param requestSnack the snack requested by the user.
     */
    public abstract void dispense(Snack requestSnack);
}

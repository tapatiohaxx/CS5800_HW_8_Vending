package org.CS5800.VendingMachine;

import static org.junit.jupiter.api.Assertions.*;

import com.CS5800.VendingMachine.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SnackDispenseHandlerTests {
    private SnackDispenseHandler cokeHandler, pepsiHandler, cheetosHandler, doritosHandler, kitkatHandler, snickersHandler;

    @BeforeEach
    public void setup() {
        cokeHandler = new CokeHandler();
        pepsiHandler = new PepsiHandler();
        cheetosHandler = new CheetosHandler();
        doritosHandler = new DoritosHandler();
        kitkatHandler = new KitKatHandler();
        snickersHandler = new SnickersHandler();

        cokeHandler.setNextHandler(pepsiHandler);
        pepsiHandler.setNextHandler(cheetosHandler);
        cheetosHandler.setNextHandler(doritosHandler);
        doritosHandler.setNextHandler(kitkatHandler);
        kitkatHandler.setNextHandler(snickersHandler);
    }

    @Test
    public void testCokeHandler() {
        Snack coke = new Snack("Coke", 1.25, 10);
        assertDoesNotThrow(() -> cokeHandler.dispense(coke));
    }

    @Test
    public void testCokeHandlerPassesToNext() {
        Snack notCoke = new Snack("Pepsi", 1.20, 10);
        assertDoesNotThrow(() -> cokeHandler.dispense(notCoke));
    }

    @Test
    public void testPepsiHandler() {
        Snack pepsi = new Snack("Pepsi", 1.20, 10);
        assertDoesNotThrow(() -> pepsiHandler.dispense(pepsi));
    }

    @Test
    public void testCheetosHandler() {
        Snack cheetos = new Snack("Cheetos", 1.75, 20);
        assertDoesNotThrow(() -> cheetosHandler.dispense(cheetos));
    }

    @Test
    public void testDoritosHandler() {
        Snack doritos = new Snack("Doritos", 1.50, 25);
        assertDoesNotThrow(() -> doritosHandler.dispense(doritos));
    }

    @Test
    public void testKitKatHandler() {
        Snack kitkat = new Snack("KitKat", 1.00, 30);
        assertDoesNotThrow(() -> kitkatHandler.dispense(kitkat));
    }

    @Test
    public void testSnickersHandler() {
        Snack snickers = new Snack("Snickers", 1.50, 5);
        assertDoesNotThrow(() -> snickersHandler.dispense(snickers));
    }
}


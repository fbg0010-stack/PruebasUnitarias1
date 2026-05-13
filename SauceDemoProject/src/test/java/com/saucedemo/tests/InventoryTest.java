package com.saucedemo.tests;

import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest extends BaseTest {

    @Test
    public void anadirUnProductoAlCarrito() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();

        assertEquals(1, inventoryPage.getCartCount(), "El carrito debería tener 1 producto");
    }

    @Test
    public void anadirDosProductosAlCarrito() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.addBikeLightToCart();

        assertEquals(2, inventoryPage.getCartCount(), "El carrito debería tener 2 productos");
    }

    @Test
    public void botonCambiaTrasAnadirProducto() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();

        String textoBoton = inventoryPage.getButtonText();
        assertEquals("Remove", textoBoton, "El texto del botón no ha cambiado a 'Remove'");
    }
}

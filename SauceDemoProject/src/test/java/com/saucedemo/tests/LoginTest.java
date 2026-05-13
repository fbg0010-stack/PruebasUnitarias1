package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginCorrecto() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        
        assertTrue(driver.getCurrentUrl().contains("inventory"), "La URL no contiene 'inventory'");
    }

    @Test
    public void loginIncorrecto() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");
        
        String error = loginPage.getErrorMessage();
        assertTrue(error.contains("Username and password do not match"), "El mensaje de error no es correcto");
    }
}

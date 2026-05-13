package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

/**
 * CLASE SUCIA (CON CODE SMELLS)
 * Este es el estado inicial del proyecto antes del refactoring.
 */
public class SauceDemoAutomation {

    public static WebDriver driver;

    // SMELL: Magic Strings (URL hardcoded)
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // SMELL: Long Method (hace todo el login y compra en uno solo)
        ejecutarTodo();
    }

    public static void ejecutarTodo() {
        driver.get("https://www.saucedemo.com/");

        // Login
        // SMELL: Nombres de variables poco descriptivos
        String u = "standard_user";
        String p = "secret_sauce";
        
        driver.findElement(By.id("user-name")).sendKeys(u);
        driver.findElement(By.id("password")).sendKeys(p);
        driver.findElement(By.id("login-button")).click();

        // SMELL: Duplicate Code (Locators repetidos)
        if (driver.getCurrentUrl().contains("inventory")) {
            System.out.println("Login ok");
        }

        // Seleccionar productos usando un Switch (SMELL: Switch Statements)
        String producto = "backpack";
        switch (producto) {
            case "backpack":
                driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
                break;
            case "bike":
                driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
                break;
            default:
                System.out.println("No hay producto");
        }

        // SMELL: Dead Code (Metodo que no se usa)
        metodoInutil();

        // SMELL: Duplicate Code (Otra vez el mismo locator)
        driver.findElement(By.className("shopping_cart_link")).click();
        
        if (driver.findElement(By.className("inventory_item_name")).getText().equals("Sauce Labs Backpack")) {
            System.out.println("Producto en carrito");
        }

        driver.quit();
    }

    public static void metodoInutil() {
        System.out.println("Esto no sirve para nada");
    }
}

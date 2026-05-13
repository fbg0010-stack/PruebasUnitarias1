package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Refactored InventoryPage using POM.
 * Solutions: Removed Switch Statements, added clear naming.
 */
public class InventoryPage {
    private WebDriver driver;

    // Locators
    private By cartBadge = By.className("shopping_cart_badge");
    private By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
    private By bikeLightAddButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By backpackRemoveButton = By.id("remove-sauce-labs-backpack");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpackToCart() {
        driver.findElement(backpackAddButton).click();
    }

    public void addBikeLightToCart() {
        driver.findElement(bikeLightAddButton).click();
    }

    public int getCartCount() {
        String countText = driver.findElement(cartBadge).getText();
        return Integer.parseInt(countText);
    }

    public boolean isRemoveButtonDisplayed() {
        return driver.findElement(backpackRemoveButton).isDisplayed();
    }

    public String getButtonText() {
        return driver.findElement(backpackRemoveButton).getText();
    }
}

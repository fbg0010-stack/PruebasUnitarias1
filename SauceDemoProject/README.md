# SauceDemo Automation: Clean Code & Refactoring Cycle 🚀

This project demonstrates a professional automation workflow using Selenium WebDriver and JUnit 5. It follows the "Clean Code" principles, showing the evolution from a legacy-style "Dirty Code" implementation to a structured, maintainable architecture using the Page Object Model (POM).

## 🎯 Project Objective
The goal is to automate the core business flow of [SauceDemo](https://www.saucedemo.com/):
1. User Login.
2. Product Selection.
3. Cart Validation.
4. Professional Refactoring and Code Smell elimination.

## 🛠️ Technical Stack
- **IDE**: IntelliJ IDEA
- **Automation**: Selenium WebDriver
- **Testing Framework**: JUnit 5
- **Pattern**: Page Object Model (POM)
- **Language**: Java

## 🧪 Code Smell Analysis & Solutions

We identified and fixed the following **10 Code Smells**:

1. **Long Method**: The initial `ejecutarTodo()` was split into small, focused methods within Page Objects.
2. **Large Class**: Logic was separated into `LoginPage`, `InventoryPage`, and Test classes.
3. **Duplicate Code**: Locators and common actions were centralized in Page Objects.
4. **Dead Code**: Removed unused helper methods and legacy prints.
5. **Switch Statements**: Replaced conditional product selection with direct method calls.
6. **Magic Strings**: Constants and URLs were extracted to a configuration layer.
7. **Poor Naming**: Renamed variables like `u` and `p` to `username` and `password`.
8. **Feature Envy**: Moved browser interactions from the Test classes to the Page Objects.
9. **Primitive Obsession**: Encapsulated state and navigation logic.
10. **Global Data**: Removed `static` WebDriver to ensure thread safety and better lifecycle management.

## 📁 Repository Structure
- `src/main/java/com/saucedemo/pages`: Contains Page Object classes.
- `src/test/java/com/saucedemo/tests`: Contains JUnit 5 test cases.
- `SauceDemoAutomation.java`: The original "Dirty Code" version for comparison.

## 🚀 How to Run
1. Ensure you have the Chrome browser installed.
2. Open the project in IntelliJ IDEA.
3. Run the tests located in `src/test/java/com/saucedemo/tests`.

---
*Created as a Final Project for the Automation and Clean Code Module.*

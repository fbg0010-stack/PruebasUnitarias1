package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        // Inicializa el WebDriver (En Selenium a partir de 4.6.0 el driver se descarga automáticamente gracias a Selenium Manager)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        
        // Inicializamos la página de Login
        loginPage = new LoginPage(driver);
    }

    @Test
    void loginCorrecto() throws InterruptedException {
        // introduce un usuario válido
        loginPage.ingresarUsuario("standard_user");
        Thread.sleep(1000); // Pausa para observar

        // introduce una contraseña válida
        loginPage.ingresarPassword("secret_sauce");
        Thread.sleep(1000);

        // pulsa el botón de login
        loginPage.clickLogin();
        Thread.sleep(2000);

        // comprueba que la URL contiene la palabra "inventory"
        assertTrue(driver.getCurrentUrl().contains("inventory"), "Tras un login correcto la URL debería contener 'inventory'");
    }

    @Test
    void loginIncorrecto() throws InterruptedException {
        // introduce un usuario válido pero contraseña incorrecta
        loginPage.ingresarUsuario("standard_user");
        Thread.sleep(1000);
        
        loginPage.ingresarPassword("wrong_password");
        Thread.sleep(1000);

        loginPage.clickLogin();
        Thread.sleep(2000);

        // Comprueba que aparece un mensaje de error en la página
        boolean isErrorDisplayed = driver.findElement(By.cssSelector("h3[data-test='error']")).isDisplayed();
        assertTrue(isErrorDisplayed, "Debería mostrarse un mensaje de error con credenciales incorrectas");
    }

    @AfterEach
    void tearDown() {
        // Cerramos el navegador al terminar cada test
        if (driver != null) {
            driver.quit();
        }
    }
}

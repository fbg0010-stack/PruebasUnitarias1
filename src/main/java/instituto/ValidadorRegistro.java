package instituto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidadorRegistroTest {

    // Traemos el "motor" que vamos a probar desde la carpeta main
    ValidadorRegistro validador = new ValidadorRegistro();

    @Test
    @DisplayName("Ejemplo: Un nombre válido debe ser aceptado")
    public void testNombreValido() {
        // Ejecutamos la lógica con un nombre correcto
        boolean resultado = validador.validarNombre("Carlos");
        
        // Sentenciamos: Como el nombre está bien, esperamos que el resultado sea TRUE
        assertTrue(resultado, "Error: El sistema rechazó un nombre válido");
    }

    // Reto 1: Nombre vacío
    @Test
    @DisplayName("Reto 1: El nombre vacío debe ser rechazado")
    public void testNombreVacio() {
        boolean resultado = validador.validarNombre("");
        assertFalse(resultado, "Error: El sistema aceptó un nombre vacío");
    }

    // Reto 2: Password justa (8 caracteres)
    @Test
    @DisplayName("Reto 2: Una contraseña de exactamente 8 caracteres debe ser aceptada")
    public void testPasswordJusta() {
        boolean resultado = validador.validarPassword("12345678");
        assertTrue(resultado, "Error: El sistema rechazó una contraseña de 8 caracteres");
    }

    // Reto 3: Password corta (5 caracteres)
    @Test
    @DisplayName("Reto 3: Una contraseña corta debe ser rechazada")
    public void testPasswordCorta() {
        boolean resultado = validador.validarPassword("Admin");
        assertFalse(resultado, "Error: El sistema aceptó una contraseña demasiado corta");
    }

    // Reto 4: Email sin arroba
    @Test
    @DisplayName("Reto 4: Un email sin arroba debe ser rechazado")
    public void testEmailSinArroba() {
        boolean resultado = validador.validarEmail("usuario.gmail.com");
        assertFalse(resultado, "Error: El sistema aceptó un email sin símbolo '@'");
    }

    // Reto 5: Edad límite (16 años)
    @Test
    @DisplayName("Reto 5: La edad mínima (16 años) debe ser aceptada")
    public void testEdadLimite() {
        boolean resultado = validador.validarEdad(16);
        assertTrue(resultado, "Error: El sistema rechazó la edad mínima legal (16 años)");
    }
}

package JennieID;

import Controlador.ControBibliote;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Punto de entrada del programa.
 */
public class Main {
    public static void main(String[] args) {
        // Hace que la consola entienda emojis y símbolos especiales (UTF-8)
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        ControBibliote controlador = new ControBibliote();
        controlador.iniciar(); // arranca el menú
    }
}

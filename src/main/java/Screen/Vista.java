package Screen;

import java.util.Scanner;

public class Vista {
    private static final String RESET    = "\u001B[0m";        // guarda el plumón
    private static final String NEGRITA  = "\u001B[1m";
    private static final String ROSA     = "\u001B[38;5;213m";
    private static final String MORADO   = "\u001B[38;5;141m";
    private static final String CIAN     = "\u001B[38;5;51m";
    private static final String VERDE    = "\u001B[38;5;120m";
    private static final String ROJO     = "\u001B[38;5;203m";
    private static final String AMARILLO = "\u001B[38;5;227m";

    // Scanner: la "oreja" que escucha lo que escribes en el teclado
    private Scanner teclado = new Scanner(System.in);

    // ===== EFECTOS ESPECIALES =====

    /** Pausa el programa unos milisegundos (para los efectos). */
    private void pausa(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /** Escribe el texto letra por letra, como si alguien lo tecleara. */
    private void escribirLento(String texto, int milisegundos) {
        for (char letra : texto.toCharArray()) {
            System.out.print(letra);
            System.out.flush();      // fuerza a mostrar la letra al instante
            pausa(milisegundos);
        }
        System.out.println();
    }

    /** Animación de "cargando" con puntitos. */
    public void cargando(String mensaje) {
        System.out.print(MORADO + mensaje + RESET);
        for (int i = 0; i < 3; i++) {
            pausa(250);
            System.out.print(ROSA + " ●" + RESET);
        }
        System.out.println();
    }

    // ===== PANTALLAS =====

    /** Pantalla de bienvenida. */
    public void mostrarBienvenida() {
        System.out.println();
        System.out.println(MORADO + RESET + AMARILLO + NEGRITA + "      BIBLIOTECA  \"EL SABER\"      " + RESET);
        System.out.print(AMARILLO);
        System.out.print(RESET);
        cargando("   Preparando los estantes");
    }

    /** Muestra el menú y devuelve la opción elegida (-1 si no es número). */
    public int mostrarMenu() {
        System.out.println();
        System.out.println(MORADO + RESET + ROSA + NEGRITA + "MENÚ PRINCIPAL" + RESET);
        System.out.println(MORADO +  RESET + CIAN + "SECCIÓN A · Libros Nuevos" + RESET);
        opcion("1", "Agregar libro nuevo");//es el menu, en numero ponemos el numero alque equivale y pues el text de a lado
        opcion("2", "Mostrar libros (orden de llegada)");
        opcion("3", "Buscar libro por código");
        opcion("4", "Eliminar el último agregado");
        System.out.println(MORADO + RESET);
        opcion("0", "Salir");
        System.out.print(MORADO + RESET + AMARILLO + "Elige tu opción: " + RESET);

        try {
            return Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1; // no escribió un número válido
        }
    }

    /** Dibuja una línea del menú, por ejemplo:  [1] Agregar libro */
    private void opcion(String numero, String texto) {
        System.out.println(MORADO +  RESET + AMARILLO + "[" + numero + "]" + RESET + " " + texto);
    }

    // ===== ENTRADA Y MENSAJES =====

    /** Hace una pregunta y devuelve lo que la persona escribió. */
    public String pedirTexto(String mensaje) {
        System.out.print(ROSA + "  -> " + RESET + mensaje);
        return teclado.nextLine().trim();
    }

    /** Mensaje de éxito (verde con palomita). */
    public void mostrarExito(String mensaje) {
        System.out.println(VERDE + NEGRITA + "  ✔ " + mensaje + RESET);
    }

    /** Mensaje de error (rojo con tache). */
    public void mostrarError(String mensaje) {
        System.out.println(ROJO + NEGRITA + "  ✘ " + mensaje + RESET);
    }

    /** Mensaje informativo (cian). */
    public void mostrarInfo(String mensaje) {
        System.out.println(CIAN + "  ℹ " + mensaje + RESET);
    }

    /** Muestra una lista de libros como tarjetitas, una por línea. */
    public void mostrarLista(String titulo, String contenido) {
        System.out.println();
        System.out.println( NEGRITA + titulo + RESET);
        for (String linea : contenido.split("\n")) {
            if (!linea.isBlank()) {
                System.out.println( RESET +linea);
            }
        }
    }

    /** Despedida. */
    public void mostrarDespedida() {
        System.out.println();
        System.out.print(MORADO + NEGRITA);
        escribirLento("  ¡Gracias por visitarnos", 30);//se muestra en una cantidad de 30 milisegundos
        System.out.print(RESET);
    }
}


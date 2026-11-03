package ModeloLog;

public class ListaSimple {

    private static final int MAXIMO = 20; // el tren solo aguanta 20 vagones
    private Nodo cabeza;                  // la locomotora (primer vagón)
    private int tamanio;                  // cuántos vagones hay

    // Al inicio el tren está vacío
    public ListaSimple() {
        cabeza = null;
        tamanio = 0;
    }

    /**
     * Agrega un libro al final de la lista.
     * Devuelve true si se pudo, false si ya está llena.
     */
    public boolean agregar(Libro libro) {
        // Si ya hay 20, no cabe otro
        if (tamanio >= MAXIMO) {
            return false;
        }

        Nodo nuevo = new Nodo(libro); // fabricamos el vagón nuevo

        if (cabeza == null) {
            cabeza = nuevo; // tren vacío: el vagón nuevo es la locomotora
        } else {
            // Caminamos desde la locomotora hasta el último vagón
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo); // enganchamos el vagón al final
        }

        tamanio++; // ahora hay un vagón más
        return true;
    }

    /**
     * Devuelve todos los libros en orden de llegada, como texto.
     */
    public String listar() {
        if (cabeza == null) {
            return "No hay libros nuevos.";
        }

        StringBuilder texto = new StringBuilder();
        Nodo actual = cabeza; // empezamos en la locomotora
        while (actual != null) {
            texto.append(actual.getLibro()).append("\n"); // anotamos el libro
            actual = actual.getSiguiente();               // pasamos al siguiente vagón
        }
        return texto.toString();
    }

    /**
     * Busca un libro por su código.
     * Devuelve el libro, o null si no existe.
     */
    public Libro buscarPorCodigo(String codigo) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getLibro().getCodigo().equals(codigo)) {
                return actual.getLibro(); // ¡encontrado!
            }
            actual = actual.getSiguiente();
        }
        return null; // revisamos todo el tren y no estaba
    }

    /**
     * Elimina el último libro agregado (LIFO) y lo devuelve.
     * Devuelve null si la lista estaba vacía.
     */
    public Libro eliminarUltimo() {
        if (cabeza == null) {
            return null; // no hay nada que quitar
        }

        Libro eliminado;

        if (cabeza.getSiguiente() == null) {
            // Solo hay un vagón: lo quitamos y el tren queda vacío
            eliminado = cabeza.getLibro();
            cabeza = null;
        } else {
            // Caminamos hasta el PENÚLTIMO vagón
            Nodo actual = cabeza;
            while (actual.getSiguiente().getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            eliminado = actual.getSiguiente().getLibro();
            actual.setSiguiente(null); // soltamos el último vagón
        }

        tamanio--; // ahora hay un vagón menos
        return eliminado;
    }

    public int getTamanio() { return tamanio; }
}

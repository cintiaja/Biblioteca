package ModeloLog;

public class Nodo {

    private Libro libro;      // el libro que viaja en este vagón
    private Nodo siguiente;   // el gancho hacia el siguiente vagón (null = no hay)

    // Al crear un vagón, solo sabe qué libro lleva
    public Nodo(Libro libro) {
        this.libro = libro;
        this.siguiente = null; // todavía no tiene vagón detrás
    }

    public Libro getLibro() { return libro; }
    public Nodo getSiguiente() { return siguiente; }

    // "Engancha" otro vagón detrás de este
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

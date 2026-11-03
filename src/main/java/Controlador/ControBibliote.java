package Controlador;

import ModeloLog.Libro;
import ModeloLog.ListaSimple;
import Screen.Vista;

public class ControBibliote {
    private ListaSimple librosNuevos; // el tren de la Sección A
    private Vista vista;       // la ventanilla

    public ControBibliote() {
        librosNuevos = new ListaSimple();
        vista = new Vista();
    }

    public void iniciar() {
        vista.mostrarBienvenida();//esto hace como blucle repite todo hasta que el usuario ponga sair

        int opcion;
        do {
            opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    eliminarUltimo();
                    break;
                case 0:
                    vista.mostrarDespedida();
                    break;
                default:
                    vista.mostrarError("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 0);
    }

    // Pide los datos, crea el libro y lo agrega a la lista
    private void agregarLibro() {
        String codigo = vista.pedirTexto("Código: ");
        String titulo = vista.pedirTexto("Título: ");
        String autor  = vista.pedirTexto("Autor: ");

        Libro libro = new Libro(codigo, titulo, autor);

        if (librosNuevos.agregar(libro)) {
            vista.cargando("  Guardando en el estante");//un mensaje que carga
            vista.mostrarExito("Libro agregado correctamente.");
        } else {
            vista.mostrarError("La lista está llena (máximo 20 libros).");//conectamos todo
        }
    }

    // Muestra todos los libros en orden de llegada
    private void mostrarLibros() {
        if (librosNuevos.getTamanio() == 0) {
            vista.mostrarError("Todavía no hay libros nuevos.");
        } else {
            vista.mostrarLista("LIBROS NUEVOS", librosNuevos.listar());
        }
    }

    // Pide un código y busca el libro
    private void buscarLibro() {
        String codigo = vista.pedirTexto("Código a buscar: ");
        vista.cargando("  Buscando");
        Libro encontrado = librosNuevos.buscarPorCodigo(codigo);

        if (encontrado != null) {
            vista.mostrarExito("Encontrado: " + encontrado);
        } else {
            vista.mostrarError("No existe un libro con ese código.");
        }
    }

    // Elimina el último libro agregado
    private void eliminarUltimo() {
        Libro eliminado = librosNuevos.eliminarUltimo();

        if (eliminado != null) {
            vista.mostrarExito("Se eliminó: " + eliminado);
        } else {
            vista.mostrarError("No hay libros para eliminar.");
        }
    }
}


package ModeloLog;

public class Libro {

    private String codigo;// privados: solo la propia clase los toca directo
    private String titulo;
    private String autor;

    // Constructor: se abre o usa cuando creamos un libro nuevo
    public Libro(String codigo, String titulo, String autor) {
        this.codigo = codigo;//el codigo de esta tarjeta (this) sera el codigo que me dieron
        this.titulo = titulo;
        this.autor = autor;
    }

    // Getters: permiten "preguntar" los datos desde afuera
    public String getCodigo() { return codigo; }//es como una funcion, en donde le dices que enviara algo asi como
    //un texto o buno cadena, que lo acabes ahi y sigas
    public String getTitulo() { return titulo; }
    public String getAutor()  { return autor; }

    // Define cómo se imprime el libro en pantalla
    @Override
    public String toString() {//es la funcion que muestra en la pnatalla el libro
        return "[" + codigo + "] " + titulo + " - " + autor;
    }
}
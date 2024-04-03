package Biblioteca;
import java.util.ArrayList;
import java.util.List;

import Libro.Libro;

public class Biblioteca {
    private List<Libro> librosDisponibles;
    private List<Libro> librosPrestados;

    public Biblioteca() {
        this.librosDisponibles = new ArrayList<>();
        this.librosPrestados = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        librosDisponibles.add(libro);
    }

    public void prestarLibro(Libro libro) {
        librosDisponibles.remove(libro);
        librosPrestados.add(libro);
    }

    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
        librosDisponibles.add(libro);
    }

    public void mostrarCatalogo() {
        System.out.println("Catálogo de la biblioteca:");
        for (Libro libro : librosDisponibles) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " (" + libro.getAnioPublicacion() + ")");
        }
    }

    public void mostrarLibrosPrestados() {
        System.out.println("Libros prestados actualmente:");
        for (Libro libro : librosPrestados) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " (" + libro.getAnioPublicacion() + ")");
        }
    }
    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }
    public List<Libro> getLibrosDisponibles() {
        return librosDisponibles;
    }
}

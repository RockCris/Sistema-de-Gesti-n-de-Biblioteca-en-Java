import java.util.Scanner;

import Biblioteca.Biblioteca;
import Libro.Libro;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");

        int opcion;
        do {
            System.out.println("\n1. Agregar Nuevo Libro");
            System.out.println("2. Prestar Libro");
            System.out.println("3. Devolver Libro");
            System.out.println("4. Mostrar Catálogo");
            System.out.println("5. Mostrar Libros Prestados");
            System.out.println("6. Salir");
            System.out.print("\nPor favor, seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese el título del libro: ");
                    String titulo = scanner.nextLine(); 
                    titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación del libro: ");
                    int anioPublicacion = scanner.nextInt();
                    biblioteca.agregarLibro(new Libro(titulo, autor, anioPublicacion));
                    System.out.println("\nLibro agregado al catálogo.");
                    break;
                    case 2:
                    System.out.print("\nIngrese el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine(); 
                    nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese el identificador del usuario: ");
                    int identificadorUsuario = scanner.nextInt();
                    System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloPrestamo = scanner.nextLine(); 
                    tituloPrestamo = scanner.nextLine();
                
                    // Buscar el libro en la lista de libros disponibles
                    Libro libroAPrestar = null;
                    for (Libro libro : biblioteca.getLibrosDisponibles()) {
                        if (libro.getTitulo().equalsIgnoreCase(tituloPrestamo)) {
                            libroAPrestar = libro;
                            break;
                        }
                    }
                
                    if (libroAPrestar != null) {
                        // Mover el libro de la lista de libros disponibles a la lista de libros prestados
                        biblioteca.prestarLibro(libroAPrestar);
                        System.out.println("\nLibro prestado correctamente a " + nombreUsuario + ".");
                    } else {
                        System.out.println("\nEl libro no está disponible para préstamo.");
                    }
                    break;
                    case 3:
                    System.out.print("\nIngrese el título del libro a devolver: ");
                    String tituloDevolucion = scanner.nextLine();
                    tituloDevolucion = scanner.nextLine();
                
                    // Buscar el libro en la lista de libros prestados
                    Libro libroADevolver = null;
                    for (Libro libro : biblioteca.getLibrosPrestados()) {
                        if (libro.getTitulo().equalsIgnoreCase(tituloDevolucion)) {
                            libroADevolver = libro;
                            break;
                        }
                    }
                
                    if (libroADevolver != null) {
                        // Mover el libro de la lista de libros prestados a la lista de libros disponibles
                        biblioteca.devolverLibro(libroADevolver);
                        System.out.println("\nLibro devuelto correctamente.");
                    } else {
                        System.out.println("\nEl libro no fue prestado previamente o no está en la lista de libros prestados.");
                    }
                    break;
                case 4:
                    biblioteca.mostrarCatalogo();
                    break;
                case 5:
                    biblioteca.mostrarLibrosPrestados();
                    break;
                case 6:
                    System.out.println("Saliendo del Sistema de Gestión de Biblioteca.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 6);
        scanner.close();
    }
}

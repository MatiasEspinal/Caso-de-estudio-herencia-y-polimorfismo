public class Main {
    public static void main(String[] args) {
        Biblioteca biblio = new Biblioteca();

        // Creamos usuarios usando las subclases
        Estudiante matias = new Estudiante("Matías Espinal", "1001", "Desarrollo de Software");
        Profesor santiago = new Profesor("Prof. Santiago", "2001", "Ingeniería");

        // Creamos materiales usando las subclases
        Libro libro1 = new Libro("Java Básico", "Autor X", "Tecnología");
        Libro libro2 = new Libro("Bases de Datos", "Autor Y", "Tecnología");
        Libro libro3 = new Libro("Redes", "Autor Z", "Tecnología");
        Libro libro4 = new Libro("Seguridad", "Autor W", "Tecnología");
        Revista revista1 = new Revista("Tech Monthly", "Varios", 45);

        System.out.println("--- PRUEBA ESTUDIANTE (Límite 3, Libros 30 días, Revistas 10 días) ---");
        biblio.registrarPrestamo(matias, libro1);
        biblio.registrarPrestamo(matias, libro2);
        biblio.registrarPrestamo(matias, revista1);
        biblio.registrarPrestamo(matias, libro4); // Debe dar error por pasar de 3

        System.out.println("\n--- PRUEBA PROFESOR (Límite 5) ---");
        biblio.registrarPrestamo(santiago, libro3); // Dejará prestarlo sin problema
    }
}
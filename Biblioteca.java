import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<MaterialBibliografico> catalogo;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void agregarMaterial(MaterialBibliografico m) { catalogo.add(m); }
    public void agregarUsuario(Usuario u) { usuarios.add(u); }

    public void registrarPrestamo(Usuario usuario, MaterialBibliografico material) {
        if (material.getEstado() == EstadoLibro.PRESTADO) {
            System.out.println("Error: '" + material.getTitulo() + "' ya está prestado.");
            return;
        }

        long activos = prestamos.stream().filter(p -> p.getUsuario().equals(usuario)).count();

        // ¡MAGIA DEL POLIMORFISMO! Verifica el límite (3 para Estudiante, 5 para Profesor)
        if (activos >= usuario.getLimitePrestamos()) {
            System.out.println("Error: " + usuario.getNombre() + " superó su límite de " + usuario.getLimitePrestamos() + " préstamos.");
            return;
        }

        Prestamo nuevo = new Prestamo(usuario, material);
        prestamos.add(nuevo);
        material.setEstado(EstadoLibro.PRESTADO);
        System.out.println("Éxito: '" + material.getTitulo() + "' prestado a " + usuario.getNombre() + ". Devolver antes de: " + nuevo.getFechaMaximaDevolucion());
    }
}
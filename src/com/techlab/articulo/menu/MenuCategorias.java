package com.techlab.articulo.menu;

import java.util.Scanner;
import com.techlab.articulo.Repositorio;
import com.techlab.articulo.Categoria;
import com.techlab.articulo.Articulo;

public class MenuCategorias extends Menu {
    private Scanner scanner;
    private Repositorio<Categoria> repoCategorias;
    private Repositorio<Articulo> repoArticulos;

    public MenuCategorias(Scanner scanner, Repositorio<Categoria> repoCategorias, Repositorio<Articulo> repoArticulos) {
        this.scanner = scanner;
        this.repoCategorias = repoCategorias;
        this.repoArticulos = repoArticulos;
    }

    @Override
    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ DE CATEGORÍAS ===");
            System.out.println("1. Crear categoría");
            System.out.println("2. Listar categorías");
            System.out.println("3. Eliminar categoría");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("❌ Ingresa un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearCategoria();
                    break;
                case 2:
                    listarCategorias();
                    break;
                case 3:
                    eliminarCategoria();
                    break;
                case 0:
                    System.out.println("↩ Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void crearCategoria() {
        System.out.print("Nombre de la categoría: ");
        String nombre = scanner.next();
        Categoria categoria = new Categoria(nombre);
        repoCategorias.agregar(categoria);
        System.out.println("✅ Categoría creada con éxito.");
    }

    private void listarCategorias() {
        for (Categoria c : repoCategorias.obtenerTodos()) {
            System.out.println(c);
        }
    }

    private void eliminarCategoria() {
        System.out.print("Código de la categoría a eliminar: ");
        int codigo = scanner.nextInt();

        // Regla de negocio: no eliminar si tiene artículos asociados
        boolean tieneArticulos = repoArticulos.obtenerTodos()
                .stream()
                .anyMatch(a -> a.getCategoria().getCodigo() == codigo);

        if (tieneArticulos) {
            System.out.println("❌ No se puede eliminar: tiene artículos asociados.");
            return;
        }

        repoCategorias.eliminar(codigo);
        System.out.println("✅ Categoría eliminada.");
    }
}

package com.techlab.articulo.menu;

import java.util.Scanner;
import com.techlab.articulo.Repositorio;
import com.techlab.articulo.Articulo;
import com.techlab.articulo.Categoria;
import com.techlab.articulo.ArticuloElectronico;
import com.techlab.articulo.ArticuloAlimenticio;

public class MenuArticulos extends Menu {
    private Scanner scanner;
    private Repositorio<Articulo> repoArticulos;
    private Repositorio<Categoria> repoCategorias;

    public MenuArticulos(Scanner scanner, Repositorio<Articulo> repoArticulos, Repositorio<Categoria> repoCategorias) {
        this.scanner = scanner;
        this.repoArticulos = repoArticulos;
        this.repoCategorias = repoCategorias;
    }

    @Override
    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ DE ARTÍCULOS ===");
            System.out.println("1. Crear artículo");
            System.out.println("2. Listar artículos");
            System.out.println("3. Eliminar artículo");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("❌ Ingresa un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearArticulo();
                    break;
                case 2:
                    listarArticulos();
                    break;
                case 3:
                    eliminarArticulo();
                    break;
                case 0:
                    System.out.println("↩ Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void crearArticulo() {
        if (repoCategorias.obtenerTodos().isEmpty()) {
            System.out.println("❌ No se pueden crear artículos: no hay categorías cargadas.");
            return;
        }

        System.out.print("Nombre del artículo: ");
        String nombre = scanner.next();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        System.out.println("Elige categoría:");
        for (Categoria c : repoCategorias.obtenerTodos()) {
            System.out.println(c.getCodigo() + " - " + c.getNombre());
        }
        int codigoCat = scanner.nextInt();
        Categoria categoria = repoCategorias.obtenerPorCodigo(codigoCat);

        System.out.println("Tipo de artículo: 1) Electrónico  2) Alimenticio");
        int tipo = scanner.nextInt();

        Articulo articulo;
        if (tipo == 1) {
            articulo = new ArticuloElectronico(nombre, precio, categoria);
        } else {
            articulo = new ArticuloAlimenticio(nombre, precio, categoria);
        }

        repoArticulos.agregar(articulo);
        System.out.println("✅ Artículo creado con éxito.");
    }

    private void listarArticulos() {
        for (Articulo a : repoArticulos.obtenerTodos()) {
            System.out.println(a);
        }
    }

    private void eliminarArticulo() {
        System.out.print("Código del artículo a eliminar: ");
        int codigo = scanner.nextInt();
        repoArticulos.eliminar(codigo);
        System.out.println("✅ Artículo eliminado.");
    }
}

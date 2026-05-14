package com.techlab.articulo;

import java.util.Scanner;
import com.techlab.articulo.menu.MenuArticulos;
import com.techlab.articulo.menu.MenuCategorias;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1) Crear repositorios genéricos
        Repositorio<Articulo> repoArticulos = new Repositorio<>();
        Repositorio<Categoria> repoCategorias = new Repositorio<>();

        // 2) Crear menús y pasarles lo que necesiten
        MenuArticulos menuArticulos = new MenuArticulos(scanner, repoArticulos, repoCategorias);
        MenuCategorias menuCategorias = new MenuCategorias(scanner, repoCategorias, repoArticulos);

        // 3) Menú principal
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Menú de Artículos");
            System.out.println("2. Menú de Categorías");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            // Validación básica
            while (!scanner.hasNextInt()) {
                System.out.println("❌ Ingresa un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuArticulos.mostrar();
                    break;
                case 2:
                    menuCategorias.mostrar();
                    break;
                case 0:
                    System.out.println("👋 Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}

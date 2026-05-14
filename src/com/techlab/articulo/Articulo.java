package com.techlab.articulo;

public abstract class Articulo implements Identificable, Calculable {
    private int codigo;
    private String nombre;
    private double precio;
    private Categoria categoria;

    // Constructor sin código (se asigna en el repositorio)
    public Articulo(String nombre, double precio, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    // Métodos de la interfaz Identificable
    @Override
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    // Método abstracto de Calculable
    @Override
    public abstract double calcularPrecioFinal();

    @Override
    public String toString() {
        return "Código: " + codigo +
               " | Nombre: " + nombre +
               " | Precio base: $" + precio +
               " | Categoría: " + categoria.getNombre() +
               " | Precio final: $" + calcularPrecioFinal();
    }
}

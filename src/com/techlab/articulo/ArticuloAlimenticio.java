package com.techlab.articulo;

public class ArticuloAlimenticio extends Articulo {
    public ArticuloAlimenticio(String nombre, double precio, Categoria categoria) {
        super(nombre, precio, categoria);
    }

    @Override
    public double calcularPrecioFinal() {
        // Ejemplo: IVA reducido 10.5% para alimentos
        return getPrecio() * 1.105;
    }
}

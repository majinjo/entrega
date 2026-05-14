package com.techlab.articulo;

public class ArticuloElectronico extends Articulo {
    public ArticuloElectronico(String nombre, double precio, Categoria categoria) {
        super(nombre, precio, categoria);
    }

    @Override
    public double calcularPrecioFinal() {
        // Ejemplo: IVA 21% para electrónicos
        return getPrecio() * 1.21;
    }
}

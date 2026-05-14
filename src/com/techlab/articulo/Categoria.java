package com.techlab.articulo;

public class Categoria implements Identificable {
    private int codigo;
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre;
    }
}

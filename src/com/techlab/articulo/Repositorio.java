package com.techlab.articulo;

import java.util.ArrayList;
import java.util.List;

public class Repositorio<T extends Identificable> {
    private List<T> elementos = new ArrayList<>();
    private int contadorCodigo = 1; // códigos automáticos

    // Agregar un elemento con código automático
    public void agregar(T elemento) {
        // Si el objeto tiene un campo código, lo asignamos automáticamente
        // Suponemos que las clases hijas tienen un constructor que recibe código
        if (elemento instanceof Categoria) {
            ((Categoria) elemento).setCodigo(contadorCodigo++);
        } else if (elemento instanceof Articulo) {
            ((Articulo) elemento).setCodigo(contadorCodigo++);
        }
        elementos.add(elemento);
    }

    // Obtener todos
    public List<T> obtenerTodos() {
        return new ArrayList<>(elementos);
    }

    // Buscar por código
    public T obtenerPorCodigo(int codigo) {
        for (T e : elementos) {
            if (e.getCodigo() == codigo) {
                return e;
            }
        }
        return null;
    }

    // Eliminar por código
    public void eliminar(int codigo) {
        elementos.removeIf(e -> e.getCodigo() == codigo);
    }

    // Modificar (reemplazar por código)
    public void modificar(int codigo, T nuevoElemento) {
        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).getCodigo() == codigo) {
                // mantenemos el mismo código
                if (nuevoElemento instanceof Categoria) {
                    ((Categoria) nuevoElemento).setCodigo(codigo);
                } else if (nuevoElemento instanceof Articulo) {
                    ((Articulo) nuevoElemento).setCodigo(codigo);
                }
                elementos.set(i, nuevoElemento);
                return;
            }
        }
    }
}

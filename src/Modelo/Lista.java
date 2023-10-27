package Modelo;

import java.util.ArrayList;

/**
 * Clase genérica que representa una lista.
 *
 * @param <T> El tipo de elementos que contendrá la lista.
 */
public class Lista<T> {
    protected ArrayList<T> lista;

    /**
     * Constructor de la lista.
     */
    public Lista() {
        lista = new ArrayList<>();
    }

    /**
     * Obtiene el tamaño de la lista.
     *
     * @return El tamaño de la lista.
     */
    public int getSize() {
        return lista.size();
    }

    /**
     * Agrega un elemento a la lista.
     *
     * @param t El elemento a agregar.
     */
    public void add(T t) {
        lista.add(t);
    }

    /**
     * Borra un elemento de la lista.
     *
     * @param t El elemento a borrar.
     */
    public void borrar(T t) {
        lista.remove(t);
    }

    /**
     * Obtiene un elemento en una posición específica de la lista.
     *
     * @param position La posición del elemento.
     * @return El elemento en la posición especificada.
     */
    public T getAt(int position) {
        return lista.get(position);
    }

    /**
     * Elimina todos los elementos de la lista, dejándola vacía.
     */
    public void clear() {
        lista.clear();
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    /**
     * Obtiene una copia de la lista como un ArrayList.
     *
     * @return Una copia de la lista como un ArrayList.
     */
    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(lista);
        return arrlist;
    }
}
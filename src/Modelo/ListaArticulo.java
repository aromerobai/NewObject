package Modelo;

import java.util.ArrayList;

/**
 * La clase ListaArticulo representa una lista de artículos en una tienda en línea.
 */
public class ListaArticulo {

    ArrayList<Articulo> articulos = new ArrayList<Articulo>();

    /**
     * Constructor por defecto de ListaArticulo.
     * Donde se inicializa la clase ListaArticulo.
     */
    public ListaArticulo(){
        // Inicialización de la lista de artículos.
    }

    /**
     * Agrega un artículo a la lista.
     *
     * @param articulo El artículo a agregar a la lista.
     */
    public void agregarArticulo(Articulo articulo){
        articulos.add(articulo);
    }

    /**
     * Obtiene la lista de artículos.
     *
     * @return La lista de artículos.
     */
    public ArrayList<Articulo> getArticulos(){
        return articulos;
    }

    /**
     * Retorna una representación en forma de cadena de la lista de artículos.
     *
     * @return Una cadena que representa la lista de artículos.
     */
    @Override
    public String toString() {
        return "ListaArticulo{" +
                "articulos=" + articulos +
                '}';
    }
}
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
        //Donde se incializa la clase ListaArticulo.
    }

    /**
     * Agrega un artículo a la lista.
     *
     * @param articulo El artículo a agregar a la lista.
     */
    public void agregarArticulo(String codigo, String descripcion, Float precio, Float gastos, int preparacion) {
        Articulo newArticulo = new Articulo(codigo, descripcion, precio, gastos, preparacion);
        articulos.add(newArticulo);
    }

    /**
     * Obtiene la lista de artículos.
     *
     * @return La lista de artículos.
     */
    public String getArticulo(String codigo) {
        String nombreArticulo = null;
        for (Articulo articulo : articulos) {
            if (articulo.getCodigo().equals(codigo)) {
                nombreArticulo = articulo.toString();
            }
        }
        return nombreArticulo;
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

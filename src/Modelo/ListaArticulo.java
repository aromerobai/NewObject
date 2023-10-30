package Modelo;

import NewObject.Excepciones.*;
import java.util.ArrayList;

/**
 * La clase ListaArticulo representa una lista de artículos en una tienda en línea.
 */
public class ListaArticulo extends Lista{

    public ArrayList<Articulo> articulos ;

    /**
     * Constructor por defecto de ListaArticulo.
     * Donde se inicializa la clase ListaArticulo.
     */
    public ListaArticulo(){
        this.articulos = new ArrayList<Articulo>();
    }

    /**
     * Agrega un artículo a la lista de artículos disponibles en el sistema.
     *
     * @param codigo       El código único del artículo.
     * @param descripcion  La descripción del artículo.
     * @param precio       El precio del artículo.
     * @param gastos       Los gastos asociados al artículo.
     * @param preparacion  El tiempo de preparación del artículo en minutos.
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
        return "ListaArticulo{ " +
                "articulos= " + articulos +
                " }";
    }

    /**
     * Comprueba si existe un artículo en la lista de artículos a través de su código.
     *
     * @param codigo El código del artículo a verificar.
     * @return true si el artículo con el código dado existe en la lista, false en caso contrario.
     */
    public boolean compruebaExistenciaArticulo(String codigo) {
        for (Articulo articulo : articulos) {
            if (articulo.getCodigo().equals(codigo)) {
                return true; // El artículo ya existe en la lista
            }
        }
        return false; // El artículo no existe en la lista
    }

}

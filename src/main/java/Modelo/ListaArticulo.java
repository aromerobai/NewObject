package Modelo;

import java.util.ArrayList;

public class ListaArticulo {

    ArrayList<Articulo> articulos = new ArrayList<Articulo>();

    public ListaArticulo(){
        //Donde se incializa la clase ListaArticulo.
    }

    public void agregarArticulo(Articulo articulo){
        articulos.add(articulo);
    }
    public  ArrayList<Articulo> getArticulos(){ return articulos;}

    @Override
    public String toString() {
        return "ListaArticulo{" +
                "articulos=" + articulos +
                '}';
    }

    public void agregarArticulo(String codigo, String descripcion, Float precio, Float gastos, int preparacion) {
        Articulo newArticulo = new Articulo(codigo, descripcion, precio, gastos, preparacion);
        articulos.add(newArticulo);
    }

    public String getArticulo(String codigo) {
        String nombreArticulo = null;
        for (Articulo articulo : articulos) {
            if (articulo.getCodigo().equals(codigo)) {
                nombreArticulo = articulo.toString();
            }
        }
        return nombreArticulo;
    }
}

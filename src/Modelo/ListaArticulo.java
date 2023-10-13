package Modelo;

import java.util.ArrayList;

public class ListaArticulo {

    ArrayList<Articulo> articulos = new ArrayList<Articulo>();

    public ListaArticulo(){
        //Donde se incializa la clase ListaArticulo.
    }

    public void agregarArticulo(Articulo articulo){}
    public  ArrayList<Articulo> getArticulos(){ return articulos;}

    @Override
    public String toString() {
        return "ListaArticulo{" +
                "articulos=" + articulos +
                '}';
    }
}

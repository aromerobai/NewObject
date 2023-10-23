package Controlador;

import Modelo.*;
import Vista.Vista;

import java.util.ArrayList;

public class Controlador {

    Datos datos = new Datos();

    public Controlador(){
        //Inicialización del controlador.
    }

    public void agregarArticulo(Articulo articulo){
        datos.agregarArticulo(articulo);
    }

    public Articulo mostrarArticulo(String codigo){
        ArrayList<Articulo> arrayArticulos = new ArrayList<Articulo>();
        ListaArticulo articulos = datos.getArticulo();
        arrayArticulos = articulos.getArticulos();
        for (Articulo articulo : arrayArticulos) {
            if (articulo.getCodigo().equals(codigo)) {
                return articulo;
            }
        }
        return null;
    }
    public void agregarCliente(Cliente cliente){}

    public ListaCliente mostrarCliente(){
        //En el futuro devolvera un objeto ListaCliente
        return null;
    }

    public void agregarPedido(Pedido pedido){}
    public ListaPedido mostrarPedido(String nif,EstadoPedido estadoPedido){
        //En el futuro devolvera un objeto ListaPedido
        return null;
    }
    public void borrarPedido(Integer id){}

    @Override
    public String toString() {
        return "Controlador{" +
                ", datos=" + datos +
                '}';
    }

}

package Controlador;

import Modelo.*;
import Vista.Vista;

public class Controlador {

    Datos datos = new Datos();
    Vista vista;

    public Controlador(){
        //Inicialización del controlador.
    }

    public void start(){
        this.vista = new Vista();
        vista.menu();

    }

    public String mostrarArticulo(String codigo){
        String articulo = datos.getArticulo(codigo);
        return articulo;
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

    public void agregarArticulo(String codigo, String descripcion, Float precio, Float gastos, int preparacion) {
        datos.agregarArticulo(codigo, descripcion, precio, gastos, preparacion);
    }
}

package Controlador;

import Modelo.*;
import Vista.Vista;
import java.util.ArrayList;

/**
 * Clase que representa el controlador de una tienda en línea.
 */
public class Controlador {
    Datos datos = new Datos();
    Vista vista;

    /**
     * Constructor por defecto del controlador. Inicializa el controlador.
     */
    public Controlador() {
        //Inicialización del controlador.
    }

    /**
     * Inicia la aplicación creando una instancia de la Vista y mostrando el menú principal.
     */
    public void start(){
        this.vista = new Vista();
        vista.menu();
    }

    /**
     * Agrega un artículo al sistema.
     *
     * @param codigo       El código del artículo.
     * @param descripcion  La descripción del artículo.
     * @param precio       El precio del artículo.
     * @param gastos       Los gastos asociados al artículo.
     * @param preparacion  El tiempo de preparación del artículo en minutos.
     */
    public void agregarArticulo(String codigo, String descripcion, Float precio, Float gastos, int preparacion) {
        datos.agregarArticulo(codigo, descripcion, precio, gastos, preparacion);
    }

    /**
     * Muestra un artículo basado en su código.
     *
     * @param codigo El código del artículo a buscar.
     * @return El artículo encontrado o null si no se encuentra.
     */
    public String mostrarArticulo(String codigo){
        String articulo = datos.getArticulo(codigo);
        return articulo;
    }

    /**
     * Agrega un cliente al sistema.
     *
     * @param nombre    El nombre del cliente.
     * @param domicilio La dirección del cliente.
     * @param nif       El NIF del cliente.
     * @param email     El correo electrónico del cliente.
     * @param tipo      El tipo de cliente (PREMIUM o ESTANDAR).
     * @param descuento El descuento aplicable al cliente (solo para clientes PREMIUM).
     * @param cuota     La cuota mensual (solo para clientes PREMIUM).
     */
    public void agregarCliente(String nombre, String domicilio, String nif, String email, TipoCliente tipo, Float descuento, Float cuota) {
        Cliente nuevoCliente;
        if (tipo == TipoCliente.PREMIUM) {
            datos.agregarCliente(nombre, domicilio, nif, email, tipo, descuento, cuota);
        } else {
            datos.agregarCliente(nombre, domicilio, nif, email, tipo, descuento, cuota);
        }
    }

    /**
     * Muestra la lista de clientes (actualmente no implementado).
     *
     * @return Una instancia de ListaCliente que contendría la lista de clientes.
     */
    public String mostrarCliente(String nif){
        String cliente = datos.getCliente(nif);
        return cliente;
    }

    /**
     * Agrega un pedido al sistema.
     *
     * @param pedido El pedido a agregar.
     */
    public void agregarPedido(Pedido pedido){}

    /**
     * Muestra la lista de pedidos basada en el NIF del cliente y el estado del pedido (actualmente no implementado).
     *
     * @param nif           El NIF del cliente.
     * @param estadoPedido  El estado del pedido.
     * @return Una instancia de ListaPedido que contendría la lista de pedidos.
     */
    public ListaPedido mostrarPedido(String nif,EstadoPedido estadoPedido){
        //En el futuro devolvera un objeto ListaPedido
        return null;
    }

    /**
     * Borra un pedido basado en su ID.
     *
     * @param id El ID del pedido a borrar.
     */
    public void borrarPedido(Integer id){}

    @Override
    public String toString() {
        return "Controlador{" +
                ", datos= " + datos +
                " }";
    }
}

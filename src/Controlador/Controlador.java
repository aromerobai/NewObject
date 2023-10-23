package Controlador;

import Modelo.*;
import Vista.Vista;
import java.util.ArrayList;

/**
 * Clase que representa el controlador de una tienda en línea.
 */
public class Controlador {
    private Datos datos = new Datos();

    /**
     * Constructor por defecto del controlador.
     */
    public Controlador() {
        // Inicialización del controlador.
    }

    /**
     * Agrega un artículo al sistema.
     *
     * @param articulo El artículo a agregar.
     */
    public void agregarArticulo(Articulo articulo) {
        datos.agregarArticulo(articulo);
    }

    /**
     * Muestra un artículo basado en su código.
     *
     * @param codigo El código del artículo a buscar.
     * @return El artículo encontrado o null si no se encuentra.
     */
    public Articulo mostrarArticulo(String codigo) {
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

    /**
     * Agrega un cliente al sistema.
     *
     * @param cliente El cliente a agregar.
     */
    public void agregarCliente(Cliente cliente) {
        datos.agregarCliente(cliente);
    }

    /**
     * Muestra la lista de clientes (actualmente no implementado).
     *
     * @return Una instancia de ListaCliente que contendría la lista de clientes.
     */
    public Cliente mostrarCliente(String nif) {
        ArrayList<Cliente> arrayClientes = new ArrayList<Cliente>();
        ListaCliente clientes = datos.getCliente();
        arrayClientes = clientes.getClientes();
        for (Cliente cliente : arrayClientes) {
            if (cliente.getNif().equals(nif)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Agrega un pedido al sistema.
     *
     * @param pedido El pedido a agregar.
     */
    public void agregarPedido(Pedido pedido) {
        // Implementación del método para agregar pedidos en el futuro.
    }

    /**
     * Muestra la lista de pedidos basada en el NIF del cliente y el estado del pedido (actualmente no implementado).
     *
     * @param nif           El NIF del cliente.
     * @param estadoPedido  El estado del pedido.
     * @return Una instancia de ListaPedido que contendría la lista de pedidos.
     */
    public ListaPedido mostrarPedido(String nif, EstadoPedido estadoPedido) {
        // En el futuro devolverá un objeto ListaPedido.
        return null;
    }

    /**
     * Borra un pedido basado en su ID.
     *
     * @param id El ID del pedido a borrar.
     */
    public void borrarPedido(Integer id) {
        // Implementación del método para borrar pedidos en el futuro.
    }

    @Override
    public String toString() {
        return "Controlador{" +
                "datos=" + datos + '}';
    }
}
package Modelo;

import java.util.ArrayList;

/**
 * La clase ListaPedido representa una lista de pedidos en una tienda en línea.
 */
public class ListaPedido extends Lista{

    ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    /**
     * Constructor por defecto de ListaPedido.
     * Donde se inicializa la clase ListaPedido.
     */
    public ListaPedido(){
        // Inicialización de la lista de pedidos.
    }

    /**
     * Agrega un pedido a la lista.
     *
     * @param pedido El pedido a agregar a la lista.
     */
    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    /**
     * Obtiene la lista de pedidos.
     *
     * @return La lista de pedidos.
     */
    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }

    /**
     * Borra un pedido de la lista por su ID.
     *
     * @param id El ID del pedido a borrar.
     */
    public void borrarPedido(Integer id){
        // Implementar lógica para borrar un pedido por su ID.
    }

    /**
     * Retorna una representación en forma de cadena de la lista de pedidos.
     *
     * @return Una cadena que representa la lista de pedidos.
     */
    @Override
    public String toString() {
        return "ListaPedido{" +
                "pedidos= " + pedidos +
                " }";
    }
}
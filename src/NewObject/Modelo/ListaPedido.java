package NewObject.Modelo;

import java.util.ArrayList;

/**
 * La clase ListaPedido representa una lista de pedidos en una tienda en línea.
 */
public class ListaPedido extends Lista {

    public ArrayList<Pedido> pedidos;

    /**
     * Constructor por defecto de ListaPedido.
     * Donde se inicializa la clase ListaPedido.
     */
    public ListaPedido() {
        this.pedidos = new ArrayList<Pedido>();
    }

    /**
     * Agrega un pedido a la lista de pedidos.
     *
     * @param id      El ID del pedido.
     * @param cantidad La cantidad de unidades del artículo solicitado.
     * @param cliente El cliente que realiza el pedido.
     * @param articulo El artículo solicitado en el pedido.
     * @param fecha   La fecha en que se realiza el pedido.
     * @param estado  El estado del pedido (ENVIADO o PENDIENTE).
     */
    public void agregarPedido(int id, int cantidad, Cliente cliente, Articulo articulo, String fecha, EstadoPedido estado) {
        Pedido pedido = new Pedido(id, cliente, articulo, cantidad, fecha, estado);
        pedidos.add(pedido);
    }

    /**
     * Obtiene la lista de pedidos.
     *
     * @return La lista de pedidos.
     */
    public String getPedidos(int id) {
        String pedidoInfo = null;
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(id)) {
                pedidoInfo = pedido.toString();
            }
        }
        return pedidoInfo;
    }

    /**
     * Obtiene información sobre los pedidos pendientes.
     *
     * @return Una cadena que contiene información detallada de los pedidos pendientes.
     */
    public String getPedidosPend() {
        String pedidoInfo = "";
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado() == EstadoPedido.PENDIENTE) {
                pedidoInfo = pedidoInfo + pedido.toString();
            }
        }
        return pedidoInfo;
    }

    /**
     * Obtiene información sobre los pedidos enviados.
     *
     * @return Una cadena que contiene información detallada de los pedidos enviados.
     */
    public String getPedidosEnvi() {
        String pedidoInfo = "";
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado() == EstadoPedido.ENVIADO) {
                pedidoInfo = pedidoInfo + pedido.toString();
            }
        }
        return pedidoInfo;
    }

    /**
     * Borra un pedido de la lista por su ID.
     *
     * @param id El ID del pedido a borrar.
     */
    public boolean borrarPedido(Integer id) {
        boolean exito = false;
        Pedido pedidoSel = null;
        for (Pedido pedido : pedidos) {
            if(pedido.getId() == id && pedido.pedidoEnviado() == false){
                pedidoSel = pedido;
                exito = true;
            }
        }
        if (exito == true){
            pedidos.remove(pedidoSel);
        }
        return exito;
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

    /**
     * Comprueba si existe un pedido en la lista de pedidos a través de su ID.
     *
     * @param id El ID del pedido a verificar.
     * @return true si el pedido con el ID dado existe en la lista, false en caso contrario.
     */
    public boolean compruebaExistenciaPedido (int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(id)) {
                return true; // El pedido ya existe en la lista
            }
        }
        return false; // El pedido no existe en la lista
    }

}
package Modelo;

/**
 * Clase que representa el modelo de datos de una tienda en línea.
 */
public class Datos {
    ListaArticulo articulos = new ListaArticulo();
    ListaPedido pedidos = new ListaPedido();
    ListaCliente clientes = new ListaCliente();

    /**
     * Constructor por defecto de Datos.
     */
    public Datos() {}

    /**
     * Agrega un artículo al modelo de datos.
     *
     * @param articulo El artículo a agregar.
     */
    public void agregarArticulo(String codigo, String descripcion, Float precio, Float gastos, int preparacion) {
        articulos.agregarArticulo(codigo, descripcion, precio, gastos, preparacion);
    }

    /**
     * Obtiene la lista de artículos del modelo de datos.
     *
     * @return La lista de artículos.
     */
    public String getArticulo(String codigo){
        String articulo = articulos.getArticulo(codigo);
        return articulo;

    }

    /**
     * (POSIBLE IMPLANTACIÓN) Borra un artículo del modelo de datos basado en su código.
     *
     * @param codigo El código del artículo a borrar.
     */
    public void borrarArticulo(String codigo) {
        // Implementación del método para borrar artículos en el futuro.
    }

    /**
     * Agrega un cliente al modelo de datos.
     *
     * @param cliente El cliente a agregar.
     */
    public void agregarCliente(Cliente cliente) {
        clientes.agregarCliente(cliente);
    }

    /**
     * Obtiene la lista de clientes del modelo de datos.
     *
     * @return La lista de clientes.
     */
    public ListaCliente getCliente() {
        return clientes;
    }

    /**
     * Agrega un pedido al modelo de datos.
     *
     * @param pedido El pedido a agregar.
     */
    public void agregarPedido(Pedido pedido) {
        pedidos.agregarPedido(pedido);
    }

    /**
     * Obtiene la lista de pedidos del modelo de datos.
     *
     * @return La lista de pedidos.
     */
    public ListaPedido getPedido() {
        return pedidos;
    }

    /**
     * Borra un pedido del modelo de datos basado en su ID.
     *
     * @param id El ID del pedido a borrar.
     */
    public void borrarPedido(Integer id) {
        // Implementación del método para borrar pedidos en el futuro.
    }


    @Override
    public String toString() {
        return "Datos{" +
                "articulos=" + articulos +
                ", pedidos=" + pedidos +
                ", clientes=" + clientes +
                '}';
    }
}

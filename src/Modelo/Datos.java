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
     * @param codigo       El código del artículo.
     * @param descripcion  La descripción del artículo.
     * @param precio       El precio del artículo.
     * @param gastos       Los gastos asociados al artículo.
     * @param preparacion  El tiempo de preparación del artículo en minutos.
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
    /*public void borrarArticulo(String codigo) {
        // Implementación del método para borrar artículos en el futuro.
    }*/

    /**
     * Agrega un cliente al modelo de datos.
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
        clientes.agregarCliente(nombre, domicilio, nif, email, tipo, descuento, cuota);
    }

    /**
     * Obtiene la lista de clientes del modelo de datos.
     *
     * @return La lista de clientes.
     */
    public String getCliente(String nif) {
        String cliente = clientes.getCliente(nif);
        return cliente;
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

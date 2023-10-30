package Modelo;

import java.time.LocalDateTime;

/**
 * Clase que representa el modelo de datos de una tienda en línea.
 */
public class Datos {
    private ListaArticulo articulos;
    private ListaPedido pedidos;
    private ListaCliente clientes;

    /**
     * Constructor por defecto de Datos.
     */
    public Datos() {
        this.articulos = new ListaArticulo();
        this.pedidos = new ListaPedido();
        this.clientes = new ListaCliente();
    }

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
     * @param id      El ID del pedido.
     * @param cliente El NIF del cliente que realiza el pedido.
     * @param articulo El código del artículo solicitado en el pedido.
     * @param cantidad La cantidad de unidades del artículo solicitado.
     * @param fecha   La fecha en que se realiza el pedido.
     * @param estado  El estado del pedido (ENVIADO o PENDIENTE).
     */
    public void agregarPedido(int id,  String cliente, String articulo, int cantidad, String fecha, EstadoPedido estado) {
        Cliente cli = null;
        for (Cliente clientePedido : clientes.clientes) {
            if (clientePedido.getNif().equals(cliente)) {
                cli = clientePedido;
            }
        }

        Articulo art = null;
        for (Articulo articuloPedido : articulos.articulos) {
            if (articuloPedido.getCodigo().equals(articulo)) {
                art = articuloPedido;
            }
        }
        if (cli == null){
            System.out.println("No existe el cliente seleccionado");
        }else if (art == null){
            System.out.println("No existe el articulo seleccionado");
        }else{
            pedidos.agregarPedido(id, cantidad, cli, art, fecha, estado);
        }
    }

    /**
     * Obtiene la lista de pedidos del modelo de datos.
     *
     * @return La lista de pedidos.
     */
    public String getPedido(int id) {
        String pedido = pedidos.getPedidos(id);
        return pedido;
    }

    /**
     * Obtiene la información de los pedidos pendientes.
     *
     * @return Una cadena que contiene información sobre los pedidos pendientes.
     */
    public String getPedidoPend(){
        String pedido = pedidos.getPedidosPend();
        return pedido;
    }

    /**
     * Obtiene la información de los pedidos enviados.
     *
     * @return Una cadena que contiene información sobre los pedidos enviados.
     */
    public String getPedidoEnvi(){
        String pedido = pedidos.getPedidosEnvi();
        return pedido;
    }

    /**
     * Borra un pedido del modelo de datos basado en su ID.
     *
     * @param id El ID del pedido a borrar.
     */
    public boolean borrarPedido(Integer id) {
        boolean exito = pedidos.borrarPedido(id);
        return exito;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "articulos=" + articulos +
                ", pedidos=" + pedidos +
                ", clientes=" + clientes +
                '}';
    }

    /**
     * Comprueba si existe un artículo en la lista de artículos a través de su código.
     *
     * @param codigo El código del artículo a verificar.
     * @return true si el artículo con el código dado existe en la lista, false en caso contrario.
     */
    public boolean existeArticulo(String codigo) {
        return articulos.compruebaExistenciaArticulo(codigo);
    }

    /**
     * Comprueba si existe un cliente en la lista de clientes a través de su NIF.
     *
     * @param nif El NIF del cliente a verificar.
     * @return true si el cliente con el NIF dado existe en la lista, false en caso contrario.
     */
    public boolean existeCliente(String nif) {
        return clientes.compruebaExistenciaCliente(nif);
    }

    /**
     * Comprueba si existe un pedido en el modelo de datos a través de su número de pedido.
     *
     * @param num El número de pedido a verificar.
     * @return true si el pedido con el número dado existe en el modelo de datos, false en caso contrario.
     */
    public boolean existePedido(int num) {
        return pedidos.compruebaExistenciaPedido(num);
    }



}

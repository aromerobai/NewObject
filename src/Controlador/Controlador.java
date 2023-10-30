package Controlador;

import Modelo.*;
import Vista.Vista;


/**
 * Clase que representa el controlador de una tienda en línea.
 */
public class Controlador {
    Datos datos = new Datos();
    Vista vista;

    /**
     * Inicia la aplicación creando una instancia de la Vista y mostrando el menú principal.
     */
    public void start() {
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
     * @param id      El ID del pedido.
     * @param cliente El NIF del cliente que realiza el pedido.
     * @param articulo El código del artículo solicitado en el pedido.
     * @param cantidad La cantidad de unidades del artículo solicitado.
     * @param fecha   La fecha en que se realiza el pedido.
     * @param estado  El estado del pedido (ENVIADO o PENDIENTE).
     */
    public void agregarPedido(int id, String cliente, String articulo, int cantidad, String fecha, EstadoPedido estado){
        datos.agregarPedido(id, cliente, articulo, cantidad, fecha, estado);
    }

    /**
     * Muestra la información de un pedido específico identificado por su ID.
     *
     * @param id El ID del pedido que se desea mostrar.
     * @return Una cadena de texto con la información del pedido.
     */
    public String mostrarPedido(int id){
        String pedido = datos.getPedido(id);
        return pedido;
    }

    /**
     * Muestra la información de los pedidos con estado "PENDIENTE".
     *
     * @return Una cadena de texto con la información de los pedidos pendientes.
     */
    public String mostrarPedidoPend(){
        String pedido = datos.getPedidoPend();
        return pedido;
    }

    /**
     * Muestra la información de los pedidos con estado "ENVIADO".
     *
     * @return Una cadena de texto con la información de los pedidos enviados.
     */
    public String mostrarPedidoEnvi(){
        String pedido = datos.getPedidoEnvi();
        return pedido;
    }

    /**
     * Borra un pedido basado en su ID.
     *
     * @param id El ID del pedido a borrar.
     */
    public boolean borrarPedido(Integer id){
        boolean exito = datos.borrarPedido(id);
        return exito;
    }

    /**
     * Devuelve una representación en forma de cadena de la instancia de Controlador.
     *
     * @return Una cadena que representa la instancia de Controlador.
     */
    @Override
    public String toString() {
        return "Controlador{" +
                ", datos= " + datos +
                " }";
    }

    /**
     * Comprueba si existe un artículo en el modelo de datos a través de su código.
     *
     * @param codigo El código del artículo a verificar.
     * @return true si el artículo con el código dado existe en el modelo de datos, false en caso contrario.
     */
    public boolean articuloExiste(String codigo) {
        return datos.existeArticulo(codigo);
    }

    /**
     * Comprueba si existe un cliente en el modelo de datos a través de su NIF.
     *
     * @param nif El NIF del cliente a verificar.
     * @return true si el cliente con el NIF dado existe en el modelo de datos, false en caso contrario.
     */
    public boolean clienteExiste(String nif) {
        return datos.existeCliente(nif);
    }

    /**
     * Comprueba si existe un pedido en el modelo de datos a través de su ID.
     *
     * @param id El ID del pedido a verificar.
     * @return true si el pedido con el ID dado existe en el modelo de datos, false en caso contrario.
     */
    public boolean pedidoExiste(int id) {
        return datos.existePedido(id);
    }

}



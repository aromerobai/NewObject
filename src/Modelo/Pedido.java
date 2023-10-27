package Modelo;

import java.time.LocalDateTime;

/**
 * La clase Pedido representa un pedido de un cliente en una tienda en línea.
 */
public class Pedido {
    Integer id;
    Cliente cliente;
    Articulo articulo;
    Integer cantidad;
    LocalDateTime fecha;
    EstadoPedido estado;

    /**
     * Constructor por defecto de Pedido.
     * Donde se inicializa la clase Pedido.
     */
    public Pedido(){
        // Inicialización de la clase Pedido.
    }

    /**
     * Constructor con argumentos para inicializar un pedido.
     *
     * @param id       El ID del pedido.
     * @param cliente  El cliente que realiza el pedido.
     * @param articulo El artículo que se solicita en el pedido.
     * @param cantidad La cantidad de unidades del artículo solicitado.
     * @param fecha    La fecha en que se realiza el pedido.
     * @param estado   El estado del pedido (ENVIADO o PENDIENTE).
     */
    public Pedido(Integer id, Cliente cliente, Articulo articulo, Integer cantidad, LocalDateTime fecha, EstadoPedido estado) {
        this.id = id;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.estado = estado;
    }

    /**
     * Obtiene el ID del pedido.
     *
     * @return El ID del pedido.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID del pedido.
     *
     * @param id El ID del pedido.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el cliente que realizó el pedido.
     *
     * @return El cliente del pedido.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente que realizó el pedido.
     *
     * @param cliente El cliente del pedido.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el artículo solicitado en el pedido.
     *
     * @return El artículo del pedido.
     */
    public Articulo getArticulo() {
        return articulo;
    }

    /**
     * Establece el artículo solicitado en el pedido.
     *
     * @param articulo El artículo del pedido.
     */
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    /**
     * Obtiene la cantidad de unidades del artículo solicitado en el pedido.
     *
     * @return La cantidad del artículo en el pedido.
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de unidades del artículo en el pedido.
     *
     * @param cantidad La cantidad del artículo en el pedido.
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la fecha en que se realizó el pedido.
     *
     * @return La fecha del pedido.
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en que se realizó el pedido.
     *
     * @param fecha La fecha del pedido.
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el estado del pedido (ENVIADO o PENDIENTE).
     *
     * @return El estado del pedido.
     */
    public EstadoPedido getEstado() {
        return estado;
    }

    /**
     * Establece el estado del pedido (ENVIADO o PENDIENTE).
     *
     * @param estado El estado del pedido.
     */
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    /**
     * Retorna una representación en forma de cadena del pedido.
     *
     * @return Una cadena que representa el pedido.
     */
    @Override
    public String toString() {
        return "Pedido{" +
                "id= " + id +
                ", cliente= " + cliente +
                ", articulo= " + articulo +
                ", cantidad= " + cantidad +
                ", fecha= " + fecha +
                ", estado="  + estado +
                " }";
    }
}
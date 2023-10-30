package Modelo;

import java.time.LocalDateTime;

/**
 * La clase Pedido representa un pedido de un cliente en una tienda en línea.
 */
public class Pedido {
    private int id;
    private Cliente cliente;
    private Articulo articulo;
    private int cantidad;
    private String fecha;
    private EstadoPedido estado;

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
    public Pedido(int id, Cliente cliente, Articulo articulo, int cantidad, String fecha, EstadoPedido estado) {
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
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en que se realizó el pedido.
     *
     * @param fecha La fecha del pedido.
     */
    public void setFecha(String fecha) {
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
        return "Pedido{\n" +
                "id= " + id +
                ", fecha= " + fecha + "\n" +
                ", cliente= " + cliente.getNombre() + ", nif: " + cliente.getNif() + "\n" +
                ", articulo= id: " + articulo.getCodigo() + " descripción: " + articulo.getDescripcion() + " precio unidad: " + articulo.getPrecio() + " €\n" +
                ", cantidad= " + cantidad +
                ", coste envío= " + precioEnvio() + " €\n" +
                ", precio total= " + precioTotal(getCantidad(), articulo.getPrecio(), precioEnvio()) + " €\n" +
                ", estado= "  + estado +
                " }\n" + "======================================================================================================================\n";
    }

    /**
     * Verifica si el pedido está en estado "ENVIADO".
     *
     * @return true si el pedido está en estado "ENVIADO", de lo contrario, false.
     */
    public boolean pedidoEnviado(){
        if (estado == EstadoPedido.ENVIADO){
            return true;
        }
        return false;
    }

    /**
     * Calcula el coste de envío teniendo en cuenta el tipo de cliente y el descuento aplicable.
     *
     * @return El coste de envío calculado.
     */
    public float precioEnvio(){
        float costeEnvio;
        Premium clientePremium = null;

        if ( cliente instanceof Premium){
            clientePremium = (Premium)cliente;
        }
        if (clientePremium != null) {
            costeEnvio = articulo.getGastosEnvio() - (articulo.getGastosEnvio() * clientePremium.getDescuento());
            return costeEnvio;
        }else{
            costeEnvio = articulo.getGastosEnvio();
            return costeEnvio;
        }
    }

    /**
     * Calcula el precio total de un pedido teniendo en cuenta la cantidad de unidades, el precio unitario y el coste de envío.
     *
     * @param cantidad   La cantidad de unidades del artículo solicitado.
     * @param precio     El precio unitario del artículo.
     * @param precEnvio  El coste de envío.
     * @return El precio total del pedido.
     */
    public float precioTotal(int cantidad, float precio, float precEnvio ){
        float total = cantidad * precio + precEnvio;
        return total;
    }
}
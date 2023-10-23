package Modelo;

/**
 * Clase que representa un cliente de tipo Premium.
 */
public class Premium extends Cliente {

    private Float descuento;
    private Float cuota;

    /**
     * Constructor por defecto de Premium.
     */
    public Premium() {}

    /**
     * Constructor con argumentos para inicializar un cliente Premium.
     *
     * @param nombre    El nombre del cliente.
     * @param domicilio El domicilio del cliente.
     * @param nif       El NIF (Número de Identificación Fiscal) del cliente.
     * @param email     El correo electrónico del cliente.
     * @param tipo      El tipo de cliente.
     * @param descuento El descuento aplicado al cliente Premium.
     * @param cuota     La cuota del cliente Premium.
     */
    public Premium(String nombre, String domicilio, String nif, String email, TipoCliente tipo, Float descuento, Float cuota) {
        super(nombre, domicilio, nif, email, tipo);
        this.descuento = descuento;
        this.cuota = cuota;
    }

    /**
     * Obtiene el descuento aplicado al cliente Premium.
     *
     * @return El descuento del cliente.
     */
    public Float getDescuento() {
        return descuento;
    }

    /**
     * Establece el descuento aplicado al cliente Premium.
     *
     * @param descuento El descuento a establecer.
     */
    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    /**
     * Obtiene la cuota del cliente Premium.
     *
     * @return La cuota del cliente.
     */
    public Float getCuota() {
        return cuota;
    }

    /**
     * Establece la cuota del cliente Premium.
     *
     * @param cuota La cuota a establecer.
     */
    public void setCuota(Float cuota) {
        this.cuota = cuota;
    }

    /**
     * Retorna una representación en forma de cadena del cliente Premium.
     *
     * @return Una cadena que representa al cliente Premium.
     */
    @Override
    public String toString() {
        return super.toString() +
                "descuento=" + descuento +
                ", cuota=" + cuota + '}';
    }
}
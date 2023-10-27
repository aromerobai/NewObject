package Modelo;
/**
 * Clase que representa un cliente de tipo Estandar.
 */
public class Estandar extends Cliente {
    private Float descuento;

    /**
     * Constructor por defecto de Estandar.
     */
    public Estandar() {}

    /**
     * Constructor con argumentos para inicializar un cliente Estandar.
     *
     * @param nombre    El nombre del cliente.
     * @param domicilio El domicilio del cliente.
     * @param nif       El NIF (Número de Identificación Fiscal) del cliente.
     * @param email     El correo electrónico del cliente.
     * @param tipo      El tipo de cliente.
     * @param descuento El descuento aplicado al cliente Estandar.
     */
    public Estandar(String nombre, String domicilio, String nif, String email, TipoCliente tipo, Float descuento) {
        super(nombre, domicilio, nif, email, tipo);
        this.descuento = descuento;
    }

    /**
     * Obtiene el descuento aplicado al cliente Estandar. En principio será 0
     *
     * @return El descuento del cliente.
     */
    public Float getDescuento() {
        return descuento;
    }

    /**
     * Establece el descuento aplicado al cliente Estandar.
     *
     * @param descuento El descuento a establecer.
     */
    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    /**
     * Retorna una representación en forma de cadena del cliente Estandar.
     *
     * @return Una cadena que representa al cliente Estandar.
     */
    @Override
    public String toString() {
        return super.toString() +
                ", descuento=" + descuento + " }";
    }
}

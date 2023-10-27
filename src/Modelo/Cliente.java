package Modelo;

/**
 * Clase que representa un cliente.
 */
public  abstract class Cliente {

    private String nombre;
    private String domicilio;
    private String nif;
    private String email;
    private TipoCliente tipo;

    /**
     * Constructor por defecto de Cliente.
     */
    public Cliente() {
    }

    /**
     * Constructor con argumentos para inicializar un cliente.
     *
     * @param nombre    El nombre del cliente.
     * @param domicilio El domicilio del cliente.
     * @param nif       El NIF (Número de Identificación Fiscal) del cliente.
     * @param email     El correo electrónico del cliente.
     * @param tipo      El tipo de cliente.
     */
    public Cliente(String nombre, String domicilio, String nif, String email, TipoCliente tipo) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.email = email;
        this.tipo = tipo;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el domicilio del cliente.
     *
     * @return El domicilio del cliente.
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Establece el domicilio del cliente.
     *
     * @param domicilio El domicilio a establecer.
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Obtiene el NIF del cliente.
     *
     * @return El NIF del cliente.
     */
    public String getNif() {
        return nif;
    }

    /**
     * Establece el NIF del cliente.
     *
     * @param nif El NIF a establecer.
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return El correo electrónico del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del cliente.
     *
     * @param email El correo electrónico a establecer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el tipo de cliente.
     *
     * @return El tipo de cliente (Estandar o Premium).
     */
    public TipoCliente getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de cliente.
     *
     * @param tipo El tipo de cliente a establecer.
     */
    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna una representación en forma de cadena del cliente.
     *
     * @return Una cadena que representa al cliente.
     */
    @Override
    public String toString() {
        return "Cliente{ " +
                "nombre= " + nombre +
                ", domicilio= " + domicilio +
                ", nif= " + nif +
                ", email= " + email +
                ", tipo= " + tipo ;
    }
}
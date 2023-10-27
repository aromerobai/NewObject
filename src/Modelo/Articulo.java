package Modelo;

/**
 * La clase Articulo representa un artículo en una tienda en línea.
 */
public class Articulo {
    private String codigo;
    private String descripcion;
    private Float precio;
    private Float gastosEnvio;
    private int preparacion;

    /**
     * Constructor por defecto de Articulo.
     * Donde se inicializa la clase Articulo.
     */
    public Articulo(){
        // Inicialización del objeto Articulo.
    }

    /**
     * Constructor con argumentos para inicializar un artículo.
     *
     * @param codigo       El código del artículo.
     * @param descripcion  La descripción del artículo.
     * @param precio       El precio del artículo.
     * @param gastosEnvio  Los gastos de envío del artículo.
     * @param preparacion  El tiempo de preparación del artículo.
     */
    public Articulo(String codigo, String descripcion, Float precio, Float gastosEnvio, int preparacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.gastosEnvio = gastosEnvio;
        this.preparacion = preparacion;
    }

    /**
     * Obtiene el código del artículo.
     *
     * @return El código del artículo.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del artículo.
     *
     * @param codigo El código a establecer.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene la descripción del artículo.
     *
     * @return La descripción del artículo.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del artículo.
     *
     * @param descripcion La descripción a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del artículo.
     *
     * @return El precio del artículo.
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del artículo.
     *
     * @param precio El precio a establecer.
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     * Obtiene los gastos de envío del artículo.
     *
     * @return Los gastos de envío del artículo.
     */
    public Float getGastosEnvio() {
        return gastosEnvio;
    }

    /**
     * Establece los gastos de envío del artículo.
     *
     * @param gastosEnvio Los gastos de envío a establecer.
     */
    public void setGastosEnvio(Float gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    /**
     * Obtiene el tiempo de preparación del artículo.
     *
     * @return El tiempo de preparación del artículo.
     */
    public Integer getPreparacion() {
        return preparacion;
    }

    /**
     * Establece el tiempo de preparación del artículo.
     *
     * @param preparacion El tiempo de preparación a establecer.
     */
    public void setPreparacion(Integer preparacion) {
        this.preparacion = preparacion;
    }

    /**
     * Retorna una representación en forma de cadena del artículo.
     *
     * @return Una cadena que representa el artículo.
     */
    @Override
    public String toString() {
        return "Articulo{ " +
                "código= " + codigo +
                ", descripción= " + descripcion +
                ", precio= " + precio + " €" +
                ", gastos de envío= " + gastosEnvio + " €" +
                ", tiempo de preparación= " + preparacion + " horas" +
                " }\n" + "======================================================================================================================\n";
    }
}
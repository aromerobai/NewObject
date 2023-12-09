package Modelo;

import jakarta.persistence.*;

@Entity
@NamedQuery(name= "Articulo.borrarByCodigo", query = "DELETE FROM Articulo WHERE codigo = ?1")
@NamedQuery(name= "Articulo.byCodigo", query = "SELECT e FROM Articulo e WHERE codigo = ?1")
public class Articulo {
    @Id
    @Column(name = "codigo", nullable = false, length = 45)
    private String codigo;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
    @Basic
    @Column(name = "precio", nullable = false, precision = 2)
    private float precio;
    @Basic
    @Column(name = "gastoEnvio", nullable = false, precision = 2)
    private float gastoEnvio;
    @Basic
    @Column(name = "preparacion", nullable = false)
    private int preparacion;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getGastoEnvio() {
        return gastoEnvio;
    }

    public void setGastoEnvio(float gastoEnvio) {
        this.gastoEnvio = gastoEnvio;
    }

    public int getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(int preparacion) {
        this.preparacion = preparacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Articulo articulo = (Articulo) o;

        if (Float.compare(articulo.precio, precio) != 0) return false;
        if (Float.compare(articulo.gastoEnvio, gastoEnvio) != 0) return false;
        if (preparacion != articulo.preparacion) return false;
        if (codigo != null ? !codigo.equals(articulo.codigo) : articulo.codigo != null) return false;
        if (descripcion != null ? !descripcion.equals(articulo.descripcion) : articulo.descripcion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (precio != +0.0f ? Float.floatToIntBits(precio) : 0);
        result = 31 * result + (gastoEnvio != +0.0f ? Float.floatToIntBits(gastoEnvio) : 0);
        result = 31 * result + preparacion;
        return result;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", gastoEnvio=" + gastoEnvio +
                ", preparacion=" + preparacion +
                '}';
    }
}

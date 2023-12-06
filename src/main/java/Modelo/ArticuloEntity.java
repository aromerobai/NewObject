package Modelo;

import javax.persistence.*;

@Entity
@Table(name = "articulo", schema = "onlinestore")
@NamedQuery(name= "Articulo.borrarByCodigo", query = "DELETE FROM ArticuloEntity WHERE codigo = ?1")
@NamedQuery(name= "Articulo.byCodigo", query = "SELECT e FROM ArticuloEntity e WHERE codigo = ?1")

public class ArticuloEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo", nullable = false, length = 45)
    private String codigo;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
    @Basic
    @Column(name = "precio", nullable = false, precision = 2)
    private Float precio;
    @Basic
    @Column(name = "gastoEnvio", nullable = false, precision = 2)
    private Float gastoEnvio;
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

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getGastoEnvio() {
        return gastoEnvio;
    }

    public void setGastoEnvio(Float gastoEnvio) {
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

        ArticuloEntity that = (ArticuloEntity) o;

        if (preparacion != that.preparacion) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (precio != that.precio) return false;
        if (gastoEnvio != that.gastoEnvio) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + precio.intValue();
        result = 31 * result + gastoEnvio.intValue();
        result = 31 * result + preparacion;
        return result;
    }
}

package Modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "cliente", schema = "onlinestore")
public class ClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nif", nullable = false, length = 45)
    private String nif;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "domicilio", nullable = false, length = 45)
    private String domicilio;
    @Basic
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Basic
    @Column(name = "tipo", nullable = false)
    private Object tipo;
    @Basic
    @Column(name = "descuento", nullable = true, precision = 0)
    private Double descuento;
    @Basic
    @Column(name = "cuota", nullable = true, precision = 0)
    private Double cuota;
    @OneToMany(mappedBy = "clienteByClienteNif")
    private Collection<PedidoEntity> pedidosByNif;

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getTipo() {
        return tipo;
    }

    public void setTipo(Object tipo) {
        this.tipo = tipo;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteEntity that = (ClienteEntity) o;

        if (nif != null ? !nif.equals(that.nif) : that.nif != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (domicilio != null ? !domicilio.equals(that.domicilio) : that.domicilio != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (descuento != null ? !descuento.equals(that.descuento) : that.descuento != null) return false;
        if (cuota != null ? !cuota.equals(that.cuota) : that.cuota != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nif != null ? nif.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (domicilio != null ? domicilio.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (descuento != null ? descuento.hashCode() : 0);
        result = 31 * result + (cuota != null ? cuota.hashCode() : 0);
        return result;
    }

    public Collection<PedidoEntity> getPedidosByNif() {
        return pedidosByNif;
    }

    public void setPedidosByNif(Collection<PedidoEntity> pedidosByNif) {
        this.pedidosByNif = pedidosByNif;
    }
}

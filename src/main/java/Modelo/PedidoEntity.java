package Modelo;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "pedido", schema = "onlinestore")
public class PedidoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPedido", nullable = false, length = 45)
    private String idPedido;
    @Basic
    @Column(name = "idArticulo", nullable = false, length = 45)
    private String idArticulo;
    @Basic
    @Column(name = "Cliente_nif", nullable = false, length = 45)
    private String clienteNif;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Basic
    @Column(name = "estado", nullable = false, length = 45)
    private String estado;
    @ManyToOne
    @JoinColumn(name = "Cliente_nif", referencedColumnName = "nif", nullable = false)
    private ClienteEntity clienteByClienteNif;
    @ManyToOne
    @JoinColumn(name = "idArticulo", referencedColumnName = "codigo", nullable = false)
    private ArticuloEntity articuloByIdArticulo;

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getClienteNif() {
        return clienteNif;
    }

    public void setClienteNif(String clienteNif) {
        this.clienteNif = clienteNif;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidoEntity that = (PedidoEntity) o;

        if (cantidad != that.cantidad) return false;
        if (idPedido != null ? !idPedido.equals(that.idPedido) : that.idPedido != null) return false;
        if (idArticulo != null ? !idArticulo.equals(that.idArticulo) : that.idArticulo != null) return false;
        if (clienteNif != null ? !clienteNif.equals(that.clienteNif) : that.clienteNif != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPedido != null ? idPedido.hashCode() : 0;
        result = 31 * result + (idArticulo != null ? idArticulo.hashCode() : 0);
        result = 31 * result + (clienteNif != null ? clienteNif.hashCode() : 0);
        result = 31 * result + cantidad;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    public ClienteEntity getClienteByClienteNif() {
        return clienteByClienteNif;
    }

    public void setClienteByClienteNif(ClienteEntity clienteByClienteNif) {
        this.clienteByClienteNif = clienteByClienteNif;
    }

    public ArticuloEntity getArticuloByIdArticulo() {
        return articuloByIdArticulo;
    }

    public void setArticuloByIdArticulo(ArticuloEntity articuloByIdArticulo) {
        this.articuloByIdArticulo = articuloByIdArticulo;
    }
}

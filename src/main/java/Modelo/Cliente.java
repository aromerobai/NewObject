package Modelo;

import jakarta.persistence.*;

@Entity
public class Cliente {
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
    private float descuento;
    @Basic
    @Column(name = "cuota", nullable = true, precision = 0)
    private float cuota;

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

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getCuota() {
        return cuota;
    }

    public void setCuota(float cuota) {
        this.cuota = cuota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (Float.compare(cliente.descuento, descuento) != 0) return false;
        if (Float.compare(cliente.cuota, cuota) != 0) return false;
        if (nif != null ? !nif.equals(cliente.nif) : cliente.nif != null) return false;
        if (nombre != null ? !nombre.equals(cliente.nombre) : cliente.nombre != null) return false;
        if (domicilio != null ? !domicilio.equals(cliente.domicilio) : cliente.domicilio != null) return false;
        if (email != null ? !email.equals(cliente.email) : cliente.email != null) return false;
        if (tipo != null ? !tipo.equals(cliente.tipo) : cliente.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nif != null ? nif.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (domicilio != null ? domicilio.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (descuento != +0.0f ? Float.floatToIntBits(descuento) : 0);
        result = 31 * result + (cuota != +0.0f ? Float.floatToIntBits(cuota) : 0);
        return result;
    }
}

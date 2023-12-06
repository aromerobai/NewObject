package Modelo;

public class Premium extends Cliente{
    Float descuento;
    Float cuota;

    public Premium(){
        //Donde se incializa la clase Premium.
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Float getCuota() {
        return cuota;
    }

    public void setCuota(Float cuota) {
        this.cuota = cuota;
    }

    @Override
    public String toString() {
        return "Premium{" +
                "descuento=" + descuento +
                ", cuota=" + cuota +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", nif='" + nif + '\'' +
                ", email='" + email + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}

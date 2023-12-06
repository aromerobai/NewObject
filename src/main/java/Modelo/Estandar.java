package Modelo;

public class Estandar extends Cliente{

    Float descuento;

    public Estandar(){
        //Donde se incializa la clase Estandar.
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Estandar{" +
                "descuento=" + descuento +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", nif='" + nif + '\'' +
                ", email='" + email + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}

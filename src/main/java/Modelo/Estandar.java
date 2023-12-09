package Modelo;

public class Estandar extends Cliente{

    Float descuento;

    public Estandar(){
        //Donde se incializa la clase Estandar.
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Estandar{" +
                "descuento=" + descuento +
                ", " + super.toString() +
                '}';
    }
}

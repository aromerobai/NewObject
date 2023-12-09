package Modelo;

public class Premium extends Cliente{
    Float descuento;
    Float cuota;

    public Premium(){
        //Donde se incializa la clase Premium.
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public float getCuota() {
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
                ", " + super.toString() +
                '}';
    }
}

package Modelo;

import java.util.ArrayList;

public class ListaPedido {

    ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public ListaPedido(){
        //Donde se incializa la clase ListaPedido.
    }

    public void agregarPedido(Pedido pedido){}
    public ArrayList<Pedido> getPedidos(){return pedidos;}
    public void borrarPedido(Integer id){}

    @Override
    public String toString() {
        return "ListaPedido{" +
                "pedidos=" + pedidos +
                '}';
    }
}

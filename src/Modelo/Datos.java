package Modelo;

public class Datos {
    ListaArticulo articulos;
    ListaPedido pedidos;
    ListaCliente clientes;

    public Datos(){
        //Inicialización del modelo de datos
    }

    public void agregarArticulo(Articulo articulo){
        articulos.agregarArticulo(articulo);
    }
    public ListaArticulo getArticulo(){return articulos;}
    public void borrarArticulo(String codigo){}

    public void agregarPedido(Pedido pedido){}
    public ListaPedido getPedido(){return pedidos;}
    public void borrarPedido(Integer id){}


    public void agregarCliente(Cliente cliente){}
    public ListaCliente mostrarCliente(){return clientes;}

    @Override
    public String toString() {
        return "Datos{" +
                "articulos=" + articulos +
                ", pedidos=" + pedidos +
                ", clientes=" + clientes +
                '}';
    }
}

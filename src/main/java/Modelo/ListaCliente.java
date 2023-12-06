package Modelo;

import java.util.ArrayList;

public class ListaCliente {

    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public ListaCliente(){
        //Donde se incializa la clase ListaCliente.
    }

    public void agregarCliente(Cliente cliente){}
    public ArrayList<Cliente> getClientes(){return clientes;}

    @Override
    public String toString() {
        return "ListaCliente{" +
                "clientes=" + clientes +
                '}';
    }
}

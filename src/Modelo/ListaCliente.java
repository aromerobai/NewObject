package Modelo;

import java.util.ArrayList;

/**
 * La clase ListaCliente representa una lista de clientes en una tienda en línea.
 */
public class ListaCliente {

    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    /**
     * Constructor por defecto de ListaCliente.
     * Donde se inicializa la clase ListaCliente.
     */
    public ListaCliente() {
        // Inicialización de la lista de clientes.
    }

    /**
     * Agrega un cliente a la lista.
     *
     * @param cliente El cliente a agregar a la lista.
     */
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    /**
     * Obtiene la lista de clientes.
     *
     * @return La lista de clientes.
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Retorna una representación en forma de cadena de la lista de clientes.
     *
     * @return Una cadena que representa la lista de clientes.
     */
    @Override
    public String toString() {
        return "ListaCliente{" +
                "clientes=" + clientes +
                '}';
    }
}
package Modelo;

import java.util.ArrayList;

/**
 * La clase ListaCliente representa una lista de clientes en una tienda en línea.
 */
public class ListaCliente extends Lista{

    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    /**
     * Constructor por defecto de ListaCliente.
     * Donde se inicializa la clase ListaCliente.
     */
    public ListaCliente() {}

    /**
     * Agrega un cliente al sistema.
     *
     * @param nombre    El nombre del cliente.
     * @param domicilio La dirección del cliente.
     * @param nif       El NIF del cliente.
     * @param email     El correo electrónico del cliente.
     * @param tipo      El tipo de cliente (PREMIUM o ESTANDAR).
     * @param descuento El descuento aplicable al cliente (solo para clientes PREMIUM).
     * @param cuota     La cuota mensual (solo para clientes PREMIUM).
     */
    public void agregarCliente(String nombre, String domicilio, String nif, String email, TipoCliente tipo, Float descuento, Float cuota) {
        Cliente newCliente;

        if (tipo == TipoCliente.PREMIUM) {
            newCliente = new Premium(nombre, domicilio, nif, email, tipo, descuento, cuota);
        } else {
            newCliente = new Estandar(nombre, domicilio, nif, email, tipo, descuento);
        }
        clientes.add(newCliente);
    }

    /**
     * Obtiene la lista de clientes.
     *
     * @return La lista de clientes.
     */
    public String getCliente(String nif) {
        String clienteInfo = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNif().equals(nif)) {
                clienteInfo = cliente.toString();
            }
        }
        return clienteInfo;
    }

    /**
     * Retorna una representación en forma de cadena de la lista de clientes.
     *
     * @return Una cadena que representa la lista de clientes.
     */
    @Override
    public String toString() {
        return "ListaCliente{" +
                "clientes= " + clientes +
                " }";
    }
}
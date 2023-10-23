package Controlador;

import Vista.Vista;

/**
 * Clase principal que inicia una tienda en línea.
 */
public class OnlineStore {
    /**
     * Punto de entrada principal de la aplicación.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        Vista newVista = new Vista();
        newVista.menu();
    }
}
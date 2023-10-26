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
    Controlador controlador= new Controlador();

    public static void main(String[] args) {
        OnlineStore onlineStore = new OnlineStore();
        onlineStore.iniciar();

    }
    void iniciar(){
        controlador.start();
    }
}
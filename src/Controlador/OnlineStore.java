package Controlador;

import Vista.Vista;

/**
 * Clase principal que inicia online store
 */
public class OnlineStore {
    /**
     * Punto de entrada principal de la aplicación.
     */
    Controlador controlador = new Controlador();

    /**
     * Método de inicio de la aplicación que crea una instancia de Online store y la inicia.
     */
    public static void main(String[] args) {
        OnlineStore onlineStore = new OnlineStore();
        onlineStore.iniciar();
    }

    /**
     * Inicia Online store a través del controlador.
     */
    void iniciar() {
        controlador.start();
    }
}
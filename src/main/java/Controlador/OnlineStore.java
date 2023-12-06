package Controlador;

public class OnlineStore {
    Controlador controlador= new Controlador();
    public static void main(String[] args) {
        OnlineStore onlineStore = new OnlineStore();
        onlineStore.iniciar();

    }
    void iniciar(){
        controlador.start();
    }
}
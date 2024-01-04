package Vista;

import controlador.Controlador;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VistaAnadirCliente {
    private Scene scene;
    private Stage stage;
    private Parent root;
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }
    public void anadirCliente() {

    }
}

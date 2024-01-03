package Vista;

import controlador.Controlador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class VistaGestionCliente {
    private Scene scene;
    private Stage stage;
    private Parent root;
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }
    public void cambiarBuscarCliente(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/menuBuscarCliente.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getRoot().setStyle("-fx-background-color: #FFEACE;");
        stage.setScene(scene);
        stage.show();

    }
    public void cambiarAnadirCliente(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/menuAnadirCliente.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getRoot().setStyle("-fx-background-color: #FFEACE;");
        stage.setScene(scene);
        stage.show();

    }


    public void cambiarMenuPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/menuPrincipal.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getRoot().setStyle("-fx-background-color: #FFEACE;");
        stage.setScene(scene);
        stage.show();

    }

}

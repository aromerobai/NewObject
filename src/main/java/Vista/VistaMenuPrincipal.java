package Vista;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class VistaMenuPrincipal {
    private Scene scene;
    private Stage stage;
    private Parent root;

    public void cambiarMenuCliente(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/menuCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void cambiarMenuArticulo(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/menuArticulo.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void cambiarMenuPedido(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/menuPedido.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void cambiarMenuInicial(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/principal.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}

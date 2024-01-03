package Vista;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class VistaGestionPedido {
    private Scene scene;
    private Stage stage;
    private Parent root;

    public void cambiarListarPedido(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/listarPedido.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getRoot().setStyle("-fx-background-color: #FFEACE;");
        stage.setScene(scene);
        stage.show();

    }
    public void cambiarEliminarPedido(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/eliminarPedido.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getRoot().setStyle("-fx-background-color: #FFEACE;");
        stage.setScene(scene);
        stage.show();

    }


    public void cambiarAnadirPedido(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/anadirPedido.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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

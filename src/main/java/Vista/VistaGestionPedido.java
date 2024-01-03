package Vista;

import controlador.Controlador;
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
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }
    public void cambiarListarPedido(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/listarPedido.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void cambiarEliminarPedido(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/eliminarPedido.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void cambiarAnadirPedido(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/anadirPedido.fxml"));
        root = loader.load();

        VistaAnadirPedido vistaAnadirPedidoControlador = loader.getController();
        vistaAnadirPedidoControlador.setControlador(controlador);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void cambiarMenuPrincipal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/menuPrincipal.fxml"));
        root = loader.load();

        VistaMenuPrincipal VistaMenuPrincipalControlador = loader.getController();
        VistaMenuPrincipalControlador.setControlador(controlador);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}

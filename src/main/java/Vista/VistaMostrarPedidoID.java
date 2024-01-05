package Vista;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class VistaMostrarPedidoID {
    private Scene scene;
    private Stage stage;
    private Parent root;
    private Controlador controlador;
    @FXML
    private TextField id_pedido;
    @FXML
    private TextArea textArea;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }
    public void mostrarPedidoID(ActionEvent event) {

        String idPedidoHandle = id_pedido.getText();

        try{
            String pedido = controlador.mostrarPedido(idPedidoHandle);
            String sinLlave1 = pedido.replace("}","");
            String sinLlave2 = sinLlave1.replace("{", "");
            String sinComas = sinLlave2.replace(",", "");
            textArea.setText(sinComas);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en la Insercion de Dato");
            alert.setHeaderText("Error en la Insercion de Dato");
            alert.setContentText("Error en la Insercion de Dato.");

            alert.showAndWait();
        }
        id_pedido.clear();
    }

    public void cambiarMenuPrincipal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/mostrarPedido.fxml"));
        root = loader.load();

        VistaMenuListarPedidos VistaMenuListarPedidosControlador = loader.getController();
        VistaMenuListarPedidosControlador.setControlador(controlador);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
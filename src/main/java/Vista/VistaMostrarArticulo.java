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
import java.sql.SQLException;

public class VistaMostrarArticulo {
    private Scene scene;
    private Stage stage;
    private Parent root;
    private Controlador controlador;

    @FXML
    private TextField codigo;
    @FXML
    private TextArea textArea;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }
/*
    @FXML
    public void mostrarArticuloCodigo(ActionEvent event) {
        String codigoHandle = codigo.getText();

        try {
            String articulo = controlador.mostrarArticuloCodigo(codigoHandle);

            if (articulo != null) {
                String art = articulo.toString();
                String sinLlaves = art.replace("{", "").replace("}", "");
                String sinComas = sinLlaves.replace(",", "");
                textArea.setText(sinComas);
            } else {
                throw new ElementoNoExistente();
            }
        } catch (ElementoNoExistente e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en la Inserción de Dato");
            alert.setHeaderText("Error en la Inserción de Dato");
            alert.setContentText("Error en la Inserción de Dato.");

            alert.showAndWait();
        }
        codigo.clear();
    }

*/
    public void cambiarMenuPrincipal (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/menuArticulo.fxml"));
        root = loader.load();
        VistaGestionArticulo VistaGestionArticuloControlador = loader.getController();
        VistaGestionArticuloControlador.setControlador(controlador);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

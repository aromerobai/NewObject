package Vista;

import controlador.Controlador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.sql.Date;

public class VistaAnadirPedido {
    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private TextField id_pedido;
    @FXML
    private TextField nif;
    @FXML
    private TextField id_articulo;
    @FXML
    private TextField cantidad;
    @FXML
    private ChoiceBox<String> estadoChoiceBox;
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }
    @FXML
    public void initialize() {
        estadoChoiceBox.getItems().addAll("PENDIENTE", "ENVIADO");
        // Puedes establecer un valor predeterminado si lo deseas
        estadoChoiceBox.setValue("PENDIENTE");
    }
    @FXML
    public void handleAnadirPedido(ActionEvent event) {

        String idPedidoHandle = id_pedido.getText();
        String nifHandle = nif.getText();
        String idArticuloHandle = id_articulo.getText();
        String cantidadHandle = cantidad.getText();
        String estadoHandle = estadoChoiceBox.getValue();

        LocalDateTime fechaActual = LocalDateTime.now();

        try{
            controlador.agregarPedido(idPedidoHandle, nifHandle, idArticuloHandle, Integer.parseInt(cantidadHandle), Date.from(fechaActual.toInstant(ZoneOffset.UTC)), estadoHandle);
        }catch (Exception e){
            System.out.println("Error al guardar los datos");
        }
    }
}

/*      System.out.println("- Inserta el ID del pedido: ");
        String id = input.next();
        input.nextLine(); // Consumir la nueva línea pendiente

        if (controlador.pedidoExiste(id)){
        throw new ElementoExistente();
        }
        System.out.println("- Inserta el nif del cliente: ");
        String nifCliente = input.nextLine();

        System.out.println("- Inserta el codigo del artículo: ");
        String articulo = input.nextLine();

        System.out.println("- Inserta la cantidad: ");
        int cantidad = input.nextInt();
        input.nextLine(); // Consumir la nueva línea pendiente

        LocalDateTime fechaActual = LocalDateTime.now();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.print("- Inserta el estado del pedido (PENDIENTE/ENVIADO): ");
        String estadoPedido = menuEstadoPedido();

        controlador.agregarPedido(id, nifCliente, articulo,  cantidad, Date.from(fechaActual.toInstant(ZoneOffset.UTC)), estadoPedido);
 */
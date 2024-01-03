package Vista;

import controlador.Controlador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class VistaAnadirPedido {
    private Scene scene;
    private Stage stage;
    private Parent root;
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
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
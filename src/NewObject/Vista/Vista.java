
package NewObject.Vista;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import NewObject.Controlador.ConexionDB;
import NewObject.Controlador.Controlador;
import NewObject.Modelo.EstadoPedido;
import NewObject.Modelo.TipoCliente;
import NewObject.Excepciones.*;
import java.util.Scanner;

/**
 * Clase que representa la vista de una tienda en línea.
 */
public class Vista {

    Controlador controlador = new Controlador();
    Scanner input = new Scanner(System.in);

    private ConexionDB conexionDB;

    /**
     * Carga datos de ejemplo en el controlador para inicializar el sistema.
     * Agrega artículos, clientes y pedidos de muestra.
     */
    public void  cargarDatos(){
        /*controlador.agregarArticulo("1", "Sistema refrigeración", 89.50f, 7.99f, 24);
        controlador.agregarArticulo("2", "Monitor", 109.22f, 7.99f, 48);
        controlador.agregarArticulo("3", "Memoria Ram 8gb", 47.25f, 20.50f, 40);
        controlador.agregarArticulo("4", "Disco duro 500gb", 68.99f, 12.99f, 50);
        controlador.agregarArticulo("5", "Ratón cableado", 18.55f, 4.45f, 24);*/

        /*TipoCliente estandar = TipoCliente.ESTANDAR;
        TipoCliente premium = TipoCliente.PREMIUM;
        controlador.agregarCliente("Daniel Freijó", "Barcelona 1", "1111", "dani@mail.com", estandar, 0.0f, null);
        controlador.agregarCliente("Andrés Romero", "Zaragoza 1", "2222", "andres@mail.com", premium, 0.4f, 10.99f);
        controlador.agregarCliente("Moisés Molina", "Burgos 1", "3333", "moises@mail.com", estandar, 0.0f, null);
        controlador.agregarCliente("Roger Gallofré", "Falsa 4", "4444", "roger@mail.com", premium, 0.4f, 10.99f);
        controlador.agregarCliente("Cristina Romero", "Lopez 1", "5555", "cristina@mail.com", estandar, 0.0f, null);
        */
       /* EstadoPedido enviado = EstadoPedido.ENVIADO;
        EstadoPedido pendiente = EstadoPedido.PENDIENTE;
        controlador.agregarPedido(1, "5555", "1", 4, "28/10/2023 06:05:15", enviado);
        controlador.agregarPedido(2, "4444", "2", 2, "29/10/2023 18:05:35", pendiente);
        controlador.agregarPedido(3, "3333","3", 8,"27/10/2023 21:05:15", enviado);
        controlador.agregarPedido(4, "2222", "4", 5,"30/10/2023 12:05:15", pendiente);
        controlador.agregarPedido(5, "1111", "5", 4, "29/10/2023 19:05:15", enviado);*/
    }

    /**
     * Constructor de la vista.
     */
    public Vista() {
        cargarDatos();
    }

    /**
     * Método principal que muestra el menú y permite interactuar con el Controlador.
     */
    public void menu() {
        boolean salir = false;
        char opcion;

        do {
            System.out.println("**************");
            System.out.println("*   INICIO   *");
            System.out.println("**************\n");
            System.out.println("1. Gestiónar artículo");
            System.out.println("2. Gestiónar cliente");
            System.out.println("3. Gestión pedido");
            System.out.println("0. SALIR");

            opcion = opcionMenu();

            try {
                switch (opcion) {
                    case '1':
                        menuArticulo();
                        break;
                    case '2':
                        menuCliente();
                        break;
                    case '3':
                        menuPedido();
                        break;
                    case '0':
                        salir = true;
                        break;
                    default:
                        throw new OpcionInvalida();
                }
            } catch (OpcionInvalida e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!salir);
    }

    /**
     * Lee una opción del menú desde la entrada estándar.
     *
     * @return La opción seleccionada como un carácter.
     */
    char opcionMenu() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Seleccione una de las siguientes opciones: ");
        String respuesta = entrada.nextLine();
        if (respuesta.isEmpty()) {
            respuesta = " ";
        }
        return respuesta.charAt(0);
    }

    /**
     * Muestra un menú para la gestión de artículos.
     */
    private void menuArticulo() {
        char opcion;
        boolean volver = false;
        do {
            System.out.println("\nMENÚ DE GESTIÓN DE ARTÍCULOS \n");
            System.out.println("1. Añadir artículo");
            System.out.println("2. Mostrar artículo");
            System.out.println("0. Volver al menu");

            opcion = opcionMenu();

            try {
                switch (opcion) {
                    case '1':
                        leerInfoArticulo();
                        break;
                    case '2':
                        mostrarArticulo();
                        break;
                    case '0':
                        volver = true;
                        break;
                    default:
                        throw new OpcionInvalida();
                }
            } catch (OpcionInvalida e){
                System.out.println("Error: " + e.getMessage());
            }
        } while (!volver);
    }

    /**
     * Lee la información de un artículo desde la entrada estándar y lo agrega al sistema.
     */
    private void leerInfoArticulo() {
        try {
            System.out.println("- Inserta el codigo");
            String codigo = input.nextLine();

            if (controlador.articuloExiste(codigo)) {
                throw new ElementoExistente();
            }

            System.out.println("- Inserta la descripcion");
            String descripcion = input.nextLine();

            System.out.println("- Inserta el precio");
            float precio = Float.valueOf(input.nextLine());

            System.out.println("- Inserta los gastos de envio");
            float gastos = Float.valueOf(input.nextLine());

            System.out.println("- Inserta tiempo de preparacion");
            int preparacion = Integer.valueOf(input.nextLine());

            controlador.agregarArticulo(codigo, descripcion, precio, gastos, preparacion);
        }
        catch (ElementoExistente e) {
            System.out.println(e.getMessage());
        } catch (DAOException e) {
            System.out.println(e.getError());
        } catch (java.sql.SQLException e) {
            System.out.println("Error accediendo a la base de datos");
        }

    }

    /**
     * Muestra un artículo en base a su código.
     */
    private void mostrarArticulo() {
        System.out.println("- Inserta el codigo del articulo");
        String codigo = input.nextLine();

        try {
            String articulo = controlador.mostrarArticulo(codigo);

            if (articulo != null) {
                String art = articulo.toString();
                System.out.println(art);
            } else {
                throw new ElementoNoExistente();
            }
        } catch (ElementoNoExistente e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DAOException e) {
            System.out.println(e.getError());
        } catch (java.sql.SQLException e) {
            System.out.println("Error accediendo a la base de datos");
        }
    }

    /**
     * Muestra un menú para la gestión de clientes.
     */
    private void menuCliente() {
        char opcion;
        boolean volver = false;
        do {
            System.out.println("\nMENÚ DE GESTIÓN DE CLIENTE \n");
            System.out.println("1. Añadir cliente");
            System.out.println("2. Mostrar cliente");
            System.out.println("0. Volver al menú");
            opcion = opcionMenu();

            try {
                switch (opcion) {
                    case '1':
                        leerInfoCliente();
                        break;
                    case '2':
                        mostrarCliente();
                        break;
                    case '0':
                        volver = true;
                        break;
                    default:
                        throw new OpcionInvalida();
                }
            } catch (OpcionInvalida e){
                System.out.println("Error: " + e.getMessage());
            }
        } while (!volver);
    }

    /**
     * Lee la información de un cliente desde la entrada estándar y lo agrega al sistema.
     */
    private void leerInfoCliente() {
        try {
            System.out.println("- Inserta el nombre (Nombre y apellidos)");
            String nombre = input.nextLine();

            System.out.println("- Inserta la direccion del domicilio (calle y número, ciudad, provincia)");
            String domicilio = input.nextLine();

            System.out.println("- Inserta el NIF (00000000X)");
            String nif = input.nextLine();

            if (controlador.clienteExiste(nif)){
                throw new ElementoExistente();
            }

            System.out.println("- Inserta el correo electronico");
            String email = input.nextLine();

            System.out.println("- Inserta el tipo de cliente (Estandar o Premium)");
            String tipoStr = input.nextLine().toUpperCase();

            TipoCliente tipo = null; // Inicializa tipo a null

            if (tipoStr.equals("ESTANDAR")) {
                tipo = TipoCliente.ESTANDAR;

                System.out.println("- Inserta el tipo de descuento para cliente estándar");
                Float descuento = Float.valueOf(input.nextLine());

                controlador.agregarCliente(nif, nombre, domicilio, email, tipo, descuento, null);

            } else if (tipoStr.equals("PREMIUM")) {
                tipo = TipoCliente.PREMIUM;

                System.out.println("- Inserta el tipo de descuento para cliente premium");
                Float desc = Float.valueOf(input.nextLine());

                System.out.println("- Inserta la cuota MENSUAL para cliente premium");
                Float cuota = Float.valueOf(input.nextLine());

                controlador.agregarCliente(nif, nombre, domicilio, email, tipo, desc, cuota);

            } else {
                System.out.println("Tipo de cliente no válido.");
            }
        }
        catch (ElementoExistente e) {
            System.out.println(e.getMessage());
        } catch (DAOException e) {
            System.out.println(e.getError());
        } catch (java.sql.SQLException e) {
            System.out.println("Error accediendo a la base de datos");
        }
    }

    /**
     * Muestra un cliente en base a su nif.
     */
    private void mostrarCliente() {
        System.out.println("- Inserta el NIF del cliente ");
        String nif = input.nextLine();

        try {
            String cliente = controlador.mostrarCliente(nif);

            if (cliente != null) {
                String cli = cliente.toString();
                System.out.println(cli);
            } else {
                throw new ElementoNoExistente();
            }
        } catch (ElementoNoExistente e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DAOException e) {
            System.out.println(e.getError());
        } catch (java.sql.SQLException e) {
            System.out.println("Error accediendo a la base de datos");
        }
    }

    /**
     * Menú de gestión de pedidos que permite al usuario agregar, eliminar y listar pedidos.
     * Proporciona opciones para gestionar pedidos y volver al menú principal.
     */
    private void menuPedido(){
        char opcion;
        boolean volver = false;
        do {
            System.out.println("\nMENÚ DE GESTIÓN DE PEDIDOS \n");
            System.out.println("1. Agregar Pedido");
            System.out.println("2. Eliminar Pedido");
            System.out.println("3. Listar Pedidos");
            System.out.println("0. Volver al menú principal");
            opcion = opcionMenu();

            try {
                switch (opcion) {
                    case '1':
                        leerInfoPedido();
                        break;
                    case '2':
                        eliminarPedido();
                        break;
                    case '3':
                        menuMostrarPedido();
                        break;
                    case '0':
                        volver = true;
                        break;
                    default:
                        throw new OpcionInvalida();
                }
            } catch (OpcionInvalida e){
                System.out.println("Error: " + e.getMessage());
            }
        } while (!volver);
    }

    /**
     * Menú para mostrar pedidos pendientes, pedidos enviados y listar un pedido por ID.
     * Proporciona opciones para mostrar diferentes tipos de pedidos y volver al menú principal.
     */
    private void menuMostrarPedido(){
        char opcion;
        boolean volver = false;
        do {
            System.out.println("\n1. Mostrar pedidos 'Pendientes'");
            System.out.println("2. Mostrar pedidos 'Enviados'");
            System.out.println("3. Listar Pedido por ID");
            System.out.println("0. Volver al menú principal");
            opcion = opcionMenu();

            try {
                switch (opcion) {
                    case '1':
                        mostrarPedidoPen();
                        break;
                    case '2':
                        mostrarPedidoEnv();
                        break;
                    case '3':
                        mostrarPedido();
                        break;
                    case '0':
                        volver = true;
                        break;
                    default:
                        throw new OpcionInvalida();
                }
            } catch (OpcionInvalida e){
                System.out.println("Error: " + e.getMessage());
            }
        } while (!volver);
    }

    /**
     * Lee la información necesaria para agregar un nuevo pedido.
     * Solicita los datos del pedido, verifica si el ID del pedido ya existe y maneja la excepción ElementoExistente.
     * Luego, agrega el pedido a la base de datos.
     */
    private void leerInfoPedido(){

        try {
            System.out.println("- Inserta el ID del pedido: ");
            int id = input.nextInt();
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String fecha = fechaActual.format(formatter);

            System.out.print("- Inserta el estado del pedido (PENDIENTE/ENVIADO): ");
            String estadoPed = input.nextLine().toUpperCase();

            EstadoPedido estado = null;
            if (estadoPed.equals("PENDIENTE")) {
                estado = EstadoPedido.PENDIENTE;
                controlador.agregarPedido(id, nifCliente, articulo,  cantidad, fecha, estado);
            } else {
                estado = EstadoPedido.ENVIADO;
                controlador.agregarPedido(id, nifCliente, articulo,  cantidad, fecha, estado);
            }
        } catch (ElementoExistente e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Elimina un pedido identificado por su ID.
     * Solicita el ID del pedido al usuario y elimina el pedido si es posible.
     * Muestra un mensaje de éxito o error según el resultado.
     */
    private void eliminarPedido(){
        System.out.println("- Inserta el ID del pedido: ");
        int id = input.nextInt();

        boolean exito = controlador.borrarPedido(id);

        if (exito == true) {
            System.out.println("Pedido eliminado con éxito");
        }else{
            System.out.println("No se ha podido eliminar el pedido, porque ya ha sido enviado");
        }
    }

    /**
     * Muestra la información de un pedido identificado por su ID.
     * Solicita el ID del pedido al usuario y muestra los detalles del pedido si se encuentra en la base de datos.
     */
    private void mostrarPedido(){
        System.out.println("- Inserta el ID del pedido: ");
        int id = input.nextInt();

        try {
            String pedido = controlador.mostrarPedido(id);

            if (pedido != null) {
                String ped = pedido.toString();
                System.out.println(ped);
            }else {
                throw new ElementoNoExistente();
            }
        } catch (ElementoNoExistente e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Muestra la información de los pedidos con estado "PENDIENTE".
     * Obtiene y muestra los detalles de los pedidos pendientes.
     */
    private void mostrarPedidoPen(){
        String pedido = controlador.mostrarPedidoPend();

        if (pedido != null){
            String info = pedido.toString();
            System.out.println(info);
        }
    }

    /**
     * Muestra la información de los pedidos con estado "ENVIADO".
     * Obtiene y muestra los detalles de los pedidos enviados.
     */
    private void mostrarPedidoEnv(){
        String pedido = controlador.mostrarPedidoEnvi();

        if (pedido != null){
            String info = pedido.toString();
            System.out.println(info);
        }
    }

}


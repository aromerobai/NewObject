
package Vista;

import Controlador.Controlador;
import Modelo.TipoCliente;
import NewObject.Excepciones.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que representa la vista de una tienda en línea.
 */
public class Vista {
    Controlador controlador = new Controlador();
    Scanner input = new Scanner(System.in);

    /**
     * Constructor de la vista.
     */
    public Vista() {
    }

    /**
     * Método principal que muestra el menú y permite interactuar con el Controlador.
     */
    public void menu() {

        boolean salir = false;
        char opcion;

        do {
            System.out.println("****INICIO****");
            System.out.println("1. Gestiónar artículo");
            System.out.println("2. Gestiónar cliente");
            System.out.println("3. Gestión pedido");
            System.out.println("0. SALIR");

            opcion = opcionMenu();

            switch (opcion) {
                case '1':
                    menuArticulo();
                case '2':
                    menuCliente();
                case '3':
                    break;
                case '0':
                    salir = true;
                    break;
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
        System.out.println("Escribe el número de una de las opciones: ");
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
            System.out.println("\nMENU DE GESTION DE ARTICULOS \n");
            System.out.println("1. Añadir artículo");
            System.out.println("2. Mostrar artículo");
            System.out.println("0. Volver al menu");
            opcion = opcionMenu();
            switch (opcion) {
                case '1':
                    leerInfoArticulo();
                case '2':
                    mostrarArticulo();
                case '0':
                    volver = true;
                    break;
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
            Float precio = Float.valueOf(input.nextLine());

            System.out.println("- Inserta los gastos de envio");
            Float gastos = Float.valueOf(input.nextLine());

            System.out.println("- Inserta tiempo de preparacion");
            int preparacion = Integer.valueOf(input.nextLine());

            controlador.agregarArticulo(codigo, descripcion, precio, gastos, preparacion);
        }
        catch (ElementoExistente e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Muestra un artículo en base a su código.
     */
    private void mostrarArticulo() {

        System.out.println("- Inserta el codigo del articulo");
        String codigo = input.nextLine();

        String articulo = controlador.mostrarArticulo(codigo);

        if (articulo != null) {
            String art = articulo.toString();
            System.out.println(art);
        } else {
            System.out.println("Articulo no encontrado");
        }
    }

    /**
     * Muestra un menú para la gestión de clientes.
     */
    private void menuCliente() {

        char opcion;
        boolean volver = false;
        do {
            System.out.println("\nMENU DE GESTIÓN DE CLIENTE \n");
            System.out.println("1. Añadir cliente");
            System.out.println("2. Mostrar cliente");
            System.out.println("0. Volver al menú");
            opcion = opcionMenu();
            switch (opcion) {
                case '1':
                    leerInfoCliente();
                case '2':
                    mostrarCliente();
                case '0':
                    volver = true;
                    break;
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

            System.out.println("- Inserta la direccion del domicilio (calle y número, ciudad, provincia");
            String domicilio = input.nextLine();

            System.out.println("- Inserta el NIF (00000000X)");
            String nif = input.nextLine();

            if (controlador.clienteExiste(nif)){
                throw new ElementoExistente();
            }

            System.out.println("\n- Inserta el correo electronico");
            String email = input.nextLine();

            System.out.println("- Inserta el tipo de cliente (Estandar o Premium)");
            String tipoStr = input.nextLine().toUpperCase();

            TipoCliente tipo = null; // Inicializa tipo a null

            if (tipoStr.equals("ESTANDAR")) {
                tipo = TipoCliente.ESTANDAR;

                System.out.println("- Inserta el tipo de descuento para cliente estándar");
                Float descuento = Float.valueOf(input.nextLine());

                controlador.agregarCliente(nombre, domicilio, nif, email, tipo, descuento, null);
            } else if (tipoStr.equals("PREMIUM")) {
                tipo = TipoCliente.PREMIUM;

                System.out.println("- Inserta el tipo de descuento para cliente premium");
                Float desc = Float.valueOf(input.nextLine());

                System.out.println("- Inserta la cuota MENSUAL para cliente premium");
                Float cuota = Float.valueOf(input.nextLine());

                controlador.agregarCliente(nombre, domicilio, nif, email, tipo, desc, cuota);
            } else {
                System.out.println("Tipo de cliente no válido.");
            }
        }
        catch (ElementoExistente e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra un cliente en base a su nif.
     */
    private void mostrarCliente() {
        System.out.println("- Inserta el NIF del cliente ");
        String nif = input.nextLine();

        String cliente = controlador.mostrarCliente(nif);

        if (cliente != null) {
            String cli = cliente.toString();
            System.out.println(cli);
        } else {
            System.out.println("Cliente no registrado");
        }
    }
}


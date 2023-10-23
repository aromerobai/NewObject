package Vista;

import Controlador.Controlador;
import Modelo.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que representa la vista de una tienda en línea.
 */
public class Vista {
    Controlador controlador = new Controlador();

    /**
     * Método principal que muestra el menú y permite interactuar con el Controlador.
     */
    public void menu() {
        boolean salir = false;
        char opcion;

        do {
            System.out.println("1. Gestionar artículo");
            System.out.println("2. Gestionar cliente");
            System.out.println("3. Gestionar pedido");
            System.out.println("0. SALIR");

            opcion = opcionMenu();
            boolean volverArticuloMenu = false;

            switch (opcion) {
                case '1':
                    do {
                        System.out.println("1. Añadir artículo");
                        System.out.println("2. Mostrar artículo");
                        System.out.println("0. Volver al menú");
                        opcion = opcionMenu();
                        switch (opcion) {
                            case '1':
                                agregarArticulo();
                                break;
                            case '2':
                                mostrarArticulo();
                                break;
                            case '0':
                                volverArticuloMenu = true;
                                break;
                        }
                    } while (!volverArticuloMenu);
                    break;
                case '2':
                    do {
                        System.out.println("1. Añadir Cliente");
                        System.out.println("2. Mostrar cliente");
                        System.out.println("0. Volver al menú");
                        opcion = opcionMenu();
                        switch (opcion) {
                            case '1':
                                agregarCliente();
                                break;
                            case '2':
                                mostrarCliente();
                                break;
                            case '0':
                                volverArticuloMenu = true;
                                break;
                        }
                    } while (!volverArticuloMenu);
                    break;
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
     * Agrega un artículo al sistema.
     */
    private void agregarArticulo() {
        Articulo articulo = new Articulo();

        System.out.println("- Inserta el código");
        Scanner cod = new Scanner(System.in);
        articulo.setCodigo(cod.nextLine());

        System.out.println("- Inserta la descripción");
        Scanner des = new Scanner(System.in);
        articulo.setDescripcion(des.nextLine());

        System.out.println("- Inserta el precio");
        Scanner pre = new Scanner(System.in);
        articulo.setPrecio(Float.valueOf(pre.nextLine()));

        System.out.println("- Inserta los gastos de envío");
        Scanner gas = new Scanner(System.in);
        articulo.setGastosEnvio(Float.valueOf(gas.nextLine()));

        System.out.println("- Inserta tiempo de preparación");
        Scanner prepa = new Scanner(System.in);
        articulo.setPreparacion(Integer.valueOf(prepa.nextLine()));

        controlador.agregarArticulo(articulo);
    }

    /**
     * Muestra un artículo en base a su código.
     */
    private void mostrarArticulo() {
        System.out.println("- Inserta el código del artículo");
        Scanner cod = new Scanner(System.in);
        String codigo = cod.nextLine();

        Articulo articulo = controlador.mostrarArticulo(codigo);

        if (articulo != null) {
            String art = articulo.toString();
            System.out.println(art);
        } else {
            System.out.println("Artículo no encontrado");
        }
    }

    /**
     * Agrega un cliente al sistema.
     */
    private void agregarCliente() {
        Cliente cliente = null;

        System.out.println("- Inserta el nombre (Nombre y apellidos)");
        Scanner nom = new Scanner(System.in);
        cliente.setNombre(nom.nextLine());

        System.out.println("- Inserta el domicilio");
        Scanner dom = new Scanner(System.in);
        cliente.setDomicilio(dom.nextLine());

        System.out.println("- Inserta el NIF");
        Scanner nif = new Scanner(System.in);
        cliente.setNif(nif.nextLine());

        System.out.println("- Inserta el correo electronico");
        Scanner ema = new Scanner(System.in);
        cliente.setEmail(ema.nextLine());

        System.out.println("- Inserta el tipo de cliente (Estandar o Premium)");
        Scanner tip = new Scanner(System.in);
        cliente.setTipo(TipoCliente.valueOf(tip.nextLine().toUpperCase()));

            // Añadir atributos adicionales según el tipo de cliente
        if (cliente.getTipo() == TipoCliente.ESTANDAR) {
            Estandar estandar = new Estandar();
            System.out.println("- Inserta el descuento para cliente estándar");
            Scanner desc = new Scanner(System.in);
            estandar.setDescuento(Float.valueOf(desc.nextLine()));
            cliente = estandar;

        } else if (cliente.getTipo() == TipoCliente.PREMIUM) {
            Premium premium = new Premium();
            System.out.println("- Inserta el descuento para cliente premium");
            Scanner desc = new Scanner(System.in);
            premium.setDescuento(Float.valueOf(desc.nextLine()));
            System.out.println("- Inserta la cuota para cliente premium");
            Scanner cuo = new Scanner(System.in);
            premium.setCuota(Float.valueOf(cuo.nextLine()));
            cliente = premium;
        }
        controlador.agregarCliente(cliente);
    }

    /**
     * Muestra un cliente en base a su nif.
     */
    private void mostrarCliente() {
        System.out.println("- Inserta el NIF del cliente ");
        Scanner nf = new Scanner(System.in);
        String nif = nf.nextLine();

        Cliente cliente = controlador.mostrarCliente(nif);

        if (cliente != null) {
            String cli = cliente.toString();
            System.out.println(cli);
        } else {
            System.out.println("Cliente no registrado");
        }
    }

}

package Vista;

import Controlador.Controlador;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que representa la vista de una tienda en línea.
 */
public class Vista {
    Controlador controlador = new Controlador();
    Scanner input = new Scanner(System.in);

    public Vista() {}

    /**
     * Método principal que muestra el menú y permite interactuar con el Controlador.
     */
    public void menu() {

        boolean salir = false;
        char opcion;

        do{
            System.out.println("1. Gestiónar artículo");
            System.out.println("2. Gestiónar cliente");
            System.out.println("3. Gestión pedido");
            System.out.println("0. SALIR");

            opcion = opcionMenu();

            switch (opcion){
             case '1':
                 menuArticulo();
                 break;
             case '2':
                 break;
             case '3':
                 break;
             case '0':
                 salir = true;
                 break;
            }
         }while(!salir);
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

    private void menuArticulo(){
        char opcion;
        boolean volver = false;
        do {
            System.out.println("MENU DE GESTION DE ARTICULOS \n");
            System.out.println("1. Añadir artículo");
            System.out.println("2. Mostrar artículo");
            System.out.println("0. Volver al menu");
            opcion = opcionMenu();
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
            }
        }while (!volver);
    }

    private void leerInfoArticulo() {
        System.out.println("- Inserta el codigo");
        String codigo = input.nextLine();

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

    private void mostrarArticulo() {

        System.out.println("- Inserta el codigo del articulo");
        String codigo = input.nextLine();

        String articulo = controlador.mostrarArticulo(codigo);

        if(articulo != null){
            String art = articulo.toString();
            System.out.println(art);
        }else{
            System.out.println("Articulo no encontrado");
        }
    }

    /**
     * Agrega un cliente al sistema.
     */
    /*private void agregarCliente() {
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
*/

    /**
     * Muestra un cliente en base a su nif.
     */
/*    private void mostrarCliente() {
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
*/

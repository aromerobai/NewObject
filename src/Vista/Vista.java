
package Vista;

import Controlador.Controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Vista {

    //Creamos el controlador
    Controlador controlador = new Controlador();
    Scanner input = new Scanner(System.in);

    //Creadora

    public Vista() {
    }

    public void menu() {

        boolean salir = false;
        char opcion;
        //Muestra el menu e interactua con el Controlador.

          do{
            System.out.println("1. Gestionar artículo");
            System.out.println("2. Gestionar cliente");
            System.out.println("3. Gestion pedido");
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

    char opcionMenu(){
        Scanner entrada  = new Scanner(System.in);
        System.out.println("Escribe el numero de una de las opciones: ");
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
}

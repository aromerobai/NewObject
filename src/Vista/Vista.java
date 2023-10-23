
package Vista;

import Controlador.Controlador;
import Modelo.Articulo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Vista {

    //Creamos el controlador
    Controlador controlador = new Controlador();

    public void menu() {

        boolean salir = false;
        char opcion;
        //Muestra el menu e interactua con el Controlador.

        do{
            System.out.println("1. Gestiónar artículo");
            System.out.println("2. Gestiónar cliente");
            System.out.println("3. Gestión pedido");
            System.out.println("0. SALIR");

            opcion = opcionMenu();
            boolean volverArticuloMenu = false;

            switch (opcion){
             case '1':
                 do {
                     System.out.println("1. Añadir artículo");
                     System.out.println("2. Mostrar artículo");
                     System.out.println("0. Volver al menu");
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
                 }while (!volverArticuloMenu);
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

    private void agregarArticulo() {
        Articulo articulo = new Articulo();

        System.out.println("- Inserta el codigo");
        Scanner cod = new Scanner(System.in);
        articulo.setCodigo(cod.nextLine());

        System.out.println("- Inserta la descripcion");
        Scanner des = new Scanner(System.in);
        articulo.setDescripcion(des.nextLine());

        System.out.println("- Inserta el precio");
        Scanner pre = new Scanner(System.in);
        articulo.setPrecio(Float.valueOf(pre.nextLine()));

        System.out.println("- Inserta los gastos de envio");
        Scanner gas = new Scanner(System.in);
        articulo.setGastosEnvio(Float.valueOf(gas.nextLine()));

        System.out.println("- Inserta tiempo de preparacion");
        Scanner prepa = new Scanner(System.in);
        articulo.setPreparacion(Integer.valueOf(prepa.nextLine()));

        controlador.agregarArticulo(articulo);
    }

    private void mostrarArticulo() {

        System.out.println("- Inserta el codigo del articulo");
        Scanner cod = new Scanner(System.in);
        String codigo = cod.nextLine();

        Articulo articulo = controlador.mostrarArticulo(codigo);
        if(articulo != null){
            String art = articulo.toString();
            System.out.println(art);
        }else{
            System.out.println("Articulo no encontrado");
        }
    }
}


package Vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Vista {

    public void menu() {

             boolean salir = false;
             char opcion;

        //Muestra el menu e interactua con el Controlador.
             do{
                 System.out.println("1. Gestiónar articulos");
                 System.out.println("2. Gestiónar clientes");
                 System.out.println("3. Gestionar pedidos");
                 System.out.println("0. SALIR");



             opcion = opcionMenu();

             switch (opcion){
                 case '1':
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
}

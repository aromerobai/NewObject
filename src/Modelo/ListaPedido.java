package Modelo;

import java.util.ArrayList;

/**
 * La clase ListaPedido representa una lista de pedidos en una tienda en línea.
 */
public class ListaPedido extends Lista{

    private ArrayList<Pedido> pedidos;

    /**
     * Constructor por defecto de ListaPedido.
     * Donde se inicializa la clase ListaPedido.
     */
    public ListaPedido(){
        this.pedidos = new ArrayList<Pedido>();
    }

    /**
     * Agrega un pedido a la lista.
     *
     * @param pedido El pedido a agregar a la lista.
     */
    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    /**
     * Obtiene la lista de pedidos.
     *
     * @return La lista de pedidos.
     */
    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }

    /**
     * Borra un pedido de la lista por su ID.
     *
     * @param id El ID del pedido a borrar.
     */
    public void borrarPedido(Integer id){
        // Implementar lógica para borrar un pedido por su ID.
    }

    /**
     * Retorna una representación en forma de cadena de la lista de pedidos.
     *
     * @return Una cadena que representa la lista de pedidos.
     */
    @Override
    public String toString() {
        return "ListaPedido{" +
                "pedidos= " + pedidos +
                " }";
    }

    /*
    package NewObject.Modelo;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class ListaPedido {

    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void eliminarPedido(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                pedidos.remove(pedido);
                break;
            }
        }
    }

    public void listarPedidos() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    public void gestionarPedidos() {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            System.out.println("1. Agregar Pedido");
            System.out.println("2. Eliminar Pedido");
            System.out.println("3. Listar Pedidos");
            System.out.println("0. Volver al menú principal");

            char opcion = scanner.next().charAt(0);

            switch (opcion) {
                case '1':
                    // Lógica para agregar un pedido
                    Pedido nuevoPedido = crearPedidoDesdeInputUsuario();
                    agregarPedido(nuevoPedido);
                    break;
                case '2':
                    // Lógica para eliminar un pedido
                    System.out.println("Ingrese el ID del pedido a eliminar:");
                    int idAEliminar = scanner.nextInt();
                    eliminarPedido(idAEliminar);
                    break;
                case '3':
                    // Lógica para listar pedidos
                    listarPedidosPorEstado();
                    break;
                case '0':
                    salir = true; // Volver al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }

    private Pedido crearPedidoDesdeInputUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Agregando un nuevo pedido:");
        System.out.print("Ingrese el ID del pedido: ");
        int id = scanner.nextInt();

        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();

        scanner.nextLine(); // Consumir la nueva línea pendiente

        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = scanner.nextLine();

        System.out.print("Ingrese el nombre del artículo: ");
        String articulo = scanner.nextLine();

        LocalDateTime fecha = LocalDateTime.now();

        System.out.print("Ingrese el estado (PENDIENTE/ENVIADO): ");
        EstadoPedido estado = EstadoPedido.valueOf(scanner.next().toUpperCase());

        Pedido nuevoPedido = new Pedido();
        nuevoPedido.setId(id);
        nuevoPedido.setCliente(cliente);
        nuevoPedido.setArticulo(articulo);
        nuevoPedido.setCantidad(cantidad);
        nuevoPedido.setFecha(fecha);
        nuevoPedido.setEstado(estado);

        return nuevoPedido;
    }

    private void listarPedidosPorEstado() {
        boolean subMenu = true;
        Scanner scanner = new Scanner(System.in);
        while (subMenu) {
            System.out.println("1. Listar pedidos Pendientes");
            System.out.println("2. Listar pedidos Enviados");
            System.out.println("0. Volver al menú anterior");

            char subOpcion = scanner.next().charAt(0);

            switch (subOpcion) {
                case '1':
                    listarPedidosPorEstado(EstadoPedido.PENDIENTE);
                    break;
                case '2':
                    listarPedidosPorEstado(EstadoPedido.ENVIADO);
                    break;
                case '0':
                    subMenu = false;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }

    private void listarPedidosPorEstado(EstadoPedido estado) {
        ArrayList<Pedido> pedidosFiltrados = obtenerPedidosPorEstado(estado);

        if (pedidosFiltrados.isEmpty()) {
            System.out.println("No hay pedidos con estado " + estado + ".");
        } else {
            for (Pedido pedido : pedidosFiltrados) {
                System.out.println(pedido);
            }
        }
    }

    private ArrayList<Pedido> obtenerPedidosPorEstado(EstadoPedido estado) {
        ArrayList<Pedido> pedidosFiltrados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado() == estado) {
                pedidosFiltrados.add(pedido);
            }
        }
        return pedidosFiltrados;
    }
}
     */
}
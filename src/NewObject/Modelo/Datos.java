package NewObject.Modelo;

import NewObject.Controlador.ConexionDB;
import NewObject.DAO.ArticuloDAO;
import NewObject.DAO.ClienteDAO;
import NewObject.DAO.DAOFactory;
import NewObject.DAO.PedidoDAO;
import NewObject.DAO.mysql.MysqlDAOFactory;
import NewObject.Excepciones.DAOException;

import java.sql.Connection;
import java.sql.SQLException;



/**
 * Clase que representa el modelo de datos de una tienda en línea.
 */
public class Datos {
    private ConexionDB conexionDB = new ConexionDB();
    public static Connection conexionMain;
    DAOFactory mysqlFactory;
    ArticuloDAO articuloDAO;
    ClienteDAO clienteDAO;
    PedidoDAO pedidoDAO;
    private ListaArticulo articulos;
    private ListaPedido pedidos;
    private ListaCliente clientes;

    /**
     * Constructor por defecto de Datos.
     */
    public Datos() {

        conexionMain = conexionDB.getConnection();
        mysqlFactory = new MysqlDAOFactory();
        articuloDAO = mysqlFactory.getArticuloDAO();
        clienteDAO = mysqlFactory.getClienteDAO();
        pedidoDAO = mysqlFactory.getPedidoDAO();

        this.articulos = new ListaArticulo();
        this.pedidos = new ListaPedido();
        this.clientes = new ListaCliente();
    }

    /**
     * Agrega un artículo al modelo de datos.
     *
     * @param codigo       El código del artículo.
     * @param descripcion  La descripción del artículo.
     * @param precio       El precio del artículo.
     * @param gastos       Los gastos asociados al artículo.
     * @param preparacion  El tiempo de preparación del artículo en minutos.
     */
    public void agregarArticulo(String codigo, String descripcion, Float precio, Float gastos, int preparacion) throws DAOException, SQLException {
        Articulo articulo = new Articulo(codigo, descripcion, precio, gastos, preparacion);
        articuloDAO.insertar(articulo);
    }

    /**
     * Obtiene la lista de artículos del modelo de datos.
     *
     * @return La lista de artículos.
     */
    public String getArticulo(String codigo) throws DAOException, SQLException {
        String nombreArticulo = null;
        nombreArticulo = articuloDAO.listarUno(codigo).toString();

        return nombreArticulo;
    }
    /**
     * Comprueba si existe un artículo en la lista de artículos a través de su código.
     *
     * @param codigo El código del artículo a verificar.
     * @return true si el artículo con el código dado existe en la lista, false en caso contrario.
     */
    public boolean existeArticulo(String codigo) throws SQLException {
        return articuloDAO.existe(codigo);
    }

    /**
     * Agrega un cliente al modelo de datos.
     *
     * @param nombre    El nombre del cliente.
     * @param domicilio La dirección del cliente.
     * @param nif       El NIF del cliente.
     * @param email     El correo electrónico del cliente.
     * @param tipo      El tipo de cliente (PREMIUM o ESTANDAR).
     * @param descuento El descuento aplicable al cliente (solo para clientes PREMIUM).
     * @param cuota     La cuota mensual (solo para clientes PREMIUM).
     */
    public void agregarCliente(String nombre, String domicilio, String nif, String email, TipoCliente tipo, Float descuento, Float cuota) throws DAOException, SQLException {
        Cliente cliente = null;
        if (tipo == TipoCliente.PREMIUM) {
            cliente = new Premium(nif, nombre, domicilio,  email, tipo, descuento, cuota);
        } else {
            cliente = new Estandar(nif, nombre, domicilio, email, tipo, descuento);
        }
        clienteDAO.insertar(cliente);
    }

    /**
     * Obtiene la lista de clientes del modelo de datos.
     *
     * @return La lista de clientes.
     */
    public String getCliente(String nif) throws DAOException, SQLException {
        String nombreCliente = null;
        nombreCliente = clienteDAO.listarUno(nif).toString();

        return nombreCliente;
    }

    /**
     * Comprueba si existe un cliente en la lista de clientes a través de su NIF.
     *
     * @param nif El NIF del cliente a verificar.
     * @return true si el cliente con el NIF dado existe en la lista, false en caso contrario.
     */
    public boolean existeCliente(String nif) throws SQLException {
        return clienteDAO.existe(nif);
    }

    /**
     * Agrega un pedido al modelo de datos.
     *
     * @param id      El ID del pedido.
     * @param cliente El NIF del cliente que realiza el pedido.
     * @param articulo El código del artículo solicitado en el pedido.
     * @param cantidad La cantidad de unidades del artículo solicitado.
     * @param fecha   La fecha en que se realiza el pedido.
     * @param estado  El estado del pedido (ENVIADO o PENDIENTE).
     */

    public void agregarPedido(int id,  String cliente, String articulo, int cantidad, String fecha, EstadoPedido estado) throws DAOException, SQLException {
        Cliente cli = null;
        Articulo art = null;

        cli = clienteDAO.listarUno(cliente);
        art = articuloDAO.listarUno(articulo);

        if (cli == null){
            System.out.println("No existe el cliente seleccionado");
        }else if (art == null){
            System.out.println("No existe el articulo seleccionado");
        }else{
            Pedido newPedido = new Pedido(id, cli, art, cantidad, fecha, estado);
            pedidoDAO.insertar(newPedido);
        }
    }

    /**
     * Obtiene la lista de pedidos del modelo de datos.
     *
     * @return La lista de pedidos.
     */
    public String getPedido(int id) throws DAOException, SQLException {
        String pedido = pedidoDAO.listarUno(String.valueOf(id)).toString();
        return pedido;
    }

    /**
     * Obtiene la información de los pedidos pendientes.
     *
     * @return Una cadena que contiene información sobre los pedidos pendientes.
     */
    public String getPedidoPend() throws DAOException, SQLException {
        String pedido = pedidoDAO.listarTodosEstado("PENDIENTE");
        return pedido;
    }

    /**
     * Obtiene la información de los pedidos enviados.
     *
     * @return Una cadena que contiene información sobre los pedidos enviados.
     */
    public String getPedidoEnvi() throws DAOException, SQLException {
        String pedido = pedidoDAO.listarTodosEstado("ENVIADO");
        return pedido;
    }

    /**
     * Borra un pedido del modelo de datos basado en su ID.
     *
     * @param id El ID del pedido a borrar.
     */
    public boolean borrarPedido(Integer id) {
        boolean exito = true;
        try {
            pedidoDAO.eliminar(String.valueOf(id));
            return exito;
        } catch (DAOException e) {
            exito = false;
            return exito;
        } catch (SQLException e) {
            exito = false;
            return exito;
        }
    }


    /**
     * Comprueba si existe un pedido en el modelo de datos a través de su número de pedido.
     *
     * @param num El número de pedido a verificar.
     * @return true si el pedido con el número dado existe en el modelo de datos, false en caso contrario.
     */
    public boolean existePedido(int num) {
        return pedidos.compruebaExistenciaPedido(num);
    }
}

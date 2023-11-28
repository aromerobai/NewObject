package NewObject.DAO.mysql;

import NewObject.DAO.ArticuloDAO;
import NewObject.DAO.ClienteDAO;
import NewObject.DAO.DAOFactory;
import NewObject.DAO.PedidoDAO;
import NewObject.Excepciones.DAOException;
import NewObject.Modelo.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Implementación concreta de PedidoDAO para manejar pedidos en una base de datos MySQL.
 */
public class MysqlPedidoDAO implements PedidoDAO {
    DAOFactory mysqlFactory;
    ArticuloDAO articuloDAO;
    ClienteDAO clienteDAO;

    /**
     * Constructor que inicializa instancias de los DAO relacionados para manejar pedidos.
     */
    public MysqlPedidoDAO(){
        mysqlFactory = new MysqlDAOFactory();
        articuloDAO = mysqlFactory.getArticuloDAO();
        clienteDAO = mysqlFactory.getClienteDAO();
    }
    final String INSERT = "INSERT INTO pedido(idPedido, idArticulo, Cliente_nif, cantidad, fecha, estado) VALUES(?,?,?,?,?,?)";
    final String SELECTBYID = "SELECT * FROM pedido WHERE idPedido = ?";
    final String SELECTPENDIENTES = "SELECT * FROM pedido WHERE estado = ?";
    final String DELETE = "DELETE FROM pedido WHERE idPedido = ?";
    final String EXISTE = "SELECT 1 FROM pedido WHERE idPedido = ?";

    /**
     * Inserta un pedido en la base de datos.
     *
     * @param pedido El pedido a insertar.
     * @throws DAOException Si ocurre un error relacionado con el DAO.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @Override
    public void insertar(Pedido pedido) throws DAOException, SQLException {
        try(PreparedStatement stat = Datos.conexionMain.prepareStatement(INSERT)) {
            java.sql.Date fechaSQL = null;
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            try {
                Date fechaConvertidaUtil = formatter.parse(pedido.getFecha());
                 fechaSQL = new java.sql.Date(fechaConvertidaUtil.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            stat.setString(1, pedido.getId().toString());
            stat.setString(2, pedido.getArticulo().getCodigo());
            stat.setString(3, pedido.getCliente().getNif());
            stat.setString(4, pedido.getCantidad().toString());
            stat.setDate(5, fechaSQL);
            stat.setString(6, pedido.getEstado().toString());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que el INSERT NO haya creado el artículo");
            }
        }
    }

    @Override
    public void modificar(Pedido pedido) throws DAOException, SQLException {

    }

    /**
     * Elimina un pedido de la base de datos por su identificador.
     *
     * @param idPedido El identificador del pedido a eliminar.
     * @throws DAOException Si ocurre un error relacionado con el DAO.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @Override
    public void eliminar(String idPedido) throws DAOException, SQLException {
        try (PreparedStatement stat = Datos.conexionMain.prepareStatement(DELETE)) {
            stat.setString(1,idPedido);
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que DELETE NO haya BORRADO el artículo");
            }
        }
    }

    @Override
    public List<Pedido> listarTodos() throws DAOException, SQLException {
        return null;
    }

    /**
     * Obtiene un pedido de la base de datos por su identificador.
     *
     * @param id El identificador del pedido.
     * @return El pedido obtenido.
     * @throws DAOException Si ocurre un error relacionado con el DAO.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @Override
    public Pedido listarUno(String id) throws DAOException, SQLException {
        Pedido pedido = null;
        try(PreparedStatement stat = Datos.conexionMain.prepareStatement(SELECTBYID)) {
            stat.setString(1, id);
            try(ResultSet rs = stat.executeQuery()) {
                if (rs.next()) {
                    pedido = convertir(rs);
                } else {
                    throw new DAOException("NO se ha encontrado ese REGISTRO.");
                }
            }
        }
        return pedido;
    }

    /**
     * Obtiene todos los pedidos con un estado específico.
     *
     * @param tipo El estado de los pedidos a obtener.
     * @return Una representación en texto de los pedidos con el estado especificado.
     * @throws DAOException Si ocurre un error relacionado con el DAO.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @Override
    public String listarTodosEstado(String tipo) throws DAOException, SQLException {
        String todosLosPedido = "";
        try (PreparedStatement stat = Datos.conexionMain.prepareStatement(SELECTPENDIENTES)) {
            stat.setString(1, tipo);
            try (ResultSet rs = stat.executeQuery()) {
                while (rs.next()) {
                    Pedido pedido = convertir(rs);
                    todosLosPedido = todosLosPedido + pedido.toString();
                }
            }
        }
        return todosLosPedido;
    }

    /**
     * Verifica si un pedido existe en la base de datos por su identificador.
     *
     * @param idPedido El identificador del pedido a verificar.
     * @return True si el pedido existe, de lo contrario False.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @Override
    public boolean existe(String idPedido) throws SQLException {
        try(PreparedStatement stat = Datos.conexionMain.prepareStatement(EXISTE)) {
            stat.setString(1, idPedido);
            try (ResultSet rs = stat.executeQuery()) {
                return rs.next();
            }
        }
    }

    /**
     * Convierte un ResultSet en un objeto Pedido.
     *
     * @param rs El ResultSet que contiene los datos del pedido.
     * @return El objeto Pedido obtenido del ResultSet.
     * @throws SQLException   Si ocurre un error de SQL.
     * @throws DAOException   Si ocurre un error relacionado con el DAO.
     */
    private Pedido convertir(ResultSet rs) throws SQLException, DAOException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String idPedido = rs.getString("idPedido");
        int idPedidoInt = Integer.parseInt(idPedido);
        String idArticulo = rs.getString("idArticulo");
        String Cliente_nif = rs.getString("Cliente_nif");
        String cantidad = rs.getString("cantidad");
        int idCantidadInt = Integer.parseInt(cantidad);

        String fechaComoString = formatter.format(rs.getDate("fecha"));

        String estado = rs.getString("estado");
        EstadoPedido estadoPedido = EstadoPedido.valueOf(estado.toUpperCase());

        Cliente cli = null;
        Articulo art = null;

        cli = clienteDAO.listarUno(Cliente_nif);
        art = articuloDAO.listarUno(idArticulo);

        Pedido pedido = new Pedido(idPedidoInt, cli, art, idCantidadInt, fechaComoString, estadoPedido);
        return pedido;
    }
}

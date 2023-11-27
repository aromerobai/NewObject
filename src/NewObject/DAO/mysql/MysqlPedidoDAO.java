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

public class MysqlPedidoDAO implements PedidoDAO {
    DAOFactory mysqlFactory;
    ArticuloDAO articuloDAO;
    ClienteDAO clienteDAO;

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
    @Override
    public boolean existe(String idPedido) throws SQLException {
        try(PreparedStatement stat = Datos.conexionMain.prepareStatement(EXISTE)) {
            stat.setString(1, idPedido);
            try (ResultSet rs = stat.executeQuery()) {
                return rs.next();
            }
        }
    }


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

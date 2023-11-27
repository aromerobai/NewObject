package NewObject.DAO.mysql;

import NewObject.Controlador.ConexionDB;
import NewObject.DAO.ClienteDAO;
import NewObject.Excepciones.DAOException;
import NewObject.Modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MysqlClienteDAO implements ClienteDAO {

    private ConexionDB conexionDB = new ConexionDB();
    private Connection conn;
    final String INSERT = "INSERT INTO cliente(nif, nombre, domicilio, email, tipo, descuento, cuota) VALUES(?,?,?,?,?,?,?)";
    final String SELECTBYNIF = "SELECT nif, nombre, domicilio, email, tipo, descuento, cuota FROM cliente WHERE nif = ?";
    final String EXISTE = "SELECT 1 FROM cliente WHERE nif = ?";

    public MysqlClienteDAO(){
        conn = conexionDB.getConnection();
    }

    @Override
    public void insertar(Cliente cliente) throws DAOException, SQLException {
        try(PreparedStatement stat = conn.prepareStatement(INSERT)) {
            stat.setString(1, cliente.getNif());
            stat.setString(2, cliente.getNombre());
            stat.setString(3, cliente.getDomicilio());
            stat.setString(4, cliente.getEmail());
            stat.setString(5, cliente.tipoCliente());

            TipoCliente tipoCliente = cliente.getTipo();
            if (tipoCliente == TipoCliente.ESTANDAR) {
                if (cliente instanceof Estandar) {
                    stat.setFloat(6, ((Estandar) cliente).getDescuento());
                }
            } else if (tipoCliente == TipoCliente.PREMIUM) {
                if (cliente instanceof Premium) {
                    stat.setFloat(6,((Premium) cliente).getDescuento());
                    stat.setFloat(7, ((Premium) cliente).getCuota());
                }
            }

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que el INSERT NO haya creado el cliente");
            }
        }
    }

    @Override
    public void modificar(Cliente cliente) throws DAOException, SQLException {

    }

    @Override
    public void eliminar(Cliente cliente) throws DAOException, SQLException {

    }

    @Override
    public List<Cliente> listarTodos() throws DAOException, SQLException {
        return null;
    }

    @Override
    public Cliente listarUno(String nif) throws DAOException, SQLException {
        Cliente cliente = null;
        try(PreparedStatement stat = conn.prepareStatement(SELECTBYNIF)) {
            stat.setString(1, nif);
            try(ResultSet rs = stat.executeQuery()) {
                if (rs.next()) {
                    cliente = convertir(rs);
                } else {
                    throw new DAOException("NO se ha encontrado ese REGISTRO.");
                }
            }
        }
        return cliente;
    }

    @Override
    public boolean existe(String nif) throws SQLException {
        try(PreparedStatement stat = conn.prepareStatement(EXISTE)) {
            stat.setString(1, nif);
            try (ResultSet rs = stat.executeQuery()) {
                return rs.next();
            }
        }
    }

    private Cliente convertir(ResultSet rs) throws SQLException {
        String nif = rs.getString("nif");
        String nombre = rs.getString("nombre");
        String domicilio = rs.getString("domicilio");
        String email = rs.getString("email");
        String tipoCliente = rs.getString("tipoCliente");
        Float descuento = rs.getFloat("descuento");
        Float cuota = rs.getFloat("cuota");

        Cliente cliente = null;
        if (TipoCliente.ESTANDAR.name().equals(tipoCliente))  {
            cliente =  new Estandar(nif, nombre, domicilio, email, TipoCliente.ESTANDAR, descuento);
        } else if (TipoCliente.PREMIUM.name().equals(tipoCliente)){
            cliente = new Premium(nif, nombre, domicilio,  email, TipoCliente.PREMIUM, descuento, cuota);
        }

        return cliente;
    }
}

package NewObject.DAO.mysql;


import NewObject.DAO.ClienteDAO;
import NewObject.Excepciones.DAOException;
import NewObject.Modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Implementación concreta de ClienteDAO para manejar clientes en una base de datos MySQL.
 */
public class MysqlClienteDAO implements ClienteDAO {
    final String INSERT = "INSERT INTO cliente(nif, nombre, domicilio, email, tipo, descuento, cuota) VALUES(?,?,?,?,?,?,?)";
    final String SELECTBYNIF = "SELECT nif, nombre, domicilio, email, tipo, descuento, cuota FROM cliente WHERE nif = ?";
    final String EXISTE = "SELECT 1 FROM cliente WHERE nif = ?";

    /**
     * Inserta un nuevo cliente en la base de datos.
     *
     * @param cliente El cliente a insertar.
     * @throws DAOException Si ocurre un error relacionado con el DAO.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @Override
    public void insertar(Cliente cliente) throws DAOException, SQLException {
        try(PreparedStatement stat = Datos.conexionMain.prepareStatement(INSERT)) {
            stat.setString(1, cliente.getNif());
            stat.setString(2, cliente.getNombre());
            stat.setString(3, cliente.getDomicilio());
            stat.setString(4, cliente.getEmail());
            stat.setString(5, cliente.tipoCliente());

            TipoCliente tipoCliente = cliente.getTipo();

            if (tipoCliente == TipoCliente.ESTANDAR) {
                if (cliente instanceof Estandar) {
                    stat.setFloat(6, ((Estandar) cliente).getDescuento());
                    stat.setFloat(7, 0.0f);
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
    public void eliminar(String idCliente) throws DAOException, SQLException {

    }

    @Override
    public List<Cliente> listarTodos() throws DAOException, SQLException {
        return null;
    }

    /**
     * Obtiene un cliente de la base de datos por su número de identificación fiscal (NIF).
     *
     * @param nif El número de identificación fiscal del cliente a obtener.
     * @return El cliente encontrado.
     * @throws DAOException Si ocurre un error relacionado con el DAO.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @Override
    public Cliente listarUno(String nif) throws DAOException, SQLException {
        Cliente cliente = null;
        try(PreparedStatement stat = Datos.conexionMain.prepareStatement(SELECTBYNIF)) {
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

    /**
     * Verifica si un cliente existe en la base de datos por su número de identificación fiscal (NIF).
     *
     * @param nif El número de identificación fiscal del cliente a verificar.
     * @return True si el cliente existe, de lo contrario False.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @Override
    public boolean existe(String nif) throws SQLException {
        try(PreparedStatement stat = Datos.conexionMain.prepareStatement(EXISTE)) {
            stat.setString(1, nif);
            try (ResultSet rs = stat.executeQuery()) {
                return rs.next();
            }
        }
    }

    /**
     * Convierte un ResultSet en un objeto de tipo Cliente.
     *
     * @param rs El ResultSet que contiene los datos del cliente.
     * @return El cliente convertido desde el ResultSet.
     * @throws SQLException Si ocurre un error de SQL.
     */
    private Cliente convertir(ResultSet rs) throws SQLException {
        String nif = rs.getString("nif");
        String nombre = rs.getString("nombre");
        String domicilio = rs.getString("domicilio");
        String email = rs.getString("email");
        String tipo = rs.getString("tipo");
        Float descuento = rs.getFloat("descuento");
        Float cuota = rs.getFloat("cuota");

        Cliente cliente = null;
        if (tipo.equals("Estandar"))  {
            cliente =  new Estandar( nombre, domicilio, nif, email, TipoCliente.ESTANDAR, descuento);
        } else if (tipo.equals("Premium")){
            cliente = new Premium( nombre, domicilio,nif,  email, TipoCliente.PREMIUM, descuento, cuota);
        }

        return cliente;
    }
}

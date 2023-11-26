package NewObject.DAO.mysql;

import NewObject.DAO.ClienteDAO;
import NewObject.Excepciones.DAOException;
import NewObject.Modelo.Cliente;

import java.sql.SQLException;
import java.util.List;

public class MysqlClienteDAO implements ClienteDAO {

    @Override
    public void insertar(Cliente cliente) throws DAOException, SQLException {

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
    public Cliente listarUno(String s) throws DAOException, SQLException {
        return null;
    }

    @Override
    public boolean existe(String s) throws SQLException {
        return false;
    }
}

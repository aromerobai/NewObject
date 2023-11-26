package NewObject.DAO.mysql;

import NewObject.DAO.ArticuloDAO;
import NewObject.DAO.ClienteDAO;
import NewObject.Excepciones.DAOException;
import NewObject.Modelo.Articulo;

import java.sql.SQLException;
import java.util.List;

public class MysqlClienteDAO implements ClienteDAO {
    @Override
    public void insertar(Articulo articulo) throws DAOException, SQLException {

    }

    @Override
    public void modificar(Articulo articulo) throws DAOException, SQLException {

    }

    @Override
    public void eliminar(Articulo articulo) throws DAOException, SQLException {

    }

    @Override
    public List<Articulo> listarTodos() throws DAOException, SQLException {
        return null;
    }

    @Override
    public Articulo listarUno(String s) throws DAOException, SQLException {
        return null;
    }

    @Override
    public boolean existe(String s) throws SQLException {
        return false;
    }
}

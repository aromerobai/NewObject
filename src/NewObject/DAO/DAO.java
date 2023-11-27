package NewObject.DAO;

import NewObject.Excepciones.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T, K> {

    void insertar (T t) throws DAOException, SQLException;

    void modificar(T t) throws DAOException, SQLException;

    void eliminar(K k) throws DAOException, SQLException;

    List<T> listarTodos() throws DAOException, SQLException;

    T listarUno(K k) throws DAOException, SQLException;

    boolean existe(K k) throws SQLException;

}

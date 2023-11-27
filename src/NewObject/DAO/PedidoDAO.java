package NewObject.DAO;

import NewObject.Excepciones.DAOException;
import NewObject.Modelo.Pedido;

import java.sql.SQLException;
import java.util.List;

public interface PedidoDAO extends DAO<Pedido, String>{
    String listarTodosEstado(String tipo) throws DAOException, SQLException;
}

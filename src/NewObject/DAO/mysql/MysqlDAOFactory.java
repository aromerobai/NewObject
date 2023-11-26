package NewObject.DAO.mysql;

import NewObject.DAO.ArticuloDAO;
import NewObject.DAO.ClienteDAO;
import NewObject.DAO.DAOFactory;

public class MysqlDAOFactory implements DAOFactory {
    @Override
    public ArticuloDAO getArticuloDAO() {
        return new MysqlArticuloDAO();
    }

    public ClienteDAO getClienteDAO() {
        return new MysqlClienteDAO();
    }
}

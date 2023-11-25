package NewObject.DAO.mysql;

import NewObject.DAO.ArticuloDAO;
import NewObject.DAO.DAOFactory;

public class MysqlDAOFactory implements DAOFactory {
    @Override
    public ArticuloDAO getArticuloDAO() {
        return new MysqlArticuloDAO();
    }
}

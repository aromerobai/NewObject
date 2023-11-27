package NewObject.DAO.mysql;

import NewObject.DAO.ArticuloDAO;
import NewObject.DAO.ClienteDAO;
import NewObject.DAO.DAOFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDAOFactory implements DAOFactory {

    @Override
    public ArticuloDAO getArticuloDAO() {
        return new MysqlArticuloDAO();
    }
    @Override
    public ClienteDAO getClienteDAO() {
        return new MysqlClienteDAO();
    }
}

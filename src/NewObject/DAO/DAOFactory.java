package NewObject.DAO;

/**
 * Interfaz para la factoría de DAO que proporciona métodos para obtener instancias de varios tipos de DAO.
 */
public interface DAOFactory {

        /**
         * Obtiene una instancia del DAO para la gestión de Artículos.
         *
         * @return Instancia del DAO de Artículos
         */
        ArticuloDAO getArticuloDAO();

        /**
         * Obtiene una instancia del DAO para la gestión de Clientes.
         *
         * @return Instancia del DAO de Clientes
         */
        ClienteDAO getClienteDAO();

        /**
         * Obtiene una instancia del DAO para la gestión de Pedidos.
         *
         * @return Instancia del DAO de Pedidos
         */
        PedidoDAO getPedidoDAO();
}
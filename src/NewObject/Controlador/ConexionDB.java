package NewObject.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para establecer y gestionar la conexión a la base de datos.
 */
public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    /**
     * Constructor de la clase que establece la conexión con la base de datos.
     */
    public ConexionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene la conexión actual a la base de datos.
     *
     * @return La conexión a la base de datos.
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Cierra la conexión a la base de datos si está abierta.
     */
    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
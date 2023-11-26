package NewObject.DAO.mysql;

import NewObject.Controlador.ConexionDB;
import NewObject.DAO.ArticuloDAO;
import NewObject.Excepciones.DAOException;
import NewObject.Modelo.Articulo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MysqlArticuloDAO implements ArticuloDAO {
    ConexionDB conexionDB = new ConexionDB();
    final String INSERT = "INSERT INTO articulo(codigo, descripcion, precio, gastoEnvio, preparacion) VALUES(?,?,?,?,?)";
    final String SELECTBYCODIGO = "SELECT codigo, descripcion, precio, gastoEnvio, preparacion FROM articulo WHERE codigo = ?";
    final String EXISTE = "SELECT 1 FROM articulo WHERE codigo = ?";


    @Override
    public void insertar(Articulo articulo) throws DAOException, SQLException {
        try(Connection conn = conexionDB.getConnection()) {
            try(PreparedStatement stat = conn.prepareStatement(INSERT)) {
                stat.setString(1, articulo.getCodigo());
                stat.setString(2, articulo.getDescripcion());
                stat.setFloat(3, articulo.getPrecio());
                stat.setFloat(4, articulo.getGastosEnvio());
                stat.setInt(5, articulo.getPreparacion());

                if (stat.executeUpdate() == 0) {
                    throw new DAOException("Puede que el INSERT NO haya creado el artículo");
                }
            }
        }
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
    public Articulo listarUno(String codigo) throws DAOException, SQLException {
        Articulo articulo = null;
        try (Connection conn = conexionDB.getConnection()) {
            try(PreparedStatement stat = conn.prepareStatement(SELECTBYCODIGO)) {
                stat.setString(1, codigo);
                try(ResultSet rs = stat.executeQuery()) {
                    if (rs.next()) {
                        articulo = convertir(rs);
                    } else {
                        throw new DAOException("NO se ha encontrado ese REGISTRO.");
                    }
                }
            }
        }
        return articulo;
    }

    @Override
    public boolean existe(String codigo) throws SQLException {
        try(Connection conn = conexionDB.getConnection()) {
            try(PreparedStatement stat = conn.prepareStatement(EXISTE)) {
                stat.setString(1, codigo);
                try(ResultSet rs = stat.executeQuery()) {
                    return rs.next();
                }
            }
        }
    }

    private Articulo convertir(ResultSet rs) throws SQLException {
        String codigo = rs.getString("codigo");
        String descripcion = rs.getString("descripcion");
        Float precio = rs.getFloat("precio");
        Float gastoEnvio = rs.getFloat("gastoEnvio");
        int preparacion = rs.getInt("preparacion");
        Articulo articulo = new Articulo(codigo, descripcion, precio, gastoEnvio, preparacion);
        return articulo;
    }
}

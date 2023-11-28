package NewObject.DAO.mysql;

import NewObject.DAO.ArticuloDAO;
import NewObject.Excepciones.DAOException;
import NewObject.Modelo.Articulo;
import NewObject.Modelo.Datos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MysqlArticuloDAO implements ArticuloDAO {

    final String INSERT = "INSERT INTO articulo(codigo, descripcion, precio, gastoEnvio, preparacion) VALUES(?,?,?,?,?)";
    final String SELECTBYCODIGO = "SELECT codigo, descripcion, precio, gastoEnvio, preparacion FROM articulo WHERE codigo = ?";
    final String EXISTE = "SELECT 1 FROM articulo WHERE codigo = ?";

    /**
     * Inserta un nuevo artículo en la base de datos.
     *
     * @param articulo El artículo a insertar.
     * @throws DAOException Si ocurre un error relacionado con el DAO.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @Override
    public void insertar(Articulo articulo) throws DAOException, SQLException {
        try(PreparedStatement stat = Datos.conexionMain.prepareStatement(INSERT)) {
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

    @Override
    public void modificar(Articulo articulo) throws DAOException, SQLException {

    }

    @Override
    public void eliminar(String idArticulo) throws DAOException, SQLException {

    }

    @Override
    public List<Articulo> listarTodos() throws DAOException, SQLException {
        return null;
    }

    /**
     * Obtiene un artículo de la base de datos por su código.
     *
     * @param codigo El código del artículo a obtener.
     * @return El artículo encontrado.
     * @throws DAOException Si ocurre un error relacionado con el DAO.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @Override
    public Articulo listarUno(String codigo) throws DAOException, SQLException {
        Articulo articulo = null;
            try(PreparedStatement stat = Datos.conexionMain.prepareStatement(SELECTBYCODIGO)) {
                stat.setString(1, codigo);
                try(ResultSet rs = stat.executeQuery()) {
                    if (rs.next()) {
                        articulo = convertir(rs);
                    } else {
                        throw new DAOException("NO se ha encontrado ese REGISTRO.");
                    }
                }
        }
        return articulo;
    }

    /**
     * Verifica si un artículo existe en la base de datos por su código.
     *
     * @param codigo El código del artículo a verificar.
     * @return True si el artículo existe, de lo contrario False.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @Override
    public boolean existe(String codigo) throws SQLException {
        try(PreparedStatement stat = Datos.conexionMain.prepareStatement(EXISTE)) {
            stat.setString(1, codigo);
            try (ResultSet rs = stat.executeQuery()) {
                return rs.next();
            }
        }
    }

    /**
     * Convierte un ResultSet en un objeto de tipo Artículo.
     *
     * @param rs El ResultSet que contiene los datos del artículo.
     * @return El artículo convertido desde el ResultSet.
     * @throws SQLException Si ocurre un error de SQL.
     */
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

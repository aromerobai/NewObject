package Modelo;

import javax.persistence.*;

public class Datos {
    ListaArticulo articulos = new ListaArticulo();
    ListaPedido pedidos = new ListaPedido();
    ListaCliente clientes = new ListaCliente();
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    public Datos(){
        //Inicialización del modelo de datos
    }

    public String getArticulo(String codigo){
        try {
            transaction.begin();
            TypedQuery<ArticuloEntity> query = entityManager.createNamedQuery("Articulo.ByCodigo", ArticuloEntity.class);
            query.setParameter(1, codigo);
            ArticuloEntity articulo = query.getSingleResult();
            transaction.commit();
            return  articulo.toString();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }
    public void borrarArticulo(String codigo){
        try {
            transaction.begin();
            Query query = entityManager.createNamedQuery("Articulo.borrarByCodigo");
            query.setParameter(1, codigo);
            query.executeUpdate();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void agregarPedido(Pedido pedido){}
    public ListaPedido getPedido(){return pedidos;}
    public void borrarPedido(Integer id){}


    public void agregarCliente(Cliente cliente){}
    public ListaCliente mostrarCliente(){return clientes;}

    public void agregarArticulo(String codigo, String descripcion, Float precio, Float gastoEnvio, int preparacion) {
        try {
            transaction.begin();
            ArticuloEntity articulo = new ArticuloEntity();
            articulo.setCodigo(codigo);
            articulo.setPrecio(precio);
            articulo.setDescripcion(descripcion);
            articulo.setPreparacion(preparacion);
            articulo.setGastoEnvio(gastoEnvio);
            entityManager.persist(articulo);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }


    @Override
    public String toString() {
        return "Datos{" +
                "articulos=" + articulos +
                ", pedidos=" + pedidos +
                ", clientes=" + clientes +
                '}';
    }
}

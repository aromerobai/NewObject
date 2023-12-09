package Modelo;

import jakarta.persistence.*;

public class Datos {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    public Datos(){
        //Inicialización del modelo de datos
    }

    public String getArticulo(String codigo){
        try {
            transaction.begin();
            TypedQuery<Articulo> query = entityManager.createNamedQuery("Articulo.byCodigo", Articulo.class);
            query.setParameter(1, codigo);
            Articulo articulo = query.getSingleResult();
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
    public void borrarPedido(Integer id){}


    public void agregarCliente(Cliente cliente){}

    public void agregarArticulo(String codigo, String descripcion, Float precio, Float gastoEnvio, int preparacion) {
        try {
            transaction.begin();
            Articulo articulo = new Articulo();
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
}

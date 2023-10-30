package Modelo;

import NewObject.Modelo.ListaArticulo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ListaArticuloTest {

    @Test
    void getArticulo() {
        ListaArticulo listaArticulo = new ListaArticulo();
        listaArticulo.agregarArticulo("111","Descripcion",100.0f,20.0f, 2);
        String resultado = listaArticulo.getArticulo("111");
        String esperado = listaArticulo.getArticulo("111");
        Assertions.assertEquals(esperado,resultado);
    }
}
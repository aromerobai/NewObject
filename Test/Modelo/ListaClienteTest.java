package Modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaClienteTest {

    @Test
    void getCliente() {
        ListaCliente listaCliente = new ListaCliente();
        TipoCliente tipo = TipoCliente.ESTANDAR;
        listaCliente.agregarCliente("Juan","Calle del pez","1222111","juan@gmail.com", tipo, 15.0f, 10.0f);
        String resultado = listaCliente.getCliente("1222111");
        String esperado = listaCliente.getCliente("1222111");
        Assertions.assertEquals(esperado,resultado);
    }
}
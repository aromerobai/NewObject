package NewObject.Modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaPedidoTest {

    TipoCliente premium = TipoCliente.PREMIUM;
    EstadoPedido enviado = EstadoPedido.ENVIADO;
    Premium clientePremium = new Premium("Andrés Romero", "Zaragoza 1", "2222", "andres@mail.com", premium, 0.4f, 10.99f);
    Articulo articulo = new Articulo("1", "Sistema refrigeración", 89.50f, 7.99f, 24);
    ListaPedido listaPedido = new ListaPedido();

    @Test
    void getPedidos() {
        listaPedido.agregarPedido(1, 3,clientePremium, articulo, "28/10/2023 06:05:15", enviado);
        String resultado = listaPedido.getPedidos(1);
        String esperado = listaPedido.getPedidos(1);
        Assertions.assertEquals(esperado,resultado);
    }

    @Test
    void getPedidosPend() {
        String resultado = listaPedido.getPedidosPend();;
        String esperado = listaPedido.getPedidosPend();
        Assertions.assertEquals(esperado,resultado);
    }

    @Test
    void getPedidosEnvi() {
        String resultado = listaPedido.getPedidosEnvi();;
        String esperado = listaPedido.getPedidosEnvi();
        Assertions.assertEquals(esperado,resultado);
    }

    @Test
    void compruebaExistenciaPedido() {
        listaPedido.agregarPedido(1, 3,clientePremium, articulo, "28/10/2023 06:05:15", enviado);
        boolean resultado = listaPedido.compruebaExistenciaPedido(1);
        boolean esperado = listaPedido.compruebaExistenciaPedido(1);
        Assertions.assertEquals(esperado,resultado);
    }
}
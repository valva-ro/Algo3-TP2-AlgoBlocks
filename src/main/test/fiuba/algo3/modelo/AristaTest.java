package fiuba.algo3.modelo;

import fiuba.algo3.modelo.dibujo.Arista;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AristaTest {
    @Test
    public void test01AristaContieneOrigen() {
        Posicion origen = new Posicion();
        Posicion destino = new Posicion(0, 1);
        Arista arista = new Arista(origen, destino);

        assertTrue(arista.contiene(origen));
    }

    @Test
    public void test02AristaContieneDestino() {
        Posicion origen = new Posicion();
        Posicion destino = new Posicion(0, 1);
        Arista arista = new Arista(origen, destino);

        assertTrue(arista.contiene(destino));
    }

    @Test
    public void test03AristaContieneDestinoYOrigen() {
        Posicion origen = new Posicion();
        Posicion destino = new Posicion(0, 1);
        Arista arista = new Arista(origen, destino);

        assertTrue(arista.contiene(origen, destino));
    }

    @Test
    public void test04ObtenerElDestinoFuncionaCorrectamente() {
        Posicion origen = new Posicion();
        Posicion destino = new Posicion(0, 1);
        Arista arista = new Arista(origen, destino);

        Posicion destinoDeLaArista = arista.obtenerDestino();

        assertTrue(destino.esIgual(destinoDeLaArista));
    }

    @Test
    public void test01NegativoAristaContieneOrigen() {
        Posicion origen = new Posicion();
        Posicion destino = new Posicion(0, 1);
        Arista arista = new Arista(origen, destino);

        origen = new Posicion(0, 2);

        assertFalse(arista.contiene(origen));
    }

    @Test
    public void test02NegativoAristaContieneDestino() {
        Posicion origen = new Posicion();
        Posicion destino = new Posicion(0, 1);
        Arista arista = new Arista(origen, destino);

        destino = new Posicion(0, 2);

        assertFalse(arista.contiene(destino));
    }

    @Test
    public void test03NegativoAristaContieneDestinoYOrigen() {
        Posicion origen = new Posicion();
        Posicion destino = new Posicion(0, 1);
        Arista arista = new Arista(origen, destino);

        origen = new Posicion(0, 4);
        destino = new Posicion(0, 2);

        assertFalse(arista.contiene(origen, destino));
    }

    @Test
    public void test04NegativoObtenerElDestinoFuncionaCorrectamente() {
        Posicion origen = new Posicion();
        Posicion destino = new Posicion(0, 1);
        Arista arista = new Arista(origen, destino);

        Posicion destinoDeLaArista = arista.obtenerDestino();
        destino = new Posicion(0, 2);

        assertFalse(destino.esIgual(destinoDeLaArista));
    }
}
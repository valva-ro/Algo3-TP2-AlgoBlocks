package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.dibujo.Arista;
import fiuba.algo3.modelo.direcciones.Direccion;
import fiuba.algo3.modelo.direcciones.Norte;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AristaTest {
    @Test
    public void test01AristaContieneOrigen() {
        Posicion Origen = new Posicion();
        Posicion Destino = new Posicion(0,1);
        Arista Arista = new Arista (Origen,Destino);


        assertTrue(Arista.contiene(Origen));

    }

    @Test
    public void test02AristaContieneDestino() {
        Posicion Origen = new Posicion();
        Posicion Destino = new Posicion(0,1);
        Arista Arista = new Arista (Origen,Destino);


        assertTrue(Arista.contiene(Destino));

    }

    @Test
    public void test03AristaContieneDestinoYOrigen() {
        Posicion Origen = new Posicion();
        Posicion Destino = new Posicion(0,1);
        Arista Arista = new Arista (Origen,Destino);


        assertTrue(Arista.contiene(Origen,Destino));

    }

    @Test
    public void test04ObtenerElDestinoFuncionaCorrectamente() {
        Posicion Origen = new Posicion();
        Posicion Destino = new Posicion(0,1);
        Arista Arista = new Arista (Origen,Destino);

        Posicion DestinoDeLaArista = Arista.obtenerDestino();

        assertTrue(Destino.esIgual(DestinoDeLaArista));

    }

    @Test
    public void test01NegativoAristaContieneOrigen() {
        Posicion Origen = new Posicion();
        Posicion Destino = new Posicion(0,1);
        Arista Arista = new Arista (Origen,Destino);

        Origen = new Posicion(0,2);

        assertFalse(Arista.contiene(Origen));

    }

    @Test
    public void test02NegativoAristaContieneDestino() {
        Posicion Origen = new Posicion();
        Posicion Destino = new Posicion(0,1);
        Arista Arista = new Arista (Origen,Destino);

        Destino = new Posicion(0,2);

        assertFalse(Arista.contiene(Destino));

    }

    @Test
    public void test03NegativoAristaContieneDestinoYOrigen() {
        Posicion Origen = new Posicion();
        Posicion Destino = new Posicion(0,1);
        Arista Arista = new Arista (Origen,Destino);

        Origen = new Posicion(0,4);
        Destino = new Posicion(0,2);

        assertFalse(Arista.contiene(Origen,Destino));

    }

    @Test
    public void test04NegativoObtenerElDestinoFuncionaCorrectamente() {
        Posicion Origen = new Posicion();
        Posicion Destino = new Posicion(0,1);
        Arista Arista = new Arista (Origen,Destino);

        Posicion DestinoDeLaArista = Arista.obtenerDestino();
        Destino = new Posicion(0,2);

        assertFalse(Destino.esIgual(DestinoDeLaArista));

    }


}

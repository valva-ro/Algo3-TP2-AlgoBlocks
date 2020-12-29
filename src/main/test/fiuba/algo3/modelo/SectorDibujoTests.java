package fiuba.algo3.modelo;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectorDibujoTests {

    @Mock
    public MockMovimiento unMovimeinto;
    public MockArriba unArriba;
    public MockAbajo unAbajo;
    public MockIzquierda unIzquierda;
    public MockDerecha unDerecha;

    @Test
    public void test05SectorDibujoAlmacenoCorrectamenteLosMovimientos () {

        SectorDibujo unSectorDibujo = new SectorDibujo();
        ArrayList <MockMovimiento> ListaMovimientos = new ArrayList<>();

        MockArriba unArriba = mock(MockArriba.class);
        MockDerecha unDerecha = mock(MockDerecha.class);
        MockAbajo unAbajo = mock(MockAbajo.class);
        MockIzquierda unIzquierda = mock(MockIzquierda.class);

        unSectorDibujo.dibujar(unArriba);
        unSectorDibujo.dibujar(unDerecha);
        unSectorDibujo.dibujar(unAbajo);
        unSectorDibujo.dibujar(unIzquierda);

        ListaMovimientos.add(unArriba);
        ListaMovimientos.add(unDerecha);
        ListaMovimientos.add(unAbajo);
        ListaMovimientos.add(unIzquierda);

        ArrayList <MockMovimiento> Movimientos = unSectorDibujo.obtenerMovimientos();

        for (int i = 0; i < ListaMovimientos.size(); i++) {
            assertEquals(ListaMovimientos.get(i), Movimientos.get(i));
        }
    }

}




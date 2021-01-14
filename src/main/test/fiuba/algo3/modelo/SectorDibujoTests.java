package fiuba.algo3.modelo;



import fiuba.algo3.modelo.bloques.NoDibuja;
import fiuba.algo3.modelo.movimientos.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectorDibujoTests {

    @Test
    public void test01SectorDibujoAlmacenoCorrectamenteLosMovimientos () {

        SectorDibujo unSectorDibujo = new SectorDibujo();
        ArrayList <Movimiento> movimientos = new ArrayList<>();

        Arriba unArriba = new Arriba(new NoDibuja());
        Derecha unDerecha = new Derecha(new NoDibuja());
        Abajo unAbajo = new Abajo(new NoDibuja());
        Izquierda unIzquierda = new Izquierda(new NoDibuja());

        unSectorDibujo.dibujar(unArriba);
        unSectorDibujo.dibujar(unDerecha);
        unSectorDibujo.dibujar(unAbajo);
        unSectorDibujo.dibujar(unIzquierda);

        movimientos.add(unArriba);
        movimientos.add(unDerecha);
        movimientos.add(unAbajo);
        movimientos.add(unIzquierda);

        ArrayList <Movimiento> dibujo = unSectorDibujo.obtenerMovimientos();

        for (int i = 0; i < movimientos.size(); i++) {
            assertEquals(movimientos.get(i), dibujo.get(i));
        }
    }
}




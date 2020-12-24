package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovimientoTest {

    //Testear comportamiento
    @Test
    public void test01UnMovimientoALaDerechaEstaEnDibuja(){
        Derecha movimientoDerecha = new Derecha(new Dibuja());

        assertTrue(movimientoDerecha.estaDibujado());
    }

    @Test
    public void test02UnMovimientoALaDerechaEstaEnNoDibuja(){
        Derecha movimientoDerecha = new Derecha(new NoDibuja());

        assertFalse(movimientoDerecha.estaDibujado());
    }

    @Test
    public void test03UnMovimientoALaIzquierdaEstaEnDibuja(){
        Izquierda movimientoIzquierda = new Izquierda(new Dibuja());

        assertTrue(movimientoIzquierda.estaDibujado());
    }

    @Test
    public void test04UnMovimientoALaIzquierdaEstaEnNoDibuja(){
        Izquierda movimientoIzquierda = new Izquierda(new NoDibuja());

        assertFalse(movimientoIzquierda.estaDibujado());
    }

    @Test
    public void test05UnMovimientoArribaEstaEnDibuja(){
        Izquierda movimientoIzquierda = new Izquierda(new Dibuja());

        assertTrue(movimientoIzquierda.estaDibujado());
    }

    @Test
    public void test06UnMovimientoArribaEstaEnNoDibuja(){
        Arriba movimientoArriba = new Arriba(new NoDibuja());

        assertFalse(movimientoArriba.estaDibujado());
    }


    @Test
    public void test07UnMovimientoAbajoEstaEnDibuja(){
        Arriba movimientoArriba = new Arriba(new NoDibuja());

        assertTrue(movimientoArriba.estaDibujado());
    }

    @Test
    public void test08UnMovimientoAbajoEstaEnNoDibuja(){
        Abajo movimientoAbajo = new Abajo(new NoDibuja());

        assertFalse(movimientoAbajo.estaDibujado());
    }
}

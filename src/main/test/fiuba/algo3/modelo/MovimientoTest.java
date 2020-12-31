package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        Arriba movimientoArriba = new Arriba(new Dibuja());

        assertTrue(movimientoArriba.estaDibujado());
    }

    @Test
    public void test08UnMovimientoAbajoEstaEnNoDibuja(){
        Abajo movimientoAbajo = new Abajo(new NoDibuja());

        assertFalse(movimientoAbajo.estaDibujado());
    }

    //Test de comportamiento de los movimientos sobre bloques
    @Test
    public void test09UnMovimientoAbajoSeInvierteHaciaArriba(){

        Abajo movimientoAbajo             = new Abajo(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimientoAbajo);
        Arriba movimientoArriba           = new Arriba(new Dibuja());

        bloqueMovimiento.invertirMovimiento();

        assertEquals(movimientoArriba.getClass(), bloqueMovimiento.obtenerMovimiento().getClass());

    }

    @Test
    public void test10UnMovimientoArribaSeInvierteHaciaAbajo(){

        Abajo movimientoAbajo             = new Abajo(new Dibuja());
        Arriba movimientoArriba           = new Arriba(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimientoArriba);

        bloqueMovimiento.invertirMovimiento();

        assertEquals(movimientoAbajo.getClass(), bloqueMovimiento.obtenerMovimiento().getClass());

    }


    @Test
    public void test11UnMovimientoDerechaSeInvierteHaciaIzquierda(){

        Derecha movimientoDerecha         = new Derecha(new Dibuja());
        Izquierda movimientoIzquierda     = new Izquierda(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimientoDerecha);

        bloqueMovimiento.invertirMovimiento();

        assertEquals(movimientoIzquierda.getClass(), bloqueMovimiento.obtenerMovimiento().getClass());

    }
    @Test
    public void test12UnMovimientoIzquierdaSeInvierteHaciaDerecha(){

        Derecha movimientoDerecha         = new Derecha(new Dibuja());
        Izquierda movimientoIzquierda     = new Izquierda(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimientoIzquierda);

        bloqueMovimiento.invertirMovimiento();

        assertEquals(movimientoDerecha.getClass(), bloqueMovimiento.obtenerMovimiento().getClass());

    }
}

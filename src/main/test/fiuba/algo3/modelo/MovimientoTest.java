package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;
import fiuba.algo3.modelo.bloques.Dibuja;
import fiuba.algo3.modelo.bloques.NoDibuja;
import fiuba.algo3.modelo.movimientos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MovimientoTest {

    // TODO: Alejo corregir los get.Class() por el esIgual()

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


    @Test
    public void test09UnMovimientoAbajoSeInvierteHaciaArriba(){

        Abajo movimientoAbajo = new Abajo(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimientoAbajo);
        Arriba movimientoArriba = new Arriba(new Dibuja());

        bloqueMovimiento.invertirMovimiento();

        assertEquals(movimientoArriba.getClass(), bloqueMovimiento.obtenerMovimiento().getClass());
    }

    @Test
    public void test10UnMovimientoArribaSeInvierteHaciaAbajo(){

        Abajo movimientoAbajo = new Abajo(new Dibuja());
        Arriba movimientoArriba = new Arriba(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimientoArriba);

        bloqueMovimiento.invertirMovimiento();

        assertEquals(movimientoAbajo.getClass(), bloqueMovimiento.obtenerMovimiento().getClass());
    }

    @Test
    public void test11UnMovimientoDerechaSeInvierteHaciaIzquierda(){

        Derecha movimientoDerecha = new Derecha(new Dibuja());
        Izquierda movimientoIzquierda = new Izquierda(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimientoDerecha);

        bloqueMovimiento.invertirMovimiento();

        assertEquals(movimientoIzquierda.getClass(), bloqueMovimiento.obtenerMovimiento().getClass());
    }

    @Test
    public void test12UnMovimientoIzquierdaSeInvierteHaciaDerecha(){

        Derecha movimientoDerecha = new Derecha(new Dibuja());
        Izquierda movimientoIzquierda = new Izquierda(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimientoIzquierda);

        bloqueMovimiento.invertirMovimiento();

        assertEquals(movimientoDerecha.getClass(), bloqueMovimiento.obtenerMovimiento().getClass());
    }

    @Test
    public void test13SectorMovimientoPosee3MovimientosALaDerecha(){
        Derecha movimientoDerecha = new Derecha(new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();

        for(int i = 0; i < 3; i++) {
           sectorDibujo.dibujar(movimientoDerecha);
        }

        for (int i = 0; i < 3; i++) {
            assertEquals(movimientoDerecha,sectorDibujo.obtenerMovimientos().get(i));
        }
    }

    @Test
    public void test14SectorMovimientoPosee10MovimientosALaDerechaEIzquierda(){
        Derecha   movimientoDerecha = new Derecha(new Dibuja());
        Izquierda movimientoIzquierda = new Izquierda(new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();

        for(int i = 0; i < 10; i++) {
            sectorDibujo.dibujar(movimientoIzquierda);
            sectorDibujo.dibujar(movimientoDerecha);
        }

        for (int i = 0; i < 10; i+=2) {
            assertEquals(movimientoIzquierda,sectorDibujo.obtenerMovimientos().get(i));
            assertEquals(movimientoDerecha,sectorDibujo.obtenerMovimientos().get(i+1));
        }
    }

    @Test
    public void test15SectorMovimientoPosee10MovimientosParaTodosLados(){
        Derecha   movimientoDerecha = new Derecha(new Dibuja());
        Izquierda movimientoIzquierda = new Izquierda(new Dibuja());
        Arriba    movimientoArriba = new Arriba(new Dibuja());
        Abajo     movimientoAbajo = new Abajo(new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();

        for(int i = 0; i < 10; i++) {
            sectorDibujo.dibujar(movimientoIzquierda);
            sectorDibujo.dibujar(movimientoDerecha);
            sectorDibujo.dibujar(movimientoArriba);
            sectorDibujo.dibujar(movimientoAbajo);
        }

        for (int i = 0; i < 10; i+=4) {
            assertEquals(movimientoIzquierda,sectorDibujo.obtenerMovimientos().get(i));
            assertEquals(movimientoDerecha,sectorDibujo.obtenerMovimientos().get(i+1));
            assertEquals(movimientoArriba,sectorDibujo.obtenerMovimientos().get(i+2));
            assertEquals(movimientoAbajo,sectorDibujo.obtenerMovimientos().get(i+3));
        }
    }

    @Test
    public void test16EjecutarUnBloqueMovimientoDeManeraInvertidaModificaSuEstado()
    {
        Movimiento movimientoMock = mock(Movimiento.class);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimientoMock);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloqueMovimiento.ejecutarInvertido(sectorDibujoMock);

        verify(movimientoMock,times(1)).invertir();
    }

    @Test
    public void test17EjecutarUnBloqueMovimientoDeManeraInvertidaAgregaUnMovimientoInvertidoAlSectorDibujo()
    {
        Movimiento movimientoMock = mock(Movimiento.class);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimientoMock);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloqueMovimiento.ejecutarInvertido(sectorDibujoMock);

        verify(sectorDibujoMock,times(1)).dibujar(movimientoMock.invertir());

    }
}

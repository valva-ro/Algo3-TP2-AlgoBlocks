package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;
import fiuba.algo3.modelo.movimientos.Dibuja;
import fiuba.algo3.modelo.movimientos.NoDibuja;
import fiuba.algo3.modelo.movimientos.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MovimientoTest {


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

        assertTrue(movimientoArriba.esIgualA(bloqueMovimiento.obtenerMovimiento()));
    }

    @Test
    public void test10UnMovimientoArribaSeInvierteHaciaAbajo(){

        Abajo movimientoAbajo = new Abajo(new Dibuja());
        Arriba movimientoArriba = new Arriba(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimientoArriba);

        bloqueMovimiento.invertirMovimiento();
        assertTrue(movimientoAbajo.esIgualA(bloqueMovimiento.obtenerMovimiento()));
    }

    @Test
    public void test11UnMovimientoDerechaSeInvierteHaciaIzquierda(){

        Derecha movimientoDerecha = new Derecha(new Dibuja());
        Izquierda movimientoIzquierda = new Izquierda(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimientoDerecha);

        bloqueMovimiento.invertirMovimiento();

        assertTrue(movimientoIzquierda.esIgualA(bloqueMovimiento.obtenerMovimiento()));
    }

    @Test
    public void test12UnMovimientoIzquierdaSeInvierteHaciaDerecha(){

        Derecha movimientoDerecha = new Derecha(new Dibuja());
        Izquierda movimientoIzquierda = new Izquierda(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimientoIzquierda);

        bloqueMovimiento.invertirMovimiento();

        assertTrue(movimientoDerecha.esIgualA(bloqueMovimiento.obtenerMovimiento()));
    }

    @Test
    public void test13SectorMovimientoPosee3MovimientosALaDerecha(){
        Derecha movimientoDerecha = new Derecha(new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
           sectorDibujo.dibujar(movimientoDerecha);
           movimientos.add(movimientoDerecha);
        }
        assertTrue(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test14SectorMovimientoPosee10MovimientosALaDerechaEIzquierda(){
        Derecha   movimientoDerecha = new Derecha(new Dibuja());
        Izquierda movimientoIzquierda = new Izquierda(new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            sectorDibujo.dibujar(movimientoIzquierda);
            movimientos.add(movimientoIzquierda);

            sectorDibujo.dibujar(movimientoDerecha);
            movimientos.add(movimientoDerecha);
        }
        assertTrue(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test15SectorMovimientoPosee10MovimientosParaTodosLados(){
        Derecha   movimientoDerecha = new Derecha(new Dibuja());
        Izquierda movimientoIzquierda = new Izquierda(new Dibuja());
        Arriba    movimientoArriba = new Arriba(new Dibuja());
        Abajo     movimientoAbajo = new Abajo(new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();

        ArrayList<Movimiento> movimientos = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            sectorDibujo.dibujar(movimientoIzquierda);
            movimientos.add(movimientoIzquierda);

            sectorDibujo.dibujar(movimientoDerecha);
            movimientos.add(movimientoDerecha);

            sectorDibujo.dibujar(movimientoArriba);
            movimientos.add(movimientoArriba);

            sectorDibujo.dibujar(movimientoAbajo);
            movimientos.add(movimientoAbajo);
        }

        assertTrue(sectorDibujo.dibujoEsIgual(movimientos));

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

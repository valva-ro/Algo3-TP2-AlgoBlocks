package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.*;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueDibuja;
import fiuba.algo3.modelo.movimientos.Movimiento;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

// TODO: actualizar estos tests al nuevo modelo

public class AlgoritmoTests {

    @Test
    public void test01NoSePuedeEjecutarUnAlgoritmoQueNoTieneBloques() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(AlgoritmoNoPuedeSerEjecutadoSiNoTieneBloquesError.class,
                () -> {
                    algoritmo.ejecutar(sectorDibujo);
                });
    }

    @Test
    public void test02AlCrearUnNuevoAlgoritmoNoDebeTenerBloques() {
        Algoritmo algoritmo = new Algoritmo();
        ArrayList <Bloque> Bloques = algoritmo.obtenerBloques();
        Integer numero = 0;

        assertEquals(Bloques.size(),numero);
    }

    @Test
    public void test03SeEjecutaUnAlgoritmoCon5BloquesDeMovimientoHaciaArriba() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloqueMovimiento bloqueArriba = fabrica.crearBloqueMovimientoArriba();
        SectorDibujo SecDib = new SectorDibujo();

        for ( int i = 0; i < 5; i = i+1){
            algoritmo.agregar(bloqueArriba);
        }
        algoritmo.ejecutar(SecDib);
        ArrayList <Movimiento> Movimientos = SecDib.obtenerMovimientos();

        for ( int i = 0; i < 5; i = i+1) {

            assertEquals(Movimientos.get(i),bloqueArriba.obtenerMovimiento());
        }
    }

    @Test
    public void test04SeEjecutaUnAlgoritmoCon5BloquesDeMovimientoHaciaAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloqueMovimiento bloqueAbajo = fabrica.crearBloqueMovimientoAbajo();
        SectorDibujo SecDib = new SectorDibujo();

        for ( int i = 0; i < 5; i = i+1){
            algoritmo.agregar(bloqueAbajo);
        }
        algoritmo.ejecutar(SecDib);
        ArrayList <Movimiento> Movimientos = SecDib.obtenerMovimientos();

        for ( int i = 0; i < 5; i = i+1) {

            assertEquals(Movimientos.get(i),bloqueAbajo.obtenerMovimiento());
        }
    }

    @Test
    public void test05SeEjecutaUnAlgoritmoCon5BloquesDeMovimientoHaciaLaDerecha() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloqueMovimiento bloqueDerecha = fabrica.crearBloqueMovimientoDerecha();
        SectorDibujo SecDib = new SectorDibujo();

        for ( int i = 0; i < 5; i = i+1){
            algoritmo.agregar(bloqueDerecha);
        }
        algoritmo.ejecutar(SecDib);
        ArrayList <Movimiento> Movimientos = SecDib.obtenerMovimientos();

        for ( int i = 0; i < 5; i = i+1) {

            assertEquals(Movimientos.get(i),bloqueDerecha.obtenerMovimiento());
        }
    }

    @Test
    public void test06SeEjecutaUnAlgoritmoCon5BloquesDeMovimientoHaciaLaIzquierda() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloqueMovimiento bloqueIzquierda = fabrica.crearBloqueMovimientoIzquierda();
        SectorDibujo SecDib = new SectorDibujo();

        for ( int i = 0; i < 5; i = i+1){
            algoritmo.agregar(bloqueIzquierda);
        }
        algoritmo.ejecutar(SecDib);
        ArrayList <Movimiento> Movimientos = SecDib.obtenerMovimientos();

        for ( int i = 0; i < 5; i = i+1) {

            assertEquals(Movimientos.get(i),bloqueIzquierda.obtenerMovimiento());
        }
    }

    @Test
    public void test07SeEjecutaUnAlgoritmoCon5BloquesDeMovimientoEnCadaDireccion() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloqueMovimiento bloqueArriba = fabrica.crearBloqueMovimientoArriba();
        BloqueMovimiento bloqueAbajo = fabrica.crearBloqueMovimientoAbajo();
        BloqueMovimiento bloqueDerecha = fabrica.crearBloqueMovimientoDerecha();
        BloqueMovimiento bloqueIzquierda = fabrica.crearBloqueMovimientoIzquierda();
        SectorDibujo SecDib = new SectorDibujo();

        for ( int i = 0; i < 5; i = i+1){
            algoritmo.agregar(bloqueArriba);
            algoritmo.agregar(bloqueAbajo);
            algoritmo.agregar(bloqueDerecha);
            algoritmo.agregar(bloqueIzquierda);
        }
        algoritmo.ejecutar(SecDib);
        ArrayList <Movimiento> Movimientos = SecDib.obtenerMovimientos();

        for ( int i = 0; i < 20; i = i+4) {

            assertEquals(Movimientos.get(i),bloqueArriba.obtenerMovimiento());
            assertEquals(Movimientos.get(i+1),bloqueAbajo.obtenerMovimiento());
            assertEquals(Movimientos.get(i+2),bloqueDerecha.obtenerMovimiento());
            assertEquals(Movimientos.get(i+3),bloqueIzquierda.obtenerMovimiento());
        }
    }

    @Test
    public void test08SeEjecutaUnAlgoritmoCon100BloquesDeMovimientoEnCadaDireccion() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloqueMovimiento bloqueArriba = fabrica.crearBloqueMovimientoArriba();
        BloqueMovimiento bloqueAbajo = fabrica.crearBloqueMovimientoAbajo();
        BloqueMovimiento bloqueDerecha = fabrica.crearBloqueMovimientoDerecha();
        BloqueMovimiento bloqueIzquierda = fabrica.crearBloqueMovimientoIzquierda();
        SectorDibujo SecDib = new SectorDibujo();

        for ( int i = 0; i < 100; i = i+1){
            algoritmo.agregar(bloqueArriba);
            algoritmo.agregar(bloqueAbajo);
            algoritmo.agregar(bloqueDerecha);
            algoritmo.agregar(bloqueIzquierda);
        }
        algoritmo.ejecutar(SecDib);
        ArrayList <Movimiento> Movimientos = SecDib.obtenerMovimientos();

        for ( int i = 0; i < 400; i = i+4) {

            assertEquals(Movimientos.get(i),bloqueArriba.obtenerMovimiento());
            assertEquals(Movimientos.get(i+1),bloqueAbajo.obtenerMovimiento());
            assertEquals(Movimientos.get(i+2),bloqueDerecha.obtenerMovimiento());
            assertEquals(Movimientos.get(i+3),bloqueIzquierda.obtenerMovimiento());
        }
    }

    @Test
    public void test09SeEjecutaUnAlgoritmoConUnBloqueDeRepetirDobleQueTiene1BloqueArriba() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloqueMovimiento bloqueArriba = fabrica.crearBloqueMovimientoArriba();
        BloquePersonalizado BloqueP = new BloquePersonalizado();
        BloqueP.agregar(bloqueArriba);
        BloqueRepetirDosVeces BloqueDosV = new BloqueRepetirDosVeces(BloqueP);
        SectorDibujo SecDib = new SectorDibujo();

        algoritmo.agregar(BloqueDosV);
        algoritmo.ejecutar(SecDib);
        ArrayList <Movimiento> Movimientos = SecDib.obtenerMovimientos();

        for ( int i = 0; i < 2; i = i+1) {

            assertEquals(Movimientos.get(i),bloqueArriba.obtenerMovimiento());
        }
    }

    // TODO: Kevin  los faltantes
    @Test
    public void test10SeEjecutaUnAlgoritmoConUnBloqueDeRepetirDobleQueTiene10BloqueArriba() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();

        BloqueMovimiento bloqueArriba;

        ArrayList <Movimiento> movimientos = new ArrayList<>();

        for(int i=0; i < 10; i = i + 1) {
            bloqueArriba = fabrica.crearBloqueMovimientoArriba();
            bloquePersonalizado.agregar(bloqueArriba);
            movimientos.add(bloqueArriba.obtenerMovimiento());
        }

        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces(bloquePersonalizado);

        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        algoritmo.agregar(bloqueRepetir);
        algoritmo.ejecutar(sectorDibujoMock);

        for(Movimiento movimiento: movimientos)
            verify(sectorDibujoMock,times(2)).dibujar(movimiento);
    }

    @Test
    public void test11SeEjecutaUnAlgoritmoConUnBloqueDeRepetirTripleQueTiene1BloqueArriba() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimiento = fabrica.crearBloqueMovimientoArriba();

        bloquePersonalizado.agregar(bloqueMovimiento);

        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces(bloquePersonalizado);

        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        algoritmo.agregar(bloqueRepetir);
        algoritmo.ejecutar(sectorDibujoMock);

        verify(sectorDibujoMock,times(3)).dibujar(bloqueMovimiento.obtenerMovimiento());

    }

    @Test
    public void test12SeEjecutaUnAlgoritmoConUnBloqueDeRepetirTripleQueTiene10BloqueArriba() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();

        BloqueMovimiento bloqueArriba;

        ArrayList <Movimiento> movimientos = new ArrayList<>();

        for(int i=0; i < 10; i = i + 1) {
            bloqueArriba = fabrica.crearBloqueMovimientoArriba();
            bloquePersonalizado.agregar(bloqueArriba);
            movimientos.add(bloqueArriba.obtenerMovimiento());
        }

        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces(bloquePersonalizado);

        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        algoritmo.agregar(bloqueRepetir);
        algoritmo.ejecutar(sectorDibujoMock);

        for(Movimiento movimiento: movimientos)
            verify(sectorDibujoMock,times(3)).dibujar(movimiento);
    }

    @Test
    public void test13SeEjecutaUnAlgoritmoConUnBloquePersonalizado() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimiento = fabrica.crearBloqueMovimientoArriba();

        bloquePersonalizado.agregar(bloqueMovimiento);

        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        algoritmo.agregar(bloquePersonalizado);
        algoritmo.ejecutar(sectorDibujoMock);

        verify(sectorDibujoMock,times(1)).dibujar(bloqueMovimiento.obtenerMovimiento());

    }

    @Test
    public void test14SeEjecutaUnAlgoritmoConUnBloqueInvertirQueTiene1BloqueArriba() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimiento = fabrica.crearBloqueMovimientoArriba();

        bloquePersonalizado.agregar(bloqueMovimiento);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloquePersonalizado);

        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        algoritmo.agregar(bloqueInvertir);
        algoritmo.ejecutar(sectorDibujoMock);

        verify(sectorDibujoMock,times(1)).dibujar(bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test15SeEjecutaUnAlgoritmoConUnBloqueInvertirQueTiene1BloqueAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimiento = fabrica.crearBloqueMovimientoAbajo();

        bloquePersonalizado.agregar(bloqueMovimiento);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloquePersonalizado);

        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        algoritmo.agregar(bloqueInvertir);
        algoritmo.ejecutar(sectorDibujoMock);

        verify(sectorDibujoMock,times(1)).dibujar(bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test16SeEjecutaUnAlgoritmoConUnBloqueInvertirQueTiene1BloqueIzquierda() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimiento = fabrica.crearBloqueMovimientoIzquierda();

        bloquePersonalizado.agregar(bloqueMovimiento);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloquePersonalizado);

        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        algoritmo.agregar(bloqueInvertir);
        algoritmo.ejecutar(sectorDibujoMock);

        verify(sectorDibujoMock,times(1)).dibujar(bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test17SeEjecutaUnAlgoritmoConUnBloqueInvertirQueTiene1BloqueDerecha() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimiento = fabrica.crearBloqueMovimientoDerecha();

        bloquePersonalizado.agregar(bloqueMovimiento);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloquePersonalizado);

        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        algoritmo.agregar(bloqueInvertir);
        algoritmo.ejecutar(sectorDibujoMock);

        verify(sectorDibujoMock,times(1)).dibujar(bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test18SeEjecutaUnAlgoritmoConUnBloqueInvertirQueTiene1BloqueEnCadaDireccion() {
        Algoritmo algoritmo = new Algoritmo();
        FabricaConcretaBloqueQueDibuja fabrica = new FabricaConcretaBloqueQueDibuja();
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();

        BloqueMovimiento bloqueArriba = fabrica.crearBloqueMovimientoArriba();
        BloqueMovimiento bloqueAbajo = fabrica.crearBloqueMovimientoAbajo();
        BloqueMovimiento bloqueIzquierda = fabrica.crearBloqueMovimientoIzquierda();
        BloqueMovimiento bloqueDerecha = fabrica.crearBloqueMovimientoDerecha();

        bloquePersonalizado.agregar(bloqueArriba);
        bloquePersonalizado.agregar(bloqueAbajo);
        bloquePersonalizado.agregar(bloqueIzquierda);
        bloquePersonalizado.agregar(bloqueDerecha);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloquePersonalizado);

        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        algoritmo.agregar(bloqueInvertir);
        algoritmo.ejecutar(sectorDibujoMock);

        verify(sectorDibujoMock,times(1)).dibujar(bloqueArriba.obtenerMovimiento());
        verify(sectorDibujoMock,times(1)).dibujar(bloqueAbajo.obtenerMovimiento());
        verify(sectorDibujoMock,times(1)).dibujar(bloqueIzquierda.obtenerMovimiento());
        verify(sectorDibujoMock,times(1)).dibujar(bloqueDerecha.obtenerMovimiento());

    }
}
package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.Bloque;
import fiuba.algo3.modelo.bloques.BloqueMovimiento;
import fiuba.algo3.modelo.bloques.BloquePersonalizado;
import fiuba.algo3.modelo.bloques.BloqueRepetirDosVeces;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueDibuja;
import fiuba.algo3.modelo.movimientos.Movimiento;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        assert(true);
    }

    @Test
    public void test11SeEjecutaUnAlgoritmoConUnBloqueDeRepetirTripleQueTiene1BloqueArriba() {
        assert(true);
    }

    @Test
    public void test12SeEjecutaUnAlgoritmoConUnBloqueDeRepetirTripleQueTiene10BloqueArriba() {
        assert(true);
    }

    @Test
    public void test13SeEjecutaUnAlgoritmoConUnBloquePersonalizado() {
        assert(true);
    }

    @Test
    public void test14SeEjecutaUnAlgoritmoConUnBloqueInvertirQueTiene1BloqueArriba() {
        assert(true);
    }

    @Test
    public void test15SeEjecutaUnAlgoritmoConUnBloqueInvertirQueTiene1BloqueAbajo() {
        assert(true);
    }

    @Test
    public void test16SeEjecutaUnAlgoritmoConUnBloqueInvertirQueTiene1BloqueIzquierda() {
        assert(true);
    }

    @Test
    public void test17SeEjecutaUnAlgoritmoConUnBloqueInvertirQueTiene1BloqueDerecha() {
        assert(true);
    }

    @Test
    public void test18SeEjecutaUnAlgoritmoConUnBloqueInvertirQueTiene1BloqueEnCadaDireccion() {
        assert(true);
    }
}
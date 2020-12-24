package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// TODO: actualizar estos tests al nuevo modelo

public class AlgoritmoTests {

    @Test
    public void test01AlCrearUnNuevoAlgoritmoNoDebeTenerBloques () {
        Algoritmo algoritmo = new Algoritmo();
        assertEquals(algoritmo.obtenerBloques().size(), 0);
    }

    @Test
    public void test02AlEjecutarUnAlgoritmoQueTieneBloqueDeLevantarLapizElPersonajeTieneElLapizLevantado () {
        Algoritmo algoritmo = new Algoritmo();
        LapizLevantado lapiz = new LapizLevantado();
        SectorDibujo sectorDibujo = new SectorDibujo();

        algoritmo.agregar(new BloqueLevantarLapiz());
        algoritmo.ejecutar(sectorDibujo);

        assertEquals(sectorDibujo.obtenerPersonaje().obtenerLapiz().getClass(), lapiz.getClass());
    }

    @Test
    public void test03AlEjecutarUnAlgoritmoQueTieneBloqueDeBajarLapizElPersonajeTieneElLapizAbajo(){
        Algoritmo algoritmo = new Algoritmo();
        LapizBajado lapiz = new LapizBajado();
        SectorDibujo sectorDibujo = new SectorDibujo();

        algoritmo.agregar(new BloqueBajarLapiz());
        algoritmo.ejecutar(sectorDibujo);

        assertEquals(sectorDibujo.obtenerPersonaje().obtenerLapiz().getClass(), lapiz.getClass());
    }

    @Test
    public void test04AlEjecutarUnAlgortimoQueTieneBloqueALaDerechaElPersonajeEstaEnX1Y0(){
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion posicion = new Posicion(1,0);

        algoritmo.agregar(new BloqueMovimiento(new Posicion(1,0)));
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.obtenerPersonaje().estaEn(posicion));
    }

    @Test
    public void test05AlEjecutarUnAlgortimoQueTieneBloqueALaIzquierdaElPersonajeEstaEnXmenos1Y0(){
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion posicion = new Posicion(-1,0);

        algoritmo.agregar(new BloqueMovimiento(new Posicion(-1,0)));
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.obtenerPersonaje().estaEn(posicion));
    }

    @Test
    public void test06AlEjecutarUnAlgortimoQueTieneBloqueArribaElPersonajeEstaEnX0Y1(){
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion posicion = new Posicion(0,1);

        algoritmo.agregar(new BloqueMovimiento(new Posicion(0,1)));
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.obtenerPersonaje().estaEn(posicion));
    }

    @Test
    public void test07AlEjecutarUnAlgortimoQueTieneBloqueAbajoElPersonajeEstaEnX0Ymenos1(){
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion posicion = new Posicion(0,-1);

        algoritmo.agregar(new BloqueMovimiento(new Posicion(0,-1)));
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.obtenerPersonaje().estaEn(posicion));
    }

    @Test
    public void test08AlEjecutarUnAlgortimoQueTieneBloqueArribaYLaDerechaElPersonajeEstaEnX1Y1(){
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion posicion = new Posicion(1,1);

        algoritmo.agregar(new BloqueMovimiento(new Posicion(0,1)));
        algoritmo.agregar(new BloqueMovimiento(new Posicion(1,0)));
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.obtenerPersonaje().estaEn(posicion));
    }

    @Test
    public void test09AlEjecutarUnAlgortimoQueTieneBloqueAbajoYLaIzquierdaElPersonajeEstaEnXmenos1Ymenos1(){
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion posicion = new Posicion(-1,-1);

        algoritmo.agregar(new BloqueMovimiento(new Posicion(0,-1)));
        algoritmo.agregar(new BloqueMovimiento(new Posicion(-1,0)));
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.obtenerPersonaje().estaEn(posicion));
    }

    @Test
    public void test10NoSePuedeEjecutarUnAlgoritmoQueNoTieneBloques(){
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(AlgoritmoNoPuedeSerEjecutadoSiNoTieneBloquesError.class,
                () -> {
                    algoritmo.ejecutar(sectorDibujo);
                });
    }
}
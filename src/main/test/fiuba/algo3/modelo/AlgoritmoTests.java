package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

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
    // TODO: Andreas los primeros 9
    @Test
    public void test02AlCrearUnNuevoAlgoritmoNoDebeTenerBloques() {
        assert(true);
    }

    @Test
    public void test03SeEjecutaUnAlgoritmoCon5BloquesDeMovimientoHaciaArriba() {
        assert(true);
    }

    @Test
    public void test04SeEjecutaUnAlgoritmoCon5BloquesDeMovimientoHaciaAbajo() {
        assert(true);
    }

    @Test
    public void test05SeEjecutaUnAlgoritmoCon5BloquesDeMovimientoHaciaLaDerecha() {
        assert(true);
    }

    @Test
    public void test06SeEjecutaUnAlgoritmoCon5BloquesDeMovimientoHaciaLaIzquierda() {
        assert(true);
    }

    @Test
    public void test07SeEjecutaUnAlgoritmoCon5BloquesDeMovimientoEnCadaDireccion() {
        assert(true);
    }

    @Test
    public void test08SeEjecutaUnAlgoritmoCon100BloquesDeMovimientoEnCadaDireccion() {
        assert(true);
    }

    @Test
    public void test09SeEjecutaUnAlgoritmoConUnBloqueDeRepetirDobleQueTiene1BloqueArriba() {
        assert(true);
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
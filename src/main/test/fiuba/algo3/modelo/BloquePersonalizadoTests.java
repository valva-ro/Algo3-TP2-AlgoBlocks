package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.*;
import fiuba.algo3.modelo.movimientos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BloquePersonalizadoTests {

    @Test
    public void test01BloquePersonalizadoSeEjecutaConUnBloqueDeMovimientoHaciaLaDerecha () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha movimiento = new Derecha(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimiento);

        bloque.agregar(bloqueMovimiento);
        bloque.ejecutar(sectorDibujo);

        assertEquals(movimiento, sectorDibujo.obtenerMovimientos().get(0));
    }

    @Test
    public void test02DecoratorDeBloquePersonalizadoBaseNoAlteraElComportamientoDelBloquePersonalizado () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha movimiento = new Derecha(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimiento);

        bloque.agregar(bloqueMovimiento);

        DecoratorBloquePersonalizadoBase decorator = new DecoratorBloquePersonalizadoBase(bloque);

        decorator.ejecutar(sectorDibujo);

        assertEquals(movimiento, sectorDibujo.obtenerMovimientos().get(0));
    }

    @Test
    public void test03BloquePersonalizadoSeEjecutaCon5BloquesDeMovimientoHaciaLaDerecha() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha derecha = new Derecha(new Dibuja());

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(derecha));
        }

        bloque.ejecutar(sectorDibujo);

        for (int i = 0; i < 5; i += 2) {
            assertEquals(derecha, sectorDibujo.obtenerMovimientos().get(i));
        }
    }

    @Test
    public void test04BloquePersonalizadoNoPuedeEjecutarseSinAlMenosUnBloque() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> bloque.ejecutar(sectorDibujo));
    }

    @Test
    public void test05DecoratorConBloquePersonalizadoNoPuedeEjecutarseSinAlMenosUnBloque() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        DecoratorBloquePersonalizadoBase decoratorBase = new DecoratorBloquePersonalizadoBase(bloque);
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> decoratorBase.ejecutar(sectorDibujo));
    }

    @Test
    public void test06BloquePersonalizadoSeEjecutaCon5BloquesDeMovimientoHaciaLaDerechaY5HaciaArriba() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha derecha = new Derecha(new Dibuja());
        Arriba arriba = new Arriba(new Dibuja());

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(derecha));
            bloque.agregar(new BloqueMovimiento(arriba));
        }

        bloque.ejecutar(sectorDibujo);

        for (int i = 0; i < 5; i += 2) {
            assertEquals(derecha, sectorDibujo.obtenerMovimientos().get(i));
            assertEquals(arriba, sectorDibujo.obtenerMovimientos().get(i+1));
        }
    }

    @Test
    public void test07BloquePersonalizadoSeEjecutaCon5BloquesDeMovimientoHaciaLaIzquierdaY5HaciaArriba() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Izquierda izquierda = new Izquierda(new Dibuja());
        Arriba arriba = new Arriba(new Dibuja());

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(izquierda));
            bloque.agregar(new BloqueMovimiento(arriba));
        }

        bloque.ejecutar(sectorDibujo);

        for (int i = 0; i < 5; i += 2) {
            assertEquals(izquierda, sectorDibujo.obtenerMovimientos().get(i));
            assertEquals(arriba, sectorDibujo.obtenerMovimientos().get(i+1));
        }
    }

    @Test
    public void test08BloquePersonalizadoSeEjecutaCon5BloquesDeMovimientoHaciaAbajoY5HaciaArriba() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Abajo abajo = new Abajo(new Dibuja());
        Arriba arriba = new Arriba(new Dibuja());

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(abajo));
            bloque.agregar(new BloqueMovimiento(arriba));
        }

        bloque.ejecutar(sectorDibujo);

        for (int i = 0; i < 5; i += 2) {
            assertEquals(abajo, sectorDibujo.obtenerMovimientos().get(i));
            assertEquals(arriba, sectorDibujo.obtenerMovimientos().get(i+1));
        }
    }

    @Test
    public void test09BloquePersonalizadoSeEjecutaConUnBloqueDeMovimientoEnCadaDireccion() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha derecha = new Derecha(new Dibuja());
        Izquierda izquierda = new Izquierda(new Dibuja());
        Arriba arriba = new Arriba(new Dibuja());
        Abajo abajo = new Abajo(new Dibuja());

        bloque.agregar(new BloqueMovimiento(derecha));
        bloque.agregar(new BloqueMovimiento(izquierda));
        bloque.agregar(new BloqueMovimiento(arriba));
        bloque.agregar(new BloqueMovimiento(abajo));

        bloque.ejecutar(sectorDibujo);

        assertEquals(derecha, sectorDibujo.obtenerMovimientos().get(0));
        assertEquals(izquierda, sectorDibujo.obtenerMovimientos().get(1));
        assertEquals(arriba, sectorDibujo.obtenerMovimientos().get(2));
        assertEquals(abajo, sectorDibujo.obtenerMovimientos().get(3));
    }

    @Test
    public void test10BloquePersonalizadoSeEjecutaCon10BloquesDeMovimientoEnCadaDireccion() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha derecha = new Derecha(new Dibuja());
        Izquierda izquierda = new Izquierda(new Dibuja());
        Arriba arriba = new Arriba(new Dibuja());
        Abajo abajo = new Abajo(new Dibuja());

        for (int i = 0; i < 10; i++) {
            bloque.agregar(new BloqueMovimiento(derecha));
            bloque.agregar(new BloqueMovimiento(izquierda));
            bloque.agregar(new BloqueMovimiento(arriba));
            bloque.agregar(new BloqueMovimiento(abajo));
        }

        bloque.ejecutar(sectorDibujo);

        for (int i = 0; i < 10; i += 4) {
            assertEquals(derecha, sectorDibujo.obtenerMovimientos().get(i));
            assertEquals(izquierda, sectorDibujo.obtenerMovimientos().get(i + 1));
            assertEquals(arriba, sectorDibujo.obtenerMovimientos().get(i + 2));
            assertEquals(abajo, sectorDibujo.obtenerMovimientos().get(i + 3));
        }
    }

    @Test
    public void test11BloquePersonalizadoSeEjecutaConDecoratorBase10BloquesDeMovimientoEnCadaDireccion() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        DecoratorBloquePersonalizadoBase decoratorBase;
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha derecha = new Derecha(new Dibuja());
        Izquierda izquierda = new Izquierda(new Dibuja());
        Arriba arriba = new Arriba(new Dibuja());
        Abajo abajo = new Abajo(new Dibuja());

        for (int i = 0; i < 10; i++) {
            bloque.agregar(new BloqueMovimiento(derecha));
            bloque.agregar(new BloqueMovimiento(izquierda));
            bloque.agregar(new BloqueMovimiento(arriba));
            bloque.agregar(new BloqueMovimiento(abajo));
        }

        decoratorBase = new DecoratorBloquePersonalizadoBase(bloque);
        decoratorBase.ejecutar(sectorDibujo);

        for (int i = 0; i < 10; i += 4) {
            assertEquals(derecha, sectorDibujo.obtenerMovimientos().get(i));
            assertEquals(izquierda, sectorDibujo.obtenerMovimientos().get(i + 1));
            assertEquals(arriba, sectorDibujo.obtenerMovimientos().get(i + 2));
            assertEquals(abajo, sectorDibujo.obtenerMovimientos().get(i + 3));
        }
    }
}

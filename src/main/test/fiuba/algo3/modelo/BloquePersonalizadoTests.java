package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;
import fiuba.algo3.modelo.bloques.BloquePersonalizado;
import fiuba.algo3.modelo.bloques.DecoratorBloquePersonalizadoBase;
import fiuba.algo3.modelo.movimientos.Dibuja;
import fiuba.algo3.modelo.bloques.BloquePersonalizadoNoPuedeEjecutarseSinBloquesError;
import fiuba.algo3.modelo.movimientos.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BloquePersonalizadoTests {

    @Test
    public void test01BloquePersonalizadoSeEjecutaConUnBloqueDeMovimientoHaciaLaDerecha () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha movimiento = new Derecha(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimiento);
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        bloque.agregar(bloqueMovimiento);
        bloque.ejecutar(sectorDibujo);
        movimientos.add(movimiento);

        assert(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test02DecoratorDeBloquePersonalizadoBaseNoAlteraElComportamientoDelBloquePersonalizado () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha movimiento = new Derecha(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimiento);
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        bloque.agregar(bloqueMovimiento);
        movimientos.add(movimiento);

        DecoratorBloquePersonalizadoBase decorator = new DecoratorBloquePersonalizadoBase(bloque);

        decorator.ejecutar(sectorDibujo);

        assert(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test03BloquePersonalizadoSeEjecutaCon5BloquesDeMovimientoHaciaLaDerecha() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha derecha = new Derecha(new Dibuja());
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(derecha));
            movimientos.add(derecha);
        }

        bloque.ejecutar(sectorDibujo);

        assert(sectorDibujo.dibujoEsIgual(movimientos));
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
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(derecha));
            bloque.agregar(new BloqueMovimiento(arriba));

            movimientos.add(derecha);
            movimientos.add(arriba);
        }

        bloque.ejecutar(sectorDibujo);

        assert(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test07BloquePersonalizadoSeEjecutaCon5BloquesDeMovimientoHaciaLaIzquierdaY5HaciaArriba() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Izquierda izquierda = new Izquierda(new Dibuja());
        Arriba arriba = new Arriba(new Dibuja());
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(izquierda));
            bloque.agregar(new BloqueMovimiento(arriba));

            movimientos.add(izquierda);
            movimientos.add(arriba);
        }

        bloque.ejecutar(sectorDibujo);

        assert(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test08BloquePersonalizadoSeEjecutaCon5BloquesDeMovimientoHaciaAbajoY5HaciaArriba() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Abajo abajo = new Abajo(new Dibuja());
        Arriba arriba = new Arriba(new Dibuja());
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(abajo));
            bloque.agregar(new BloqueMovimiento(arriba));

            movimientos.add(abajo);
            movimientos.add(arriba);
        }

        bloque.ejecutar(sectorDibujo);

        assert(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test09BloquePersonalizadoSeEjecutaConUnBloqueDeMovimientoEnCadaDireccion() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha derecha = new Derecha(new Dibuja());
        Izquierda izquierda = new Izquierda(new Dibuja());
        Arriba arriba = new Arriba(new Dibuja());
        Abajo abajo = new Abajo(new Dibuja());
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        bloque.agregar(new BloqueMovimiento(derecha));
        bloque.agregar(new BloqueMovimiento(izquierda));
        bloque.agregar(new BloqueMovimiento(arriba));
        bloque.agregar(new BloqueMovimiento(abajo));

        movimientos.add(derecha);
        movimientos.add(izquierda);
        movimientos.add(arriba);
        movimientos.add(abajo);

        bloque.ejecutar(sectorDibujo);

        assert(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test10BloquePersonalizadoSeEjecutaCon10BloquesDeMovimientoEnCadaDireccion() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha derecha = new Derecha(new Dibuja());
        Izquierda izquierda = new Izquierda(new Dibuja());
        Arriba arriba = new Arriba(new Dibuja());
        Abajo abajo = new Abajo(new Dibuja());
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            bloque.agregar(new BloqueMovimiento(derecha));
            bloque.agregar(new BloqueMovimiento(izquierda));
            bloque.agregar(new BloqueMovimiento(arriba));
            bloque.agregar(new BloqueMovimiento(abajo));

            movimientos.add(derecha);
            movimientos.add(izquierda);
            movimientos.add(arriba);
            movimientos.add(abajo);
        }

        bloque.ejecutar(sectorDibujo);

        assert(sectorDibujo.dibujoEsIgual(movimientos));
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
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            bloque.agregar(new BloqueMovimiento(derecha));
            bloque.agregar(new BloqueMovimiento(izquierda));
            bloque.agregar(new BloqueMovimiento(arriba));
            bloque.agregar(new BloqueMovimiento(abajo));

            movimientos.add(derecha);
            movimientos.add(izquierda);
            movimientos.add(arriba);
            movimientos.add(abajo);
        }

        decoratorBase = new DecoratorBloquePersonalizadoBase(bloque);
        decoratorBase.ejecutar(sectorDibujo);

        assert(sectorDibujo.dibujoEsIgual(movimientos));
    }
}

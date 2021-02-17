package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;
import fiuba.algo3.modelo.bloques.BloquePersonalizado;
import fiuba.algo3.modelo.bloques.DecoratorBloquePersonalizadoBase;
import fiuba.algo3.modelo.bloques.BloquePersonalizadoNoPuedeEjecutarseSinBloquesError;

import fiuba.algo3.modelo.direcciones.Este;
import fiuba.algo3.modelo.direcciones.Norte;
import fiuba.algo3.modelo.direcciones.Oeste;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BloquePersonalizadoTests {

    @Test
    public void test01BloquePersonalizadoSeEjecutaConUnBloqueDeMovimientoHaciaElEste() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este());
        sectorDibujo.invertirDibuja();

        bloque.agregar(bloqueEste);
        bloque.ejecutar(sectorDibujo);

        assert(sectorDibujo.existe(new Posicion(1, 0)));
    }

    @Test
    public void test02DecoratorDeBloquePersonalizadoBaseNoAlteraElComportamientoDelBloquePersonalizado () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este());
        sectorDibujo.invertirDibuja();

        bloque.agregar(bloqueEste);

        DecoratorBloquePersonalizadoBase decorator = new DecoratorBloquePersonalizadoBase(bloque);

        decorator.ejecutar(sectorDibujo);

        assert(sectorDibujo.existe(new Posicion(1, 0)));
    }

    @Test
    public void test03BloquePersonalizadoSeEjecutaCon5BloquesDeMovimientoHaciaLaDerecha() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(new Este()));
        }

        bloque.ejecutar(sectorDibujo);

        assert(sectorDibujo.existe(new Posicion(1, 0)));
        assert(sectorDibujo.existe(new Posicion(2, 0)));
        assert(sectorDibujo.existe(new Posicion(3, 0)));
        assert(sectorDibujo.existe(new Posicion(4, 0)));
        assert(sectorDibujo.existe(new Posicion(5, 0)));
    }

    @Test
    public void test04BloquePersonalizadoNoPuedeEjecutarseSinAlMenosUnBloque() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> bloque.ejecutar(sectorDibujo));
    }

    @Test
    public void test05DecoratorConBloquePersonalizadoNoPuedeEjecutarseSinAlMenosUnBloque() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        DecoratorBloquePersonalizadoBase decoratorBase = new DecoratorBloquePersonalizadoBase(bloque);
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> decoratorBase.ejecutar(sectorDibujo));
    }

    @Test
    public void test06BloquePersonalizadoSeEjecutaCon5BloquesDeMovimientoHaciaLaDerechaY5HaciaArriba() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(new Este()));
            bloque.agregar(new BloqueMovimiento(new Norte()));
        }

        bloque.ejecutar(sectorDibujo);

        assert(sectorDibujo.existe(new Posicion(1, 0)));
        assert(sectorDibujo.existe(new Posicion(1, 1)));
        assert(sectorDibujo.existe(new Posicion(2, 1)));
        assert(sectorDibujo.existe(new Posicion(2, 2)));
        assert(sectorDibujo.existe(new Posicion(3, 2)));
        assert(sectorDibujo.existe(new Posicion(3, 3)));
        assert(sectorDibujo.existe(new Posicion(4, 3)));
        assert(sectorDibujo.existe(new Posicion(4, 4)));
        assert(sectorDibujo.existe(new Posicion(5, 4)));
        assert(sectorDibujo.existe(new Posicion(5, 5)));
    }
}
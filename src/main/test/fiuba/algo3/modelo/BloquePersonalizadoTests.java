package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.*;

import fiuba.algo3.modelo.direcciones.Este;
import fiuba.algo3.modelo.direcciones.Norte;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BloquePersonalizadoTests {

    @Test
    public void test01BloquePersonalizadoSeEjecutaConUnBloqueDeMovimientoHaciaElEste() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());

        bloque.agregar(bloqueEste);
        bloque.ejecutar(sectorDibujo);

        assert(sectorDibujo.existePosicion(new Posicion(1, 0)));
    }

    @Test
    public void test02DecoratorDeBloquePersonalizadoBaseNoAlteraElComportamientoDelBloquePersonalizado () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());

        bloque.agregar(bloqueEste);

        DecoratorBloquePersonalizadoBase decorator = new DecoratorBloquePersonalizadoBase(bloque);

        decorator.ejecutar(sectorDibujo);

        assert(sectorDibujo.existePosicion(new Posicion(1, 0)));
    }

    @Test
    public void test03BloquePersonalizadoSeEjecutaCon5BloquesDeMovimientoHaciaLaDerecha() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(new Este(), new Dibuja()));
        }

        bloque.ejecutar(sectorDibujo);

        assert(sectorDibujo.existePosicion(new Posicion(1, 0)));
        assert(sectorDibujo.existePosicion(new Posicion(2, 0)));
        assert(sectorDibujo.existePosicion(new Posicion(3, 0)));
        assert(sectorDibujo.existePosicion(new Posicion(4, 0)));
        assert(sectorDibujo.existePosicion(new Posicion(5, 0)));
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

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(new Este(), new Dibuja()));
            bloque.agregar(new BloqueMovimiento(new Norte(), new Dibuja()));
        }

        bloque.ejecutar(sectorDibujo);

        assert(sectorDibujo.existePosicion(new Posicion(1, 0)));
        assert(sectorDibujo.existePosicion(new Posicion(1, 1)));
        assert(sectorDibujo.existePosicion(new Posicion(2, 1)));
        assert(sectorDibujo.existePosicion(new Posicion(2, 2)));
        assert(sectorDibujo.existePosicion(new Posicion(3, 2)));
        assert(sectorDibujo.existePosicion(new Posicion(3, 3)));
        assert(sectorDibujo.existePosicion(new Posicion(4, 3)));
        assert(sectorDibujo.existePosicion(new Posicion(4, 4)));
        assert(sectorDibujo.existePosicion(new Posicion(5, 4)));
        assert(sectorDibujo.existePosicion(new Posicion(5, 5)));
    }

    @Test
    public void test07AlAgregarVariosBloquesABloquePersonalizadoYLuegoSacarlosTodosElBloqueNoPuedeEjecutarse() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());

        for (int i = 0; i < 5; i++) {
            bloque.agregar(bloqueEste);
            bloque.agregar(bloqueNorte);
        }

        for (int i = 0; i < 5; i++) {
            bloque.sacar(bloqueEste);
            bloque.sacar(bloqueNorte);
        }

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> bloque.ejecutar(sectorDibujo));

        assertFalse(sectorDibujo.existePosicion(new Posicion(1, 0)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(1, 1)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(2, 1)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(2, 2)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(3, 2)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(3, 3)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(4, 3)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(4, 4)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 4)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 5)));
    }

    @Test
    public void test07AlAgregarVariosBloquesABloquePersonalizadoYLuegoSacarlosTodosExceptoUnoDeCadaElSectorDibujoQuedaConDosAristas() {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());

        for (int i = 0; i < 5; i++) {
            bloque.agregar(bloqueEste);
            bloque.agregar(bloqueNorte);
        }

        for (int i = 0; i < 4; i++) {
            bloque.sacar(bloqueEste);
            bloque.sacar(bloqueNorte);
        }

        bloque.ejecutar(sectorDibujo);

        assert(sectorDibujo.existeArista(new Posicion(0, 0), new Posicion(1, 0)));
        assert(sectorDibujo.existeArista(new Posicion(1, 0), new Posicion(1, 1)));

        assert(sectorDibujo.existePosicion(new Posicion(1, 0)));
        assert(sectorDibujo.existePosicion(new Posicion(1, 1)));

        assertFalse(sectorDibujo.existePosicion(new Posicion(2, 1)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(2, 2)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(3, 2)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(3, 3)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(4, 3)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(4, 4)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 4)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 5)));
    }
}
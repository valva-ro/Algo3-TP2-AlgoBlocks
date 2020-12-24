package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BloquePersonalizadoTests {

    @Test
    public void test01BloquePersonalizadoSeEjecutaConUnBloqueDeMovimientoHaciaLaDerecha () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();

        bloque.agregar(new BloqueMovimiento(new Posicion(1, 0)));
        bloque.ejecutar(sectorDibujo);

        // TODO: testear comportamiento con BloqueMovimiento cuando este implementado
    }

    @Test
    public void test02DecoratorDeBloquePersonalizadoBaseNoAlteraElComportamientoDelBloquePersonalizado () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();

        bloque.agregar(new BloqueMovimiento(new Posicion(1, 0)));

        DecoratorBloquePersonalizadoBase decorator = new DecoratorBloquePersonalizadoBase(bloque);

        decorator.ejecutar(sectorDibujo);

        // TODO: testear comportamiento con BloqueMovimiento cuando este implementado
    }

    @Test
    public void test03BloquePersonalizadoSeEjecutaConDiezBloquesDeMovimientoHaciaLaDerecha () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();

        for (int i = 0; i < 10; i++) {
            bloque.agregar(new BloqueMovimiento(new Posicion(1,0)));
        }
        bloque.ejecutar(sectorDibujo);

        // TODO: testear comportamiento con BloqueMovimiento cuando este implementado
    }

    @Test
    public void test04BloquePersonalizadoNoPuedeEjecutarseSinAlMenosUnBloque () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> {
                    bloque.ejecutar(sectorDibujo);
                });
    }
}

package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BloquePersonalizadoTests {

    @Test
    public void test01BloquePersonalizadoSeEjecutaConUnBloqueDeMovimientoHaciaLaDerecha () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();

        bloque.agregar(new BloqueMovimiento(new Derecha(new Dibuja())));
        bloque.ejecutar(sectorDibujo);

        // TODO: testear comportamiento en SectorDibujo cuando este implementado
        assert(true);
    }

    @Test
    public void test02DecoratorDeBloquePersonalizadoBaseNoAlteraElComportamientoDelBloquePersonalizado () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();

        bloque.agregar(new BloqueMovimiento(new Derecha(new Dibuja())));

        DecoratorBloquePersonalizadoBase decorator = new DecoratorBloquePersonalizadoBase(bloque);

        decorator.ejecutar(sectorDibujo);

        // TODO: testear comportamiento en SectorDibujo cuando este implementado
        assert(true);
    }

    @Test
    public void test03BloquePersonalizadoSeEjecutaConDiezBloquesDeMovimientoHaciaLaDerecha () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();

        for (int i = 0; i < 10; i++) {
            bloque.agregar(new BloqueMovimiento(new Derecha(new Dibuja())));
        }
        bloque.ejecutar(sectorDibujo);

        // TODO: testear comportamiento en SectorDibujo cuando este implementado
        assert(true);
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

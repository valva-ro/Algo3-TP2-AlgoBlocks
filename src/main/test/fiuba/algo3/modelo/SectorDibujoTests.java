package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SectorDibujoTests {
    @Test
    public void test01SectorDibujoInicialmenteTieneSoloUnBucleEnX0Y0() {
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 0)));

        for (int i = -100; i <= 100; i++) {
            for (int j = -100; j <= 100; j++) {
                if (i != 0 && j != 0)
                    assertFalse(sectorDibujo.existePosicion(new Posicion(i, j)));
            }
        }
    }

    @Test
    public void test02() {
        SectorDibujo sectorDibujo = new SectorDibujo();
    }

    @Test
    public void test03() {
        SectorDibujo sectorDibujo = new SectorDibujo();
    }
}
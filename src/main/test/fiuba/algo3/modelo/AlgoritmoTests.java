package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}

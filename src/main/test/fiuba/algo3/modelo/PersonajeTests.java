package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTests {

    @Test
    public void test01AlCrearElPersonajeTieneElLapizLevantado() {
        // Preguntar
        Personaje personaje = new Personaje();
        LapizLevantado lapiz = new LapizLevantado();
        assertEquals(personaje.obtenerLapiz().getClass(), lapiz.getClass());
    }

    @Test
    public void test02AlCrearElPersonajeYBajarElLapizTieneElLapizAbajo() {
        Personaje personaje = new Personaje();
        LapizBajado lapiz = new LapizBajado();
        personaje.bajarLapiz();
        assertEquals(personaje.obtenerLapiz().getClass(), lapiz.getClass());
    }
}

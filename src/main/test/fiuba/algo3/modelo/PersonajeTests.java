package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTests {

    @Test
    public void test01AlCrearElPersonajeTieneElLapizLevantado() {
        // TODO: preguntar si conviene usar el getClass() o implementar un metodo que sea lapizEstaLevantado() (aunque solo se use aca)
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

    @Test
    public void test03AlCrearElPersonajeSeUbicaEnElCentroDeCoordenadas() {
        Personaje personaje = new Personaje();
        Posicion  posicion  = new Posicion(0,0);

        assertTrue(personaje.estaEn(posicion));
    }

    @Test
    public void test04AlCrearElPersonajeYMoverloHaciaX0Y1EstaEnEsaPosicion() {
        Personaje personaje = new Personaje();
        Posicion  posicion  = new Posicion(0,1);

        personaje.moverHacia(posicion);

        assertTrue(personaje.estaEn(posicion));
    }
}

package fiuba.algo3.modelo;

import fiuba.algo3.modelo.direcciones.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DireccionTest {

    @Test
    public void test01SeActualizaDireccionNorte() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, 1);
        Direccion norte = new Norte();

        posicion = norte.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test02SeActualizaDireccionSur() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, -1);
        Direccion sur = new Sur();

        posicion = sur.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test03SeActualizaDireccionEste() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(1, 0);
        Direccion este = new Este();

        posicion = este.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test04SeActualizaDireccionOeste() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(-1, 0);
        Direccion oeste = new Oeste();

        posicion = oeste.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test05InvertirDireccionNorte() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, -1);
        Direccion norte = new Norte();

        norte = norte.invertir();
        posicion = norte.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test06InvertirDireccionSur() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, 1);
        Direccion sur = new Sur();

        sur = sur.invertir();
        posicion = sur.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test07InvertirDireccionEste() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(-1, 0);
        Direccion este = new Este();

        este = este.invertir();
        posicion = este.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test08InvertirDireccionOeste() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(1, 0);
        Direccion oeste = new Oeste();

        oeste = oeste.invertir();
        posicion = oeste.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test09InvertirDosVecesDireccionNorteDevuelveDireccionOriginal() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, 1);
        Direccion norte = new Norte();

        norte = norte.invertir();
        norte = norte.invertir();
        posicion = norte.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test10InvertirDosVecesDireccionSurDevuelveDireccionOriginal() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, -1);
        Direccion sur = new Sur();

        sur = sur.invertir();
        sur = sur.invertir();
        posicion = sur.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test11InvertirDosVecesDireccionEsteDevuelveDireccionOriginal() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(1, 0);
        Direccion este = new Este();

        este = este.invertir();
        este = este.invertir();
        posicion = este.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test12InvertirDosVecesDireccionOesteDevuelveDireccionOriginal() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(-1, 0);
        Direccion oeste = new Oeste();

        oeste = oeste.invertir();
        oeste = oeste.invertir();
        posicion = oeste.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test13SeActualizanVariasDirecciones() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, 1);
        Direccion sur = new Sur();
        Direccion este = new Este();
        Direccion oeste = new Oeste();
        Direccion norte = new Norte();

        posicion = norte.actualizarPosicion(posicion);
        posicion = norte.actualizarPosicion(posicion);
        posicion = sur.actualizarPosicion(posicion);
        posicion = oeste.actualizarPosicion(posicion);
        posicion = este.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test14SeActualizanVariasDireccionesInvertidas() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, -1);
        Direccion sur = new Sur();
        Direccion este = new Este();
        Direccion oeste = new Oeste();
        Direccion norte = new Norte();

        norte = norte.invertir();
        este = este.invertir();
        oeste = oeste.invertir();
        sur = sur.invertir();
        posicion = norte.actualizarPosicion(posicion);
        posicion = norte.actualizarPosicion(posicion);
        posicion = sur.actualizarPosicion(posicion);
        posicion = oeste.actualizarPosicion(posicion);
        posicion = este.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test15SeActualizanTantoDireccionesInvertidasComoNormales() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(2, 2);
        Direccion surInvertido = new Sur();
        Direccion este = new Este();
        Direccion oesteInvertido = new Oeste();
        Direccion norte = new Norte();

        oesteInvertido = oesteInvertido.invertir();
        surInvertido = surInvertido.invertir();
        posicion = norte.actualizarPosicion(posicion);
        posicion = surInvertido.actualizarPosicion(posicion);
        posicion = oesteInvertido.actualizarPosicion(posicion);
        posicion = este.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test01NegativoSeActualizaDireccionNorte() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, 0);
        Direccion norte = new Norte();

        posicion = norte.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test02NegativoSeActualizaDireccionSur() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, 0);
        Direccion sur = new Sur();

        posicion = sur.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test03NegativoSeActualizaDireccionEste() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, 0);
        Direccion este = new Este();

        posicion = este.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test04NegativoSeActualizaDireccionOeste() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, 0);
        Direccion oeste = new Oeste();

        posicion = oeste.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test05NegativoInvertirDireccionNorte() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, 1);
        Direccion norte = new Norte();

        norte = norte.invertir();
        posicion = norte.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test06NegativoInvertirDireccionSur() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, -1);
        Direccion sur = new Sur();

        sur = sur.invertir();
        posicion = sur.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test07NegativoInvertirDireccionEste() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(1, 0);
        Direccion este = new Este();

        este = este.invertir();
        posicion = este.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test08NegativoInvertirDireccionOeste() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(-1, 0);
        Direccion oeste = new Oeste();

        oeste = oeste.invertir();
        posicion = oeste.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test09NegativoInvertirDosVecesDireccionNorteDevuelveDireccionOriginal() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, -1);
        Direccion norte = new Norte();

        norte = norte.invertir();
        norte = norte.invertir();
        posicion = norte.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test10NegativoInvertirDosVecesDireccionSurDevuelveDireccionOriginal() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, 1);
        Direccion sur = new Sur();

        sur = sur.invertir();
        sur = sur.invertir();
        posicion = sur.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test11NegativoInvertirDosVecesDireccionEsteDevuelveDireccionOriginal() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(-1, 0);
        Direccion este = new Este();

        este = este.invertir();
        este = este.invertir();
        posicion = este.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test12NegativoInvertirDosVecesDireccionOesteDevuelveDireccionOriginal() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(1, 0);
        Direccion oeste = new Oeste();

        oeste = oeste.invertir();
        oeste = oeste.invertir();
        posicion = oeste.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test13NegativoSeActualizanVariasDirecciones() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, 0);
        Direccion sur = new Sur();
        Direccion este = new Este();
        Direccion oeste = new Oeste();
        Direccion norte = new Norte();

        posicion = norte.actualizarPosicion(posicion);
        posicion = norte.actualizarPosicion(posicion);
        posicion = sur.actualizarPosicion(posicion);
        posicion = oeste.actualizarPosicion(posicion);
        posicion = este.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test14NegativoSeActualizanVariasDireccionesInvertidas() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, 0);
        Direccion sur = new Sur();
        Direccion este = new Este();
        Direccion oeste = new Oeste();
        Direccion norte = new Norte();

        norte = norte.invertir();
        este = este.invertir();
        oeste = oeste.invertir();
        sur = sur.invertir();
        posicion = norte.actualizarPosicion(posicion);
        posicion = norte.actualizarPosicion(posicion);
        posicion = sur.actualizarPosicion(posicion);
        posicion = oeste.actualizarPosicion(posicion);
        posicion = este.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }

    @Test
    public void test15NegativoSeActualizanTantoDireccionesInvertidasComoNormales() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0, 0);
        Direccion surInvertido = new Sur();
        Direccion este = new Este();
        Direccion oesteInvertido = new Oeste();
        Direccion norte = new Norte();

        oesteInvertido = oesteInvertido.invertir();
        surInvertido = surInvertido.invertir();
        posicion = norte.actualizarPosicion(posicion);
        posicion = surInvertido.actualizarPosicion(posicion);
        posicion = oesteInvertido.actualizarPosicion(posicion);
        posicion = este.actualizarPosicion(posicion);

        assertFalse(posicion.esIgual(posicionActualizada));
    }
}
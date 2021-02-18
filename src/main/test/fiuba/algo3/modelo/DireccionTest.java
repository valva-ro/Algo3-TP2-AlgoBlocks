package fiuba.algo3.modelo;

import fiuba.algo3.modelo.direcciones.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DireccionTest {

    @Test
    public void test01SeActualizaDireccionNorte() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0,1);
        Direccion Norte = new Norte();

        posicion = Norte.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test02SeActualizaDireccionSur() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0,-1);
        Direccion Sur = new Sur();

        posicion = Sur.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test03SeActualizaDireccionEste() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(1,0);
        Direccion Este = new Este();

        posicion = Este.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test04SeActualizaDireccionOeste() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(-1,0);
        Direccion Oeste = new Oeste();

        posicion = Oeste.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test05InvertirDireccionNorte() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0,-1);
        Direccion Norte = new Norte();

        Norte = Norte.invertir();
        posicion = Norte.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test06InvertirDireccionSur() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0,1);
        Direccion Sur = new Sur();

        Sur = Sur.invertir();
        posicion = Sur.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test07InvertirDireccionEste() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(-1,0);
        Direccion Este = new Este();

        Este = Este.invertir();
        posicion = Este.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test08InvertirDireccionOeste() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(1,0);
        Direccion Oeste = new Oeste();

        Oeste = Oeste.invertir();
        posicion = Oeste.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test09InvertirDosVecesDireccionNorteDevuelveDireccionOriginal() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0,1);
        Direccion Norte = new Norte();

        Norte = Norte.invertir();
        Norte = Norte.invertir();
        posicion = Norte.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test10InvertirDosVecesDireccionSurDevuelveDireccionOriginal() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0,-1);
        Direccion Sur = new Sur();

        Sur = Sur.invertir();
        Sur = Sur.invertir();
        posicion = Sur.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test11InvertirDosVecesDireccionEsteDevuelveDireccionOriginal() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(1,0);
        Direccion Este = new Este();

        Este = Este.invertir();
        Este = Este.invertir();
        posicion = Este.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test12InvertirDosVecesDireccionOesteDevuelveDireccionOriginal() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(-1,0);
        Direccion Oeste = new Oeste();

        Oeste = Oeste.invertir();
        Oeste = Oeste.invertir();
        posicion = Oeste.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test13SeActualizanVariasDirecciones() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0,1);
        Direccion Sur = new Sur();
        Direccion Este = new Este();
        Direccion Oeste = new Oeste();
        Direccion Norte = new Norte();

        posicion = Norte.actualizarPosicion(posicion);
        posicion = Norte.actualizarPosicion(posicion);
        posicion = Sur.actualizarPosicion(posicion);
        posicion = Oeste.actualizarPosicion(posicion);
        posicion = Este.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test14SeActualizanVariasDireccionesInvertidas() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(0,-1);
        Direccion Sur = new Sur();
        Direccion Este = new Este();
        Direccion Oeste = new Oeste();
        Direccion Norte = new Norte();

        Norte = Norte.invertir();
        Este = Este.invertir();
        Oeste = Oeste.invertir();
        Sur = Sur.invertir();
        posicion = Norte.actualizarPosicion(posicion);
        posicion = Norte.actualizarPosicion(posicion);
        posicion = Sur.actualizarPosicion(posicion);
        posicion = Oeste.actualizarPosicion(posicion);
        posicion = Este.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }

    @Test
    public void test15SeActualizanTantoDireccionesInvertidasComoNormales() {
        Posicion posicion = new Posicion();
        Posicion posicionActualizada = new Posicion(2,2);
        Direccion SurInvertido = new Sur();
        Direccion Este = new Este();
        Direccion OesteInvertido = new Oeste();
        Direccion Norte = new Norte();

        OesteInvertido = OesteInvertido.invertir();
        SurInvertido = SurInvertido.invertir();
        posicion = Norte.actualizarPosicion(posicion);
        posicion = SurInvertido.actualizarPosicion(posicion);
        posicion = OesteInvertido.actualizarPosicion(posicion);
        posicion = Este.actualizarPosicion(posicion);

        assertTrue(posicion.esIgual(posicionActualizada));

    }



}

package fiuba.algo3.modelo;

import fiuba.algo3.modelo.direcciones.Oeste;
import fiuba.algo3.modelo.direcciones.Sur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import fiuba.algo3.modelo.bloques.*;

public class BloqueInvertirTest {

    @Test
    public void test01ElBloqueInvertirLanzaLaExcepcionDeBloquePersonalizadoAlEjecutarseSinNingunBloqueDentro()
    {
        BloqueInvertir bloqueInvertir = new BloqueInvertir();
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> bloqueInvertir.ejecutar(sectorDibujo));
    }

    @Test
    public void test02AgregarUnBloqueAlBloqueInvertirYEjecutarloRealizaLaOperacionInversaDelBloqueInterior()
    {
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        BloqueInvertir bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregar(bloqueMovimientoMock);

        bloqueInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock, times(1)).ejecutarInvertido(sectorDibujoMock);
    }


    @Test
    public void test03EjecutarElBloqueInvertirConDosBloquesInterioresRealizaLaOperacionInversaEnCadaUnoDeEllos()
    {
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        BloqueInvertir bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregar(bloqueMovimientoMock);
        bloqueInvertir.agregar(otroMovimientoMock);

        bloqueInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(1)).ejecutarInvertido(sectorDibujoMock);
        verify(otroMovimientoMock,times(1)).ejecutarInvertido(sectorDibujoMock);
    }

    @Test
    public void test04UnBloqueInvertirConUnBloqueRepetirDosVecesQueAdemasTieneOtroBloqueLoEjecutaDosVecesInvertido()
    {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloqueRepetir);

        bloqueInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(2)).ejecutarInvertido(sectorDibujoMock);
    }

    @Test
    public void test05UnBloqueInvertirConUnBloqueRepetirTresVecesConUnBloqueDeMovimientoLoEjecutaTresVecesInvertido()
    {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloqueRepetir);

        bloqueInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(3)).ejecutarInvertido(sectorDibujoMock);
    }


    @Test
    public void test06ElEjecutarInvertidoDeUnBloqueInvertirRealizaLaEjecucionNormalDeLosBloquesInteriores()
    {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueInvertir bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregar(bloqueMovimientoMock);

        bloqueInvertir.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(0)).ejecutarInvertido(sectorDibujoMock);
        verify(bloqueMovimientoMock,times(1)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test07EjecutarUnBloqueInvertirConUnBloqueInvertirDentroRealizaUnaOperacionSinInvertir()
    {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueInvertir bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregar(bloqueMovimientoMock);

        BloqueInvertir otroBloqueInvertir = new BloqueInvertir(bloqueInvertir);

        otroBloqueInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(0)).ejecutarInvertido(sectorDibujoMock);
        verify(bloqueMovimientoMock,times(1)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test08TenerTresBloquesInvertirUnoDentroDeOtroEjecutaDeManeraInvertida()
    {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueInvertir primerInvertir = new BloqueInvertir();

        primerInvertir.agregar(bloqueMovimientoMock);

        BloqueInvertir segundoInvertir = new BloqueInvertir(primerInvertir);
        BloqueInvertir tercerInvertir = new BloqueInvertir(segundoInvertir);

        tercerInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(1)).ejecutarInvertido(sectorDibujoMock);
    }

    @Test
    public void test09TenerUnBloqueInvertirDentroDeOtroNoInviertePeroSiInvierteLoQueNoOesteEnElPrimerInvertir()
    {
        BloqueMovimiento unBloqueMovimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        BloqueInvertir primerInvertir = new BloqueInvertir();
        BloqueInvertir segundoInvertir = new BloqueInvertir();

        primerInvertir.agregar(unBloqueMovimientoMock);

        segundoInvertir.agregar(primerInvertir);
        segundoInvertir.agregar(otroMovimientoMock);

        segundoInvertir.ejecutar(sectorDibujoMock);

        verify(unBloqueMovimientoMock,times(0)).ejecutarInvertido(sectorDibujoMock);
        verify(otroMovimientoMock,times(1)).ejecutarInvertido(sectorDibujoMock);
    }

    @Test
    public void test10AlAgregarUnBloqueDeMovimientoYLuegoSacarloElBloqueNoPuedeEjecutarse() {

        BloqueInvertir bloque = new BloqueInvertir();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new Dibuja());

        bloque.agregar(bloqueOeste);
        bloque.sacar(bloqueOeste);

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> bloque.ejecutar(sectorDibujo));

        assertFalse(sectorDibujo.existePosicion(new Posicion(1, 0)));
        assertFalse(sectorDibujo.existeArista(new Posicion(0, 0), new Posicion(1, 0)));
    }

    @Test
    public void test11AlAgregarDosBloqueDeMovimientoYLuegoSacarUnoElDibujoQuedaConUnaArista() {

        BloqueInvertir bloque = new BloqueInvertir();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new Dibuja());

        bloque.agregar(bloqueOeste);
        bloque.agregar(bloqueOeste);
        bloque.sacar(bloqueOeste);

        bloque.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(1, 0)));
        assertTrue(sectorDibujo.existeArista(new Posicion(0, 0), new Posicion(1, 0)));
    }

    @Test
    public void test12AlAgregarVariosBloqueDeMovimientoYLuegoSacarlosTodosElBloqueNoPuedeEjecutarse() {

        BloqueInvertir bloque = new BloqueInvertir();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new Dibuja());
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur(), new Dibuja());

        for (int i = 0; i < 5; i++) {
            bloque.agregar(bloqueOeste);
            bloque.agregar(bloqueSur);
        }

        for (int i = 0; i < 5; i++) {
            bloque.sacar(bloqueOeste);
            bloque.sacar(bloqueSur);
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
    public void test13AlAgregarVariosBloqueDeMovimientoYLuegoSacarlosTodosExceptoUnoElSectorDibujoContieneDosAristas() {

        BloqueInvertir bloque = new BloqueInvertir();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new Dibuja());
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur(), new Dibuja());

        for (int i = 0; i < 5; i++) {
            bloque.agregar(bloqueOeste);
            bloque.agregar(bloqueSur);
        }

        for (int i = 0; i < 4; i++) {
            bloque.sacar(bloqueOeste);
            bloque.sacar(bloqueSur);
        }

        bloque.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(1, 0)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(1, 1)));

        assertTrue(sectorDibujo.existeArista(new Posicion(0, 0), new Posicion(1, 0)));
        assertTrue(sectorDibujo.existeArista(new Posicion(1, 0), new Posicion(1, 1)));

        assertFalse(sectorDibujo.existePosicion(new Posicion(2, 1)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(2, 2)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(3, 2)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(3, 3)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(4, 3)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(4, 4)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 4)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 5)));

        assertFalse(sectorDibujo.existeArista(new Posicion(1, 1), new Posicion(2, 1)));
        assertFalse(sectorDibujo.existeArista(new Posicion(2, 1), new Posicion(2, 2)));
        assertFalse(sectorDibujo.existeArista(new Posicion(2, 2), new Posicion(3, 2)));
        assertFalse(sectorDibujo.existeArista(new Posicion(3, 2), new Posicion(3, 3)));
        assertFalse(sectorDibujo.existeArista(new Posicion(3, 3), new Posicion(4, 3)));
        assertFalse(sectorDibujo.existeArista(new Posicion(4, 3), new Posicion(4, 4)));
        assertFalse(sectorDibujo.existeArista(new Posicion(4, 4), new Posicion(5, 4)));
        assertFalse(sectorDibujo.existeArista(new Posicion(5, 4), new Posicion(5, 5)));
    }
}

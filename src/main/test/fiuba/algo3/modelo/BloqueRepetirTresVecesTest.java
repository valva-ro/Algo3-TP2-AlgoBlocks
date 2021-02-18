package fiuba.algo3.modelo;

import fiuba.algo3.modelo.direcciones.Este;
import fiuba.algo3.modelo.direcciones.Norte;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import fiuba.algo3.modelo.bloques.*;

public class BloqueRepetirTresVecesTest {

    @Test
    public void test01ElBloqueRepetirTresVecesLanzaLaExcepcionDeBloquePersonalizadoAlEjecutarseSinNingunBloqueDentro()
    {
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces();
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> bloqueRepetir.ejecutar(sectorDibujo));
    }

    @Test
    public void test02AlEjecutarElBloqueRepetirTresVecesConUnBloqueSoloEsteUltimoSeEjecutaTresVeces()
    {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);

        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(3)).ejecutar(sectorDibujoMock);
    }


    @Test
    public void test03AlEjecutarDosVecesElBloqueRepetirTresVecesConUnBloqueSoloEsteUltimoSeEjecutaSeisVeces()
    {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);

        bloqueRepetir.ejecutar(sectorDibujoMock);
        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(6)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test04AlEjecutarUnaVezElBloqueRepetirTresVecesConDosBloquesSeEjecutaCadaUnoTresVeces()
    {
        BloqueMovimiento movimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces();

        bloqueRepetir.agregar(movimientoMock);
        bloqueRepetir.agregar(otroMovimientoMock);

        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(movimientoMock,times(3)).ejecutar(sectorDibujoMock);
        verify(otroMovimientoMock,times(3)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test05AlEjecutarDosVecesElBloqueRepetirTresVecesConDosBloquesSeEjecutaCadaUnoSeisVeces()
    {
        BloqueMovimiento movimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces();

        bloqueRepetir.agregar(movimientoMock);
        bloqueRepetir.agregar(otroMovimientoMock);

        bloqueRepetir.ejecutar(sectorDibujoMock);
        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(movimientoMock,times(6)).ejecutar(sectorDibujoMock);
        verify(otroMovimientoMock,times(6)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test06TenerUnBloqueRepetirTresVecesDentroDeOtroBloqueRepetirTresVecesSeEjecutaNueveVeces()
    {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);

        BloqueRepetirTresVeces otroBloqueRepetir = new BloqueRepetirTresVeces(bloqueRepetir);

        otroBloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(9)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test07TenerUnBloqueRepetirDosVecesDentroDeUnBloqueRepetirTresVecesSeEjecutaSeisVeces()
    {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirDosVeces bloqueRepetirDosVeces = new BloqueRepetirDosVeces();

        bloqueRepetirDosVeces.agregar(bloqueMovimientoMock);

        BloqueRepetirTresVeces bloqueRepetirTresVeces = new BloqueRepetirTresVeces(bloqueRepetirDosVeces);

        bloqueRepetirTresVeces.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(6)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test08EjecutarDeFormaInvertidaUnBloqueRepetirTresVecesEjecutaTresVecesDeFormaInvertidaLosBloquesInternos()
    {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirTresVeces bloqueRepetirTresVeces = new BloqueRepetirTresVeces();

        bloqueRepetirTresVeces.agregar(bloqueMovimientoMock);

        bloqueRepetirTresVeces.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(3)).ejecutarInvertido(sectorDibujoMock);
    }


    @Test
    public void test09EjecutarDeFormaInvertidaUnBloqueRepetirTresVecesNoEjecutaLaFormaEstandard()
    {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirTresVeces bloqueRepetirTresVeces = new BloqueRepetirTresVeces();

        bloqueRepetirTresVeces.agregar(bloqueMovimientoMock);

        bloqueRepetirTresVeces.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(0)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test10AgregarBloquesAlBloqueRepetirTresVecesTambienLosEjecutaTresVeces()
    {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);

        bloqueRepetir.agregar(otroMovimientoMock);

        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(3)).ejecutar(sectorDibujoMock);
        verify(otroMovimientoMock,times(3)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test11AgregarBloquesAlBloqueRepetirTresVecesTambienLosEjecutaTresVecesDeFormaInvertida()
    {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);

        bloqueRepetir.agregar(otroMovimientoMock);

        bloqueRepetir.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(3)).ejecutarInvertido(sectorDibujoMock);
        verify(otroMovimientoMock,times(3)).ejecutarInvertido(sectorDibujoMock);
    }

    @Test
    public void test12AlAgregarUnBloqueDeMovimientoYLuegoSacarloElBloqueNoPuedeEjecutarse() {

        BloqueRepetirTresVeces bloque = new BloqueRepetirTresVeces();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());

        bloque.agregar(bloqueEste);
        bloque.sacar(bloqueEste);

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> bloque.ejecutar(sectorDibujo));

        assertFalse(sectorDibujo.existePosicion(new Posicion(1, 0)));
        assertFalse(sectorDibujo.existeArista(new Posicion(0, 0), new Posicion(1, 0)));
    }

    @Test
    public void test13AlAgregarDosBloqueDeMovimientoYLuegoSacarUnoElDibujoQuedaConTresAristas() {

        BloqueRepetirTresVeces bloque = new BloqueRepetirTresVeces();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());

        bloque.agregar(bloqueEste);
        bloque.agregar(bloqueEste);
        bloque.sacar(bloqueEste);

        bloque.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(1, 0)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(2, 0)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(3, 0)));

        assertTrue(sectorDibujo.existeArista(new Posicion(0, 0), new Posicion(1, 0)));
        assertTrue(sectorDibujo.existeArista(new Posicion(1, 0), new Posicion(2, 0)));
        assertTrue(sectorDibujo.existeArista(new Posicion(2, 0), new Posicion(3, 0)));
    }

    @Test
    public void test13AlAgregarVariosBloqueDeMovimientoYLuegoSacarlosTodosElBloqueNoPuedeEjecutarse() {

        BloqueRepetirTresVeces bloque = new BloqueRepetirTresVeces();
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
    public void test14AlAgregarVariosBloqueDeMovimientoYLuegoSacarlosTodosExceptoUnoElSectorDibujoContieneSeisAristas() {

        BloqueRepetirTresVeces bloque = new BloqueRepetirTresVeces();
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

        assertTrue(sectorDibujo.existePosicion(new Posicion(1, 0)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(1, 1)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(2, 1)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(2, 2)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(3, 2)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(3, 3)));

        assertTrue(sectorDibujo.existeArista(new Posicion(0, 0), new Posicion(1, 0)));
        assertTrue(sectorDibujo.existeArista(new Posicion(1, 0), new Posicion(1, 1)));
        assertTrue(sectorDibujo.existeArista(new Posicion(1, 1), new Posicion(2, 1)));
        assertTrue(sectorDibujo.existeArista(new Posicion(2, 1), new Posicion(2, 2)));
        assertTrue(sectorDibujo.existeArista(new Posicion(2, 2), new Posicion(3, 2)));
        assertTrue(sectorDibujo.existeArista(new Posicion(3, 2), new Posicion(3, 3)));

        assertFalse(sectorDibujo.existePosicion(new Posicion(4, 3)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(4, 4)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 4)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 5)));

        assertFalse(sectorDibujo.existeArista(new Posicion(3, 3), new Posicion(4, 3)));
        assertFalse(sectorDibujo.existeArista(new Posicion(4, 3), new Posicion(4, 4)));
        assertFalse(sectorDibujo.existeArista(new Posicion(4, 4), new Posicion(5, 4)));
        assertFalse(sectorDibujo.existeArista(new Posicion(5, 4), new Posicion(5, 5)));
    }
}
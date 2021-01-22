package fiuba.algo3.modelo;

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
}
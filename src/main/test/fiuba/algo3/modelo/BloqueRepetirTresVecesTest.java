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
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces(bloquePersonalizado);
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> bloqueRepetir.ejecutar(sectorDibujo));
    }

    @Test
    public void test02AlEjecutarElBloqueRepetirTresVecesConUnBloqueSoloEsteUltimoSeEjecutaTresVeces()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();

        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces(bloquePersonalizado);

        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(3)).ejecutar(sectorDibujoMock);
    }


    @Test
    public void test03AlEjecutarDosVecesElBloqueRepetirTresVecesConUnBloqueSoloEsteUltimoSeEjecutaSeisVeces()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();

        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces(bloquePersonalizado);

        bloqueRepetir.ejecutar(sectorDibujoMock);
        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(6)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test04AlEjecutarUnaVezElBloqueRepetirTresVecesConDosBloquesSeEjecutaCadaUnoTresVeces()
    {

        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();

        BloqueMovimiento movimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(movimientoMock);
        bloquePersonalizado.agregar(otroMovimientoMock);
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces(bloquePersonalizado);

        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(movimientoMock,times(3)).ejecutar(sectorDibujoMock);
        verify(otroMovimientoMock,times(3)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test05AlEjecutarDosVecesElBloqueRepetirTresVecesConDosBloquesSeEjecutaCadaUnoSeisVeces()
    {

        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();

        BloqueMovimiento movimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(movimientoMock);
        bloquePersonalizado.agregar(otroMovimientoMock);
        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces(bloquePersonalizado);

        bloqueRepetir.ejecutar(sectorDibujoMock);
        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(movimientoMock,times(6)).ejecutar(sectorDibujoMock);
        verify(otroMovimientoMock,times(6)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test06TenerUnBloqueRepetirTresVecesDentroDeOtroBloqueRepetirTresVecesSeEjecutaNueveVeces()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces(bloquePersonalizado);
        BloqueRepetirTresVeces otroBloqueRepetir = new BloqueRepetirTresVeces(bloqueRepetir);

        otroBloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(9)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test07TenerUnBloqueRepetirDosVecesDentroDeUnBloqueRepetirTresVecesSeEjecutaSeisVeces()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirDosVeces bloqueRepetirDosVeces = new BloqueRepetirDosVeces(bloquePersonalizado);
        BloqueRepetirTresVeces bloqueRepetirTresVeces = new BloqueRepetirTresVeces(bloqueRepetirDosVeces);

        bloqueRepetirTresVeces.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(6)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test08EjecutarDeFormaInvertidaUnBloqueRepetirTresVecesEjecutaTresVecesDeFormaInvertidaLosBloquesInternos()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirTresVeces bloqueRepetirTresVeces = new BloqueRepetirTresVeces(bloquePersonalizado);

        bloqueRepetirTresVeces.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(3)).ejecutarInvertido(sectorDibujoMock);
    }


    @Test
    public void test09EjecutarDeFormaInvertidaUnBloqueRepetirTresVecesNoEjecutaLaFormaEstandard()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirTresVeces bloqueRepetirTresVeces = new BloqueRepetirTresVeces(bloquePersonalizado);

        bloqueRepetirTresVeces.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(0)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test10AgregarBloquesAlBloqueRepetirTresVecesTambienLosEjecutaTresVeces()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces(bloquePersonalizado);

        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);

        bloqueRepetir.agregar(otroMovimientoMock);

        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(3)).ejecutar(sectorDibujoMock);
        verify(otroMovimientoMock,times(3)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test11AgregarBloquesAlBloqueRepetirTresVecesTambienLosEjecutaTresVecesDeFormaInvertida()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces(bloquePersonalizado);

        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);

        bloqueRepetir.agregar(otroMovimientoMock);

        bloqueRepetir.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(3)).ejecutarInvertido(sectorDibujoMock);
        verify(otroMovimientoMock,times(3)).ejecutarInvertido(sectorDibujoMock);
    }
}
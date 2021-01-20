package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import fiuba.algo3.modelo.bloques.*;

public class BloqueRepetirDosVecesTest {

    @Test
    public void test01ElBloqueRepetirDosVecesLanzaLaExcepcionDeBloquePersonalizadoAlEjecutarseSinNingunBloqueDentro()
    {
        BloquePersonalizado bloque = new BloquePersonalizado();
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces(bloque);
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> bloqueRepetir.ejecutar(sectorDibujo));
    }

    @Test
    public void test02AlEjecutarElBloqueRepetirDosVecesConUnBloqueSoloEsteUltimoSeEjecutaDosVeces()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();

        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces(bloquePersonalizado);

        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(2)).ejecutar(sectorDibujoMock);
    }


    @Test
    public void test03AlEjecutarDosVecesElBloqueRepetirConUnBloqueSoloEsteUltimoSeEjecutaCuatroVeces()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();

        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces(bloquePersonalizado);

        bloqueRepetir.ejecutar(sectorDibujoMock);
        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(4)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test04AlEjecutarUnaVezElBloqueRepetirConDosBloquesSeEjecutaCadaUnoDosVeces()
    {

        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();

        BloqueMovimiento movimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(movimientoMock);
        bloquePersonalizado.agregar(otroMovimientoMock);
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces(bloquePersonalizado);

        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(movimientoMock,times(2)).ejecutar(sectorDibujoMock);
        verify(otroMovimientoMock,times(2)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test05AlEjecutarDosVecesElBloqueRepetirConDosBloquesSeEjecutaCadaUnoCuatroVeces()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();

        BloqueMovimiento movimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(movimientoMock);
        bloquePersonalizado.agregar(otroMovimientoMock);
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces(bloquePersonalizado);

        bloqueRepetir.ejecutar(sectorDibujoMock);
        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(movimientoMock,times(4)).ejecutar(sectorDibujoMock);
        verify(otroMovimientoMock,times(4)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test06TenerUnBloqueRepetirDosVecesDentroDeOtroBloqueRepetirDosVecesSeEjecutaCuatroVeces()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces(bloquePersonalizado);
        BloqueRepetirDosVeces otroBloqueRepetir = new BloqueRepetirDosVeces(bloqueRepetir);

        otroBloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(4)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test07TenerUnBloqueRepetirTresVecesDentroDeUnBloqueRepetirDosVecesSeEjecutaSeisVeces()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirTresVeces bloqueRepetirTresVeces = new BloqueRepetirTresVeces(bloquePersonalizado);
        BloqueRepetirDosVeces bloqueRepetirDosVeces = new BloqueRepetirDosVeces(bloqueRepetirTresVeces);

        bloqueRepetirDosVeces.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(6)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test08EjecutarDeFormaInvertidaUnBloqueRepetirDosVecesEjecutaDosVecesDeFormaInvertidaLosBloquesInternos()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirDosVeces bloqueRepetirDosVeces = new BloqueRepetirDosVeces(bloquePersonalizado);

        bloqueRepetirDosVeces.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(2)).ejecutarInvertido(sectorDibujoMock);
    }


    @Test
    public void test09EjecutarDeFormaInvertidaUnBloqueRepetirDosVecesNoEjecutaLaFormaEstandard()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirDosVeces bloqueRepetirDosVeces = new BloqueRepetirDosVeces(bloquePersonalizado);

        bloqueRepetirDosVeces.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(0)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test10AgregarBloquesAlBloqueRepetirDosVecesTambienLosEjecutaDosVeces()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces(bloquePersonalizado);

        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);

        bloqueRepetir.agregar(otroMovimientoMock);

        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(2)).ejecutar(sectorDibujoMock);
        verify(otroMovimientoMock,times(2)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test11AgregarBloquesAlBloqueRepetirDosVecesTambienLosEjecutaDosVecesDeFormaInvertida()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces(bloquePersonalizado);

        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);

        bloqueRepetir.agregar(otroMovimientoMock);

        bloqueRepetir.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(2)).ejecutarInvertido(sectorDibujoMock);
        verify(otroMovimientoMock,times(2)).ejecutarInvertido(sectorDibujoMock);
    }
}

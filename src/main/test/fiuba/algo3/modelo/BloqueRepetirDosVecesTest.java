package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import fiuba.algo3.modelo.bloques.*;

public class BloqueRepetirDosVecesTest {

    @Test
    public void test01ElBloqueRepetirDosVecesLanzaLaExcepcionDeBloquePersonalizadoAlEjecutarseSinNingunBloqueDentro() {
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces();
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> bloqueRepetir.ejecutar(sectorDibujo));
    }

    @Test
    public void test02AlEjecutarElBloqueRepetirDosVecesConUnBloqueSoloEsteUltimoSeEjecutaDosVeces() {

        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);

        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(2)).ejecutar(sectorDibujoMock);
    }


    @Test
    public void test03AlEjecutarDosVecesElBloqueRepetirConUnBloqueSoloEsteUltimoSeEjecutaCuatroVeces() {

        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);

        bloqueRepetir.ejecutar(sectorDibujoMock);
        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(4)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test04AlEjecutarUnaVezElBloqueRepetirConDosBloquesSeEjecutaCadaUnoDosVeces() {

        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);
        bloqueRepetir.agregar(otroMovimientoMock);

        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(2)).ejecutar(sectorDibujoMock);
        verify(otroMovimientoMock,times(2)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test05AlEjecutarDosVecesElBloqueRepetirConDosBloquesSeEjecutaCadaUnoCuatroVeces() {

        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);
        bloqueRepetir.agregar(otroMovimientoMock);

        bloqueRepetir.ejecutar(sectorDibujoMock);
        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(4)).ejecutar(sectorDibujoMock);
        verify(otroMovimientoMock,times(4)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test06TenerUnBloqueRepetirDosVecesDentroDeOtroBloqueRepetirDosVecesSeEjecutaCuatroVeces() {

        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);
        bloqueRepetir.agregar(otroMovimientoMock);

        BloqueRepetirDosVeces otroBloqueRepetir = new BloqueRepetirDosVeces(bloqueRepetir);

        otroBloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(4)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test07TenerUnBloqueRepetirTresVecesDentroDeUnBloqueRepetirDosVecesSeEjecutaSeisVeces() {
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirTresVeces bloqueRepetirTresVeces = new BloqueRepetirTresVeces();

        bloqueRepetirTresVeces.agregar(bloqueMovimientoMock);

        BloqueRepetirDosVeces bloqueRepetirDosVeces = new BloqueRepetirDosVeces(bloqueRepetirTresVeces);

        bloqueRepetirDosVeces.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(6)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test08EjecutarDeFormaInvertidaUnBloqueRepetirDosVecesEjecutaDosVecesDeFormaInvertidaLosBloquesInternos() {

        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirDosVeces bloqueRepetirDosVeces = new BloqueRepetirDosVeces();

        bloqueRepetirDosVeces.agregar(bloqueMovimientoMock);

        bloqueRepetirDosVeces.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(2)).ejecutarInvertido(sectorDibujoMock);
    }


    @Test
    public void test09EjecutarDeFormaInvertidaUnBloqueRepetirDosVecesNoEjecutaLaFormaEstandard() {

        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirDosVeces bloqueRepetirDosVeces = new BloqueRepetirDosVeces();

        bloqueRepetirDosVeces.agregar(bloqueMovimientoMock);

        bloqueRepetirDosVeces.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(0)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test10AgregarBloquesAlBloqueRepetirDosVecesTambienLosEjecutaDosVeces() {

        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);

        bloqueRepetir.agregar(otroMovimientoMock);

        bloqueRepetir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(2)).ejecutar(sectorDibujoMock);
        verify(otroMovimientoMock,times(2)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test11AgregarBloquesAlBloqueRepetirDosVecesTambienLosEjecutaDosVecesDeFormaInvertida() {

        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces();

        bloqueRepetir.agregar(bloqueMovimientoMock);

        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);

        bloqueRepetir.agregar(otroMovimientoMock);

        bloqueRepetir.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(2)).ejecutarInvertido(sectorDibujoMock);
        verify(otroMovimientoMock,times(2)).ejecutarInvertido(sectorDibujoMock);
    }
}

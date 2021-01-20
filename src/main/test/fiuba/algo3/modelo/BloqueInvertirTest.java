package fiuba.algo3.modelo;

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
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloquePersonalizado);
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> bloqueInvertir.ejecutar(sectorDibujo));
    }

    @Test
    public void test02AgregarUnBloqueAlBloqueInvertirYEjecutarloRealizaLaOperaciónInversaDelBloqueInterior()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloquePersonalizado);

        bloqueInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock, times(1)).ejecutarInvertido(sectorDibujoMock);
    }


    @Test
    public void test03EjecutarElBloqueInvertirConDosBloquesInterioresRealizaLaOperaciónInversaEnCadaUnoDeEllos()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);
        bloquePersonalizado.agregar(otroMovimientoMock);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloquePersonalizado);

        bloqueInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(1)).ejecutarInvertido(sectorDibujoMock);
        verify(otroMovimientoMock,times(1)).ejecutarInvertido(sectorDibujoMock);
    }

    @Test
    public void test04UnBloqueInvertirConUnBloqueRepetirDosVecesQueAdemasTieneOtroBloqueLoEjecutaDosVecesInvertido()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirDosVeces bloqueRepetir = new BloqueRepetirDosVeces(bloquePersonalizado);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloqueRepetir);

        bloqueInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(2)).ejecutarInvertido(sectorDibujoMock);
    }

    @Test
    public void test05UnBloqueInvertirConUnBloqueRepetirTresVecesConUnBloqueDeMovimientoLoEjecutaTresVecesInvertido()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueRepetirTresVeces bloqueRepetir = new BloqueRepetirTresVeces(bloquePersonalizado);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloqueRepetir);

        bloqueInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(3)).ejecutarInvertido(sectorDibujoMock);
    }


    @Test
    public void test06ElEjecutarInvertidoDeUnBloqueInvertirRealizaLaEjecucionNormalDeLosBloquesInteriores()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloquePersonalizado);

        bloqueInvertir.ejecutarInvertido(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(0)).ejecutarInvertido(sectorDibujoMock);
        verify(bloqueMovimientoMock,times(1)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test07EjecutarUnBloqueInvertirConUnBloqueInvertirDentroRealizaUnaOperacionSinInvertir()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloquePersonalizado);
        BloqueInvertir otroBloqueInvertir = new BloqueInvertir(bloqueInvertir);

        otroBloqueInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(0)).ejecutarInvertido(sectorDibujoMock);
        verify(bloqueMovimientoMock,times(1)).ejecutar(sectorDibujoMock);
    }

    @Test
    public void test08TenerTresBloquesInvertirUnoDentroDeOtroEjecutaDeManeraInvertida()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueInvertir primerInvertir = new BloqueInvertir(bloquePersonalizado);
        BloqueInvertir segundoInvertir = new BloqueInvertir(primerInvertir);
        BloqueInvertir tercerInvertir = new BloqueInvertir(segundoInvertir);

        tercerInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(1)).ejecutarInvertido(sectorDibujoMock);
    }

    @Test
    public void test09TenerUnBloqueInvertirDentroDeOtroNoInviertePeroSiInvierteLoQueNoEsteEnElPrimerInvertir()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueInvertir primerInvertir = new BloqueInvertir(bloquePersonalizado);
        BloqueInvertir segundoInvertir = new BloqueInvertir(primerInvertir);

        BloqueMovimiento otroMovimientoMock = mock(BloqueMovimiento.class);

        segundoInvertir.agregar(otroMovimientoMock);

        segundoInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(0)).ejecutarInvertido(sectorDibujoMock);
        verify(otroMovimientoMock,times(1)).ejecutarInvertido(sectorDibujoMock);
    }
}

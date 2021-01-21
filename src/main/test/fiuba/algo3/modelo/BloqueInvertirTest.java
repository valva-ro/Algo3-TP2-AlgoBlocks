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
        BloqueInvertir bloqueInvertir = new BloqueInvertir();
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> bloqueInvertir.ejecutar(sectorDibujo));
    }

    @Test
    public void test02AgregarUnBloqueAlBloqueInvertirYEjecutarloRealizaLaOperaciónInversaDelBloqueInterior()
    {
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);
        BloqueInvertir bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregar(bloqueMovimientoMock);

        bloqueInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock, times(1)).ejecutarInvertido(sectorDibujoMock);
    }


    @Test
    public void test03EjecutarElBloqueInvertirConDosBloquesInterioresRealizaLaOperaciónInversaEnCadaUnoDeEllos()
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
    public void test09TenerUnBloqueInvertirDentroDeOtroNoInviertePeroSiInvierteLoQueNoEsteEnElPrimerInvertir()
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
}

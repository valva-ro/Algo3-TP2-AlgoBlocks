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

    //TODO: Falta el codigo que haga pasar las pruebas
    /*
    @Test
    public void test02AgregarUnBloqueAlBloqueInvertirYEjecutarloRealizaLaOperaciónInversaDelBloqueInterior()
    {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        SectorDibujo sectorDibujoMock = mock(SectorDibujo.class);
        BloqueMovimiento bloqueMovimientoMock = mock(BloqueMovimiento.class);

        bloquePersonalizado.agregar(bloqueMovimientoMock);

        BloqueInvertir bloqueInvertir = new BloqueInvertir(bloquePersonalizado);

        bloqueInvertir.ejecutar(sectorDibujoMock);

        verify(bloqueMovimientoMock,times(1)).invertirMovimiento();
        verify(bloqueMovimientoMock,times(1)).ejecutar(sectorDibujoMock);
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

        verify(bloqueMovimientoMock,times(1)).invertirMovimiento();
        verify(bloqueMovimientoMock,times(1)).ejecutar(sectorDibujoMock);

        verify(otroMovimientoMock,times(1)).invertirMovimiento();
        verify(otroMovimientoMock,times(1)).ejecutar(sectorDibujoMock);

    }
     */
}

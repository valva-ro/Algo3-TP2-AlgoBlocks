package fiuba.algo3.modelo;

import fiuba.algo3.AlgoBlocks;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueDibuja;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueNoDibuja;

import fiuba.algo3.modelo.movimientos.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AlgoBlocksTest {
    @Test
    public void test01AgregarBloqueMovimientoArribaDibujaEnSectorDibujoMovimientoArriba(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Arriba arribaMock = mock(Arriba.class);
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        algoBlocks.agregarBloqueMovimientoArriba();
        movimientos.add(arribaMock);
        algoBlocks.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test02AgregarBloqueMovimientoAbajoDibujaEnSectorDibujoMovimientoAbajo(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        Abajo abajoMock = mock(Abajo.class);
        ArrayList<Movimiento> movimientos = new ArrayList<>();
        SectorDibujo sectorDibujo = new SectorDibujo();

        algoBlocks.agregarBloqueMovimientoAbajo();
        movimientos.add(abajoMock);
        algoBlocks.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test03AgregarBloqueMovimientoDerechaAgregaUnBloqueMovimientoDerecha(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        Derecha derechaMock = mock(Derecha.class);
        ArrayList<Movimiento> movimientos = new ArrayList<>();
        SectorDibujo sectorDibujo = new SectorDibujo();

        algoBlocks.agregarBloqueMovimientoDerecha();
        movimientos.add(derechaMock);
        algoBlocks.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test04AgregarBloqueMovimientoIzquierdaAgregaUnBloqueMovimientoIzquierda(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        Izquierda izquierdaMock = mock(Izquierda.class);
        ArrayList<Movimiento> movimientos = new ArrayList<>();
        SectorDibujo sectorDibujo = new SectorDibujo();

        algoBlocks.agregarBloqueMovimientoIzquierda();
        movimientos.add(izquierdaMock);
        algoBlocks.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test05AgregarBloqueLevantarLapizCambiaDeFabricaANoDibuja(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        FabricaConcretaBloqueQueNoDibuja fabricaNoDibuja = new FabricaConcretaBloqueQueNoDibuja();

        algoBlocks.agregarBloqueLevantarLapiz();

        assertEquals(algoBlocks.obtenerFabrica().getClass(), fabricaNoDibuja.getClass());
    }

    @Test
    public void test06AgregarBloqueBajarLapizCambiaDeFabricaDibuja(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        FabricaConcretaBloqueQueDibuja fabricaDibuja = new FabricaConcretaBloqueQueDibuja();

        algoBlocks.agregarBloqueBajarLapiz();

        assertEquals(algoBlocks.obtenerFabrica().getClass(), fabricaDibuja.getClass());
    }
}

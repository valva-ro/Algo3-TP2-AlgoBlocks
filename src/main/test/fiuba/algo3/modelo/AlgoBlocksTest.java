package fiuba.algo3.modelo;

import fiuba.algo3.AlgoBlocks;
import fiuba.algo3.modelo.movimientos.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

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
    public void test03AgregarBloqueMovimientoDerechaDibujaEnSectorDibujoMovimientoDerecha(){

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
    public void test04AgregarBloqueMovimientoIzquierdaDibujaEnSectorDibujoMovimientoIzquierda(){

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

        //Al cambiar la fabrica , los movimientos nuevos van a tener el estado de noDibuja
        AlgoBlocks algoBlocks = new AlgoBlocks();
        Arriba arribaNoDibuja = new Arriba(new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        movimientos.add(arribaNoDibuja);
        algoBlocks.agregarBloqueLevantarLapiz();
        algoBlocks.agregarBloqueMovimientoArriba();
        algoBlocks.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test06AgregarBloqueBajarLapizCambiaDeFabricaDibuja(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        Arriba arribaDibuja = new Arriba(new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        movimientos.add(arribaDibuja);
        algoBlocks.agregarBloqueBajarLapiz();

        algoBlocks.agregarBloqueMovimientoArriba();
        algoBlocks.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.dibujoEsIgual(movimientos));
    }

    @Test
    public void test07AlCambiarDeFabricaConBloqueBajarLapizLosMovimientosTienenEstadoDibuja(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        Dibuja estadoDibuja = new Dibuja();
        NoDibuja estadoNoDibuja = new NoDibuja();
        SectorDibujo sectorDibujo = new SectorDibujo();
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        movimientos.add(new Arriba(estadoNoDibuja));
        movimientos.add(new Abajo(estadoNoDibuja));
        movimientos.add(new Arriba(estadoDibuja));
        movimientos.add(new Abajo(estadoDibuja));

        algoBlocks.agregarBloqueMovimientoArriba();
        algoBlocks.agregarBloqueMovimientoAbajo();
        algoBlocks.agregarBloqueBajarLapiz();
        algoBlocks.agregarBloqueMovimientoArriba();
        algoBlocks.agregarBloqueMovimientoAbajo();
        algoBlocks.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.dibujoEsIgual(movimientos));
    }
}

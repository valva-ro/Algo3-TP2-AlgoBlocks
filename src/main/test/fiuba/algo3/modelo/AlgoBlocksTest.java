package fiuba.algo3.modelo;

import fiuba.algo3.modelo.AlgoBlocks;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class AlgoBlocksTest {
    @Test
    public void test01AgregarBloqueMovimientoArribaNoDibujaEnSectorDibujo() {

        AlgoBlocks algoBlocks = new AlgoBlocks();
        SectorDibujo sectorDibujo = new SectorDibujo();

        algoBlocks.agregarBloqueMovimientoArriba();
        algoBlocks.ejecutar(sectorDibujo);

        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(0, 1);

        assertFalse(sectorDibujo.existeArista(origen, destino));
    }

    @Test
    public void test02AgregarBloqueMovimientoAbajoNoDibujaEnSectorDibujo() {

        AlgoBlocks algoBlocks = new AlgoBlocks();
        SectorDibujo sectorDibujo = new SectorDibujo();

        algoBlocks.agregarBloqueMovimientoAbajo();
        algoBlocks.ejecutar(sectorDibujo);

        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(0, -1);

        assertFalse(sectorDibujo.existeArista(origen, destino));
    }

    @Test
    public void test03AgregarBloqueMovimientoDerechaNoDibujaEnSectorDibujo() {

        AlgoBlocks algoBlocks = new AlgoBlocks();
        SectorDibujo sectorDibujo = new SectorDibujo();

        algoBlocks.agregarBloqueMovimientoDerecha();
        algoBlocks.ejecutar(sectorDibujo);

        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(1, 0);

        assertFalse(sectorDibujo.existeArista(origen, destino));
    }

    @Test
    public void test04AgregarBloqueMovimientoIzquierdaNoDibujaEnSectorDibujo() {

        AlgoBlocks algoBlocks = new AlgoBlocks();
        SectorDibujo sectorDibujo = new SectorDibujo();

        algoBlocks.agregarBloqueMovimientoIzquierda();
        algoBlocks.ejecutar(sectorDibujo);

        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(-1, 0);

        assertFalse(sectorDibujo.existeArista(origen, destino));
    }

    @Test
    public void test05AgregarBloqueLevantarLapizCambiaDeFabricaANoDibuja() {

        AlgoBlocks algoBlocks = new AlgoBlocks();
        SectorDibujo sectorDibujo = new SectorDibujo();

        algoBlocks.agregarBloqueLevantarLapiz();
        algoBlocks.agregarBloqueMovimientoArriba();
        algoBlocks.ejecutar(sectorDibujo);

        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(0, 1);

        assertFalse(sectorDibujo.existeArista(origen, destino));
    }

    @Test
    public void test06AgregarBloqueBajarLapizCambiaDeFabricaDibuja() {

        AlgoBlocks algoBlocks = new AlgoBlocks();
        SectorDibujo sectorDibujo = new SectorDibujo();

        algoBlocks.agregarBloqueBajarLapiz();
        algoBlocks.agregarBloqueMovimientoArriba();
        algoBlocks.ejecutar(sectorDibujo);

        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(0, 1);

        assertTrue(sectorDibujo.existeArista(origen, destino));
    }

    @Test
    public void test07AlCambiarDeFabricaConBloqueBajarLapizLosMovimientosTienenEstadoDibuja(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(0, 1);

        algoBlocks.agregarBloqueMovimientoArriba();
        algoBlocks.agregarBloqueMovimientoAbajo();
        algoBlocks.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existeArista(origen, destino));
        assertFalse(sectorDibujo.existeArista(origen, destino));

        algoBlocks.agregarBloqueBajarLapiz();
        algoBlocks.agregarBloqueMovimientoArriba();
        algoBlocks.agregarBloqueMovimientoAbajo();
        algoBlocks.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existeArista(origen, destino));
        assertTrue(sectorDibujo.existeArista(origen, destino));
    }
}
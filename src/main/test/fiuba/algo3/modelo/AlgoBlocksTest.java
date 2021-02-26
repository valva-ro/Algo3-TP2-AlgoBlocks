package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlgoBlocksTest {
    // TODO: mockear y verificar cantidad de ejecuciones
    @Test
    public void test01AgregarBloqueMovimientoArribaNoDibujaEnSectorDibujo() {

        AlgoBlocks algoBlocks = new AlgoBlocks();
        Algoritmo algoritmo = new Algoritmo();

        algoBlocks.agregarBloqueMovimientoArriba(algoritmo);
    }

    @Test
    public void test02AgregarBloqueMovimientoAbajoNoDibujaEnSectorDibujo() {

        AlgoBlocks algoBlocks = new AlgoBlocks();
        Algoritmo algoritmo = new Algoritmo();

        algoBlocks.agregarBloqueMovimientoAbajo(algoritmo);
    }

    @Test
    public void test03AgregarBloqueMovimientoDerechaNoDibujaEnSectorDibujo() {

        AlgoBlocks algoBlocks = new AlgoBlocks();
        Algoritmo algoritmo = new Algoritmo();

        algoBlocks.agregarBloqueMovimientoDerecha(algoritmo);
    }

    @Test
    public void test04AgregarBloqueMovimientoIzquierdaNoDibujaEnSectorDibujo() {

        AlgoBlocks algoBlocks = new AlgoBlocks();
        Algoritmo algoritmo = new Algoritmo();

        algoBlocks.agregarBloqueMovimientoIzquierda(algoritmo);

    }

    @Test
    public void test05AgregarBloqueLevantarLapizCambiaDeFabricaANoDibuja() {

        AlgoBlocks algoBlocks = new AlgoBlocks();
        Algoritmo algoritmo = new Algoritmo();

        algoBlocks.agregarBloqueLevantarLapiz();
        algoBlocks.agregarBloqueMovimientoArriba(algoritmo);
    }

    @Test
    public void test06AgregarBloqueBajarLapizCambiaDeFabricaDibuja() {

        AlgoBlocks algoBlocks = new AlgoBlocks();
        Algoritmo algoritmo = new Algoritmo();

        algoBlocks.agregarBloqueBajarLapiz();
        algoBlocks.agregarBloqueMovimientoArriba(algoritmo);
    }

    @Test
    public void test07AlCambiarDeFabricaConBloqueBajarLapizLosMovimientosTienenEstadoDibuja() {

        AlgoBlocks algoBlocks = new AlgoBlocks();
        Algoritmo algoritmo = new Algoritmo();

        algoBlocks.agregarBloqueMovimientoArriba(algoritmo);
        algoBlocks.agregarBloqueMovimientoAbajo(algoritmo);

        algoBlocks.agregarBloqueBajarLapiz();
        algoBlocks.agregarBloqueMovimientoArriba(algoritmo);
        algoBlocks.agregarBloqueMovimientoAbajo(algoritmo);
    }
}
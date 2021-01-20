package fiuba.algo3.modelo;

import fiuba.algo3.AlgoBlocks;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueDibuja;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueNoDibuja;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlgoBlocksTest {
    @Test
    public void test01AgregarBloqueMovimientoArribaAgregaUnBloqueMovimientoArriba(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        algoBlocks.agregarBloqueMovimientoArriba();
        FabricaConcretaBloqueQueNoDibuja fabricaNoDibuja = new FabricaConcretaBloqueQueNoDibuja();

        assertEquals(algoBlocks.obtenerAlgoritmo().obtenerBloques().get(0).getClass(), fabricaNoDibuja.crearBloqueMovimientoArriba().getClass());
    }

    @Test
    public void test02AgregarBloqueMovimientoAbajoAgregaUnBloqueMovimientoAbajo(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        algoBlocks.agregarBloqueMovimientoAbajo();
        FabricaConcretaBloqueQueNoDibuja fabricaNoDibuja = new FabricaConcretaBloqueQueNoDibuja();

        assertEquals(algoBlocks.obtenerAlgoritmo().obtenerBloques().get(0).getClass(), fabricaNoDibuja.crearBloqueMovimientoAbajo().getClass());
    }

    @Test
    public void test03AgregarBloqueMovimientoDerechaAgregaUnBloqueMovimientoDerecha(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        algoBlocks.agregarBloqueMovimientoDerecha();
        FabricaConcretaBloqueQueNoDibuja fabricaNoDibuja = new FabricaConcretaBloqueQueNoDibuja();

        assertEquals(algoBlocks.obtenerAlgoritmo().obtenerBloques().get(0).getClass(), fabricaNoDibuja.crearBloqueMovimientoDerecha().getClass());
    }

    @Test
    public void test04AgregarBloqueMovimientoIzquierdaAgregaUnBloqueMovimientoIzquierda(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        algoBlocks.agregarBloqueMovimientoIzquierda();
        FabricaConcretaBloqueQueNoDibuja fabricaNoDibuja = new FabricaConcretaBloqueQueNoDibuja();

        assertEquals(algoBlocks.obtenerAlgoritmo().obtenerBloques().get(0).getClass(), fabricaNoDibuja.crearBloqueMovimientoIzquierda().getClass());
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

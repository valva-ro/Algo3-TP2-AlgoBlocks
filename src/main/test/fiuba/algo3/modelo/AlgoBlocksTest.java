package fiuba.algo3.modelo;

import fiuba.algo3.AlgoBlocks;
import fiuba.algo3.modelo.bloques.BloqueMovimiento;
import fiuba.algo3.modelo.bloques.Dibuja;
import fiuba.algo3.modelo.bloques.NoDibuja;
import fiuba.algo3.modelo.movimientos.Arriba;
import fiuba.algo3.modelo.movimientos.Abajo;
import fiuba.algo3.modelo.movimientos.Izquierda;
import fiuba.algo3.modelo.movimientos.Derecha;
import fiuba.algo3.modelo.FabricaConcretaBloqueQueNoDibuja;
import fiuba.algo3.modelo.FabricaAbstractaDeBloques;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlgoBlocksTest {
    @Test
    public void test01AgregarBloqueMovimientoArribaAlAlgoritmoLoAgrega(){

        AlgoBlocks algoBlocks = new AlgoBlocks();
        algoBlocks.agregarBloqueMovimientoArriba();

        /*
        SectorDibujo sectorDibujo = new SectorDibujo();
        algoBlocks.ejecutar(sectorDibujo);
        */


    }
}

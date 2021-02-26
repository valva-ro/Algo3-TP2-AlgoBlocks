package fiuba.algo3.modelo;

import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueDibuja;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueNoDibuja;

public class AlgoBlocks {

    private FabricaAbstractaDeBloques fabricaDeBloques;

    public AlgoBlocks() {
        fabricaDeBloques = new FabricaConcretaBloqueQueNoDibuja();
    }

    public void agregarBloqueMovimientoArriba(Algoritmo algoritmo) {
        algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoArriba());
    }

    public void agregarBloqueMovimientoAbajo(Algoritmo algoritmo) {
        algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoAbajo());
    }

    public void agregarBloqueMovimientoDerecha(Algoritmo algoritmo) {
        algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoDerecha());
    }

    public void agregarBloqueMovimientoIzquierda(Algoritmo algoritmo) {
        algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoIzquierda());
    }

    public void agregarBloqueLevantarLapiz() {
        this.fabricaDeBloques = new FabricaConcretaBloqueQueNoDibuja();
    }

    public void agregarBloqueBajarLapiz() {
        this.fabricaDeBloques = new FabricaConcretaBloqueQueDibuja();
    }
}
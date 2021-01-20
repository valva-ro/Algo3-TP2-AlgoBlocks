package fiuba.algo3;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueDibuja;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueNoDibuja;

public class AlgoBlocks {

    private Algoritmo algoritmo = new Algoritmo();
    private FabricaAbstractaDeBloques fabricaDeBloques;

    public AlgoBlocks(){
        fabricaDeBloques = new FabricaConcretaBloqueQueNoDibuja();
    }

    public void agregarBloqueMovimientoArriba(){
        algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoArriba());
    }

    public void agregarBloqueMovimientoAbajo(){
        algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoAbajo());
    }

    public void agregarBloqueMovimientoDerecha(){
        algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoDerecha());
    }

    public void agregarBloqueMovimientoIzquierda(){
        algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoIzquierda());
    }

    public void agregarBloqueLevantarLapiz(){
        this.fabricaDeBloques = new FabricaConcretaBloqueQueNoDibuja();
    }

    public void agregarBloqueBajarLapiz(){
        this.fabricaDeBloques = new FabricaConcretaBloqueQueDibuja();
    }

    public void ejecutar(SectorDibujo sectorDibujo){
        algoritmo.ejecutar(sectorDibujo);
    }

    public Algoritmo obtenerAlgoritmo(){
        return this.algoritmo;
    }

    public FabricaAbstractaDeBloques obtenerFabrica(){
        return this.fabricaDeBloques;
    }
}



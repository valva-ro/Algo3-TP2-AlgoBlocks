package fiuba.algo3;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.FabricaAbstractaDeBloques;
import fiuba.algo3.modelo.FabricaConcretaBloqueQueNoDibuja;
import fiuba.algo3.modelo.SectorDibujo;
import fiuba.algo3.modelo.bloques.BloqueMovimiento;

public class AlgoBlocks {

    private Algoritmo algoritmo = new Algoritmo();
    private FabricaAbstractaDeBloques fabricaDeBloques;

    public AlgoBlocks(){
        fabricaDeBloques = new FabricaConcretaBloqueQueNoDibuja();
    }

    public void agregarBloqueMovimientoArriba(){

        algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoArriba());
    }

    public void ejecutar(SectorDibujo sectorDibujo){ //actualizar que recibe un parametro en el UML
        algoritmo.ejecutar(sectorDibujo);
    }


}



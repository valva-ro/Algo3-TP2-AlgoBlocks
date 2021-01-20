package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;

import java.util.ArrayList;

public class BloquePersonalizado extends Bloques {

    public BloquePersonalizado() {
        this.bloques = new ArrayList<>();
    }

    public void ejecutar(SectorDibujo sectorDibujo) {

        this.contieneBloques();
        for (Bloque bloque : bloques) {
            bloque.ejecutar(sectorDibujo);
        }
    }

    public void ejecutarInvertido(SectorDibujo sectorDibujo) {

        this.contieneBloques();
        for (Bloque bloque : bloques) {
            bloque.ejecutarInvertido(sectorDibujo);
        }
    }

    public void contieneBloques(){
        if (bloques.size() < 1) {
            throw new BloquePersonalizadoNoPuedeEjecutarseSinBloquesError();
        }
    }
}
